package br.com.spo.service.interfaces;

import java.io.Serializable;

import br.com.spo.model.beans.Contato;

public interface IContatoService extends Serializable {
    
    public void salvar(Contato contato);
    
}
