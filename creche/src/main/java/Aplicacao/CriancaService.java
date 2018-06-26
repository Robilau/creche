/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

import Dominio.Features.Crianca.Crianca;
import Dominio.Features.Crianca.ICriancaService;
import java.util.List;
import Dominio.Features.Crianca.ICriancaRepository;

/**
 *
 * @author Aluno
 */
public class CriancaService implements ICriancaService {

    ICriancaRepository repositorio;

    public CriancaService(ICriancaRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Crianca adicionar(Crianca crianca) throws Exception {
        crianca.validar();
        return repositorio.adicionar(crianca);
    }

    @Override
    public Crianca atualizar(Crianca crianca) throws Exception {
        crianca.validar();
        return repositorio.atualizar(crianca);
    }

    @Override
    public Crianca pegar(Crianca crianca) throws Exception{
        return repositorio.pegar(crianca.getId());
    }

    @Override
    public List<Crianca> pegarTodas() throws Exception{
        return repositorio.pegarTodas();
    }

    @Override
    public boolean deletar(Crianca crianca) throws Exception{
        return repositorio.deletar(crianca.getId());
    }
     
}
