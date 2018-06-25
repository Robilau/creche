/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Features.Turma;

import Dominio.Features.Cuidador.Cuidador;
import Dominio.Entidade;
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
    private Cuidador cuidador;

    public Cuidador getCuidador() {
        return cuidador;
    }

    public void setCuidador(Cuidador cuidador) {
        this.cuidador = cuidador;
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
    public void validar() throws Exception {
        if (cuidador == null) throw new Exception ("cuidador não pode estar nulo");
    }

    @Override
    public String toString() {
        return "Turma{" + "dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", cuidador=" + cuidador.getNome() + '}';
    }
    
    
}
