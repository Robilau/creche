/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

import Dominio.Fatures.Relatorio.IRelatorioRepository;
import Dominio.Fatures.Relatorio.IRelatorioService;
import Dominio.Fatures.Relatorio.Relatorio;
import Dominio.Features.Crianca.Crianca;
import Infraestrutura.PDF.IPDFService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author T0KS1CK
 */
public class RelatorioService implements IRelatorioService {

    private IRelatorioRepository repositorio;
    private IPDFService PDFService;

    public RelatorioService(IRelatorioRepository repositorio, IPDFService PDFService) {
        this.repositorio = repositorio;
        this.PDFService = PDFService;
    }

    @Override
    public Relatorio adicionar(Relatorio relatorio, Crianca crianca) throws Exception {
        relatorio.validar();
        return repositorio.adicionar(relatorio, crianca.getId());
    }

    @Override
    public Relatorio atualizar(Relatorio relatorio, Crianca crianca) throws Exception {
        relatorio.validar();
        return repositorio.atualizar(relatorio, crianca.getId());
    }

    @Override
    public Relatorio pegar(Date date, Crianca crianca) throws Exception {
        return repositorio.pegar(date, crianca.getId());
    }

    @Override
    public List<Relatorio> pegarTodos(Date dateInicio, Date dateFim, Crianca crianca) throws Exception {
        return repositorio.pegarTodos(dateInicio, dateFim, crianca.getId());
    }
    
    @Override
    public List<Relatorio> pegarTodos(Crianca crianca) throws Exception {
        return repositorio.pegarTodos(crianca.getId());
    }

    @Override
    public void gerarPdfRelatorio(List<Relatorio> relatorios, Crianca crianca, String path) throws Exception {
        PDFService.gerarPdfRelatorio(relatorios, crianca, path);
    }

}
