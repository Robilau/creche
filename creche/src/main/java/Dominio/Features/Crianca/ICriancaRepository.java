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
public interface ICriancaRepository {

    Crianca adicionar(Crianca crianca) throws Exception;

    Crianca atualizar(Crianca crianca) throws Exception;

    Crianca pegar(int id) throws Exception;

    boolean deletar(int id) throws Exception;

    List<Crianca> pegarTodas() throws Exception;
}
