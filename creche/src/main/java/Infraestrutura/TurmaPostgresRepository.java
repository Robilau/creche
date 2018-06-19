/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Dominio.Cuidador;
import Dominio.Features.Turma.Turma;
import Dominio.Features.Turma.ITurmaPostgresRepository;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class TurmaPostgresRepository implements ITurmaPostgresRepository{
       private final String SQL_INSERT = "INSERT INTO TBTurma (dataInicio_turma, dataFim_turma, cuidador_id) VALUES (?,?,?);";
    private final String SQL_UPDATE = "UPDATE TBTurma SET dataInicio_turma = ?, dataFim_turma = ?, cuidador_id = ? WHERE id_turma = ?;";
    private final String SQL_DELETE = "DELETE FROM TBTurma WHERE id_turma = ?;";
    private final String SQL_GETALL = "SELECT * FROM TBTurma t, TBCuidador c WHERE t.cuidador_id = c.id_cuidador;";
    private final String SQL_GET = "SELECT * FROM TBTurma t, TBCuidador c WHERE t.cuidador_id = c.id_cuidador AND t.id_turma = ?;";
    
    @Override
    public Turma adicionar(Turma turma) throws SQLException{
        PreparedStatement statement = PostgresDAO.createStatementReturningGeneratedKeys(SQL_INSERT);
        statement = prepareStatement(statement, turma);

        turma.setId(PostgresDAO.add(statement));
        return turma;
    }

    @Override
    public Turma atualizar(Turma turma) throws SQLException, Exception {
        if (turma.getId() < 1) {
            throw new Exception("Id inválido");
        }
        PreparedStatement statement = PostgresDAO.createStatement(SQL_UPDATE);
        statement = prepareStatement(statement, turma);
        statement.setInt(4, turma.getId());

        if (PostgresDAO.update(statement)) {
            return pegar(turma.getId());
        }
        return null;
    }

    @Override
    public boolean deletar(int id) throws SQLException, Exception {
        if (id < 1) {
            throw new Exception("Id inválido");
        }
        PreparedStatement statement = PostgresDAO.createStatement(SQL_DELETE);
        statement.setInt(1, id);
        return PostgresDAO.delete(statement);
    }

    @Override
    public List<Turma> pegarTodos() throws SQLException {
        PreparedStatement statement = PostgresDAO.createStatement(SQL_GETALL);
        ResultSet rs = PostgresDAO.get(statement);
        List<Turma> lista = new ArrayList();
        while (rs.next()) {
            lista.add(make(rs));
        }
        return lista;
    }

    @Override
    public Turma pegar(int id) throws SQLException, Exception {
        if (id < 1) {
            throw new Exception("Id inválido");
        }
        PreparedStatement statement = PostgresDAO.createStatement(SQL_GET);
        statement.setInt(1, id);
        ResultSet rs = PostgresDAO.get(statement);
        if (rs.next()) {
            return make(rs);
        }
        return null;
    }

    private PreparedStatement prepareStatement(PreparedStatement statement, Turma turma) throws SQLException {
        statement.setDate(1, new Date (turma.getDataInicio().getTime()));
        statement.setDate(2, new Date(turma.getDataFim().getTime()));
        statement.setInt(3, turma.getCuidador().getId());
        return statement;
    }

    private Turma make(ResultSet rs) throws SQLException {
        Turma turma = new Turma();
        Cuidador cuidador = new Cuidador();
        turma.setId(rs.getInt("id_turma"));
        turma.setDataInicio(rs.getDate("dataInicio_turma"));
        turma.setDataFim(rs.getDate("dataFim_turma"));
        cuidador.setId(rs.getInt("cuidador_id"));
        cuidador.setNome(rs.getString("nome_cuidador"));
        cuidador.setRG(rs.getString("rg_cuidador"));
        cuidador.setTelefone(rs.getString("telefone_cuidador"));
        cuidador.setCPF(rs.getString("cpf_cuidador"));
        turma.setCuidador(cuidador);
        return turma;
    }
}
