package it.univpm.demoSpringBootActivation.requests;

import java.io.IOException;
import java.util.List;

import it.univpm.demoSpringBootActivation.exceptions.MissingTeamException;
import it.univpm.demoSpringBootActivation.exceptions.NoNationalityException;
import it.univpm.demoSpringBootActivation.model.*;
import it.univpm.demoSpringBootActivation.utilities.*;
/**
 * Classe contenente  metodi statici per realizzare filtri
 * @author leonardomannini
 *
 */
public class Filters implements Directories {
	/**
	 * Construttore vuoto
	 */
	public Filters() {}
	/**
	 * Funzione che chiama le API per ottenere una stringa con formato JSON e deserializzarla in un oggetto di tipo Team
	 * @param nomeTeam Nome della squadra  da visualizzare
	 * @return newTeam Oggetto Team contenente il json Deserializzato
	 * @throws IOException se accade qualche errore di I/O
	 * @throws MissingTeamException Se la squadra richiesta non esiste
	 */
	public static Team returnTeam(String nomeTeam) throws IOException { //ex richiesa
		//File leagueFile = new File(LEAGUE_DIR);
		League newLeague = JsonParser.parseLeague(LEAGUE_DIR); 
		int teamId = newLeague.lookForId(nomeTeam);
		if(teamId==-1)
			{
				Team newTeam = new Team();
				return newTeam;
			}
		else
			{
			String result = Dataset.download("https://api.football-data.org/v2/teams/" + teamId);
			FileInputOutput.toFile(result,  TEAM_DIR+"/team"+teamId+".json");
			Team newTeam = JsonParser.parseTeam(TEAM_DIR+"/team"+teamId+".json");
			return newTeam;	
		}
	}
	/**
	 * Funzione che, dato in input un anno, restituisce tutte le squadre fondate dopo quell'anno
	 * @param year Anno con cui filtrare le squadre
	 * @return result Elenco di squadre fondate nell'anno <code>year</code>
	 * @throws IOException se accade qualche errore di I/O
	 */
	
	public static String foundedYearFilter(String year) throws IOException{
		int yearStr=0;
		try{
			yearStr =Integer.parseInt(year);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		int n=0;
		League newLeague = JsonParser.parseLeague(LEAGUE_DIR);
		String result = "Founded " + year + ":\n\n";
		for (Team i : newLeague.getTeams()) {
			if(i.getFounded()==yearStr) {
				result += i.toString()+"\n";
				n++;
			}
		}
		result+="Total: " + n +" teams founded in " + year +".\n";
		return result;
	}

	/**
	 * Funzione che, data in input una lettera, restituisce tutte le squadre il cui nome inizia con quella lettera
	 * @param letter Lettera con cui filtrare le squadre
	 * @return result Elenco di squadre il cui nome inizia per <code> letter </code>
	 * @throws IOException se accade qualche errore di I/O
	 */
	public static String startsWith(String letter) throws IOException {
		char letterChar = letter.charAt(0);
		if(!Character.isLetter(letterChar)) {
			return "Incorrect input: you have to type in a letter.";
		}
		if(Character.isLowerCase(letterChar)) {
			letterChar = Character.toUpperCase(letterChar);
		}
		int n=0;
		League newLeague= JsonParser.parseLeague(LEAGUE_DIR	);
		String result = "Teams that start with the letter " + letterChar + ":\n\n";
		for (Team i : newLeague.getTeams()) {
			if (i.getlongName().charAt(0)==letterChar) {
				result += i.toString() + "\n\n";
				n++;
			}
		}
		result+="Total: " + n + " teams.\n";
		return result;
	}
	/**
	 * Funzione che, data in input una squadra e una o più nazionalità, restituisce tutti i marcatori di nazionalità corrispondente
	 * @param longName Nome della squadra da visualizzare
	 * @param nationality ArrayList di nazionalità con cui filtrare i marcatori della squadra scelta
	 * @return result Elenco di marcatori di una squadra filtrati per nazionalità
	 * @throws IOException se accade qualche errore di I/O
	 */
	public static String returnScorersForNationality(String longName, List<String> nationality) throws IOException{
		for(String i : nationality) {
			if(!Nationalities.isNationality(i)) {
				System.out.println("One of the searched nationalities is not correct: "+i+" is not a nationality.\n");
				throw new  NoNationalityException();
			}
		}
		String result = longName + ":\n\n";
		int n=0;
		Scorers scorers= JsonParser.parseScorers(SCORERS_DIR);
		for (Scorer i : scorers.getScorers()) {
			if (i.getTeam().getlongName().equals(longName) && nationality.contains(i.getPlayer().getNationality())) {
					result+=i.getPlayer().toString()+"\n";
					n++;
			}
		}
		result+="Total: " + n + " " + " scorers of the searched nationality.\n";
		return result;
	}
	/**
	 * Funzione che, data in input una squadra e uno o più ruoli, restituisce tutti i marcatori del ruolo corrispondente
	 * @param longName Nome della squadra da visualizzare
	 * @param position ArrayList di ruoli con cui i filtrare i marcatori della squadra scelta
	 * @return result Elenco di  marcatori di una squadra filtrati per ruolo
	 * @throws MissingTeamException Se non esiste la squadra <code>longName</code>
	 * @throws IOException se accade qualche errore di I/O
	 */
	public static String returnScorersForPosition(String longName, List<String> position) throws MissingTeamException, IOException{
		for(String i : position) {
			if(!Positions.isPosition(i)) {
				return "One of the searched position is not correct: "+i+" is not a soccer position.";
			}
		}
		String result = longName + ":\n\n";
		int n=0;
		Scorers scorers= JsonParser.parseScorers(SCORERS_DIR);
		for (Scorer i : scorers.getScorers()) {
			if (i.getTeam().getlongName().equals(longName) && position.contains(i.getPlayer().getPosition())) {
					result+=i.getPlayer().toString()+"\n";
					n++;
			}
		}
		result+="Total: " + n + " " + " scorers.\n";
		return result;
	}
	
}
