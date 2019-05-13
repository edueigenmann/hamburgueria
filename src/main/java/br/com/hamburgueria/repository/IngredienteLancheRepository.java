package br.com.hamburgueria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.hamburgueria.model.IngredienteLancheModel;

public interface IngredienteLancheRepository extends JpaRepository<IngredienteLancheModel, Long> {

	@Query(" SELECT i FROM IngredienteLancheModel i WHERE i.lanche.id = :id ")
	List<IngredienteLancheModel> findByIdLanche(@Param("id") Long id);

}
