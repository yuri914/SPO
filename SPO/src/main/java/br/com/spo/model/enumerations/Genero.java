package br.com.spo.model.enumerations;

public enum Genero {

    MASCULINO("M", "Masculino"), FEMININO("F", "Feminino");

    protected String codigo;
    protected String descricao;

    private Genero(String codigo, String descricao) {
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

