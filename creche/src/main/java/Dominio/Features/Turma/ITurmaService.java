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
public interface ITurmaService {
    Turma adicionar(Turma turma) throws SQLException, Exception;

    Turma atualizar(Turma turma) throws SQLException, Exception;

    Turma pegar(Turma turma) throws SQLException, Exception;

    List<Turma> pegarTodas() throws SQLException;

    boolean deletar(Turma turma)  throws SQLException, Exception;
}
