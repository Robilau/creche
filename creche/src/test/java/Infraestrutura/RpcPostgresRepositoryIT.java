/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Common.ObjectMother;
import Common.SeedDatabase;
import Dominio.Features.RPC.Rpc;
import java.sql.SQLException;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author T0KS1CK
 */
public class RpcPostgresRepositoryIT {
    Rpc _rpc;
    Rpc _rpcEsperada;
    RpcPostgresRepository _repositorio;
    SeedDatabase _seed = new SeedDatabase();
    
    @Before
    public void setUp() throws SQLException {
        _rpc = new Rpc();
        _rpcEsperada = new Rpc();
        _repositorio = new RpcPostgresRepository();
        _seed.criancaERpcSeed();
    }

    /**
     * Test of adicionar method, of class RpcPostgresRepository.
     */
    @Test
    public void testAdicionar() throws Exception {
        System.out.println("adicionar");
        _rpc = ObjectMother.pegarRpc();
        _rpcEsperada = _repositorio.adicionar(_rpc);
        Assertions.assertThat(_rpcEsperada.getId()).isEqualTo(2);
    }

    /**
     * Test of atualizar method, of class RpcPostgresRepository.
     */
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        _rpc = ObjectMother.pegarRpc();
        _rpc.setId(1);
        _rpc.setNome("atualizar");
        _rpcEsperada = _repositorio.atualizar(_rpc);
        Assertions.assertThat(_rpcEsperada.getNome()).isEqualToIgnoringCase(_rpc.getNome());
    }

    /**
     * Test of deletar method, of class RpcPostgresRepository.
     */
    @Test
    public void testDeletar() throws Exception {
        System.out.println("deletar");
        int id = 1;
        Assertions.assertThat(_repositorio.deletar(id)).isTrue();
        Assertions.assertThat(_repositorio.pegar(id)).isNull();
    }

    /**
     * Test of pegarTodas method, of class RpcPostgresRepository.
     */
    @Test
    public void testPegarTodas() throws Exception {
        List<Rpc> result = _repositorio.pegarTodos();
        Assertions.assertThat(result.size()).isEqualTo(1);
    }

    /**
     * Test of pegar method, of class RpcPostgresRepository.
     */
    @Test
    public void testPegar() throws Exception {
        System.out.println("pegar");
        _rpc = ObjectMother.pegarRpc();
        _rpc.setId(1);
        _rpcEsperada = _repositorio.pegar(_rpc.getId());
        Assertions.assertThat(_rpcEsperada.getNome()).isEqualToIgnoringCase(_rpc.getNome());
    }
    
}
