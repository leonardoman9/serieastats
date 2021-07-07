package it.univpm.demoSpringBootActivation;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.demoSpringBootActivation.requests.Requests;
import it.univpm.demoSpringBootActivation.exceptions.*;

/**
 * This applications gives informations and statics about Italian's tier one football league (Serie A).
 * @author Leonardo Mannini
 * @author Luca Ranucci
 * @version 1.0
 * @since 2021-06-21
 */
@SpringBootApplication
@RestController
public class DemoSpringBootActivationApplication {
public static void main(String[] args) throws IOException, MissingTeamException { 
	Requests.doRequests();
	SpringApplication.run(DemoSpringBootActivationApplication.class, args);
}
}

