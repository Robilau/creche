/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura.Login;

import Infraestrutura.PostgresDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 *
 * @author T0KS1CK
 */
public class ConfiguracoesLogin implements IConfiguracoesLogin {

    private String gerenteLogin;
    private String gerenteSenha;
    private final String sql_pegar_login_cuidador = "SELECT id_cuidador FROM TBCuidador WHERE login_cuidador = ? AND senha_cuidador = ?";
    private final String sql_mudar_senha_cuidador = "UPDATE TBCuidador SET senha_cuidador = ? WHERE login_cuidador = ?";
    private final String sql_verifica_login = "SELECT id_cuidador FROM TBCuidador WHERE login_cuidador = ? AND id_cuidador != ?";

    @Override
    public boolean modificarSenhaGerente(String login, String senha, String NovaSenha) throws Exception{
        Properties prop = new Properties();
        OutputStream output;
        output = new FileOutputStream("config.properties");
        prop.setProperty("login", login);
        prop.setProperty("senha", NovaSenha);
        prop.store(output, null);
        return true;
    }

    @Override
    public boolean existeLogin(String login, int id) throws Exception {
        PreparedStatement statement = PostgresDAO.createStatement(sql_verifica_login);
        statement.setString(1, login);
        statement.setInt(2, id);
        ResultSet rs = PostgresDAO.get(statement);
        return rs.next();
    }

    @Override
    public boolean modificarSenhaCuidador(String login, String senha, String NovaSenha) throws Exception {
        PreparedStatement statement = PostgresDAO.createStatement(sql_mudar_senha_cuidador);
        statement.setString(1, NovaSenha);
        statement.setString(2, login);
        return PostgresDAO.update(statement);
    }

    private void CarregarLoginGerente() throws Exception {
        File configFile = new File("config.properties");
        InputStream inputStream = new FileInputStream(configFile);
        Properties p = new Properties();
        p.load(inputStream);

        gerenteLogin = p.getProperty("login");
        gerenteSenha = p.getProperty("senha");
    }

    @Override
    public boolean VerificarLoginGerente(String login, String senha) throws Exception {
        CarregarLoginGerente();
        return login.equals(gerenteLogin) && senha.equals(gerenteSenha);
    }

    @Override
    public boolean VerificarLoginCuidador(String login, String senha) throws Exception {
        PreparedStatement statement = PostgresDAO.createStatement(sql_pegar_login_cuidador);
        statement.setString(1, login);
        statement.setString(2, senha);
        ResultSet rs = PostgresDAO.get(statement);
        return rs.next();
    }
}
