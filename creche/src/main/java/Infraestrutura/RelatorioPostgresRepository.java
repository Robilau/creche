/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Dominio.Fatures.Relatorio.IRelatorioRepository;
import Dominio.Fatures.Relatorio.Relatorio;
import Dominio.Features.Crianca.Crianca;
import Dominio.Features.Cuidador.Cuidador;
import Dominio.Features.Turma.Turma;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author T0KS1CK
 */
public class RelatorioPostgresRepository implements IRelatorioRepository {

    private final String SQL_INSERT = " INSERT INTO TBRelatorio (texto_relatorio, ausente_relatorio, data_relatorio, crianca_id) VALUES (?,?,?,?);";
    private final String SQL_UPDATE = "UPDATE TBRelatorio SET texto_relatorio = ?, ausente_relatorio = ?, data_relatorio = ?, crianca_id = ? WHERE id_relatorio = ?;";
    private final String SQL_GETALL_RELATORIOS = "SELECT id_relatorio, texto_relatorio, ausente_relatorio, data_relatorio FROM TBRelatorio WHERE id_crianca = ? AND data_relatorio BETWEEN ? AND ?";
    private final String SQL_GET_CRIANCA = "SELECT c.nome_crianca, c.id_crianca, cu.nome_cuidador, cu.telefone_cuidador  FROM TBTurma t, TBcuidador cu, TBCrianca c WHERE c.turma_id = t.id_turma AND cu.id_cuidador = t.cuidador_id AND c.id_crianca = ?";
    private final String SQL_GET = "SELECT * FROM TBRelatorio, TBRpc, TBTurma, TBCuidador WHERE id_relatorio = ?";

    @Override
    public Relatorio adicionar(Relatorio relatorio, int idCrianca) throws Exception {
        PreparedStatement statement = PostgresDAO.createStatementReturningGeneratedKeys(SQL_INSERT);
        statement = prepareStatement(statement, relatorio, idCrianca);

        relatorio.setId(PostgresDAO.add(statement));
        return relatorio;
    }

    @Override
    public Relatorio atualizar(Relatorio relatorio, int criancaId) throws SQLException, Exception {
        if (relatorio.getId() < 1) {
            throw new Exception("Id inválido");
        }
        PreparedStatement statement = PostgresDAO.createStatement(SQL_UPDATE);
        statement = prepareStatement(statement, relatorio, criancaId);
        statement.setDate(4, new java.sql.Date(relatorio.getData().getTime()));
        statement.setInt(5, criancaId);

        if (PostgresDAO.update(statement)) {
            return pegar(relatorio.getData(), criancaId);
        }
        return null;
    }

    @Override
    public List<Relatorio> pegarTodos(Date dateInicio, Date dateFim, int criancaId) throws SQLException {
        PreparedStatement statement = PostgresDAO.createStatement(SQL_GETALL_RELATORIOS);
        statement.setDate(2, new java.sql.Date(dateInicio.getTime()));
        statement.setDate(3, new java.sql.Date(dateFim.getTime()));
        statement.setInt(1, criancaId);
        ResultSet rs = PostgresDAO.get(statement);
        List<Relatorio> lista = new ArrayList();
        while (rs.next()) {
            lista.add(makeRelatorio(rs));
        }        
        return lista;
    }

    @Override
    public Relatorio pegar(Date date, int criancaId) throws SQLException, Exception {
        if (criancaId < 1) {
            throw new Exception("Id criança inválido");
        }
        PreparedStatement statement = PostgresDAO.createStatement(SQL_GET);
        statement.setInt(1, criancaId);
        statement.setDate(2, new java.sql.Date(date.getTime()));
        ResultSet rs = PostgresDAO.get(statement);
        if (rs.next()) {
            return makeRelatorio(rs);
        }
        return null;
    }

    private PreparedStatement prepareStatement(PreparedStatement statement, Relatorio relatorio, int idCrianca) throws SQLException {
        statement.setString(1, relatorio.getTexto());
        statement.setBoolean(2, relatorio.isAusente());
        statement.setDate(3, new java.sql.Date(relatorio.getData().getTime()));
        statement.setInt(4, idCrianca);
        return statement;
    }

    private Relatorio makeRelatorio(ResultSet rs) throws SQLException {
        Relatorio r = new Relatorio();
        r.setId(rs.getInt("id_relatorio"));
        r.setTexto(rs.getString("texto_relatorio"));
        r.setAusente(rs.getBoolean("ausente_relatorio"));
        r.setData(rs.getDate("data_relatorio"));
        return r;
    }
    
    private Crianca makeCrianca(ResultSet rs) throws SQLException {
        Crianca c = new Crianca();
        Turma turma = new Turma();
        Cuidador cuidador = new Cuidador();
        c.setId(rs.getInt("id_crianca"));
        c.setNome(rs.getString("nome_crianca"));
        cuidador.setNome(rs.getString("nome_cuidador"));
        cuidador.setTelefone("telefone_cuidador");
        turma.setCuidador(cuidador);
        c.setTurma(turma);
        return c;
    }
}
