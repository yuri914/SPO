package br.com.spo.service.implementations;

import br.com.spo.model.beans.Estatistica;
import br.com.spo.model.dao.impl.EstatisticaDaoImpl;
import br.com.spo.service.interfaces.IEstatisticaService;

public class EstatisticaService implements IEstatisticaService {

    private EstatisticaDaoImpl estatisticaDao;
    
    @Override
    public Estatistica findByUsuario(Long idUsuario) {
        return getEstatisticaDao().findByUsuario(idUsuario);
    }

    public EstatisticaDaoImpl getEstatisticaDao() {
        if (estatisticaDao == null) {
            estatisticaDao = new EstatisticaDaoImpl();
        }
        return estatisticaDao;
    }
    
}
