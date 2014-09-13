package br.com.spo.controler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.FlowEvent;

import br.com.spo.model.beans.Cidade;
import br.com.spo.model.beans.Contato;
import br.com.spo.model.beans.Estado;
import br.com.spo.model.beans.Usuario;
import br.com.spo.model.enumerations.Genero;
import br.com.spo.model.enumerations.Telas;
import br.com.spo.service.implementations.CidadeService;
import br.com.spo.service.implementations.ContatoService;
import br.com.spo.service.implementations.EstadoService;
import br.com.spo.service.implementations.UsuarioService;
import br.com.spo.util.FacesUtil;

@ManagedBean
@ViewScoped
public class CadastroUsuarioBean {

    private Usuario usuario;
    private Contato contato;
    private Estado estadoSelecionado;
    private List<Estado> estados;
    private List<Cidade> cidades;

    private EstadoService estadoService;
    
    private CidadeService cidadeService;

    private UsuarioService usuarioService;
    
    private ContatoService contatoService;
    
	private FacesMessage msg;
    
    public CadastroUsuarioBean() {
        estados = getEstadoService().listarTodos();
    }
    
    public String salvar() {
        String outcome = null;
        contato.getUsuario().setDataCadastro(new Date());
        getContatoService().salvar(contato);
        msg = new FacesMessage("Sucesso", "Bem vindo :" + contato.getUsuario().getNome());
        outcome = FacesUtil.redirecionar(Telas.HOME.getUrl());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return outcome;
    }

    public void listarCidades(AjaxBehaviorEvent event) {
        if (estadoSelecionado != null) {
            cidades = getCidadeService().listarCidades(estadoSelecionado);
        }
    }

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    public Genero[] getGeneros() {
        return Genero.values();
    }

    public String getDataFormatada() {
        if (contato.getUsuario().getDataNascimento() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormatada = sdf.format(contato.getUsuario().getDataNascimento());
            return dataFormatada;
        } else {
            return "";
        }
    }
    public void nomeExistente(AjaxBehaviorEvent event) {
        if (StringUtils.isNotBlank(contato.getUsuario().getNome())) {
            if(getUsuarioService().verificaNomeExistente(contato.getUsuario().getNome())){
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "", " Este usuário já existe !");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
        
    }
    
    
    
    public Contato getContato() {
        if (contato == null) {
            contato = new Contato();
        }
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Cidade> getCidades() {
        if (cidades == null) {
            cidades = new ArrayList<Cidade>();
        }
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
    
    public CidadeService getCidadeService() {
        if (cidadeService == null) {
            cidadeService = new CidadeService();
        }
        return cidadeService;
    }

    public EstadoService getEstadoService() {
        if (estadoService == null) {
            estadoService = new EstadoService();
        }
        return estadoService;
    }

    public Estado getEstadoSelecionado() {
        return estadoSelecionado;
    }

    public void setEstadoSelecionado(Estado estadoSelecionado) {
        this.estadoSelecionado = estadoSelecionado;
    }
    
    public List<Estado> getEstados() {
        return estados;
    }
    
    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
    
    public ContatoService getContatoService() {
        if (contatoService == null) {
            contatoService = new ContatoService();
        }
        return contatoService;
    }

    public UsuarioService getUsuarioService() {
        if (usuarioService == null) {
            usuarioService = new UsuarioService();
        }
        return usuarioService;
    }
    
}
