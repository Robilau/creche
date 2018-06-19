/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Features.Gerente;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public interface IGerentePostgresRepository {

    Gerente adicionar(Gerente gerente) throws SQLException;

    Gerente atualizar(Gerente gerente) throws SQLException, Exception;

    Gerente pegar(int id) throws SQLException, Exception;

    boolean deletar(int id) throws SQLException, Exception;

    List<Gerente> pegarTodos() throws SQLException;

}
