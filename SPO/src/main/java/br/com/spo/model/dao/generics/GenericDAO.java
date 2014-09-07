package br.com.spo.model.dao.generics;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuri.sousa
 *
 * @param <T>
 *            entity class
 */
public interface GenericDAO<T extends Serializable> {
    void salvar(T t);

    void alterar(T t);

    void remover(Serializable id);

    T buscarPorId(Serializable id);

    List<T> listarTodos();

    List<?> buscarPorJpql(String jpql, Object... parans);

    Object buscarUnicoResultadoPorJpql(String jpql, Object... parans);

    int count();
}
