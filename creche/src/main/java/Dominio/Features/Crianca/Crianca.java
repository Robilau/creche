/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Features.Crianca;

import Dominio.Pessoa;
import Dominio.Pessoa;
import Dominio.ResponsavelPelaCrianca;
import Dominio.ResponsavelPelaCrianca;
import java.util.Date;

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
 * @see ResponsavelPelaCrianca
 * @see Entidade
 */
public class Crianca extends Pessoa {

    private Date dataNascimento;
    private ResponsavelPelaCrianca responsavelPelaCrianca;

    public Crianca() {
    }   

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ResponsavelPelaCrianca getResponsavelPelaCrianca() {
        return responsavelPelaCrianca;
    }

    public void setResponsavelPelaCrianca(ResponsavelPelaCrianca responsavelPelaCrianca) {
        this.responsavelPelaCrianca = responsavelPelaCrianca;
    }

    @Override
    public void validar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
