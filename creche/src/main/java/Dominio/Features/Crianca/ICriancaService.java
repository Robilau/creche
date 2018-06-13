/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Features.Crianca;

import java.util.List;

/**
 *
 * @author Aluno
 */
public interface ICriancaService {
    void adicionar(Crianca crianca);
    void atualizar(Crianca crianca);
    Crianca pegar(Crianca crianca);
    List<Crianca> pegarTodas();
    void deletar(Crianca crianca);
}
