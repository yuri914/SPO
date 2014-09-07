package br.com.spo.service.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.spo.model.beans.Cidade;
import br.com.spo.model.beans.Estado;

public interface ICidadeService extends Serializable {
    
    public List<Cidade> listarCidades(Estado estado);

}
