package br.com.spo.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_estatistica")
public class Estatistica implements Entidade {

    private static final long serialVersionUID = 5304369216711491156L;

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @JoinColumn(nullable = false, name = "id_usuario")
    @OneToOne(targetEntity = Usuario.class)
    private Usuario usuario;

    @Column(nullable = false, name = "placar_cheio")
    private Integer placarCheio;

    @Column(nullable = false, name = "vencedor")
    private Integer vencedorJogo;

    @Column(nullable = false, name = "diferenca_de_gols")
    private Integer diferencaGols;

    @Column(nullable = false, name = "placar_do_perdedor")
    private Integer placarPerdedor;

    @Column(nullable = false, name = "pontos")
    private Integer pontos;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getPlacarCheio() {
        return placarCheio;
    }

    public void setPlacarCheio(Integer placarCheio) {
        this.placarCheio = placarCheio;
    }

    public Integer getVencedorJogo() {
        return vencedorJogo;
    }

    public void setVencedorJogo(Integer vencedorJogo) {
        this.vencedorJogo = vencedorJogo;
    }

    public Integer getDiferencaGols() {
        return diferencaGols;
    }

    public void setDiferencaGols(Integer diferencaGols) {
        this.diferencaGols = diferencaGols;
    }

    public Integer getPlacarPerdedor() {
        return placarPerdedor;
    }

    public void setPlacarPerdedor(Integer placarPerdedor) {
        this.placarPerdedor = placarPerdedor;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
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
        Estatistica other = (Estatistica) obj;
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
