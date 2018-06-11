/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import Dominio.Crianca;
import Infraestrutura.CriancaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author T0KS1CK
 */
public class Teste {

    public static void main(String[] args) throws SQLException, Exception {
        Crianca c = new Crianca();
        c.setEndereco("aba");
        c.setNome("crianca id");
        c.setRG("asdsads");
        c.setTelefone("23423asd");

        CriancaDAO repo = new CriancaDAO();
        repo.Adicionar(c);

        Crianca r = new Crianca();
        r.setEndereco("rrrrr");
        r.setNome("crianca r");
        r.setRG("rrrr");
        r.setTelefone("23r");
        r.setId(1);
        repo.Atualizar(r);
        
        List<Crianca> a = repo.PegarTodas();
        for (Crianca crianca : a) {
            System.out.println("nome: " + crianca.getNome());
        }
        
        //System.out.println(repo.Pegar(3).toString());
    }
}
