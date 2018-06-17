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
    private final String dropTbCrianca = "DROP TABLE TBCrianca;";
    private final String createTbCrianca = "CREATE TABLE TBCrianca (id_crianca serial primary key not null, nome_crianca text, rg_crianca text, dataNascimento_crianca Date, rpc_id integer);";
    private final String insertTbCrianca = "INSERT INTO TBCrianca (nome_crianca, rg_crianca, dataNascimento_crianca, rpc_id) VALUES ('nome_crianca','rg_crianca', now(), 1);";
    
    private final String dropTbRpc = "DROP TABLE TBRpc;";
    private final String createTbRpc = "CREATE TABLE TBRpc (id_rpc serial primary key not null, nome_rpc text not null, rg_rpc text not null, cpf_rpc text not null, telefone_rpc text not null, endereco_rpc text not null);";
    private final String insertTbRpc = "INSERT INTO TBRpc (nome_rpc, rg_rpc, cpf_rpc, endereco_rpc, telefone_rpc) VALUES ('nome_rpc', 'rg_rpc', 'cpf_rpc', 'endereco_rpc', 'telefone_rpc')";
    
    
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
}
