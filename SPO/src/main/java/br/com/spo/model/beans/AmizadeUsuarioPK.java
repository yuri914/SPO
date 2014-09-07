package br.com.spo.model.beans;

import java.io.Serializable;

//@Embeddable
public class AmizadeUsuarioPK implements Serializable {

    private static final long serialVersionUID = -1178689237630581274L;

    // @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Usuario usuarioPrimario;

    // @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Usuario usuarioSecundario;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((usuarioPrimario == null) ? 0 : usuarioPrimario.hashCode());
        result = (prime * result) + ((usuarioSecundario == null) ? 0 : usuarioSecundario.hashCode());
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
        AmizadeUsuarioPK other = (AmizadeUsuarioPK) obj;
        if (usuarioPrimario == null) {
            if (other.usuarioPrimario != null) {
                return false;
            }
        } else if (!usuarioPrimario.equals(other.usuarioPrimario)) {
            return false;
        }
        if (usuarioSecundario == null) {
            if (other.usuarioSecundario != null) {
                return false;
            }
        } else if (!usuarioSecundario.equals(other.usuarioSecundario)) {
            return false;
        }
        return true;
    }

}
