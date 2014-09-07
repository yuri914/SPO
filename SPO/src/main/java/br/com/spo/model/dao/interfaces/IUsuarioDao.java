package br.com.spo.model.dao.interfaces;

import br.com.spo.model.beans.Usuario;
import br.com.spo.model.dao.generics.GenericDAO;

public interface IUsuarioDao extends GenericDAO<Usuario> {
    
    public Usuario autenticar(Usuario usuario);

}
