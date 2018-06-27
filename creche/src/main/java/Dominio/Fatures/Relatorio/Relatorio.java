/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Fatures.Relatorio;

import Dominio.Base.Entidade;
import Dominio.Features.Crianca.Crianca;
import java.util.ArrayList;
import java.util.Date;

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

    private String texto;
    private Date data;
    private boolean ausente;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isAusente() {
        return ausente;
    }

    public void setAusente(boolean ausente) {
        this.ausente = ausente;
    }
    
    
    
    @Override
    public void validar() throws Exception {
        if (ausente == false && texto.length() < 100) throw  new Exception ("O texto deve ter pelo menos 100 caracteres ou a opção ausente deve estar marcada");
        if (data == null) throw new Exception ("A data não pode estar vazia");
    }
}
