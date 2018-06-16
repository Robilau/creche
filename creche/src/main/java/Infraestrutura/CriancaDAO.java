/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Dominio.Features.Crianca.Crianca;
import Dominio.Features.Crianca.ICriancaPostgresRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T0KS1CK
 */
public class CriancaDAO implements ICriancaPostgresRepository {

    private final String SQL_INSERT = "INSERT INTO TBCrianca (nome, telefone, endereco, rg) VALUES (?,?,?,?);";
    private final String SQL_UPDATE = "UPDATE TBCrianca SET nome = ?, telefone = ?, endereco = ?, rg = ? WHERE id_crianca = ?;";
    private final String SQL_DELETE = "DELETE FROM TBCrianca WHERE id_crianca = ?;";
    private final String SQL_GETALL = "SELECT * FROM TBCrianca;";
    private final String SQL_GET = "SELECT * FROM TBCrianca WHERE id_crianca = ?;";

    @Override
    public Crianca adicionar(Crianca crianca) throws SQLException {
        PreparedStatement statement = DAO.criarStatementRetornandoChaveGerada(SQL_INSERT);
        statement = prepareStatement(statement, crianca);

        crianca.setId(DAO.add(statement));
        return crianca;
    }

    @Override
    public Crianca atualizar(Crianca crianca) throws SQLException, Exception {
        if (crianca.getId() < 1) {
            throw new Exception("Id inválido");
        }
        PreparedStatement statement = DAO.criarStatement(SQL_UPDATE);
        statement = prepareStatement(statement, crianca);
        statement.setLong(5, crianca.getId());

        if (DAO.update(statement)) {
            return pegar(crianca.getId());
        }
        return null;
    }

    @Override
    public boolean deletar(long id) throws SQLException, Exception {
        if (id < 1) {
            throw new Exception("Id inválido");
        }
        PreparedStatement statement = DAO.criarStatement(SQL_DELETE);
        statement.setLong(1, id);
        return DAO.delete(statement);
    }

    @Override
    public List<Crianca> pegarTodas() throws SQLException {
        PreparedStatement statement = DAO.criarStatement(SQL_GETALL);
        ResultSet rs = DAO.get(statement);
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
        PreparedStatement statement = DAO.criarStatement(SQL_GET);
        statement.setLong(1, id);
        ResultSet rs = DAO.get(statement);
        if (rs.next()) {
            return make(rs);
        }
        return null;
    }

    private PreparedStatement prepareStatement(PreparedStatement statement, Crianca crianca) throws SQLException {
        statement.setString(1, crianca.getNome());
        statement.setString(2, crianca.getTelefone());
        statement.setString(3, crianca.getTelefone());
        statement.setString(4, crianca.getEndereco());
        return statement;
    }

    private Crianca make(ResultSet rs) throws SQLException {
        Crianca c = new Crianca();
        c.setNome(rs.getString("nome"));
        c.setTelefone(rs.getString("telefone"));
        c.setEndereco(rs.getString("endereco"));
        c.setRG(rs.getString("rg"));
        return c;
    }
}
