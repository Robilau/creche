/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Features.RPC;

import Dominio.Pessoa;

/**
 * A classe Mensalidade possibilita instanciar o objeto mensalidade e extende
 * sua funcionalidade a partir das super-classses<b>Pessoa</b> e
 * <b>Entidade</b>. Possui atributos, e métodos diversos para acessar esses
 * atributos sempre utilizando-se dos principios de POO como por exemplo
 * encapsulamento.
 *
 * @author Gabriel Celestino, Leticia Ventura, Lucas Chaves
 * @version 1.0
 * @since Vr 1.0
 * @see Entidade
 * @see Pessoa
 */
public class Rpc extends Pessoa {

    private String CPF;
    private String telefone;
    private String endereco;

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public void validar() throws Exception {
        if (CPF.isEmpty()) {
            throw new Exception("CPF não pode estar vazio");
        }
        if (telefone.isEmpty()) {
            throw new Exception("Telefone não pode estar vazio");
        }
        if (endereco.isEmpty()) {
            throw new Exception("Endereco não pode estar vazio");
        }
    }

}
