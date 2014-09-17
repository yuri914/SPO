package br.com.spo.service.implementations;

import br.com.spo.model.beans.Usuario;
import br.com.spo.model.dao.impl.UsuarioDao;
import br.com.spo.service.exceptions.AutenticacaoException;
import br.com.spo.service.interfaces.IUsuarioService;

public class UsuarioService implements IUsuarioService {
    
    private static final long serialVersionUID = -8144950014959940389L;
    
    private UsuarioDao usuarioDao;
    
    @Override
    public void salvar(Usuario usuario) {
        getUsuarioDao().salvar(usuario);
    }
    
    public Usuario autenticarUsuario(Usuario usuario) throws AutenticacaoException {
        Usuario usuarioAutenticado = getUsuarioDao().autenticar(usuario);
        if (usuarioAutenticado == null) {
            throw new AutenticacaoException();
        }
        return usuarioAutenticado;
    }
    
    public boolean verificarUsuarioExistente(String username) {
        return getUsuarioDao().verificaUsuarioExistente(username).intValue() > 0;
    }

    public UsuarioDao getUsuarioDao() {
        if (usuarioDao == null) {
            usuarioDao = new UsuarioDao();
        }
        return usuarioDao;
    }
    
}
