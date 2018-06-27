/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Fatures.Relatorio;

import Dominio.Features.Crianca.Crianca;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aluno
 */
public interface IRelatorioRepository {

    Relatorio adicionar(Relatorio relatorio, int criancaId) throws Exception;

    Relatorio atualizar(Relatorio relatorio, int criancaId) throws Exception;

    Relatorio pegar(Date date, int criancaId) throws Exception;

    List<Relatorio> pegarTodos(Date dateInicio, Date dateFim, int criancaId) throws Exception;

}
