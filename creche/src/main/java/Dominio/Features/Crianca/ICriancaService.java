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
public interface ICriancaService {

    Crianca adicionar(Crianca crianca) throws Exception;

    Crianca atualizar(Crianca crianca) throws Exception;

    Crianca pegar(Crianca crianca) throws Exception;

    List<Crianca> pegarTodas() throws Exception;

    boolean deletar(Crianca crianca)  throws Exception;
}
