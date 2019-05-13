package br.com.hamburgueria.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hamburgueria.model.IngredienteLancheModel;
import br.com.hamburgueria.model.LancheModel;
import br.com.hamburgueria.repository.IngredienteLancheRepository;
import br.com.hamburgueria.repository.LancheRepository;
import br.com.hamburgueria.vo.LancheVo;

@Service
public class LancheService {

	@Autowired
	LancheRepository hamburgueriaRepository;

	@Autowired
	IngredienteLancheRepository ingredienteLancheRepository;
	
	/**
	 * Retorna Lanche por Id
	 * @param id
	 * @return
	 */
	public LancheVo getLancheById(Long id) {
		LancheVo lancheVo = new LancheVo();
		
		LancheModel entity = this.hamburgueriaRepository.findOne(id);
		if (entity != null) {
			lancheVo = parseEntityVo(entity);
		}
		
		return lancheVo; 
	}

	/**
	 * Retorna uma lista de TODOS os lanches cadastrados 
	 * @return
	 */
	public List<LancheVo> getAllLanches() {

		List<LancheVo> listLancheRetorno = new ArrayList<>();

		List<LancheModel> list = this.hamburgueriaRepository.findAll();

		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				listLancheRetorno.add(parseEntityVo(list.get(i)));
			}
		}

		return listLancheRetorno;
	}

	/**
	 * Converte model em VO
	 * @param entity
	 * @return
	 */
	private LancheVo parseEntityVo(LancheModel entity) {

		BigDecimal preco = BigDecimal.ZERO;
		List<String> ingredientesLanche = new ArrayList<>();
		LancheVo vo = new LancheVo();

		vo.setId(entity.getId());
		vo.setNomeLanche(entity.getNomeLanche());

		List<IngredienteLancheModel> listIngrediente = this.ingredienteLancheRepository.findByIdLanche(entity.getId());
		if (!listIngrediente.isEmpty()) {

			preco = BigDecimal.ZERO;

			for (int i = 0; i < listIngrediente.size(); i++) {
				preco = preco.add(listIngrediente.get(i).getIngrediente().getPreco());
				ingredientesLanche.add(listIngrediente.get(i).getIngrediente().getDescricao());
			}
			
			vo.setPreco(preco);
			vo.setIngredientes(ingredientesLanche);

		}
		
		return vo;
	}

}
