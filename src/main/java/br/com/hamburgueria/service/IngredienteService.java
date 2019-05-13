package br.com.hamburgueria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hamburgueria.model.IngredienteModel;
import br.com.hamburgueria.repository.IngredienteRepository;
import br.com.hamburgueria.vo.IngredienteVo;

@Service
public class IngredienteService {

	@Autowired
	IngredienteRepository ingredienteRepository;

	/**
	 * Recupera os ingredientes do banco de dados
	 * 
	 * @return
	 */
	public List<IngredienteVo> getAllIngrediente() {

		List<IngredienteVo> vo = new ArrayList<>();

		List<IngredienteModel> model = this.ingredienteRepository.findAll();
		if (!model.isEmpty()) {
			for (int i = 0; i < model.size(); i++) {
				vo.add(parseModelVo(model.get(i)));
			}
		}

		return vo;
	}

	/**
	 * Converte o model para um VO para exibir as informações na tela
	 * 
	 * @param model
	 * @return
	 */
	private IngredienteVo parseModelVo(IngredienteModel model) {

		IngredienteVo vo = new IngredienteVo();
		vo.setId(model.getId());
		vo.setDescricao(model.getDescricao());
		vo.setQtde(0);
		vo.setPreco(model.getPreco());

		return vo;
	}

	/**
	 * Retorna Ingrediente por Id
	 * @param id
	 * @return
	 */
	public IngredienteVo getIngredienteById(Long id) {
		
		IngredienteVo vo = new IngredienteVo();

		IngredienteModel model = this.ingredienteRepository.findOne(id);
		
		if (model != null) {
			vo = parseModelVo(model);
		}

		return vo;
	}
}
