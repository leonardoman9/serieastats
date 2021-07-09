package it.univpm.demoSpringBootActivation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import it.univpm.demoSpringBootActivation.requests.*;

/**
 * Applicazione che fornisce statistiche e filtri riguardanti la Serie A e le squadre di calcio che ne fanno parte.
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
		public static void main(String[] args){ 
			Requests.doRequests();
			SpringApplication.run(DemoSpringBootActivationApplication.class, args);
			}
}

