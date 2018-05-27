/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import org.jongo.marshall.jackson.oid.ObjectId;

/**
 *
 * @author Aluno
 */
public abstract class Entidade {
    
    @ObjectId
    private String Id;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }  
    
    public abstract boolean validar();    
}
