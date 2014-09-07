package br.com.spo.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

import br.com.spo.model.beans.Cidade;
import br.com.spo.model.dao.impl.CidadeDao;

@FacesConverter(value = "cidadeConverter")
public class CidadeConverter implements Converter {

    private CidadeDao cidadeDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if ((value != null) && !StringUtils.isEmpty(value)) {
            return getCidadeDao().buscarPorId(Long.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Cidade) {
            Cidade cidade = (Cidade) value;
            return String.valueOf(cidade.getId());
        }
        return "";
    }
    
    public CidadeDao getCidadeDao() {
        if (cidadeDao == null) {
            cidadeDao = new CidadeDao();
        }
        return cidadeDao;
    }

}
