package br.com.spo.model.dao.impl;

import java.util.List;

import br.com.spo.model.beans.Cidade;
import br.com.spo.model.beans.Estado;
import br.com.spo.model.dao.generics.JPAGenericDAO;
import br.com.spo.model.dao.interfaces.ICidadeDao;

public class CidadeDao extends JPAGenericDAO<Cidade> implements ICidadeDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Cidade> listarCidades(Estado estado) {
        StringBuilder sb = new StringBuilder();

        sb.append("From Cidade c where c.estado.id = ?");
        
        return (List<Cidade>) buscarPorJpql(sb.toString(), estado.getId());
    }

}
