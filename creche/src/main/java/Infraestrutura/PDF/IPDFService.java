/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura.PDF;

import Dominio.Fatures.Relatorio.Relatorio;
import Dominio.Features.Crianca.Crianca;
import java.util.List;

/**
 *
 * @author T0KS1CK
 */
public interface IPDFService {
    
    public void gerarPdfRelatorio(List<Relatorio> relatorios, Crianca crianca, String path) throws Exception ;
}
