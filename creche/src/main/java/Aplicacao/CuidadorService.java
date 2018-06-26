/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

import Dominio.Features.Cuidador.Cuidador;
import Dominio.Features.Cuidador.ICuidadorService;
import java.util.List;
import Dominio.Features.Cuidador.ICuidadorRepository;
import Infraestrutura.Login.IConfiguracoesLogin;

/**
 *
 * @author Aluno
 */
public class CuidadorService implements ICuidadorService {

    ICuidadorRepository repositorio;
    IConfiguracoesLogin configLogin;

    public CuidadorService(ICuidadorRepository repositorio, IConfiguracoesLogin configLogin) {
        this.repositorio = repositorio;
        this.configLogin = configLogin;
    }

    @Override
    public Cuidador adicionar(Cuidador cuidador) throws Exception {
        cuidador.validar();
        if (!configLogin.existeLogin(cuidador.getLogin(), cuidador.getId())) {
            return repositorio.adicionar(cuidador);
        }
        throw new Exception("Já existe um usuário cadastrado com esse login");
    }

    @Override
    public Cuidador atualizar(Cuidador cuidador) throws Exception {
        cuidador.validar();
        if (!configLogin.existeLogin(cuidador.getLogin(), cuidador.getId())) {
            return repositorio.atualizar(cuidador);
        }
        throw new Exception("Já existe um usuário cadastrado com esse login");
    }

    @Override
    public Cuidador pegar(Cuidador cuidador) throws Exception {
        return repositorio.pegar(cuidador.getId());
    }

    @Override
    public boolean deletar(Cuidador cuidador) throws Exception {
        if (!repositorio.ExisteForeignKey(cuidador.getId())) {
            return repositorio.deletar(cuidador.getId());
        }
        throw new Exception("Não é possível deletar um cuidador que esteja cadastrado em uma turma");
    }

    @Override
    public List<Cuidador> pegarTodos() throws Exception {
        return repositorio.pegarTodos();
    }
}
