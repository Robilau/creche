/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
// * and open the template in the editor.
 */
package Infraestrutura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Aluno
 */
public abstract class postgresDAO {
    
    protected String TBName;
    protected String[] TBColumns;
    
    private String formatArrayToQuery(Object[] obj){
        String res = "";
        for (int i = 0; i < obj.length - 1; i++) {
            res += obj[i] + ",";
        }
        return res + obj[obj.length - 1];
    }
    
    public void Adicionar (Object[] obj) throws SQLException{       
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBCreche", "postgres", "aluno");
        Statement st = conn.createStatement();       
        
        String query = "SELECT FROM " + TBName + " ("+ formatArrayToQuery(TBColumns) +") VALUES ("+formatArrayToQuery(obj) +")";
        
        st.execute(query);
        st.close();
    }
}
