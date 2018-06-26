/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

import Dominio.Features.Turma.ITurmaService;
import Dominio.Features.Turma.Turma;
import java.util.List;
import Dominio.Features.Turma.ITurmaRepository;

/**
 *
 * @author Aluno
 */
public class TurmaService implements ITurmaService{

    ITurmaRepository repositorio;

    public TurmaService(ITurmaRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Turma adicionar(Turma turma) throws Exception {
        turma.validar();
        return repositorio.adicionar(turma);
    }

    @Override
    public Turma atualizar(Turma turma) throws Exception {
        turma.validar();
        return repositorio.atualizar(turma);
    }

    @Override
    public Turma pegar(Turma turma) throws Exception{
        return repositorio.pegar(turma.getId());
    }

    @Override
    public List<Turma> pegarTodas() throws Exception{
        return repositorio.pegarTodos();
    }

    @Override
    public boolean deletar(Turma turma) throws Exception{
        if (!repositorio.ExisteForeignKey(turma.getId()))return repositorio.deletar(turma.getId());
        throw new Exception ("Não é possível deletar uma turma que possua crianças cadastradas");
    }
    
}
