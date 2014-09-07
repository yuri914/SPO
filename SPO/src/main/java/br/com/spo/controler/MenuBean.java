package br.com.spo.controler;

import javax.faces.bean.ManagedBean;

import br.com.spo.model.beans.Usuario;
import br.com.spo.model.enumerations.Telas;
import br.com.spo.util.FacesUtil;

@ManagedBean
public class MenuBean {

    public Usuario getUsuarioLogado() {
        return (Usuario) FacesUtil.getSessionMap().get("usuarioLogado");
    }
    
    public String logout() {
        FacesUtil.invalidarSessao();
        return FacesUtil.redirecionar(Telas.INDEX.getUrl());
    }
}
