package br.com.spo.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_palpite")
public class Palpite implements Entidade {

    private static final long serialVersionUID = -3493441978508422103L;

    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Long id;

    @JoinColumn(nullable = false)
    @ManyToOne(targetEntity = Jogo.class)
    private Jogo jogo;

    @Column(nullable = false)
    private Integer palpiteMandante;

    @Column(nullable = false)
    private Integer palpiteVisitante;

    @JoinColumn(nullable = false, name = "id_usuario")
    @ManyToOne
    private Usuario usuario;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Integer getPalpiteMandante() {
        return palpiteMandante;
    }

    public void setPalpiteMandante(Integer palpiteMandante) {
        this.palpiteMandante = palpiteMandante;
    }

    public Integer getPalpiteVisitante() {
        return palpiteVisitante;
    }

    public void setPalpiteVisitante(Integer palpiteVisitante) {
        this.palpiteVisitante = palpiteVisitante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
