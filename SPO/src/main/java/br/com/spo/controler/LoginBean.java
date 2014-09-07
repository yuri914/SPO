package br.com.spo.controler;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.spo.model.beans.Usuario;
import br.com.spo.model.enumerations.Telas;
import br.com.spo.service.interfaces.IUsuarioService;
import br.com.spo.util.FacesUtil;

@ManagedBean
@RequestScoped
public class LoginBean {
    
    private Usuario usuario;

    private IUsuarioService usuarioService;

    public String autenticar() {
        String outcome = null;
        if ("admin".equals(usuario.getUsername()) && "123".equals(usuario.getPassword())) {
            FacesUtil.getSessionMap().put("usuarioLogado", usuario);
            outcome = FacesUtil.redirecionar(Telas.HOME.getUrl());
        } else {
            FacesMessage message = new FacesMessage("Dados incorretos.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return outcome;
    }

    public LoginBean() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
