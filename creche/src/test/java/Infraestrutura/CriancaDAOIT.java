/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Dominio.Features.Crianca.Crianca;
import Common.ObjectMother;
import Common.SeedDatabase;
import java.sql.SQLException;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Aluno
 */
public class CriancaDAOIT {

    Crianca _crianca;
    Crianca _criancaEsperada;
    CriancaPostgresRepository _repositorio;
    SeedDatabase _seed = new SeedDatabase();

    @Before
    public void setUp() throws SQLException {
        _crianca = new Crianca();
        _criancaEsperada = new Crianca();
        _repositorio = new CriancaPostgresRepository();
        _seed.criancaSeed();
    }

    /**
     * Test of adicionar method, of class CriancaPostgresRepository.
     * @throws java.lang.Exception
     */
    @Test
    public void testAdicionar() throws Exception {
        System.out.println("adicionar");
        _crianca = ObjectMother.pegarCrianca();
        _criancaEsperada = _repositorio.adicionar(_crianca);
        Assertions.assertThat(_criancaEsperada.getId()).isEqualTo(2);
    }

    /**
     * Test of atualizar method, of class CriancaPostgresRepository.
     * @throws java.lang.Exception
     */
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        _crianca = ObjectMother.pegarCrianca();
        _crianca.setId(1);
        _crianca.setNome("atualizar");
        _criancaEsperada = _repositorio.atualizar(_crianca);
        Assertions.assertThat(_criancaEsperada.getNome()).isEqualToIgnoringCase(_crianca.getNome());
    }

    /**
     * Test of pegarTodas method, of class CriancaPostgresRepository.
     * @throws java.lang.Exception
     */
    @Test
    public void testPegarTodas() throws Exception {
        List<Crianca> result = _repositorio.pegarTodas();
        Assertions.assertThat(result.size()).isEqualTo(1);
    }

    /**
     * Test of pegar method, of class CriancaPostgresRepository.
     * @throws java.lang.Exception
     */
    @Test
    public void testPegar() throws Exception {
        System.out.println("pegar");
        _crianca = ObjectMother.pegarCrianca();
        _crianca.setId(1);
        _criancaEsperada = _repositorio.pegar(_crianca.getId());
        Assertions.assertThat(_criancaEsperada.getNome()).isEqualToIgnoringCase(_crianca.getNome());
    }

    /**
     * Test of deletar method, of class CriancaPostgresRepository.
     * @throws java.lang.Exception
     */
    @Test
    public void testDeletar() throws Exception {
        System.out.println("deletar");
        long id = 1;
        Assertions.assertThat(_repositorio.deletar(id)).isTrue();
        Assertions.assertThat(_repositorio.pegar(id)).isNull();
    }

}
