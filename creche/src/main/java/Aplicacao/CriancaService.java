/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

import Dominio.Features.Crianca.Crianca;
import Dominio.Features.Crianca.ICriancaPostgresRepository;
import Dominio.Features.Crianca.ICriancaService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class CriancaService implements ICriancaService {

    ICriancaPostgresRepository repositorio;

    public CriancaService(ICriancaPostgresRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Crianca adicionar(Crianca crianca) throws SQLException, Exception {
        crianca.validar();
        return repositorio.adicionar(crianca);
    }

    @Override
    public Crianca atualizar(Crianca crianca) throws SQLException, Exception {
        crianca.validar();
        return repositorio.atualizar(crianca);
    }

    @Override
    public Crianca pegar(Crianca crianca) throws SQLException, Exception{
        return repositorio.pegar(crianca.getId());
    }

    @Override
    public List<Crianca> pegarTodas() throws SQLException{
        return repositorio.pegarTodas();
    }

    @Override
    public boolean deletar(Crianca crianca) throws SQLException, Exception{
        return repositorio.deletar(crianca.getId());
    }
     
}
