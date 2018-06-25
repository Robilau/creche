/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura.Login;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author T0KS1CK
 */
public interface IConfiguracoesLogin {

    public boolean VerificarLoginGerente(String login, String senha) throws IOException;

    public boolean VerificarLoginCuidador(String login, String senha) throws SQLException;

    public boolean modificarSenhaGerente(String login, String senha, String NovaSenha);

    public String getNome_da_pessoa_logada();
}
