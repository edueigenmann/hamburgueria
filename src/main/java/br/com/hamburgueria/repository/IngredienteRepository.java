package br.com.hamburgueria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hamburgueria.model.IngredienteModel;

public interface IngredienteRepository extends JpaRepository<IngredienteModel, Long>{

}
