package br.com.hamburgueria.vo;

import java.math.BigDecimal;
import java.util.List;

public class LancheVo {

	private Long id;
	private String nomeLanche;
	private List<String> ingredientes;
	private BigDecimal preco;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeLanche() {
		return this.nomeLanche;
	}

	public void setNomeLanche(String nomeLanche) {
		this.nomeLanche = nomeLanche;
	}

	public List<String> getIngredientes() {
		return this.ingredientes;
	}

	public void setIngredientes(List<String> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public BigDecimal getPreco() {
		return this.preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
}
