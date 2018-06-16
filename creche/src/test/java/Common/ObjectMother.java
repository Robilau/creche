/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Dominio.Features.Crianca.Crianca;

/**
 *
 * @author Aluno
 */
public class ObjectMother {
    public static Crianca pegarCrianca(){
        Crianca c = new Crianca();
        c.setEndereco("endereco");
        c.setNome("nome");
        c.setRG("rg");
        c.setTelefone("telefone");
        return c;
    }
}
