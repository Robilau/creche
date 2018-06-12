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

    public Crianca adicionar(Crianca crianca) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBCreche", "postgres", "aluno");

        PreparedStatement statement = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, crianca.getNome());
        statement.setString(2, crianca.getTelefone());
        statement.setString(3, crianca.getTelefone());
        statement.setString(4, crianca.getEndereco());

        int affectedRows = statement.executeUpdate();
        if (affectedRows != 0) {
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                crianca.setId(generatedKeys.getLong(1));
            }
        }
        return crianca;
    }

    public void atualizar(Crianca crianca) throws SQLException, Exception {
        if (crianca.getId() < 1) {
            throw new Exception("Id inválido");
        }

        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBCreche", "postgres", "aluno");
        Statement st = conn.createStatement();

        StringBuilder query = new StringBuilder();
        query.append("UPDATE TBCrianca SET ");
        query.append("nome = \'").append(crianca.getNome()).append("\', ");
        query.append("telefone = \'").append(crianca.getTelefone()).append("\', ");
        query.append("endereco = \'").append(crianca.getEndereco()).append("\', ");
        query.append("rg = \'").append(crianca.getRG()).append("\'");
        query.append(" WHERE id_crianca = ").append(crianca.getId());

        st.execute(query.toString());
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
        if (rs.first()) {
            Crianca c = new Crianca();
            c.setNome(rs.getString("nome"));
            c.setTelefone(rs.getString("telefone"));
            c.setEndereco(rs.getString("endereco"));
            c.setRG(rs.getString("rg"));
            return c;
        }
        return null;
    }
}
