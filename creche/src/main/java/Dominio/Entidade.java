/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**A classe Entidade é abstrata e fornece atributos e métodos
 * relevantes para o instanciamento de objetos que herdam 
 * essas características... 
 * @author Gabriel Celestino, Leticia Ventura, Lucas Chaves
 * @version 1.0
 * @since Vr. 1.0
 */
public abstract class Entidade {

    int Id;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public abstract boolean validar();

}
