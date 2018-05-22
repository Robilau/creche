/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import com.mongodb.DB;
import com.mongodb.Mongo;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

/**
 * Classe que faz a conexão com o banco de dados
 * @author Leticia
 */
public class DAO <T>{
    DB _db;
    Jongo _jongo;
    MongoCollection _colecao;

    public DAO(String colecao) {
        _db = new Mongo().getDB("Creche");
        _jongo = new Jongo(_db);
        _colecao = _jongo.getCollection(colecao);
    }
    
    public Iterable<T> PegarTodos(){
        return _colecao.find().as(clazz);
    }
    
}
