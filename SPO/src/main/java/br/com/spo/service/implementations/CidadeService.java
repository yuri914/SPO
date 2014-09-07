package br.com.spo.service.implementations;

import java.util.List;

import br.com.spo.model.beans.Cidade;
import br.com.spo.model.beans.Estado;
import br.com.spo.model.dao.impl.CidadeDao;
import br.com.spo.service.interfaces.ICidadeService;

public class CidadeService implements ICidadeService {

    private static final long serialVersionUID = -9206179930388569872L;

    private CidadeDao cidadeDao;

    @Override
    public List<Cidade> listarCidades(Estado estado) {
        return getCidadeDao().listarCidades(estado);
    }
    
    public CidadeDao getCidadeDao() {
        if (cidadeDao == null) {
            cidadeDao = new CidadeDao();
        }
        return cidadeDao;
    }

}
