package br.com.hamburgueria.vo;

import java.math.BigDecimal;

public class IngredienteVo {

	private Long id;
	private String descricao;
	private BigDecimal preco;
	private Integer qtde;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return this.preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQtde() {
		return this.qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

}
