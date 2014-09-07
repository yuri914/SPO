package br.com.spo.model.dao.impl;

import javax.persistence.NoResultException;

import br.com.spo.model.beans.Usuario;
import br.com.spo.model.dao.generics.JPAGenericDAO;
import br.com.spo.model.dao.interfaces.IUsuarioDao;

public class UsuarioDao extends JPAGenericDAO<Usuario> implements IUsuarioDao {
    
    @Override
    public Usuario autenticar(Usuario usuario) {
        StringBuilder sb = new StringBuilder();
        sb.append("From Usuario u where ");
        sb.append("u.username = ? AND password = ?");

        try {
            return (Usuario) buscarUnicoResultadoPorJpql(sb.toString(), usuario.getUsername(), usuario.getPassword());
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
