/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

import Dominio.Features.RPC.IRpcPostgresRepository;
import Dominio.Features.RPC.IRpcService;
import Dominio.Features.RPC.Rpc;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author T0KS1CK
 */
public class RpcService implements IRpcService{
    IRpcPostgresRepository repositorio;

    public RpcService(IRpcPostgresRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Rpc adicionar(Rpc rpc) throws SQLException, Exception {
        rpc.validar();
        return repositorio.adicionar(rpc);
    }

    @Override
    public Rpc atualizar(Rpc rpc) throws SQLException, Exception {
        rpc.validar();
        return repositorio.atualizar(rpc);
    }

    @Override
    public Rpc pegar(Rpc rpc) throws SQLException, Exception{
        rpc.validar();
        return repositorio.pegar(rpc.getId());
    }

    @Override
    public List<Rpc> pegarTodas() throws SQLException{
        return repositorio.pegarTodos();
    }

    @Override
    public boolean deletar(Rpc rpc) throws SQLException, Exception{
        rpc.validar();
        if (!repositorio.ExisteForeignKey(rpc.getId())) return repositorio.deletar(rpc.getId());
        throw new Exception("Não é possível deletar um Responsavel Pela Crianca que possua crianças cadastradas");
    }
}
