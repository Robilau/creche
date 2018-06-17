/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Date;

/**
 * A classe Mensalidade possibilita instanciar o objeto mensalidade e extende
 * sua funcionalidade a partir da super-classse <b>Entidade</b>. Possui
 * atributos, e métodos diversos para acessar esses atributos sempre
 * utilizando-se dos principios de POO como por exemplo encapsulamento.
 *
 * @author Gabriel Celestino, Leticia Ventura, Lucas Chaves
 * @version 1.0
 * @since Vr 1.0
 * @see Entidade
 */
public class Mensalidade extends Entidade {

    private Date dataMensalidade;
    private double valorFixo;
    private double gastoCantina;
    private double falorFinal;

    /**
     * Método construtor da classe <b><i>Mensalidade</i></b>. Este método recebe
     * 4 parametros como atributos para o seu funcionamento.
     *
     * @param <b>dataMensalidade</b> Data em que a mensalidade vai ser gerada
     * @param <b>valorFixo</b> O valor fixo da mensalidade
     * @param <b>gastoCantina</b> Valor refente aos gastos da criança na cantina
     * @param <b>falorFinal</b> O valor fixo da mensalidade mais o valor refente
     * aos gastos da criança na cantina
     */
    public Mensalidade(Date dataMensalidade, double valorFixo, double gastoCantina, double falorFinal) {
        this.dataMensalidade = dataMensalidade;
        this.valorFixo = valorFixo;
        this.gastoCantina = gastoCantina;
        this.falorFinal = falorFinal;
    }

    public Date getDataMensalidade() {
        return dataMensalidade;
    }

    public void setDataMensalidade(Date dataMensalidade) {
        this.dataMensalidade = dataMensalidade;
    }

    public double getValorFixo() {
        return valorFixo;
    }

    public void setValorFixo(double valorFixo) {
        this.valorFixo = valorFixo;
    }

    public double getGastoCantina() {
        return gastoCantina;
    }

    public void setGastoCantina(double gastoCantina) {
        this.gastoCantina = gastoCantina;
    }

    public double getFalorFinal() {
        return falorFinal;
    }

    public void setFalorFinal(double falorFinal) {
        this.falorFinal = falorFinal;
    }

    @Override
    public void validar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
