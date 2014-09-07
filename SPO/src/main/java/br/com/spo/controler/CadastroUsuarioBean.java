package br.com.spo.controler;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import br.com.spo.model.beans.Cidade;
import br.com.spo.model.beans.Contato;
import br.com.spo.model.beans.Usuario;
import br.com.spo.model.enumerations.Genero;

@ManagedBean
@ViewScoped
public class CadastroUsuarioBean {
    
    Usuario usuario = new Usuario();
    Cidade cidade = new Cidade();
    Contato contato = new Contato();
    List<Cidade> cidades = new ArrayList<Cidade>();
    
    public void save() {
        FacesMessage msg = new FacesMessage("Sucesso", "Bem vindo :" + usuario.getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }
    
    public Genero[] getGeneros() {
        return Genero.values();
    }
    
    public Contato getContato() {
        return contato;
    }
    
    public void setContato(Contato contato) {
        this.contato = contato;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Cidade getCidade() {
        return cidade;
    }
    
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    public List<Cidade> getCidades() {
        return cidades;
    }
    
    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
    
}
