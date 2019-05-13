package br.com.hamburgueria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_lanche")
public class LancheModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", insertable = false, updatable = false)
	private Long id;

	@Column(name = "nome_lanche")
	private String nomeLanche;
	
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

}
