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
 * @author T0KS1CK
 */
public interface IRelatorioService {

    Relatorio adicionar(Relatorio relatorio, Crianca crianca) throws Exception;

    Relatorio atualizar(Relatorio relatorio, Crianca crianca) throws Exception;

    Relatorio pegar(Date date, Crianca crianca) throws Exception;

    List<Relatorio> pegarTodos(Date dateInicio, Date dateFim, Crianca crianca) throws Exception;

    List<Relatorio> pegarTodos(Crianca crianca) throws Exception;
    
    void gerarPdfRelatorio(List<Relatorio> relatorios, Crianca crianca, String path) throws Exception;
}
