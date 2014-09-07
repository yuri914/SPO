package br.com.spo.util;

import java.util.Map;

import javax.faces.context.FacesContext;

public class FacesUtil {

    public static String redirecionar(String url) {
        return url == null ? "" : url + "?faces-redirect=true";
    }
    
    public static Map<String, Object> getSessionMap() {
        return getFacesContext().getExternalContext().getSessionMap();
    }

    public static void invalidarSessao() {
        getFacesContext().getExternalContext().invalidateSession();
    }

    private static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
    
}
