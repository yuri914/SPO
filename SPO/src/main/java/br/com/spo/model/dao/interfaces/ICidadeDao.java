package br.com.spo.model.dao.interfaces;

import java.util.List;

import br.com.spo.model.beans.Cidade;
import br.com.spo.model.beans.Estado;
import br.com.spo.model.dao.generics.GenericDAO;

public interface ICidadeDao extends GenericDAO<Cidade> {

    public List<Cidade> listarCidades(Estado estado);
    
}
