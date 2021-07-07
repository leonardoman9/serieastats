package it.univpm.demoSpringBootActivation.controller;

import java.io.IOException;


import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import it.univpm.demoSpringBootActivation.model.*;
import it.univpm.demoSpringBootActivation.requests.*;
import it.univpm.demoSpringBootActivation.utilities.JsonParser;
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
		League result = JsonParser.parseLeague("league.json");
		if (Boolean.parseBoolean(showTeams)) {System.out.println(result.toStringHeaderAndTeams());}	
		else						 { System.out.println(result.toStringHeader());}
		
		return result;
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
		Team newTeam = Filters.returnTeam(nomeTeam);
		System.out.println(newTeam+"\n");
		return newTeam;
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
	public Scorers returnLeagueScorers() throws IOException, MissingTeamException {
		Scorers scorers = JsonParser.parseScorers("scorers.json");
		System.out.println(scorers.toString());
		return scorers;
	}
	
	
	//DA QUI INIZIANO LE STATISTICHE//
	
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
		String result = Stat.returnVenues();
		System.out.println(result);
		return result;
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
		String result = Stat.returnFoundedAfter(yearFounded);
		System.out.println(result);
		return result;
	}
	@GetMapping("/teamsForEachVenue")
	@ResponseBody
	@JsonIgnoreProperties
	public String returnTeamsVenues() throws IOException {
		String result = Stat.returnTeamsVenues();
		System.out.println(result);
		return result;
	}

	
	@GetMapping("/teamScorers")
	@ResponseBody
	/**
	 * Mostra i marcatori di una specifica squadra, a scelta dell'utente.
	 * 	localhost:8080/teamScorers?team={longTeamName}
	 *  Inserire %20 al posto di uno spazio nel Nome del team
	 * @param longName
	 * @return
	 * @throws IOException
	 * @throws MissingTeamException
	 */
	public String returnteamScorers(@RequestParam(name = "team", defaultValue = "FC Internazionale Milano") String longName) throws IOException, MissingTeamException {
		String result = Stat.returnTeamScorers(longName);
		System.out.println(result);
		return result;
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
		String result = Stat.returnTeamNationalities(longName);
		System.out.println(result);
		return result;
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
		String result = Stat.returnCountNationalities(longName);
		System.out.println(result);
		return result;
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
		String result = Stat.returnYoungScorers(longName);
		System.out.println(result);
		return result;
	}
	@GetMapping("/scorersForPosition")
	@ResponseBody
	/**
	 * Mostra tutti i marcatori di un ruolo di una squadra
	 * localhost:8080/youngScorers?team={longName}?position={position}
	 * Inserire %20 al posto di uno spazio nel Nome lungo del team
	 * @param longName
	 * @return
	 * @throws IOException
	 * @throws MissingTeamException
	 */
	public String returnScorersForPosition(@RequestParam(name = "team", defaultValue = "FC Internazionale Milano") String longName, @RequestParam(name = "position", defaultValue = "Attacker") String position) throws IOException, MissingTeamException {
		String result = Stat.returnScorersForPosition(longName, position);
		System.out.println(result);
		return result;
	}
	//DA QUI INIZIANO I FILTRI
	
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
		String result = Filters.startsWith(letter);
		System.out.println(result);
		return result;
	}
	/**
	 * 
	 * @param position
	 * @param team
	 * @return
	 * @throws IOException
	 */
	@GetMapping("/getPosition")
	@ResponseBody
	@JsonIgnoreProperties
	public String returnPosition( @RequestParam(name = "team", defaultValue = "FC Internazionale Milano") String team, 
								  @RequestParam(name = "position", defaultValue = "Attacker") String position) 
								  throws IOException {
		String result = Filters.positionFilter(team, position);
		System.out.println(result);
		return result;
	}
	public String returnPosition( @RequestParam(name = "team", defaultValue = "FC Internazionale Milano") String team, 
						   		  @RequestParam(name = "position1", defaultValue = "Attacker") String position1,
						   		  @RequestParam(name = "position2", defaultValue = "Midfielder") String position2)
						   		  throws IOException {
		String result = Filters.positionFilter(team, position1, position2);
		System.out.println(result);
		return result;
	}
	public String returnPosition( @RequestParam(name = "team", defaultValue = "FC Internazionale Milano") String team, 
	   		  					  @RequestParam(name = "position1", defaultValue = "Attacker") String position1,
	   		  					  @RequestParam(name = "position2", defaultValue = "Midfielder") String position2,
	   		  					  @RequestParam(name = "position2", defaultValue = "Defender") String position3)
	   		  					  throws IOException {
		String result = Filters.positionFilter(team, position1, position2, position3);
		System.out.println(result);
		return result;
	}
}
	

