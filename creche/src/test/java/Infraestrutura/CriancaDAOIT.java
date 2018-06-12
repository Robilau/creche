/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Dominio.Crianca;
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
    ObjectMother _objectMother;
    CriancaDAO _repositorio;
    SeedDatabase _seed;

    @Before
    public void setUp() throws SQLException {
        _crianca = new Crianca();
        _criancaEsperada = new Crianca();
        _objectMother = new ObjectMother();
        _repositorio = new CriancaDAO();
        _seed.criancaSeed();
    }

    /**
     * Test of adicionar method, of class CriancaDAO.
     */
    @Test
    public void testAdicionar() throws Exception {
        System.out.println("adicionar");
        _crianca = _objectMother.pegarCrianca();
        _criancaEsperada = _repositorio.adicionar(_crianca);
        Assertions.assertThat(_criancaEsperada.getId()).isEqualTo(2);
    }

    /**
     * Test of atualizar method, of class CriancaDAO.
     */
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        _crianca = _objectMother.pegarCrianca();
        _crianca.setId(1);
        _repositorio.atualizar(_crianca);
    }

    /**
     * Test of pegarTodas method, of class CriancaDAO.
     */
    @Test
    public void testPegarTodas() throws Exception {
        List<Crianca> result = _repositorio.pegarTodas();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

    /**
     * Test of pegar method, of class CriancaDAO.
     */
    @Test
    public void testPegar() throws Exception {
        System.out.println("pegar");
        _crianca = _objectMother.pegarCrianca();
        _crianca.setId(1);
        _criancaEsperada = _repositorio.pegar(_crianca.getId());
        Assertions.assertThat(_criancaEsperada.getNome()).isEqualToIgnoringCase("nome");
    }

}
