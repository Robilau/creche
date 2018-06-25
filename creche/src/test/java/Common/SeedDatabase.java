/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Aluno
 */
public class SeedDatabase {
    protected final String dropTbCrianca = "DROP TABLE TBCrianca;";
    protected final String createTbCrianca = "CREATE TABLE TBCrianca (id_crianca serial primary key not null, nome_crianca text, rg_crianca text, dataNascimento_crianca Date, rpc_id integer);";
    protected final String insertTbCrianca = "INSERT INTO TBCrianca (nome_crianca, rg_crianca, dataNascimento_crianca, rpc_id) VALUES ('nome_crianca','rg_crianca', now(), 1);";
    
    protected final String dropTbRpc = "DROP TABLE TBRpc;";
    protected final String createTbRpc = "CREATE TABLE TBRpc (id_rpc serial primary key not null, nome_rpc text not null, rg_rpc text not null, cpf_rpc text not null, telefone_rpc text not null, endereco_rpc text not null);";
    protected final String insertTbRpc = "INSERT INTO TBRpc (nome_rpc, rg_rpc, cpf_rpc, endereco_rpc, telefone_rpc) VALUES ('nome_rpc', 'rg_rpc', 'cpf_rpc', 'endereco_rpc', 'telefone_rpc')";
    
    protected final String dropTbTurma = "DROP TABLE TBTurma;";
    protected final String createTbTurma = "CREATE TABLE TBTurma (id_turma serial primary key not null, cuidador_id integer not null, dataInicio_turma Date not null, dataFim_turma Date not null, FOREIGN KEY (cuidador_id) REFERENCES TBCuidador (id_cuidador));";
    protected final String insertTbturma = "INSERT INTO TBTurma (dataInicio_turma, dataFim_turma, cuidador_id) VALUES (now(), now(), 1)";
    
    protected final String dropTbCuidador = "DROP TABLE TBCuidador;";
    protected final String createTbCuidador = "Create table TBCuidador (id_cuidador serial primary key not null, nome_cuidador text not null, telefone_cuidador text not null, rg_cuidador text not null, cpf_cuidador text not null, login_cuidador text not null, senha_cuidador text not null);";
    protected final String insertTbCuidador = "INSERT INTO TBCuidador (nome_cuidador, rg_cuidador, telefone_cuidador, cpf_cuidador, login_cuidador, senha_cuidador) VALUES ('nome_cuidador', 'rg_cuidador', 'telefone_cuidador', 'cpf_cuidador', 'login', 'senha')";
    
    public void criancaERpcSeed() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBCreche", "postgres", "aluno");
        Statement st = conn.createStatement();
        st.execute(dropTbCrianca);
        st.execute(dropTbRpc);
        st.execute(createTbRpc);
        st.execute(insertTbRpc);
        st.execute(createTbCrianca);
        st.execute(insertTbCrianca);
    }
    
    public void turmaECuidadorSeed() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBCreche", "postgres", "aluno");
        Statement st = conn.createStatement();
        st.execute(dropTbTurma);
        st.execute(dropTbCuidador);
        st.execute(createTbCuidador);
        st.execute(createTbTurma);        
        st.execute(insertTbCuidador);
        st.execute(insertTbturma);
    }
    
    public void cuidadorSeed() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBCreche", "postgres", "aluno");
        Statement st = conn.createStatement();
        st.execute(dropTbTurma);
        st.execute(dropTbCuidador);
        st.execute(createTbCuidador);
        st.execute(createTbTurma);        
        st.execute(insertTbCuidador);
    }
}
