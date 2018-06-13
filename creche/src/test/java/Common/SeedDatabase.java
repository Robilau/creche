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
    String seedCriancaTable = "DROP TABLE TBCrianca; "
            + "CREATE TABLE TBCrianca (id_crianca serial primary key not null, nome text, telefone text, endereco text, rg text); "
            + "INSERT INTO TBCrianca (nome, telefone, endereco, rg) VALUES ('nome','telefone','endereco','rg');";
    public void criancaSeed() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBCreche", "postgres", "aluno");
        Statement st = conn.createStatement();
        st.execute(seedCriancaTable);
    }
}