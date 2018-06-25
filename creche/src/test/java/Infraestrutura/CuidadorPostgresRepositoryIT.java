/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Common.ObjectMother;
import Common.SeedDatabase;
import Dominio.Features.Cuidador.ICuidadorPostgresRepository;
import Dominio.Features.Cuidador.Cuidador;
import java.sql.SQLException;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Aluno
 */
public class CuidadorPostgresRepositoryIT {
    Cuidador _cuidador;
    Cuidador _cuidadorEsperado;
    ICuidadorPostgresRepository _repositorio;

    @Before
    public void setUp() throws SQLException {
        _cuidador = new Cuidador();
        _cuidadorEsperado = new Cuidador();
        _repositorio = new CuidadorPostgresRepository();
    }

    /**
     * Test of adicionar method, of class CuidadorPostgresRepository.
     */
    @Test
    public void testAdicionar() throws Exception {
        System.out.println("adicionar");
        SeedDatabase.cuidadorSeed();
        _cuidador = ObjectMother.pegarCuidador();
        _cuidadorEsperado = _repositorio.adicionar(_cuidador);
        Assertions.assertThat(_cuidadorEsperado.getId()).isEqualTo(2);
    }

    /**
     * Test of atualizar method, of class CuidadorPostgresRepository.
     */
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        SeedDatabase.cuidadorSeed();
        _cuidador = ObjectMother.pegarCuidador();
        _cuidador.setId(1);
        _cuidador.setNome("Novo Nome");
        _cuidadorEsperado = _repositorio.atualizar(_cuidador);
        Assertions.assertThat(_cuidadorEsperado.getNome()).isEqualTo(_cuidador.getNome());
    }

    /**
     * Test of deletar method, of class CuidadorPostgresRepository.
     */
    @Test
    public void testDeletar() throws Exception {
        System.out.println("deletar");
        SeedDatabase.cuidadorSeed();
        int id = 1;
        Assertions.assertThat(_repositorio.deletar(id)).isTrue();
        Assertions.assertThat(_repositorio.pegar(id)).isNull();
    }

    /**
     * Test of pegarTodos method, of class CuidadorPostgresRepository.
     */
    @Test
    public void testPegarTodos() throws Exception {
        SeedDatabase.cuidadorSeed();
        List<Cuidador> result = _repositorio.pegarTodos();
        Assertions.assertThat(result.size()).isEqualTo(1);
    }

    /**
     * Test of pegar method, of class CuidadorPostgresRepository.
     */
    @Test
    public void testPegar() throws Exception {
        System.out.println("pegar");
        SeedDatabase.cuidadorSeed();
        _cuidador = ObjectMother.pegarCuidador();
        _cuidador.setId(1);
        _cuidadorEsperado = _repositorio.pegar((int) _cuidador.getId());
        Assertions.assertThat(_cuidadorEsperado).isNotNull();
    }

    /**
     * Test of ExisteForeignKey method, of class CuidadorPostgresRepository.
     */
    @Test
    public void testExisteForeignKey() throws Exception {
        System.out.println("ExisteForeignKey");
        SeedDatabase.turmaECuidadorSeed();
        Assertions.assertThat(_repositorio.ExisteForeignKey(1)).isTrue();
    }
    
    /**
     * Test of ExisteForeignKey method, of class CuidadorPostgresRepository.
     */
    @Test
    public void testExisteForeignKey_shouldBeFalse() throws Exception {
        System.out.println("ExisteForeignKey");
        SeedDatabase.cuidadorSeed();
        Assertions.assertThat(_repositorio.ExisteForeignKey(2)).isFalse();
    }
    
}
