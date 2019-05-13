package br.com.hamburgueria.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hamburgueria.service.PromocaoService;
import br.com.hamburgueria.vo.ConsultaPromocaoVo;

@RestController
@RequestMapping("/promocao")
@CrossOrigin
public class PromocaoResource {

	@Autowired
	PromocaoService promocaoService;

	@PostMapping("/consultaPromocao")
	public ResponseEntity consultaPromocao(@RequestBody ConsultaPromocaoVo vo) {
		try {
			return new ResponseEntity(this.promocaoService.consultaPromocao(vo), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
