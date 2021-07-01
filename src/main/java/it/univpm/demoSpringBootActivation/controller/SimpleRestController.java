package it.univpm.demoSpringBootActivation.controller;

import java.io.IOException;


import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.univpm.demoSpringBootActivation.model.League;
import it.univpm.demoSpringBootActivation.model.Scorers;
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
	public String returnFoundedAfter(@RequestParam(name = "year", defaultValue = "1800") String yearFounded) throws IOException {
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

	/*  localhost:8080/leagueScorers
	 *  Show all first 100 Serie A scorers ordered.
	 * T
	 */
	@GetMapping("/leagueScorers")
	@ResponseBody
	public Scorers returnLeagueScorers() throws IOException, MissingTeamException {
		return Requests.returnLeagueScorers();
	}
	/*  localhost:8080/teamScorers?name={longTeamName}
	 *  Show scorers from a particular Team.
	 *  Only works with Long Team Name, because the scorers request returns a Team object with only a Long Name attribute.
	 *  */
	@GetMapping("/teamScorers")
	@ResponseBody
	public String returnteamScorers(@RequestParam(name = "team", defaultValue = "FC Internazionale Milano") String longName) throws IOException, MissingTeamException {
		return Stat.returnTeamScorers(longName);
	}
	/*  localhost:8080/teamNationalities?teamName={teamName}
	 *  Show scorers from a particular Team.
	 *  Only works with Long Team Name, because the scorers request returns a Team object with only a Long Name attribute.
	 *  */
	@GetMapping("/teamNationalities")
	@ResponseBody
	public String returnteamNationalities(@RequestParam(name = "team", defaultValue = "FC Internazionale Milano") String longName) throws IOException, MissingTeamException {
		return Stat.returnTeamNationalities(longName);
	}
}
	

