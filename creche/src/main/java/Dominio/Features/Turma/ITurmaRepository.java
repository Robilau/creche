/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Features.Turma;

import Dominio.Features.Turma.Turma;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public interface ITurmaRepository {
    Turma adicionar(Turma turma) throws Exception;

    Turma atualizar(Turma turma) throws Exception;

    Turma pegar(int id) throws Exception;

    boolean deletar(int id) throws Exception;
    
    List<Turma> pegarTodos() throws Exception;
    
    public boolean ExisteForeignKey(int id) throws Exception;
}
