/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import Dominio.Crianca;
import Infraestrutura.CriancaDAO;

/**
 *
 * @author T0KS1CK
 */
public class Teste {
    public static void main(String[] args) {
        Crianca c = new Crianca();
        c.setEndereco("aaa");
        c.setNome("crianca");
        c.setRG("asdsads");
        c.setTelefone("23423asd");
        
        CriancaDAO repo = new CriancaDAO();
        repo.Inserir(c);
        Iterable<Crianca> a = repo.PegarTodos();
        for (Crianca crianca : a) {
            System.out.println("id: " + crianca.getId());
        }
    }
}
