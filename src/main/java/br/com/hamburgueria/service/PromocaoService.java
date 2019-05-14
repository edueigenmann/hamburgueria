package br.com.hamburgueria.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hamburgueria.enumerator.Ingredientes;
import br.com.hamburgueria.vo.ConsultaPromocaoVo;
import br.com.hamburgueria.vo.IngredienteVo;
import br.com.hamburgueria.vo.LancheVo;

@Service
public class PromocaoService {

	@Autowired
	LancheService lancheService;

	@Autowired
	IngredienteService ingredienteService;

	/**
	 * Método faz as consultas das promoções
	 * 
	 * @param vo
	 * @return
	 */
	public BigDecimal consultaPromocao(ConsultaPromocaoVo vo) {

		LancheVo lancheVo = this.lancheService.getLancheById(vo.getIdLanche());
		BigDecimal precoLancheAtualizado = vo.getValorAtualLanche();
		IngredienteVo ingrediente = this.ingredienteService.getIngredienteById(vo.getIdIngrediente());

		if (Ingredientes.QUEIJO.getValue().longValue() == vo.getIdIngrediente()
				|| Ingredientes.HAMBURGUER_CARNE.getValue().longValue() == vo.getIdIngrediente()) {
			precoLancheAtualizado = regraMuitaCarneMuitoQueijo(lancheVo, precoLancheAtualizado, vo, ingrediente);
		} else {
			precoLancheAtualizado = somaValorIngrediente(vo);
		}

		precoLancheAtualizado = regraLight(lancheVo, precoLancheAtualizado, ingrediente);

		return precoLancheAtualizado;
	}

	/**
	 * Verifica qtde de queijo e carne adicional para ver se add o valor
	 * 
	 * @param lancheVo
	 * @param precoLancheAtualizado
	 * @param qtdeIngrediente
	 * @param ingrediente
	 * @return
	 */
	private BigDecimal regraMuitaCarneMuitoQueijo(LancheVo lancheVo, BigDecimal precoLancheAtualizado, ConsultaPromocaoVo vo,
			IngredienteVo ingrediente) {

		if (vo.getSomaSubtrai().equals("Soma")) {
			if (vo.getQtdeIngrediente() % 3 != 0) {
				precoLancheAtualizado = precoLancheAtualizado.add(ingrediente.getPreco());
			} 
		} else {
			if (vo.getQtdeIngrediente() % 3 != 2) {
				precoLancheAtualizado = precoLancheAtualizado.subtract(ingrediente.getPreco());
			} 
		}
		
		return precoLancheAtualizado;
	}

	/**
	 * Verifica regra do lanche ligth para dar deconto
	 * 
	 * @param lancheVo
	 * @param precoLancheAtualizado
	 * @return
	 */
	private BigDecimal regraLight(LancheVo lancheVo, BigDecimal precoLancheAtualizado, IngredienteVo ingrediente) {
		boolean alface = false;
		boolean bacon = false;

		for (int i = 0; i < lancheVo.getIngredientes().size(); i++) {
			if (!alface) {
				if (lancheVo.getIngredientes().get(i).equals(Ingredientes.ALFACE.getText())) {
					alface = true;
				}
			}

			if (!bacon) {
				if (lancheVo.getIngredientes().get(i).equals(Ingredientes.BACON.getText())) {
					bacon = true;
				}
			}
		}

		if ((alface || ingrediente.getId() == Ingredientes.ALFACE.getValue().longValue()) && !bacon) {
			precoLancheAtualizado = precoLancheAtualizado.subtract(precoLancheAtualizado.multiply(new BigDecimal(0.1)));
		}

		return precoLancheAtualizado;
	}

	/**
	 * Soma o valor de cada ingrediente add
	 * 
	 * @param vo
	 * @return
	 */
	private BigDecimal somaValorIngrediente(ConsultaPromocaoVo vo) {
		IngredienteVo ingrediente = this.ingredienteService.getIngredienteById(vo.getIdIngrediente());
		if (vo.getSomaSubtrai().equals("Soma")) {
			return vo.getValorAtualLanche().add(ingrediente.getPreco());
		}

		return vo.getValorAtualLanche().subtract(ingrediente.getPreco());
	}
}
