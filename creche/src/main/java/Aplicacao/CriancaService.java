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
    public void adicionar(Crianca crianca) {
        try {
            repositorio.adicionar(crianca);
        } catch (SQLException ex) {
            Logger.getLogger(CriancaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(Crianca crianca) {
        try {
            repositorio.atualizar(crianca);
        } catch (Exception ex) {
            Logger.getLogger(CriancaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Crianca pegar(Crianca crianca) {
        Crianca c = new Crianca();
        try {
            c = repositorio.pegar(crianca.getId());
        } catch (Exception ex) {
            Logger.getLogger(CriancaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public List<Crianca> pegarTodas() {
        ArrayList<Crianca> lista = new ArrayList<>();
        try {
            lista = (ArrayList<Crianca>) repositorio.pegarTodas();
        } catch (SQLException ex) {
            Logger.getLogger(CriancaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public void deletar(Crianca crianca) {
        try {
            repositorio.deletar(crianca.getId());
        } catch (Exception ex) {
            Logger.getLogger(CriancaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
