package br.com.spo.service.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.spo.model.beans.Estado;

public interface IEstadoService extends Serializable {

    public List<Estado> listarTodos();

}
