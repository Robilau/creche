/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

import Dominio.Features.Turma.ITurmaPostgresRepository;
import Dominio.Features.Turma.ITurmaService;
import Dominio.Features.Turma.Turma;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class TurmaService implements ITurmaService{

    ITurmaPostgresRepository repositorio;

    public TurmaService(ITurmaPostgresRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Turma adicionar(Turma turma) throws SQLException, Exception {
        turma.validar();
        return repositorio.adicionar(turma);
    }

    @Override
    public Turma atualizar(Turma turma) throws SQLException, Exception {
        turma.validar();
        return repositorio.atualizar(turma);
    }

    @Override
    public Turma pegar(Turma turma) throws SQLException, Exception{
        return repositorio.pegar(turma.getId());
    }

    @Override
    public List<Turma> pegarTodas() throws SQLException{
        return repositorio.pegarTodos();
    }

    @Override
    public boolean deletar(Turma turma) throws SQLException, Exception{
        if (!repositorio.ExisteForeignKey(turma.getId()))return repositorio.deletar(turma.getId());
        throw new Exception ("Não é possível deletar uma turma que possua crianças cadastradas");
    }
    
}
