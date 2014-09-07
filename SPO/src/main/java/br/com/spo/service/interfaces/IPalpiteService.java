package br.com.spo.service.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.spo.model.beans.Palpite;

public interface IPalpiteService extends Serializable {

    public List<Palpite> listarTodos();

}
