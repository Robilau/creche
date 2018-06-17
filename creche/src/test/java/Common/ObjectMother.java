/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Dominio.Features.Crianca.Crianca;
import Dominio.Features.RPC.Rpc;
import java.util.Date;

/**
 *
 * @author Aluno
 */
public class ObjectMother {
    public static Crianca pegarCrianca(){
        Crianca c = new Crianca();
        c.setDataNascimento(new Date());
        c.setNome("nome_crianca");
        c.setRG("rg_crianca");
        c.setResponsavelPelaCrianca(pegarRpc());
        c.getResponsavelPelaCrianca().setId(1);
        return c;
    }
    
    public static Rpc pegarRpc(){
        Rpc rpc = new Rpc();
        rpc.setNome("nome_rpc");
        rpc.setRG("rg_rpc");
        rpc.setCPF("cpf_rpc");
        rpc.setTelefone("telefone_rpc");
        rpc.setEndereco("endereco_rpc");
        return rpc;
    }
}
