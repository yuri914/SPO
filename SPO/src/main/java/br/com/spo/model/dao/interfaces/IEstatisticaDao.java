package br.com.spo.model.dao.interfaces;

import br.com.spo.model.beans.Estatistica;
import br.com.spo.model.dao.generics.GenericDAO;

public interface IEstatisticaDao extends GenericDAO<Estatistica> {
    
    public Estatistica findByUsuario(Long idUsuario);

}
