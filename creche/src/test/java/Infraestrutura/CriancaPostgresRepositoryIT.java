/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Common.ObjectMother;
import Common.SeedDatabase;
import Dominio.Features.Crianca.Crianca;
import Dominio.Features.Crianca.ICriancaPostgresRepository;
import java.sql.SQLException;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author T0KS1CK
 */
public class CriancaPostgresRepositoryIT {
    Crianca _crianca;
    Crianca _criancaEsperada;
    ICriancaPostgresRepository _repositorio;

    @AfterClass
    public static void tearDownClass() throws Exception {
        SeedDatabase.seedCompleto();
    }
    
    @Before
    public void setUp() throws SQLException {
        _crianca = new Crianca();
        _criancaEsperada = new Crianca();
        _repositorio = new CriancaPostgresRepository();
        SeedDatabase.seedCompleto();
    }

    /**
     * Test of adicionar method, of class CriancaPostgresRepository.
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
     * Test of deletar method, of class CriancaPostgresRepository.
     */
    @Test
    public void testDeletar() throws Exception {
        System.out.println("deletar");
        int id = 1;
        Assertions.assertThat(_repositorio.deletar(id)).isTrue();
        Assertions.assertThat(_repositorio.pegar(id)).isNull();
    }

    /**
     * Test of pegarTodas method, of class CriancaPostgresRepository.
     */
    @Test
    public void testPegarTodas() throws Exception {
        List<Crianca> result = _repositorio.pegarTodas();
        Assertions.assertThat(result.size()).isEqualTo(1);
    }

    /**
     * Test of pegar method, of class CriancaPostgresRepository.
     */
    @Test
    public void testPegar() throws Exception {
        System.out.println("pegar");
        _crianca = ObjectMother.pegarCrianca();
        _crianca.setId(1);
        _criancaEsperada = _repositorio.pegar((int) _crianca.getId());
        Assertions.assertThat(_criancaEsperada.getNome()).isNotEmpty();
        Assertions.assertThat(_criancaEsperada.getResponsavelPelaCrianca().getNome()).isNotEmpty();
        Assertions.assertThat(_criancaEsperada.getTurma().getCuidador().getNome()).isNotEmpty();
    }
    
}