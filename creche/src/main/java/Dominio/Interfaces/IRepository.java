
package Dominio.Interfaces;

import java.util.List;

/**
 * Interface que define os metodos que uma classe de repositorio deve ter
 * @author Aluno
 */
public interface IRepository <T>{
    T Adicionar(T t);
    T Atualizar(T t);
    boolean Excluir(T t);
    List<T> PegarTodos();
    T Pegar(long id);
}
