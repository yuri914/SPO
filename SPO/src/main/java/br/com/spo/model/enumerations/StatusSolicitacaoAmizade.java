package br.com.spo.model.enumerations;

public enum StatusSolicitacaoAmizade {

	PENDENTE("P", "Pendente"), CONFIRMADA("C", "Confirmada"), REJEITADA("R",
			"Rejeitada"), CANCELADA("CD", "Cancelada");

	protected String codigo;
	protected String descricao;

	private StatusSolicitacaoAmizade(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
