package br.com.hamburgueria.vo;

import java.math.BigDecimal;

public class ConsultaPromocaoVo {

	private Long idLanche;

	private Long idIngrediente;

	private Double qtdeIngrediente;
	
	private BigDecimal valorAtualLanche;
	
	private String somaSubtrai;

	public Long getIdLanche() {
		return this.idLanche;
	}

	public void setIdLanche(Long idLanche) {
		this.idLanche = idLanche;
	}

	public Long getIdIngrediente() {
		return this.idIngrediente;
	}

	public void setIdIngrediente(Long idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public Double getQtdeIngrediente() {
		return this.qtdeIngrediente;
	}

	public void setQtdeIngrediente(Double qtdeIngrediente) {
		this.qtdeIngrediente = qtdeIngrediente;
	}

	public BigDecimal getValorAtualLanche() {
		return this.valorAtualLanche;
	}

	public void setValorAtualLanche(BigDecimal valorAtualLanche) {
		this.valorAtualLanche = valorAtualLanche;
	}

	public String getSomaSubtrai() {
		return this.somaSubtrai;
	}

	public void setSomaSubtrai(String somaSubtrai) {
		this.somaSubtrai = somaSubtrai;
	}

}
