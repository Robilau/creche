/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Dominio.Features.Crianca.Crianca;
import java.util.Date;

/**
 *
 * @author Aluno
 */
public class ObjectMother {
    public static Crianca pegarCrianca(){
        Crianca c = new Crianca();
        c.setDataNascimento(new Date());
        c.setNome("nome");
        c.setRG("rg");
        return c;
    }
}
