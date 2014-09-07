package br.com.spo.service.implementations;

import java.util.ArrayList;
import java.util.List;

import br.com.spo.model.beans.Estado;
import br.com.spo.service.interfaces.IEstadoService;

public class EstadoService implements IEstadoService {

	private static final long serialVersionUID = -7113940442347954816L;

	@Override
    public List<Estado> listarTodos() {
        List<Estado> estados = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Estado estado = new Estado();
            estado.setId((long) i);
            estado.setNome("Estado " + i);
            estados.add(estado);
        }
        return estados;
    }
    
}
