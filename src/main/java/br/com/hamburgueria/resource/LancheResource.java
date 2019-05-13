package br.com.hamburgueria.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hamburgueria.service.LancheService;

@RestController
@RequestMapping("/lanche")
@CrossOrigin
public class LancheResource {

	@Autowired
	LancheService lancheService;
	
	@GetMapping("/getAll")
	public ResponseEntity getAllLanches() {
		try {
			return new ResponseEntity(this.lancheService.getAllLanches(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
