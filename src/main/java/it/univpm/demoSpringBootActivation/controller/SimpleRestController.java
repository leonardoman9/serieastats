package it.univpm.demoSpringBootActivation.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import it.univpm.demoSpringBootActivation.model.*;
import it.univpm.demoSpringBootActivation.requests.*;
import it.univpm.demoSpringBootActivation.utilities.*;
import it.univpm.demoSpringBootActivation.exceptions.*;
/**
 * RestController dell'applicazione WebRest SpringBoot
 * @author Leonardo Mannini
 * @author Luca Ranucci
 *
 */

@RestController
public class SimpleRestController implements Directories{
	/**
	 *  Mostra informazioni riguardo tutte le squadre della Serie A e informazioni riguardanti la Serie A
	 *  <br>
	 *  <code>localhost:8080/league</code>
	 *  <br>
	 *  Mostra informazioni riguardanti la Serie A
	 *  <br>
	 *  <code>localhost:8080/league?showTeams=false</code>
	 *  <br>
	 * @param showTeams <code>true</code> o <code>false</code>, serve a decidere se mostrare informazioni su tutte le squadre (true) o solo informazioni sul Campionato (false)
	 * @return newLeague Oggetto contenente la squadra deserializzata 
	 */
	@GetMapping("/league")
	@ResponseBody
	@JsonIgnoreProperties
	public League returnLeague(@RequestParam(name = "showTeams", defaultValue = "true") String showTeams) {
		League newLeague=new League();
		try {
			newLeague = JsonParser.parseLeague(LEAGUE_DIR);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (Boolean.parseBoolean(showTeams)) 
			{System.out.println(newLeague.toStringHeaderAndTeams());}	
		else
			{ System.out.println(newLeague.toStringHeader());}
		
		return newLeague;
	}
	/**
	 * Mostra informazioni riguardanti una squadra a scelta dell'utente
	 * <br>
	 * <code>localhost:8080/team?name=[nomeTeam]</code>
	 * <br>
	 * @param nomeTeam Il nome della squadra da visualizzare
	 * @return newTeam Oggetto contenente la squadra deserializzata 
	 * @throws IOException Se accade qualche errore di I/O
	 * @throws MissingTeamException Se il team richiesto non esiste
	 */
	@GetMapping("/team")
	@ResponseBody
	@JsonIgnoreProperties
	public  Team returnTeam(@RequestParam(name = "name", defaultValue = "Roma") String nomeTeam) throws MissingTeamException {
		Team newTeam = new Team();
		try {
			newTeam = Filters.returnTeam(nomeTeam);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		if(newTeam.getShortName()==null) {
			System.out.println("There is not a team called "+nomeTeam+".");
			throw new MissingTeamException();
		}
		else {
			System.out.println(newTeam+"\n");
			return newTeam;
		}
			
	}
	/**
	 *  Mostra i primi 100 marcatori della Serie A, ordinati per numero di gol
	 *  <br>
	 * 	<code>localhost:8080/leagueScorers</code>
	 * <br>
	 * @return scorers Oggetto contenente la squadra deserializzata
	 * @throws IOException Se accade un errore di I/O
	 */
	@GetMapping("/leagueScorers")     
	@ResponseBody

	public Scorers returnLeagueScorers() throws IOException {
		Scorers scorers = JsonParser.parseScorers(SCORERS_DIR);
		System.out.println(scorers.toString());
		return scorers;
	}
	
	
	/*********************************************DA QUI INIZIANO LE STATISTICHE**********************************/
	
	
	/**
	 *  Mostra i nomi degli stadi delle partite di Serie A.
	 *  <br>
	 *  <code>localhost:8080/venues</code>
	 *  <br>
	 * @return result Elenco di stadi della Serie A
	 * @throws IOException Se accade qualche errore di I/O
	 */
	@GetMapping("/venues")
	@ResponseBody
	@JsonIgnoreProperties
	public String returnVenues() throws IOException {
		String result="";
		try {
			result = Stat.returnVenues();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
	/**
	 * Mostra tutti gli stadi e il numero di squadra che giocano in ognuno di essi le partite "in casa".
	 * <br>
	 * <code>localhost:8080/teamsForEachVenue</code>
	 * <br>
	 * @return result Elenco di stadi e numero di relative squadre
	 * @throws IOException Se accade qualche errore di I/O
	 */
	@GetMapping("/teamsForEachVenue")
	@ResponseBody
	@JsonIgnoreProperties
	public String returnTeamsVenues() throws IOException {
		String result = Stat.returnTeamsVenues();
		System.out.println(result);
		return result;
	}
	/**
	 * Mostra tutte le squadre fondate dopo un certo anno, specificato dall'utente
     * <br>
	 * <code>localhost:8080/foundedAfter?year=[year]</code>
	 * <br>
	 * @param yearFounded Anno minimo di fondazione
	 * @return result Elenco di squadre fondate dopo l'anno richiesto
	 * @throws IOException Se accade qualche errore di I/O
	 */
	@GetMapping("/foundedAfter")
	@ResponseBody
	@JsonIgnoreProperties
	public String returnFoundedAfter(@RequestParam(name = "year", defaultValue = "1800") String yearFounded) throws IOException {
		String result = Stat.returnFoundedAfter(yearFounded);
		System.out.println(result);
		return result;
	}

	 /**
	 *  Mostra i marcatori di una specifica squadra, a scelta dell'utente.
	 * <br>
	 * 	<code>localhost:8080/teamScorers?team=[longTeamName]</code>
	 * <br>
	 *  Utilizzare il nome esteso della squadra  come input
	 *  
	 * @param longName Nome della squadra di cui visualizzarne i marcatori
	 * @return result Elenco di marcatori della squadra richiesta
	 * @throws IOException Se accade qualche errore di I/O
	 * @throws MissingTeamException se la squadra richiesta non esiste
	 */
	@GetMapping("/teamScorers")
	@ResponseBody
	public String returnteamScorers(@RequestParam(name = "team", defaultValue = "FC Internazionale Milano") String longName) throws IOException {
		String result = Stat.returnTeamScorers(longName);
		System.out.println(result);
		return result;
	}
	/**
	 *  
	 *  Mostra tutte le nazionalità dei marcatori di una specifica squadra, a scelta dell'utente
	 *<br>
	 *<code> localhost:8080/teamNationalities?team=[teamName]</code>
	 *  <br>
	 *  Utilizzare il nome esteso della squadra come input
	 *  
	 * @param longName Nome della squadra di cui si vuole visualizzare la nazionalità dei marcatori
	 * @return result Elenco di nazionalità dei marcatori della squadra richiesta
	 * @throws IOException Se accade qualche errore di I/O
	 * @throws MissingTeamException se la squadra richiesta non esiste
	 */
	@GetMapping("/teamNationalities")
	@ResponseBody
	public String returnTeamNationalities(@RequestParam(name = "team", defaultValue = "FC Internazionale Milano") String longName) throws IOException {
		String result = Stat.returnTeamNationalities(longName);
		System.out.println(result);
		return result;
	
	}
	/**
	 *
	 * <p>
	 * Mostra e conta tutte le nazionalità dei marcatori di una specifica squadra, a scelta dell'utente.
	 * <br>
	 * <code>localhost:8080/countNationalities?team=[teamName]</code>
	 * <br>
	 * Utilizzare il nome esteso della squadra come input
	 * </p>
	 * @param longName Nome della squadra di cui si vuole visualizzare e contare le nazionalità dei marcatori
	 * @return result Elenco di nazionalità e numero di marcatori per ogni nazionalità
	 * @throws IOException Se accade qualche errore di I/O
	 * @throws MissingTeamException se la squadra richiesta non esiste
	 */
	@GetMapping("/countNationalities")
	@ResponseBody
	public String returnCountNationalities(@RequestParam(name = "team", defaultValue = "FC Internazionale Milano") String longName) throws IOException {
		String result = Stat.returnCountNationalities(longName);
		System.out.println(result);
		return result;
	}
	/**
	 * Mostra tutti i marcatori di una squadra con età minore di 28 anni
	 * <br>
	 * <code>localhost:8080/youngScorers?team=[longName]</code>
	 * <br>
	 * Utilizzare il nome esteso della squadra come input
	 * 
	 * @param longName Nome della squadra di cuoi si vuole visualizzare i marcatori giovani
	 * @return result Elenco di marcatori con età minore di 28 anni
	 * @throws IOException Se accade qualche errore di I/O
	 * @throws MissingTeamException se la squadra richiesta none esiste
	 */
	@GetMapping("/youngScorers")
	@ResponseBody
	public String returnYoungScorers(@RequestParam(name = "team", defaultValue = "FC Internazionale Milano") String longName) throws IOException {
		String result = Stat.returnYoungScorers(longName);
		System.out.println(result);
		return result;
	}

	/*********************************************DA QUI INIZIANO I FILTRI**********************************/
	
	/**
	 * Mostra tutte le squadre il cui nome inizia con una certa lettera, a scelta dell'utente.
	 * <br>
	 * <code>localhost:8080/startsWith?letter=[letter]</code>
	 * <br>
	 * @param letter Lettera con cui filtrare i nomi delle squadre
	 * @return Elenco di squadre il cui nome inizia per <code>letter</code>
	 * @throws IOException Se accade qualche errore di I/O
	 */
	@GetMapping("/startsWith")
	@ResponseBody
	@JsonIgnoreProperties
	public String returnStartsWith(@RequestParam(name = "letter", defaultValue = "f") String letter) throws IOException {
		String result = Filters.startsWith(letter);
		System.out.println(result);
		return result;
	}
	/**
	 * Mostra tutte le squadre fondate in un certo anno, a scelta dell'utente
	 * <br>
	 * <code>localhost:8080/foundedIn?year=[year]</code>
	 * <br>
	 * @param year Anno con cui filtrare le squadre
	 * @return Elenco di squadre fondate nell'anno scelto dall'utente
	 * @throws IOException Se accade qualche errore di I/O
	 */
	@GetMapping("/foundedIn")
	@ResponseBody
	@JsonIgnoreProperties
	public String returnFoundedYearFilter(@RequestParam(name = "year", defaultValue = "1902") String year) throws IOException {
		String result = Filters.foundedYearFilter(year);
		System.out.println(result);
		return result;
	}
	/**
	 * Mostra tutti i giocatori di una o più nazionalità di una squadra, a scelta dell'utente.
	 * <br>
	 * <code>localhost:8080/team?=[longName]&#38;nationality?=[nationality]</code>
	 * <br>
	 * Utilizzare il nome esteso della squadra  come input
	 * 
	 * @param longName Nome della squadra di cui visualizzare i marcatori filtrati per nazionalità
	 * @param nationalities Una o più nazionalità da filtrare
	 * @return Elenco dei marcatori della squadra scelta filtrati per nazionalità
	 * @throws IOException Se accade qualche errore di I/O
	 */
	@GetMapping("/nationalitiesForTeam")
	@ResponseBody
	@JsonIgnoreProperties
	public String returnScorersForNationality(@RequestParam(name = "team", defaultValue = "FC Internazionale Milano") String longName
											 ,@RequestParam(name = "nationality")List<String> nationalities) throws IOException {
			String result="";
			result = Filters.returnScorersForNationality(longName, nationalities);
			System.out.println(result);
			return result;
	}
	/**
	 * Mostra tutti i marcatori di un ruolo di una squadra
	 * <br>
	 * <code>localhost:8080/scorersForPosition?team=[longName]&#38;position[position]</code>
	 * <br>
	 * Utilizzare il nome esteso della squadra come input
	 * @param longName Nome della squadra di cui visualizzare i marcatori giovani
	 * @param position Ruoli da filtrare
	 * @return result Elenco di marcatori della squadra scelta filtrati per ruolo
	 * @throws IOException Se accade qualche errore di I/O
	 * @throws MissingTeamException se la squadra richiesta non esiste
	 */
	
	@GetMapping("/scorersForPosition")
	@ResponseBody
	public String returnScorersForPosition(@RequestParam(name = "team", defaultValue = "FC Internazionale Milano") String longName, 
										   @RequestParam(name = "position", defaultValue = "Attacker") List<String> position) throws IOException, MissingTeamException {
		String result = Filters.returnScorersForPosition(longName, position);
		System.out.println(result);
		return result;
	}
}
