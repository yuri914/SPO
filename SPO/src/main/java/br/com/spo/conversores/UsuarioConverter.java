package br.com.spo.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

import br.com.spo.model.beans.Usuario;
import br.com.spo.model.dao.impl.UsuarioDao;

@FacesConverter(value = "usuarioConverter")
public class UsuarioConverter implements Converter {

	UsuarioDao usuarioDao;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null && !StringUtils.isEmpty(value)){
			return getUsuarioDao().buscarPorId(Long.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		 if (value instanceof Usuario) {
	            Usuario usuario = (Usuario) value;
	            return String.valueOf(usuario.getId());
	        }
	        return "";
	}

	public UsuarioDao getUsuarioDao() {
		if (usuarioDao == null) {
			usuarioDao = new UsuarioDao();
		}
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
