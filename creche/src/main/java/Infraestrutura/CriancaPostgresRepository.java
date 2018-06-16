/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Dominio.Features.Crianca.Crianca;
import Dominio.Features.Crianca.ICriancaPostgresRepository;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author T0KS1CK
 */
public class CriancaPostgresRepository implements ICriancaPostgresRepository {

    private final String SQL_INSERT = "INSERT INTO TBCrianca (nome, rg, dataNascimento) VALUES (?,?,?);";
    private final String SQL_UPDATE = "UPDATE TBCrianca SET nome = ?, rg = ?, dataNascimento = ? WHERE id_crianca = ?;";
    private final String SQL_DELETE = "DELETE FROM TBCrianca WHERE id_crianca = ?;";
    private final String SQL_GETALL = "SELECT * FROM TBCrianca;";
    private final String SQL_GET = "SELECT * FROM TBCrianca WHERE id_crianca = ?;";

    @Override
    public Crianca adicionar(Crianca crianca) throws SQLException{
        PreparedStatement statement = PostgresDAO.createStatementReturningGeneratedKeys(SQL_INSERT);
        statement = prepareStatement(statement, crianca);

        crianca.setId(PostgresDAO.add(statement));
        return crianca;
    }

    @Override
    public Crianca atualizar(Crianca crianca) throws SQLException, Exception {
        if (crianca.getId() < 1) {
            throw new Exception("Id inválido");
        }
        PreparedStatement statement = PostgresDAO.createStatement(SQL_UPDATE);
        statement = prepareStatement(statement, crianca);
        statement.setLong(4, crianca.getId());

        if (PostgresDAO.update(statement)) {
            return pegar(crianca.getId());
        }
        return null;
    }

    @Override
    public boolean deletar(long id) throws SQLException, Exception {
        if (id < 1) {
            throw new Exception("Id inválido");
        }
        PreparedStatement statement = PostgresDAO.createStatement(SQL_DELETE);
        statement.setLong(1, id);
        return PostgresDAO.delete(statement);
    }

    @Override
    public List<Crianca> pegarTodas() throws SQLException {
        PreparedStatement statement = PostgresDAO.createStatement(SQL_GETALL);
        ResultSet rs = PostgresDAO.get(statement);
        List<Crianca> lista = new ArrayList();
        while (rs.next()) {
            lista.add(make(rs));
        }
        return lista;
    }

    @Override
    public Crianca pegar(long id) throws SQLException, Exception {
        if (id < 1) {
            throw new Exception("Id inválido");
        }
        PreparedStatement statement = PostgresDAO.createStatement(SQL_GET);
        statement.setLong(1, id);
        ResultSet rs = PostgresDAO.get(statement);
        if (rs.next()) {
            return make(rs);
        }
        return null;
    }

    private PreparedStatement prepareStatement(PreparedStatement statement, Crianca crianca) throws SQLException {
        java.util.Date d = crianca.getDataNascimento();
        statement.setString(1, crianca.getNome());
        statement.setString(2, crianca.getRG());
        statement.setDate(3, new Date(d.getYear(), d.getMonth(), d.getDate()));
        return statement;
    }

    private Crianca make(ResultSet rs) throws SQLException {
        Crianca c = new Crianca();
        c.setNome(rs.getString("nome"));
        c.setRG(rs.getString("rg"));
        return c;
    }
}
