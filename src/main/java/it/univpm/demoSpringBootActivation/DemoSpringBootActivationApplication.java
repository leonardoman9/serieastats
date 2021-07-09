package it.univpm.demoSpringBootActivation;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.demoSpringBootActivation.exceptions.MissingTeamException;
import it.univpm.demoSpringBootActivation.requests.*;

/**
 * Questa applicazione API REST restituisce informazioni, statistiche, filtri riguardanti la Serie A (massima serie del campionato italiano di calcio),
 * Le informazioni sono fornite dal servizio RESTful www.football-data.org tramite Rest API.
 * @author Leonardo Mannini
 * @author Luca Ranucci
 * @version 1.0
 * @since 2021-06-21
 */
@SpringBootApplication
@RestController
public class DemoSpringBootActivationApplication {
	/**
	 * Main dell'applicazione
	 * @param args Argomenti passati a linea di comando
	 */
public static void main(String[] args) { 
	Requests.doRequests();
	SpringApplication.run(DemoSpringBootActivationApplication.class, args);
	}
}

