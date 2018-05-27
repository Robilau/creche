/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infraestrutura;

import Dominio.Entidade;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import static javafx.scene.input.KeyCode.T;
import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

/**
 * Classe que faz a conexão com o banco de dados
 *
 * @author Leticia
 */
public class DAO<T extends Entidade> {

    DB _db;
    Jongo _jongo;
    MongoCollection _colecao;
    Class clazz;

    /**
     * O método construtor recebe como parâmetro o nome da coleção alvo no banco
     * de dados
     *
     * @param colecao
     */
    public DAO(String colecao) {
        _db = new Mongo().getDB("CRECHE");
        _jongo = new Jongo(_db);
        _colecao = _jongo.getCollection(colecao);
        clazz = T.getClass();
    }

    /**
     * Método que pega todos os dados da coleção
     *
     * @return
     */
    public Iterable<T> PegarTodos() {
        return _colecao.find().as(clazz);
    }

    /**
     * Método que pega o elemento correspondente ao Id passado por parametro
     *
     * @param id
     * @return
     */
    public T Pegar(String id) {
        return (T) _colecao.findOne(new ObjectId(id)).as(clazz);
    }
    
    /**
     * Método que atualiza na base de dados o objeto passado por paramtro
     * @param t
     * @return 
     */
    public T Atualizar(T t){
        WriteResult wr = _colecao.update(new ObjectId(t.getId())).with(t);
        if (wr.getN() == 1) return Pegar(t.getId());
        return null;
    }
    
    /**
     * Método que insere na base de dados o objeto passado por parametro
     * @param t
     * @return 
     */
    public T Inserir (T t){
        WriteResult wr = _colecao.save(t);
        if (wr.getN() == 1) return Pegar(t.getId());
        return null;
    }
    
    /**
     * Método que remove da base de dados o objeto referente ao id passado por parametro
     * @param id
     * @return 
     */
    public boolean Remover(String id){
        WriteResult wr = _colecao.remove(new ObjectId(id));
        if (wr.getN() == 1) return true;
        return false;
    }

}
