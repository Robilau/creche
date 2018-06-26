/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

import Dominio.Features.RPC.IRpcService;
import Dominio.Features.RPC.Rpc;
import java.util.List;
import Dominio.Features.RPC.IRpcRepository;

/**
 *
 * @author T0KS1CK
 */
public class RpcService implements IRpcService{
    IRpcRepository repositorio;

    public RpcService(IRpcRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Rpc adicionar(Rpc rpc) throws Exception {
        rpc.validar();
        return repositorio.adicionar(rpc);
    }

    @Override
    public Rpc atualizar(Rpc rpc) throws Exception {
        rpc.validar();
        return repositorio.atualizar(rpc);
    }

    @Override
    public Rpc pegar(Rpc rpc) throws Exception{
        return repositorio.pegar(rpc.getId());
    }

    @Override
    public List<Rpc> pegarTodos() throws Exception{
        return repositorio.pegarTodos();
    }

    @Override
    public boolean deletar(Rpc rpc) throws Exception{
        if (!repositorio.ExisteForeignKey(rpc.getId())) return repositorio.deletar(rpc.getId());
        throw new Exception("Não é possível deletar um Responsavel Pela Crianca que possua crianças cadastradas");
    }
}
