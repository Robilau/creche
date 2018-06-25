/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author T0KS1CK
 */
public enum TipoUsuario{
    GERENTE(1), CUIDADOR(2);
    private final int valor;

    private TipoUsuario(int valor) {
        this.valor = valor;
    }    
    public int getValor(){
        return valor;
    }
}
