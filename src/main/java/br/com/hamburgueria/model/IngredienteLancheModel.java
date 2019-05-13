package br.com.hamburgueria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ingrediente_lanche")
public class IngredienteLancheModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lanche", foreignKey = @ForeignKey(name = "FK_INGREDIENTELANCHE_LANCHE"))
	private LancheModel lanche;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ingrediente", foreignKey = @ForeignKey(name = "FK_INGREDIENTELANCHE_INGREDIENTE"))
	private IngredienteModel ingrediente;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LancheModel getLanche() {
		return this.lanche;
	}

	public void setLanche(LancheModel lanche) {
		this.lanche = lanche;
	}

	public IngredienteModel getIngrediente() {
		return this.ingrediente;
	}

	public void setIngrediente(IngredienteModel ingrediente) {
		this.ingrediente = ingrediente;
	}
}
