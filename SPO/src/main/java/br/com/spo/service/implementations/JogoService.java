package br.com.spo.service.implementations;

import java.util.ArrayList;
import java.util.List;

import br.com.spo.model.beans.Jogo;
import br.com.spo.model.dao.impl.JogoDao;
import br.com.spo.model.enumerations.Genero;
import br.com.spo.service.interfaces.IJogoService;

public class JogoService implements IJogoService {
    
    private static final long serialVersionUID = 6119199650878854068L;

    private JogoDao jogoDao;
    
    @Override
    public List<Jogo> listarTodos() {
        return getJogoDao().listarTodos();
    }

    public JogoDao getJogoDao() {
        if (jogoDao == null) {
            jogoDao = new JogoDao();
        }
        return jogoDao;
    }

    public List<Genero> removerGenero(Genero genero) {
        List<Genero> generosFiltrados = new ArrayList<>();
        if (Genero.MASCULINO.equals(genero)) {
            generosFiltrados.add(Genero.FEMININO);
        } else {
            generosFiltrados.add(Genero.MASCULINO);
        }
        return generosFiltrados;
    }

}
