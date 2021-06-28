package it.univpm.demoSpringBootActivation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.demoSpringBootActivation.model.Dataset;

@SpringBootApplication
@RestController
public class DemoSpringBootActivationApplication {
public static void main(String[] args) throws IOException {
	String teamId = "1";
	Dataset.download("https://api.football-data.org/v2/teams/"+teamId);
	SpringApplication.run(DemoSpringBootActivationApplication.class, args);
}

}

