package br.com.spo.model.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_jogo")
public class Jogo implements Entidade {

    private static final long serialVersionUID = -6070453990883344966L;

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date data;

    @JoinColumn(name = "equipe_mandante", nullable = false)
    @ManyToOne(targetEntity = Equipe.class)
    private Equipe equipeMandante;

    @JoinColumn(name = "equipe_visitante", nullable = false)
    @ManyToOne(targetEntity = Equipe.class)
    private Equipe equipeVisitante;

    @Column(nullable = false)
    private Integer rodada;

    @Column(name = "url_confronto")
    private String urlConfronto;

    @Column(name = "placar_mandante")
    private Integer placarMandante;

    @Column(name = "placar_visitante")
    private Integer placarVisitante;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date hora;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Estadio estadio;
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Equipe getEquipeMandante() {
        return equipeMandante;
    }

    public void setEquipeMandante(Equipe equipeMandante) {
        this.equipeMandante = equipeMandante;
    }

    public Equipe getEquipeVisitante() {
        return equipeVisitante;
    }

    public void setEquipeVisitante(Equipe equipeVisitante) {
        this.equipeVisitante = equipeVisitante;
    }

    public Integer getRodada() {
        return rodada;
    }

    public void setRodada(Integer rodada) {
        this.rodada = rodada;
    }

    public String getUrlConfronto() {
        return urlConfronto;
    }

    public void setUrlConfronto(String urlConfronto) {
        this.urlConfronto = urlConfronto;
    }

    public Integer getPlacarMandante() {
        return placarMandante;
    }

    public void setPlacarMandante(Integer placarMandante) {
        this.placarMandante = placarMandante;
    }

    public Integer getPlacarVisitante() {
        return placarVisitante;
    }

    public void setPlacarVisitante(Integer placarVisitante) {
        this.placarVisitante = placarVisitante;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Estadio getEstadio() {
        return estadio;
    }
    
    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public String getDataFormatada() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = sdf.format(data);
        return dataFormatada;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Jogo other = (Jogo) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
