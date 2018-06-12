/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Date;

/**
 * A classe Turma possibilita instanciar o objeto turma e extende sua
 * funcionalidade a partir da super-classse
 * <b>Entidade</b>. Possui atributos, e métodos diversos para acessar esses
 * atributos sempre utilizando-se dos principios de POO como por exemplo
 * encapsulamento.
 *
 * @author Gabriel Celestino, Leticia Ventura, Lucas Chaves
 * @version 1.0
 * @since Vr 1.0
 * @see Entidade
 */
public class Turma extends Entidade {

    private Date dataInicio;
    private Date dataFim;

    /**
     * Método construtor da classe <b><i>Turma</i></b>. Este método recebe 2
     * parametros como atributos para o seu funcionamento.
     *
     * @param <b>dataInicio</b>
     * @param <b>dataFim</b>
     */
    public Turma(Date dataInicio, Date dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public boolean validar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
