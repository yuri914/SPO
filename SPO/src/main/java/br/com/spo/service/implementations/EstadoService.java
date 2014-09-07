package br.com.spo.service.implementations;

import java.util.ArrayList;
import java.util.List;

import br.com.spo.model.beans.Estado;
import br.com.spo.service.interfaces.IEstadoService;

public class EstadoService implements IEstadoService {

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
