package br.com.hamburgueria.enumerator;

public enum Ingredientes {

	ALFACE(1, "Alface"),
	BACON(2, "Bacon"),
	HAMBURGUER_CARNE(3, "Hamburguer de Carne"),
	OVO(4, "Ovo"),
	QUEIJO(5, "Queijo");
	
	private Ingredientes(Integer value, String text) {
		this.value = value;
		this.text = text;
	}

	private final Integer value;

	private final String text;

	public String getText() {
		return this.text;
	}

	public Integer getValue() {
		return this.value;
	}
	
}
