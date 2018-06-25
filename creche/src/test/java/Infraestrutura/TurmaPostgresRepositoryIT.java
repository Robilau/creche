/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Common.ObjectMother;
import Common.SeedDatabase;
import Dominio.Features.Turma.ITurmaPostgresRepository;
import Dominio.Features.Turma.Turma;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Aluno
 */
public class TurmaPostgresRepositoryIT {

    Turma _turma;
    Turma _turmaEsperada;
    ITurmaPostgresRepository _repositorio;

    @AfterClass
    public static void tearDownClass() throws Exception {
        SeedDatabase.restartDB();
    }

    @Before
    public void setUp() throws SQLException {
        _turma = new Turma();
        _turmaEsperada = new Turma();
        _repositorio = new TurmaPostgresRepository();
    }

    /**
     * Test of adicionar method, of class TurmaPostgresRepository.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAdicionar() throws Exception {
        System.out.println("adicionar");
        SeedDatabase.turmaECuidadorSeed();
        _turma = ObjectMother.pegarTurma();
        _turmaEsperada = _repositorio.adicionar(_turma);
        Assertions.assertThat(_turmaEsperada.getId()).isEqualTo(2);
        Assertions.assertThat(_turmaEsperada.getNome()).isEqualTo(_turma.getNome());
        Assertions.assertThat(_turmaEsperada.getCuidador().getNome()).isEqualTo(_turma.getCuidador().getNome());
    }

    /**
     * Test of atualizar method, of class TurmaPostgresRepository.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        SeedDatabase.turmaECuidadorSeed();
        _turma = ObjectMother.pegarTurma();
        _turma.setId(1);
        _turma.setNome("nome atualizado");
        _turmaEsperada = _repositorio.atualizar(_turma);
        Assertions.assertThat(_turmaEsperada.getNome()).isEqualTo(_turma.getNome());
        Assertions.assertThat(_turmaEsperada.getCuidador().getNome()).isEqualTo(_turma.getCuidador().getNome());
    }

    /**
     * Test of deletar method, of class TurmaPostgresRepository.
     */
    @Test
    public void testDeletar() throws Exception {
        System.out.println("deletar");
        SeedDatabase.turmaECuidadorSeed();
        int id = 1;
        Assertions.assertThat(_repositorio.deletar(id)).isTrue();
        Assertions.assertThat(_repositorio.pegar(id)).isNull();
    }

    /**
     * Test of pegarTodos method, of class TurmaPostgresRepository.
     */
    @Test
    public void testPegarTodos() throws Exception {
        SeedDatabase.turmaECuidadorSeed();
        List<Turma> result = _repositorio.pegarTodos();
        Assertions.assertThat(result.size()).isEqualTo(1);
    }

    /**
     * Test of pegar method, of class TurmaPostgresRepository.
     */
    @Test
    public void testPegar() throws Exception {
        System.out.println("pegar");
        SeedDatabase.turmaECuidadorSeed();
        int idParaBuscar = 1;
        _turmaEsperada = _repositorio.pegar(idParaBuscar);
        Assertions.assertThat(_turmaEsperada.getNome()).isNotEmpty();
        Assertions.assertThat(_turmaEsperada.getCuidador().getNome()).isNotEmpty();
    }

    /**
     * Test of ExisteForeignKey method, of class TurmaPostgresRepository.
     */
    @Test
    public void testExisteForeignKey_shouldBeFalse() throws Exception {
        SeedDatabase.turmaECuidadorSeed();
        int id = 1;
        boolean resultado = _repositorio.ExisteForeignKey(id);
        Assertions.assertThat(resultado).isFalse();
    }
    
        /**
     * Test of ExisteForeignKey method, of class TurmaPostgresRepository.
     */
    @Test
    public void testExisteForeignKey_shouldBeTrue() throws Exception {
        SeedDatabase.seedCompleto();
        int id = 1;
        boolean resultado = _repositorio.ExisteForeignKey(id);
        Assertions.assertThat(resultado).isTrue();
    }
}
