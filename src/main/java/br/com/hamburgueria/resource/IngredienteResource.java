package br.com.hamburgueria.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hamburgueria.service.IngredienteService;

@RestController
@RequestMapping("/ingrediente")
@CrossOrigin
public class IngredienteResource {

	@Autowired
	IngredienteService ingredienteService;
	
	@GetMapping("/getAll")
	public ResponseEntity getAllIngrediente() {
		try {
			return new ResponseEntity(this.ingredienteService.getAllIngrediente(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
