/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

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
    /**
     * Método construtor da classe <b><i>Gerente</i></b>. Este método recebe 5
     * parametros como atributos para o seu funcionamento.
     * @param <b>CPF</b>
     * @param <b>nome</b>
     * @param <b>telefone</b>
     * @param <b>endereco</b>
     * @param <b>RG </b>
     */
    public Gerente(String CPF, String nome, String telefone, String endereco, String RG) {
        super(nome, telefone, endereco, RG);
        this.CPF = CPF;
    }

    private String CPF;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    @Override
    public boolean validar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
