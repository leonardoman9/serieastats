package it.univpm.demoSpringBootActivation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.demoSpringBootActivation.model.Team;
import it.univpm.demoSpringBootActivation.model.League;


@RestController
public class SimpleRestController {
	@GetMapping("/teams")
	public Team returnTeams(@RequestParam(name = "id", defaultValue = "0") String teamId) {
		return new Team("Questa", "E'", "Prova", "Con", "Teams", 12, "tu");
	}	
	
	@GetMapping("/team")
	public Team returnTeam(@RequestParam(name = "id", defaultValue = "0") String teamId) {
		return new Team("Questaltra", "prova", "con", "solo", "Team a scelta dell'utente", 12, "tu");
	}	
	@GetMapping("/league")
	public League returnLeague(@RequestParam(name="id", defaultValue="0") String leagueID) {
		return new League(20, "Italia", "Serie A", "Settembre 2020", "Giugno 2021", null);
	}
	
}
	

