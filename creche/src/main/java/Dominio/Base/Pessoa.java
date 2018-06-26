/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Base;

import Dominio.Base.Entidade;

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
    String RG;   
    
    public Pessoa(){
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    } 
    
    @Override
    public void validar() throws Exception{
        if(nome.isEmpty()) throw new Exception("Nome não pode ser vazio");
        if(RG.isEmpty()) throw new Exception("RG não pode ser vazio");
    }   
}
