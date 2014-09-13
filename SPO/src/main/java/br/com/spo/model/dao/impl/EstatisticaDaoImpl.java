package br.com.spo.model.dao.impl;

import javax.persistence.Query;

import br.com.spo.model.beans.Estatistica;
import br.com.spo.model.dao.generics.JPAGenericDAO;
import br.com.spo.model.dao.interfaces.IEstatisticaDao;

public class EstatisticaDaoImpl extends JPAGenericDAO<Estatistica> implements IEstatisticaDao {
    
    @Override
    public Estatistica findByUsuario(Long idUsuario) {
        Query namedQuery = getEntityManager().createNamedQuery("Estatistica.findByUsuario", Estatistica.class);
        namedQuery.setParameter("idUsuario", idUsuario);
        return (Estatistica) namedQuery.getSingleResult();
    }
    
}
