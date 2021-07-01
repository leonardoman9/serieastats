package it.univpm.demoSpringBootActivation.controller;

import java.io.IOException;


import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.univpm.demoSpringBootActivation.model.League;
import it.univpm.demoSpringBootActivation.model.Team;
import it.univpm.demoSpringBootActivation.stats.Requests;
import it.univpm.demoSpringBootActivation.stats.Stat;
import it.univpm.demoSpringBootActivation.exceptions.*;

@RestController
public class SimpleRestController {
	/*
	 *  localhost:8080/league
	 *  Shows informations about the league and all teams in the league
	 *  localhost:8080/league?showTeams=false
	 *  Shows informations about the league 
	 */
	@GetMapping("/league")
	@ResponseBody
	@JsonIgnoreProperties
	public League returnLeague(@RequestParam(name = "showTeams", defaultValue = "true") String showTeams) throws IOException {
		return Requests.returnLeague(Boolean.parseBoolean(showTeams));
	}
	
	/*
	 *  localhost:8080/team?name={teamName}
	 *  Show a particular Team
	 */
	@GetMapping("/team")
	@ResponseBody
	public  Team returnTeam(@RequestParam(name = "name", defaultValue = "Roma") String nomeTeam) throws IOException, MissingTeamException {
		return Requests.returnTeam(nomeTeam);
	}
	/*
	 *  localhost:8080/venues
	 *  Shows all venues of Serie A.
	 */
	@GetMapping("/venues")
	@ResponseBody
	@JsonIgnoreProperties
	public String returnVenues() throws IOException {
		return Stat.returnVenues();
	}
	
	/*
	 *  localhost:8080/foundedAfter?year={year}
	 *  Shows all teams founded after a certain year
	 */
	@GetMapping("/foundedAfter")
	@ResponseBody
	@JsonIgnoreProperties
	public String returnFoundedAfter(@RequestParam(name = "year", defaultValue = "1902") String yearFounded) throws IOException {
		return Stat.returnFoundedAfter(yearFounded);
	}
	/*
	 *  localhost:8080/teamsForEachVenue
	 *  Shows all teams in every venue
	 */
	@GetMapping("/teamsForEachVenue")
	@ResponseBody
	@JsonIgnoreProperties
	public String returnTeamsVenues() throws IOException {
		return Stat.returnTeamsVenues();
	}
}
	

