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

    public boolean VerificarLoginGerente(String login, String senha) throws Exception;

    public boolean VerificarLoginCuidador(String login, String senha) throws Exception;

    public boolean modificarSenhaGerente(String login, String senha, String NovaSenha) throws Exception;

    public boolean existeLogin(String login, int id) throws Exception;

    public boolean modificarSenhaCuidador(String login, String senha, String NovaSenha) throws Exception;

}
