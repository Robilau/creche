/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

import Dominio.Features.Gerente.Gerente;
import Dominio.Features.Gerente.IGerentePostgresRepository;
import Dominio.Features.Gerente.IGerenteService;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class GerenteService implements IGerenteService {

    IGerentePostgresRepository repositorio;

    public GerenteService(IGerentePostgresRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Gerente adicionar(Gerente gerente) throws SQLException, Exception {
        gerente.validar();
        return repositorio.adicionar(gerente);
    }

    @Override
    public Gerente atualizar(Gerente gerente) throws SQLException, Exception {
        gerente.validar();
        return repositorio.atualizar(gerente);
    }

    @Override
    public Gerente pegar(Gerente gerente) throws SQLException, Exception {
        return repositorio.pegar(gerente.getId());
    }

    @Override
    public boolean deletar(Gerente gerente) throws SQLException, Exception {
        return repositorio.deletar(gerente.getId());
    }

    @Override
    public List<Gerente> pegarTodos() throws SQLException {
        return repositorio.pegarTodos();
    }

}
