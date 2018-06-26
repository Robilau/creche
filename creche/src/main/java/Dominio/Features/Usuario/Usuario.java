/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Features.Usuario;

import Dominio.Features.Usuario.TipoUsuario;

/**
 *
 * @author T0KS1CK
 */
public class Usuario {
    private String login;
    private TipoUsuario tipoUsuario;

    public String getLogin() {
        return login;
    }

    public void setLogin(String nome) {
        this.login = nome;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
}


