package it.univpm.demoSpringBootActivation.controller;

import java.io.IOException;
import java.util.Scanner;


import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.demoSpringBootActivation.model.Dataset;
import it.univpm.demoSpringBootActivation.model.JsonParser;
import it.univpm.demoSpringBootActivation.model.League;
import it.univpm.demoSpringBootActivation.model.Team;


@RestController
public class SimpleRestController {
	
	/*
	 * 
	 * prova esempio
	 * localhost:8080/home?=abc
	 */
	@GetMapping("/home")
	@ResponseBody
	public String getHome(@RequestParam String id) {
		return "ID : " + id;
	}
	
	/*
	 *  localhost:8080/teams?={id}
	 *  List all teams for a particular competition.
	 */
	@GetMapping("/teams")
	@ResponseBody
	public Team returnTeams(@RequestParam(name = "id", defaultValue = "SA") String leagueId) throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/"+leagueId+"/teams");
		Team newTeam = new Team();
		newTeam = JsonParser.parseTeam(result);
		return newTeam;
	}	
	/*
	 *  localhost:8080/league?={id}
	 */
	@GetMapping("/league")
	@ResponseBody
	@JsonIgnoreProperties
	public League returnLeague(@RequestParam(name="id", defaultValue="0") String leagueID) throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/teams");
		League newLeague = new League();
		newLeague = JsonParser.parseLeague(result);
		return newLeague;
	}
	/*
	 *  localhost:8080/teams?={id}
	 *  List all teams for a particular competition.
	 *  Range per squadre italiane: [TODO] 
	 */
	@GetMapping("/team")
	@ResponseBody
	public  Team returnTeam(@RequestParam(name = "id", defaultValue = "15") String teamId) throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/teams/" + teamId);
		Team newTeam = new Team();
		newTeam = JsonParser.parseTeam(result);
		return newTeam;
	}	
	
}
	

