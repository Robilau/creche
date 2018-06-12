/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Dominio.Crianca;
import Dominio.ResponsavelPelaCrianca;

/**
 *
 * @author Aluno
 */
public class ObjectMother {
    public Crianca pegarCrianca(){
        Crianca c = new Crianca();
        c.setEndereco("lages");
        c.setNome("crianca");
        c.setRG("123890");
        c.setTelefone("456");
        return c;
    }
}
