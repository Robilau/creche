/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura.Login;

import Dominio.Features.Usuario.Usuario;

/**
 *
 * @author T0KS1CK
 */
public interface ILoginService {

    public Usuario verificarUsuario(String login, String senha) throws Exception;

    public boolean modificarSenha(Usuario user, String senha, String novaSenha) throws Exception;

}
