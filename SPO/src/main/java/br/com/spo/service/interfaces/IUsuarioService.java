package br.com.spo.service.interfaces;

import java.io.Serializable;

import br.com.spo.model.beans.Usuario;

public interface IUsuarioService extends Serializable {

    public void salvar(Usuario usuario);
    
}
