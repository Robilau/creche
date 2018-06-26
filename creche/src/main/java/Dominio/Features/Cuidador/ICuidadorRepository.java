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
public interface ICuidadorRepository {

    Cuidador adicionar(Cuidador cuidador) throws Exception;

    Cuidador atualizar(Cuidador cuidador) throws Exception;

    Cuidador pegar(int id) throws Exception;

    boolean deletar(int id) throws Exception;

    List<Cuidador> pegarTodos() throws Exception;

    public boolean ExisteForeignKey(int id) throws Exception;
}
