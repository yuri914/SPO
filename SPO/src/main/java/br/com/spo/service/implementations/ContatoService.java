package br.com.spo.service.implementations;

import br.com.spo.model.beans.Contato;
import br.com.spo.model.dao.impl.ContatoDao;
import br.com.spo.service.interfaces.IContatoService;

public class ContatoService implements IContatoService {
    
    private static final long serialVersionUID = -5151824245090910895L;

    private ContatoDao contatoDao;

    @Override
    public void salvar(Contato contato) {
        if (contato.getId() == null) {
            getContatoDao().salvar(contato);
        } else {
            getContatoDao().alterar(contato);
        }
    }
    
    public ContatoDao getContatoDao() {
        if (contatoDao == null) {
            contatoDao = new ContatoDao();
        }
        return contatoDao;
    }
    
}
