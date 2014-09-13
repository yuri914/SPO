package br.com.spo.service.interfaces;

import br.com.spo.model.beans.Estatistica;

public interface IEstatisticaService {
    
    public Estatistica findByUsuario(Long idUsuario);
    
}
