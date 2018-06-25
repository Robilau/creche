/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

import Dominio.Features.Cuidador.Cuidador;
import Dominio.Features.Cuidador.ICuidadorPostgresRepository;
import Dominio.Features.Cuidador.ICuidadorService;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class CuidadorService implements ICuidadorService {

    ICuidadorPostgresRepository repositorio;

    @Override
    public Cuidador adicionar(Cuidador cuidador) throws SQLException, Exception {
        cuidador.validar();
        return repositorio.adicionar(cuidador);
    }

    public CuidadorService(ICuidadorPostgresRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Cuidador atualizar(Cuidador cuidador) throws SQLException, Exception {
        cuidador.validar();
        return repositorio.atualizar(cuidador);
    }

    @Override
    public Cuidador pegar(Cuidador cuidador) throws SQLException, Exception {
        return repositorio.pegar(cuidador.getId());
    }

    @Override
    public boolean deletar(Cuidador cuidador) throws SQLException, Exception {
        if (!repositorio.ExisteForeignKey(cuidador.getId())) return repositorio.deletar(cuidador.getId());
        throw new Exception ("Não é possível deletar um cuidador que esteja cadastrado em uma turma");
    }

    @Override
    public List<Cuidador> pegarTodos() throws SQLException {
        return repositorio.pegarTodos();
    }
}
