
package Dominio.Interfaces;

import java.util.Vector;

/**
 * Interface que define os metodos que uma classe de repositorio deve ter
 * @author Aluno
 */
public interface IRepository <T>{
    T Adicionar(T t);
    T Atualizar(T t);
    void Excluir(T t);
    Vector<T> PegarTodos();
    T Pegar(long id);
}
