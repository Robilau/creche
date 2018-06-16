/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Dominio.Features.Crianca.Crianca;
import java.util.ArrayList;

/**
 *A classe Relatorio possibilita instanciar o objeto relatorio e extende
 * sua funcionalidade a partir da super-classse <b>Entidade</b>. Possui
 * atributos, e métodos diversos para acessar esses atributos sempre
 * utilizando-se dos principios de POO como por exemplo encapsulamento.
 *
 * @author Gabriel Celestino, Leticia Ventura, Lucas Chaves
 * @version 1.0
 * @since Vr 1.0
 * @see Entidade
 */
public class Relatorio extends Entidade {

    private ArrayList<Mensalidade> consumoCrianca = new ArrayList<>();
    private ArrayList<Crianca> diaCrianca = new ArrayList<>();

    public ArrayList<Mensalidade> getConsumoCrianca() {
        return consumoCrianca;
    }

    public void setConsumoCrianca(ArrayList<Mensalidade> consumoCrianca) {
        this.consumoCrianca = consumoCrianca;
    }

    public ArrayList<Crianca> getDiaCrianca() {
        return diaCrianca;
    }

    public void setDiaCrianca(ArrayList<Crianca> diaCrianca) {
        this.diaCrianca = diaCrianca;
    }

    @Override
    public void validar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
