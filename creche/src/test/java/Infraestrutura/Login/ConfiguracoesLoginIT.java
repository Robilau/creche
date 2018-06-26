/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura.Login;

import java.sql.SQLException;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author T0KS1CK
 */
public class ConfiguracoesLoginIT {
    IConfiguracoesLogin config;
    
    @Before
    public void setUp() {
        config = new ConfiguracoesLogin();
    }

    /**
     * Test of VerificarLoginGerente method, of class ConfiguracoesLogin.
     */
    @Test
    public void testVerificarLoginGerente() throws Exception {
        String login = "admin";
        String senha = "admin";
        Assertions.assertThat(config.VerificarLoginGerente(login, senha)).isTrue();
    }

    /**
     * Test of VerificarLoginCuidador method, of class ConfiguracoesLogin.
     */
    @Test
    public void testVerificarLoginCuidador() throws Exception {
        String login = "login";
        String senha = "senha";
        Assertions.assertThat(config.VerificarLoginCuidador(login, senha)).isTrue();
    }
    
    /**
     * Test of modificarSenhaGerente method, of class ConfiguracoesLogin.
     */
    @Test
    public void testModificarSenhaGerente() throws Exception {
        String login = "admin";
        String senha = "admin";
        String novaSenha = "pass";
        Assertions.assertThat(config.modificarSenhaGerente(login, senha, novaSenha)).isTrue();
        config.modificarSenhaGerente("admin", "pass", "admin");
    }
    
}
