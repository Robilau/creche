/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Dominio.Crianca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T0KS1CK
 */
public class CriancaDAO {

    String SQL_INSERT = "INSERT INTO TBCrianca (nome, telefone, endereco, rg) VALUES (?,?,?,?);";
    String SQL_UPDATE = "UPDATE TBCrianca SET nome = ?, telefone = ?, endereco = ?, rg = ? WHERE id_crianca = ?";

    public Crianca adicionar(Crianca crianca) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBCreche", "postgres", "aluno");

        PreparedStatement statement = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
        statement = prepararPreparedStatement(statement, crianca);

        int affectedRows = statement.executeUpdate();
        if (affectedRows != 0) {
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                crianca.setId(generatedKeys.getLong(1));
            }
        }
        return crianca;
    }

    public Crianca atualizar(Crianca crianca) throws SQLException, Exception {
        if (crianca.getId() < 1) {
            throw new Exception("Id inválido");
        }

        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBCreche", "postgres", "aluno");
        PreparedStatement statement = conn.prepareStatement(SQL_UPDATE);
        statement = prepararPreparedStatement(statement, crianca);
        statement.setLong(5, crianca.getId());

        int affectedRows = statement.executeUpdate();
        if (affectedRows != 0) {
            return pegar(crianca.getId());
        }
        return null;
    }
    
    public void deletar(long id) throws SQLException, Exception {
        if (id < 1) {
            throw new Exception("Id inválido");
        }

        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBCreche", "postgres", "aluno");
        Statement statement = conn.createStatement();
        statement.execute("DELETE FROM TBCrianca WHERE id_crianca = " + id);
    }

    public List<Crianca> pegarTodas() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBCreche", "postgres", "aluno");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM TBCrianca");

        List<Crianca> lista = new ArrayList<Crianca>();
        while (rs.next()) {
            Crianca c = new Crianca();
            c.setNome(rs.getString("nome"));
            c.setTelefone(rs.getString("telefone"));
            c.setEndereco(rs.getString("endereco"));
            c.setRG(rs.getString("rg"));
            lista.add(c);
        }
        return lista;
    }

    public Crianca pegar(long id) throws SQLException, Exception {
        if (id < 1) {
            throw new Exception("Id inválido");
        }
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBCreche", "postgres", "aluno");
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM TBCrianca WHERE id_crianca = " + id);
        if (rs.next()) {
            Crianca c = new Crianca();
            c.setNome(rs.getString("nome"));
            c.setTelefone(rs.getString("telefone"));
            c.setEndereco(rs.getString("endereco"));
            c.setRG(rs.getString("rg"));
            return c;
        }
        return null;
    }

    private PreparedStatement prepararPreparedStatement(PreparedStatement statement, Crianca crianca) throws SQLException {
        statement.setString(1, crianca.getNome());
        statement.setString(2, crianca.getTelefone());
        statement.setString(3, crianca.getTelefone());
        statement.setString(4, crianca.getEndereco());
        return statement;
    }
}
