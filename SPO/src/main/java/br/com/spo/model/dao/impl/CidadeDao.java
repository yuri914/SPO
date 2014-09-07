package br.com.spo.model.dao.impl;

import java.util.HashMap;
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
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        sb.append("From Cidade c where c.estado = :estadoId");
        parametros.put("estadoId", estado.getId());
        
        return (List<Cidade>) getEntityManager().createQuery(sb.toString(), Cidade.class);
    }

}
