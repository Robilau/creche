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
public interface ITurmaPostgresRepository {
    Turma adicionar(Turma turma) throws SQLException;

    Turma atualizar(Turma turma) throws SQLException, Exception;

    Turma pegar(int id) throws SQLException, Exception;

    boolean deletar(int id) throws SQLException, Exception;
    
    boolean ExisteForeignKey(int id) throws SQLException, Exception;

    List<Turma> pegarTodos() throws SQLException;
}
