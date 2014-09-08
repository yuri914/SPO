package br.com.spo.service.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.spo.model.beans.Jogo;

public interface IJogoService extends Serializable {

    public List<Jogo> listarTodos();

}
