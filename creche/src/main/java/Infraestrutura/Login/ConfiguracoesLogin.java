/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura.Login;

import Infraestrutura.PostgresDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T0KS1CK
 */
public class ConfiguracoesLogin implements IConfiguracoesLogin {

    private String nome_da_pessoa_logada;
    private String gerenteLogin;
    private String gerenteSenha;
    private final String sql_pegar_login_cuidador = "SELECT nome_cuidador FROM TBCuidador WHERE login_cuidador = ? AND senha_cuidador = ?";

    @Override
    public boolean modificarSenhaGerente(String login, String senha, String NovaSenha) {
        Properties prop = new Properties();
        OutputStream output;
        try {
            if (VerificarLoginGerente(login, senha)) {
                output = new FileOutputStream("config.properties");
                prop.setProperty("senha", NovaSenha);
                prop.store(output, null);
                return true;
            }            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConfiguracoesLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConfiguracoesLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private void CarregarLoginGerente() throws FileNotFoundException, IOException {
        File configFile = new File("config.properties");
        InputStream inputStream = new FileInputStream(configFile);
        Properties p = new Properties();
        p.load(inputStream);

        gerenteLogin = p.getProperty("login");
        gerenteSenha = p.getProperty("senha");
    }

    @Override
    public boolean VerificarLoginGerente(String login, String senha) throws IOException {
        CarregarLoginGerente();
        if (login.equals(login) && senha.equals(gerenteSenha)) {
            nome_da_pessoa_logada = "Gerente";
            return true;
        }
        return false;
    }

    @Override
    public boolean VerificarLoginCuidador(String login, String senha) throws SQLException {
        PreparedStatement statement = PostgresDAO.createStatement(sql_pegar_login_cuidador);
        statement.setString(1, login);
        statement.setString(2, senha);
        ResultSet rs = PostgresDAO.get(statement);
        if (rs.next()) {
            nome_da_pessoa_logada = rs.getString("nome_cuidador");
            return true;
        }
        return false;
    }

    @Override
    public String getNome_da_pessoa_logada() {
        return nome_da_pessoa_logada;
    }
}
