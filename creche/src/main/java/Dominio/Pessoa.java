/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 * A classe Pessoa é abstrata e fornece atributos e métodos relevantes para o
 * instanciamento de objetos que herdam essas características...
 *
 * @author Gabriel Celestino, Leticia Ventura, Lucas Chaves
 * @version 1.0
 * @since Vr. 1.0
 * @see Entidade
 */
public abstract class Pessoa extends Entidade {

    String nome;
    String telefone;
    String endereco;
    String RG;

    /**
     * Método construtor da super-classe <b><i>pessoa</i></b>. Este método
     * recebe 3 parametros como atributos para o seu funcionamento.
     * @param <b>nome</b> Nome do objeto instanciado 
     * @param <b>telefone</b> Telefone do objeto instanciado
     * @param <b>endereco</b> Endereço do objeto instanciado
     * @param <b>RG</b> RG  do objeto instanciado
     */
    public Pessoa(String nome, String telefone, String endereco, String RG) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.RG = RG;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

}
