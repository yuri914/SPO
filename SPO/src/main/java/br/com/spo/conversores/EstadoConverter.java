package br.com.spo.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.spo.model.beans.Estado;
import br.com.spo.model.dao.impl.EstadoDao;

@FacesConverter(value = "estadoConverter")
public class EstadoConverter implements Converter {

    private EstadoDao estadoDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if ((value != null) && !value.equals("")) {
            return getEstadoDao().buscarPorId(Long.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Estado) {
            Estado estado = (Estado) value;
            return String.valueOf(estado.getId());
        }
        return "";
    }

    public EstadoDao getEstadoDao() {
        if (estadoDao == null) {
            estadoDao = new EstadoDao();
        }
        return estadoDao;
    }

}
