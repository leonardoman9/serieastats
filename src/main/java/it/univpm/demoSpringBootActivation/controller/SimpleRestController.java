package it.univpm.demoSpringBootActivation.controller;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.demoSpringBootActivation.model.Dataset;
import it.univpm.demoSpringBootActivation.model.JsonParser;
import it.univpm.demoSpringBootActivation.model.League;
import it.univpm.demoSpringBootActivation.model.Team;


@RestController
public class SimpleRestController {
	
	/*
	 * 
	 * /v2/competitions/teams/{id}
	 */
	
	@GetMapping("/team")
	public Team returnTeams(@RequestParam(name = "id", defaultValue = "1") String teamId) throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/teams/"+"1");
		Team newTeam = new Team();
		newTeam = JsonParser.parseTeam(result);
		return newTeam;
	}	
	@GetMapping("/league")
	public League returnLeague(@RequestParam(name="id", defaultValue="0") String leagueID) throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA");
		League newLeague = new League();
		newLeague = JsonParser.parseLeague(result);
		return newLeague;
	}
	
	@GetMapping("/teams")
	public Team returnTeam(@RequestParam(name = "id", defaultValue = "0") String teamId) {
		return new Team();
	}	
	
}
	

