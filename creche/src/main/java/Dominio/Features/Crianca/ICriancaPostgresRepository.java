/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Features.Crianca;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public interface ICriancaPostgresRepository {
    Crianca adicionar(Crianca crianca) throws SQLException;
    Crianca atualizar(Crianca crianca) throws SQLException, Exception;
    Crianca pegar(long id)throws SQLException, Exception;
    void deletar(long id) throws SQLException, Exception;
    List<Crianca> pegarTodas()throws SQLException;
}
