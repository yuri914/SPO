package br.com.spo.model.beans;

import br.com.spo.model.enumerations.StatusSolicitacaoAmizade;

//@Entity
//@Table(name = "rl_amizade")
//@AssociationOverrides({ @AssociationOverride(name = "pk.usuarioPrimario", joinColumns = @JoinColumn(name = "id_usuario_primario")),
//    @AssociationOverride(name = "pk.usuarioSecundario", joinColumns = @JoinColumn(name = "id_usuario_Secundario")) })
public class AmizadeUsuario {

    // @EmbeddedId
    private AmizadeUsuarioPK pk;

    // @Column(name = "status_amizade", nullable = false)
    private StatusSolicitacaoAmizade statusAmizade;

    public AmizadeUsuarioPK getPk() {
        return pk;
    }

    public void setPk(AmizadeUsuarioPK pk) {
        this.pk = pk;
    }

    public StatusSolicitacaoAmizade getStatusAmizade() {
        return statusAmizade;
    }

    public void setStatusAmizade(StatusSolicitacaoAmizade statusAmizade) {
        this.statusAmizade = statusAmizade;
    }

}
