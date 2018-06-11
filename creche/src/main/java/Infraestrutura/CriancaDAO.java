/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Dominio.Crianca;
import java.sql.Connection;
import java.sql.DriverManager;
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

    public boolean Adicionar(Crianca crianca) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBCreche", "postgres", "aluno");
        Statement st = conn.createStatement();

        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO TBCrianca (nome, telefone, endereco, rg) VALUES (");
        query.append("\'" + crianca.getNome() + "\',");
        query.append("\'" + crianca.getTelefone() + "\',");
        query.append("\'" + crianca.getEndereco() + "\',");
        query.append("\'" + crianca.getRG() + "\'");
        query.append(");");

        boolean res = st.execute(query.toString());
        st.close();

        return res;
    }

    public Crianca Atualizar(Crianca crianca) throws SQLException, Exception {
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

        ResultSet rs = st.executeQuery(query.toString());

        Crianca c = new Crianca();
        c.setNome(rs.getString("nome"));
        c.setTelefone(rs.getString("telefone"));
        c.setEndereco(rs.getString("endereco"));
        c.setRG(rs.getString("rg"));

        st.close();

        return c;
    }

    public List<Crianca> PegarTodas() throws SQLException {
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

    public Crianca Pegar(int id) throws SQLException, Exception {
        if (id < 1) {
            throw new Exception("Id inválido");
        }
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBCreche", "postgres", "aluno");
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM TBCrianca WHERE id_crianca = " + id);

        Crianca c = new Crianca();
        c.setNome(rs.getString("nome"));
        c.setTelefone(rs.getString("telefone"));
        c.setEndereco(rs.getString("endereco"));
        c.setRG(rs.getString("rg"));
        return c;
    }

    private Crianca take(ResultSet rs) throws SQLException {
        Crianca c = new Crianca();
        if (rs.next()) {
            c.setNome(rs.getString("nome"));
            c.setTelefone(rs.getString("telefone"));
            c.setEndereco(rs.getString("endereco"));
            c.setRG(rs.getString("rg"));
        }
        return c;
    }
}
