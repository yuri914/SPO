package br.com.spo.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_equipe")
public class Equipe implements Entidade {
    
    private static final long serialVersionUID = -8708511745757368775L;
    
    @Id
    @Column(nullable = false)
    @GeneratedValue
    private Long id;
    
    @NotNull
    @Column(nullable = false, length = 50)
    private String nome;
    
    @NotNull
    @Column(nullable = false, length = 80)
    private String escudo;
    
    @NotNull
    @Column(nullable = false, length = 3)
    private String sigla;
    
    @Override
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEscudo() {
        return escudo;
    }
    
    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }
    
    public String getSigla() {
        return sigla;
    }
    
    public void setSigla(String sigla) {
        this.sigla = sigla;
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
        Equipe other = (Equipe) obj;
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
