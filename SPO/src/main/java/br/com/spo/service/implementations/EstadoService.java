package br.com.spo.service.implementations;

import java.util.List;

import br.com.spo.model.beans.Estado;
import br.com.spo.model.dao.impl.EstadoDao;
import br.com.spo.service.interfaces.IEstadoService;

public class EstadoService implements IEstadoService {
    
    private EstadoDao estadoDao;

	private static final long serialVersionUID = -7113940442347954816L;

	@Override
    public List<Estado> listarTodos() {
        return getEstadoDao().listarTodos();
    }
    
    public EstadoDao getEstadoDao() {
        if (estadoDao == null) {
            estadoDao = new EstadoDao();
        }
        return estadoDao;
    }

}
