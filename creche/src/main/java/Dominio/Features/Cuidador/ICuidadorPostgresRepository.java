/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Features.Cuidador;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public interface ICuidadorPostgresRepository {

    Cuidador adicionar(Cuidador cuidador) throws SQLException;

    Cuidador atualizar(Cuidador cuidador) throws SQLException, Exception;

    Cuidador pegar(int id) throws SQLException, Exception;

    boolean deletar(int id) throws SQLException, Exception;

    List<Cuidador> pegarTodos() throws SQLException;

    public boolean ExisteForeignKey(int id) throws SQLException, Exception;
}
