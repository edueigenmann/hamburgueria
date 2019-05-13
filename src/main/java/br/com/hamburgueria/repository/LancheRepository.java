package br.com.hamburgueria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hamburgueria.model.LancheModel;

public interface LancheRepository extends JpaRepository<LancheModel, Long> {
	
}
