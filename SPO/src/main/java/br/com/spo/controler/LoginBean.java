package br.com.spo.controler;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.spo.model.beans.Usuario;
import br.com.spo.model.enumerations.Telas;
import br.com.spo.service.exceptions.AutenticacaoException;
import br.com.spo.service.implementations.UsuarioService;
import br.com.spo.util.FacesUtil;

@ManagedBean
@RequestScoped
public class LoginBean {

    private Usuario usuario;
    
    private UsuarioService usuarioService;
    
    public LoginBean() {
        usuario = new Usuario();
    }
    
    public String autenticar() {
        String outcome = null;
        
        try {
            Usuario usuarioAutenticado = getUsuarioService().autenticarUsuario(usuario);
            FacesUtil.getSessionMap().put("usuarioLogado", usuarioAutenticado);
            outcome = FacesUtil.redirecionar(Telas.HOME.getUrl());
        } catch (AutenticacaoException e) {
            FacesMessage message = new FacesMessage(e.getMessage());
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
        return outcome;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public UsuarioService getUsuarioService() {
        if (usuarioService == null) {
            usuarioService = new UsuarioService();
        }
        return usuarioService;
    }

}
