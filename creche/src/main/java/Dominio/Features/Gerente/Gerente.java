/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Features.Gerente;

import Dominio.Pessoa;

/**
 * A classe Gerente possibilita instanciar gerentes e extende sua funcionalidade
 * a partir das super-classses <b>Pessoa</b> e <b>Entidade</b>. Possui
 * atributos, e métodos diversos para acessar esses atributos sempre
 * utilizando-se dos principios de POO como por exemplo encapsulamento.
 *
 * @author Gabriel Celestino, Leticia Ventura, Lucas Chaves
 * @version 1.0
 * @since Vr 1.0
 * @see Pessoa
 * @see Entidade
 */
public class Gerente extends Pessoa {

    private String CPF;
    private String telefone;
    private String login;
    private String senha;

    public Gerente() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public void validar() throws Exception {
        super.validar();
        if (CPF == null) {
            throw new Exception("CPF não pode ser nulo");
        }
        if (telefone == null) {
            throw new Exception("O campo telefone não pode ser nulo");
        }
        if (login == null) {
            throw new Exception("O campo login não pode ser nulo");
        }
        if (senha == null) {
            throw new Exception("O campo login não pode ser nulo");
        }

    }

}
