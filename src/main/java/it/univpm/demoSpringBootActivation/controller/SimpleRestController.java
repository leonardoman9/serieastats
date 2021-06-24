package it.univpm.demoSpringBootActivation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.demoSpringBootActivation.model.ClasseDiProva;

@RestController
public class SimpleRestController {
	@GetMapping("/prova")
	public ClasseDiProva metodoEsempio(@RequestParam(name="param1", defaultValue="ciao") String param1){
		return new ClasseDiProva("Prova1", "Prova2");
	}
	@PostMapping("/prova")
	public ClasseDiProva metodoEsempio2(@RequestBody ClasseDiProva body) {
		return body;
	}
	
}
	

