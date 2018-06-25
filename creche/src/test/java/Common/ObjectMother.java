/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Dominio.Features.Cuidador.Cuidador;
import Dominio.Features.Crianca.Crianca;
import Dominio.Features.RPC.Rpc;
import Dominio.Features.Turma.Turma;
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
    
    public static Cuidador pegarCuidador(){
        Cuidador cuidador = new Cuidador();
        cuidador.setNome("nome_cuidador");
        cuidador.setRG("rg_cuidador");
        cuidador.setCPF("cpf_cuidador");
        cuidador.setTelefone("telefone_cuidador");
        cuidador.setLogin("login");
        cuidador.setSenha("senha");
        return cuidador;
    }

    public static Turma pegarTurma() {
        Turma turma = new Turma();
        turma.setCuidador(pegarCuidador());
        turma.getCuidador().setId(1);
        turma.setDataFim(new Date());
        turma.setDataInicio(new Date());
        return turma;
    }
}
