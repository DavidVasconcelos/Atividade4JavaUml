package Exercicio3;

public enum Cores {

	BRANCO("Branco", 21), PRETO("Preto", 22), VERMELHO("Vermelho", 23), AMARELO("Amarelo", 24), AZUL("Azul", 25);

	private String nome;
	private Integer codigo;

	private Cores(String nome, Integer codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

}