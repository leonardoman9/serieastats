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
import it.univpm.demoSpringBootActivation.exceptions.*;

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
	 *  localhost:8080/league?={id}
	 */
	@GetMapping("/league")
	@ResponseBody
	@JsonIgnoreProperties
	public League returnLeague() throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/teams");
		League newLeague = new League();
		newLeague = JsonParser.parseLeague(result);
		System.out.println(newLeague);
		return newLeague;
	}
	@GetMapping("/venues")
	@ResponseBody
	@JsonIgnoreProperties
	public void returnVenues() throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/teams");
		League newLeague = new League();
		newLeague = JsonParser.parseLeague(result);
		System.out.println(newLeague.countVenues());
	}
	/*
	 *  localhost:8080/teams?={id}
	 *  List all teams for a particular competition.
	 *  Range per squadre italiane: [TODO] 
	 */
	@GetMapping("/team")
	@ResponseBody
	public  Team returnTeam(@RequestParam(name = "id", defaultValue = "100") String nomeTeam) throws IOException, MissingTeamException {
		String result1 = Dataset.download("https://api.football-data.org/v2/competitions/SA/teams");
		League newLeague = new League();
		newLeague = JsonParser.parseLeague(result1);
		int teamId = newLeague.lookFor(nomeTeam);
		if(teamId==-1)
			{throw new MissingTeamException(nomeTeam+" does not exist. \n");}
		String result = Dataset.download("https://api.football-data.org/v2/teams/" + teamId);
		Team newTeam = new Team();
		newTeam = JsonParser.parseTeam(result);
		System.out.println(newTeam);
		return newTeam;
	}	
	
}
	

