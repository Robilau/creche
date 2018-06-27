/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Features.Turma;

import Dominio.Features.Cuidador.Cuidador;
import Dominio.Base.Entidade;
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

    private String nome;
    private String turno;
    private Cuidador cuidador;

    public Cuidador getCuidador() {
        return cuidador;
    }

    public void setCuidador(Cuidador cuidador) {
        this.cuidador = cuidador;
    }   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    

    @Override
    public void validar() throws Exception {
        if (cuidador == null) throw new Exception ("cuidador não pode estar nulo");
        if (turno.isEmpty()) throw new Exception("Turno não pode estar vazio");
        if (nome.isEmpty()) throw new Exception("Nome não pode estar vazio");
    }

    @Override
    public String toString() {
        return String.format("Nome: %-20s"
                + "Turno: %-20s"
                + "Cuidador: %s", nome, turno, cuidador.getNome());
    }
    
    
}
