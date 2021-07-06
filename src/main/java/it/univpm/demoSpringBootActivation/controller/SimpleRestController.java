package it.univpm.demoSpringBootActivation.controller;

import java.io.IOException;


import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ch.qos.logback.core.filter.Filter;
import it.univpm.demoSpringBootActivation.model.League;
import it.univpm.demoSpringBootActivation.model.Scorers;
import it.univpm.demoSpringBootActivation.model.Team;
import it.univpm.demoSpringBootActivation.requests.Filters;
import it.univpm.demoSpringBootActivation.requests.Requests;
import it.univpm.demoSpringBootActivation.requests.Stat;
import it.univpm.demoSpringBootActivation.exceptions.*;
/**
 * RestController dell'applicazione WebRest SpringBoot
 * @author Leonardo Mannini
 * @author Luca Ranucci
 *
 */

@RestController
public class SimpleRestController {
	
	@GetMapping("/league")
	@ResponseBody
	@JsonIgnoreProperties
	/**
	 * /*
	 *  localhost:8080/league
	 *  Mostra informazioni riguardo tutte le squadre della Serie A e informazioni riguardanti la Serie A
	 *  
	 *  localhost:8080/league?showTeams=false
	 *  Mostra informazioni riguardanti la Serie A
	 * @param showTeams
	 * @return
	 * @throws IOException
	 */
	public League returnLeague(@RequestParam(name = "showTeams", defaultValue = "true") String showTeams) throws IOException {
		return Requests.returnLeague(Boolean.parseBoolean(showTeams));
	}
	
	
	@GetMapping("/team")
	@ResponseBody
	/**
	 * Mostra informazioni riguardanti una squadra a scelta dell'utente
	 * localhost:8080/team?name={shortname}
	 * Funziona con lo shortname
	 * @param nomeTeam
	 * @return
	 * @throws IOException
	 * @throws MissingTeamException
	 */
	public  Team returnTeam(@RequestParam(name = "name", defaultValue = "Roma") String nomeTeam) throws IOException, MissingTeamException {
		return Requests.returnTeam(nomeTeam);
	}
	
	@GetMapping("/venues")
	@ResponseBody
	@JsonIgnoreProperties
	/**
	 *  Mostra informazioni riguardanti gli stadi delle partite di Serie A.
	 *  localhost:8080/venues
	 * @return
	 * @throws IOException
	 */
	public String returnVenues() throws IOException {
		return Stat.returnVenues();
	}

	@GetMapping("/foundedAfter")
	@ResponseBody
	@JsonIgnoreProperties
	/**
	 * Mostra tutte le squadre fondate dopo un certo anno specificato dall'utente
	 * localhost:8080/foundedAfter?year={year}
	 * @param yearFounded
	 * @return
	 * @throws IOException
	 */
	public String returnFoundedAfter(@RequestParam(name = "year", defaultValue = "1800") String yearFounded) throws IOException {
		return Stat.returnFoundedAfter(yearFounded);
	}
	@GetMapping("/teamsForEachVenue")
	@ResponseBody
	@JsonIgnoreProperties
	public String returnTeamsVenues() throws IOException {
		return Stat.returnTeamsVenues();
	}

	@GetMapping("/leagueScorers")   
	@ResponseBody
	/**
	 *  Mostra i primi 100 marcatori della Serie A, ordinati per numero di gol
	 * 	localhost:8080/leagueScorers
	 * 
	 * @return
	 * @throws IOException
	 * @throws MissingTeamException
	 */
	public String returnLeagueScorers() throws IOException, MissingTeamException {
		return Requests.returnLeagueScorers();
	}
	@GetMapping("/teamScorers")
	@ResponseBody
	/**
	 * Mostra i marcatori di una specifica squadra, a scelta dell'utente.
	 * 	localhost:8080/teamScorers?name={longTeamName}
	 *  Inserire %20 al posto di uno spazio nel Nome del team
	 * @param longName
	 * @return
	 * @throws IOException
	 * @throws MissingTeamException
	 */
	public String returnteamScorers(@RequestParam(name = "team", defaultValue = "FC Internazionale Milano") String longName) throws IOException, MissingTeamException {
		return Stat.returnTeamScorers(longName);
	}
	
	@GetMapping("/teamNationalities")
	@ResponseBody
	/**
	 * /*  
	 *  Show scorers from a particular Team.
	 *  Only works with Long Team Name, because the scorers request returns a Team object with only a Long Name attribute.
	 *  localhost:8080/teamNationalities?team={teamName}
	 *  Inserire %20 al posto di uno spazio nel Nome del team
	 * @param longName
	 * @return
	 * @throws IOException
	 * @throws MissingTeamException
	 */
	public String returnteamNationalities(@RequestParam(name = "team", defaultValue = "FC Internazionale Milano") String longName) throws IOException, MissingTeamException {
		return Stat.returnTeamNationalities(longName);
	}
	
	@GetMapping("/countNationalities")
	@ResponseBody
	/**
	 * /*  
	 *  Show the number of scorers of each nationality of the team
	 *  Only works with Long Team Name, because the scorers request returns a Team object with only a Long Name attribute.
	 *  localhost:8080/countNationalities?team={teamName}
	 *  Inserire %20 al posto di uno spazio nel Nome del team
	 * @param longName
	 * @return
	 * @throws IOException
	 * @throws MissingTeamException
	 */
	public String returnCountNationalities(@RequestParam(name = "team", defaultValue = "FC Internazionale Milano") String longName) throws IOException, MissingTeamException {
		return Stat.returnCountNationalities(longName);
	}
	@GetMapping("/youngScorers")
	@ResponseBody
	/**
	 * Mostra tutti i marcatori di una squadra con età minore a 28 anni
	 * localhost:8080/youngScorers?team={longName}
	 * Inserire %20 al posto di uno spazio nel Nome lungo del team
	 * @param longName
	 * @return
	 * @throws IOException
	 * @throws MissingTeamException
	 */
	public String returnYoungScorers(@RequestParam(name = "team", defaultValue = "FC Internazionale Milano") String longName) throws IOException, MissingTeamException {
		return Stat.youngScorers(longName);
	}
	
	/**
	 * Mostra tutte le squadre il cui nome inizia con una certa lettera
	 * localhost:8080/startsWith?letter={c}
	 * @param letter
	 * @return
	 * @throws IOException
	 */
	@GetMapping("/startsWith")
	@ResponseBody
	@JsonIgnoreProperties
	public String returnStartsWith(@RequestParam(name = "letter", defaultValue = "F") String letter) throws IOException {
		return Filters.startsWith(letter);
	}
	
	@GetMapping("/getPosition")
	@ResponseBody
	@JsonIgnoreProperties
	public String returnPosition(@RequestParam(name = "position", defaultValue = "Midfielder") String position, @RequestParam(name = "team", defaultValue = "FC Internazionale Milano") String team) throws IOException {
		return Filters.positionFilter(position, team);
	}
	
}
	

