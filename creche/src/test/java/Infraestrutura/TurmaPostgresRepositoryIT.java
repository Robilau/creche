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
    SeedDatabase _seed = new SeedDatabase();

    @Before
    public void setUp() throws SQLException {
        _turma = new Turma();
        _turmaEsperada = new Turma();
        _repositorio = new TurmaPostgresRepository();
        _seed.turmaECuidadorSeed();
    }

    /**
     * Test of adicionar method, of class TurmaPostgresRepository.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAdicionar() throws Exception {
        System.out.println("adicionar");
        _turma = ObjectMother.pegarTurma();
        _turmaEsperada = _repositorio.adicionar(_turma);
        Assertions.assertThat(_turmaEsperada.getId()).isEqualTo(2);
    }

    /**
     * Test of atualizar method, of class TurmaPostgresRepository.
     * @throws java.lang.Exception
     */
    @Test
    public void testAtualizar() throws Exception {
        System.out.println("atualizar");
        _turma = ObjectMother.pegarTurma();
        _turma.setId(1);
        _turma.setDataInicio(new Date(1996, 8, 12));
        _turmaEsperada = _repositorio.atualizar(_turma);
        Assertions.assertThat(_turmaEsperada.getDataInicio()).hasYear(_turma.getDataInicio().getYear());
    }

    /**
     * Test of deletar method, of class TurmaPostgresRepository.
     */
    @Test
    public void testDeletar() throws Exception {
        System.out.println("deletar");
        int id = 1;
        Assertions.assertThat(_repositorio.deletar(id)).isTrue();
        Assertions.assertThat(_repositorio.pegar(id)).isNull();
    }

    /**
     * Test of pegarTodos method, of class TurmaPostgresRepository.
     */
    @Test
    public void testPegarTodos() throws Exception {
        List<Turma> result = _repositorio.pegarTodos();
        Assertions.assertThat(result.size()).isEqualTo(1);
    }

    /**
     * Test of pegar method, of class TurmaPostgresRepository.
     */
    @Test
    public void testPegar() throws Exception {
        System.out.println("pegar");
        _turma = ObjectMother.pegarTurma();
        _turma.setId(1);
        _turmaEsperada = _repositorio.pegar((int) _turma.getId());
        Assertions.assertThat(_turmaEsperada.getDataInicio()).hasYear(_turma.getDataInicio().getYear());
        Assertions.assertThat(_turmaEsperada.getCuidador().getNome()).isEqualToIgnoringCase(_turma.getCuidador().getNome());
    }

}
