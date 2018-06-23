/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Features.Crianca;

import Dominio.Entidade;
import Dominio.Pessoa;
import Dominio.Features.RPC.Rpc;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A classe crianca possibilita instanciar crianças e extende sua funcionalidade
 * a partir das super-classses <b>Pessoa</b> <b>Entidade</b>. Possui atributos, e métodos diversos
 * para acessar esses atributos sempre utilizando-se dos principios de POO como
 * por exemplo encapsulamento.
 *
 * @author Gabriel Celestino, Leticia Ventura, Lucas Chaves
 * @version 1.0
 * @since Vr 1.0
 * @see Pessoa
 * @see Rpc
 * @see Entidade
 */
public class Crianca extends Pessoa {

    private Date dataNascimento;
    private Rpc responsavelPelaCrianca;

    public Crianca() {
    }   

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Rpc getResponsavelPelaCrianca() {
        return responsavelPelaCrianca;
    }

    public void setResponsavelPelaCrianca(Rpc responsavelPelaCrianca) {
        this.responsavelPelaCrianca = responsavelPelaCrianca;
    }

    @Override
    public void validar() throws Exception{
        super.validar();
        if (responsavelPelaCrianca == null) throw new Exception("Responsável pela crianca não pode ser nulo");
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "  RG: " + this.getRG() + "  Data de Nascimento: " + DateFormat.getDateInstance(DateFormat.SHORT).format(dataNascimento);
    }
    
    

}
