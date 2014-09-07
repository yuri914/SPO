package br.com.spo.service.implementations;

import br.com.spo.model.beans.Usuario;
import br.com.spo.model.dao.impl.UsuarioDao;
import br.com.spo.service.interfaces.IUsuarioService;

public class UsuarioService implements IUsuarioService {

    private static final long serialVersionUID = -8144950014959940389L;

    private UsuarioDao usuarioDao;

    @Override
    public void salvar(Usuario usuario) {
        getUsuarioDao().salvar(usuario);
    }

    public UsuarioDao getUsuarioDao() {
        if (usuarioDao == null) {
            usuarioDao = new UsuarioDao();
        }
        return usuarioDao;
    }
    
}
