package it.univpm.demoSpringBootActivation.requests;

import java.io.File;
import java.io.IOException;

import it.univpm.demoSpringBootActivation.exceptions.MissingTeamException;
import it.univpm.demoSpringBootActivation.model.*;
import it.univpm.demoSpringBootActivation.utilities.*;
/**
 * Classe contenente  metodi statici per realizzare filtri
 * @author leonardomannini
 *
 */
public class Filters implements Directories {
	/**
	 * Funzione che chiama le API per ottenere una stringa con formato JSON e deserializzarla in un oggetto di tipo Team
	 * @param nomeTeam
	 * @return
	 * @throws IOException
	 * @throws MissingTeamException
	 */
	public static Team returnTeam(String nomeTeam) throws IOException, MissingTeamException { //ex richiesa
		//File leagueFile = new File(LEAGUE_DIR);
		League newLeague = JsonParser.parseLeague(LEAGUE_DIR); // TODO ???'
		int teamId = newLeague.lookForId(nomeTeam);
		if(teamId==-1)
			{throw new MissingTeamException(nomeTeam);}
		String result = Dataset.download("https://api.football-data.org/v2/teams/" + teamId);
		FileInputOutput.toFile(result,  TEAM_DIR+"/team"+teamId+".json");
		Team newTeam = JsonParser.parseTeam(TEAM_DIR+"/team"+teamId+".json");
		return newTeam;	
	}
	/**
	 * Funzione che, dato in input un anno, restituisce tutte le squadre fondate dopo quell'anno
	 * @param year
	 * @return
	 * @throws IOException
	 */
	
	public static String foundedYearFilter(String year) throws IOException{
		int yearStr =Integer.parseInt(year);
		League newLeague = JsonParser.parseLeague(LEAGUE_DIR);
		String result = year + ":\n";
		for (Team i : newLeague.getTeams()) {
			if(i.getFounded()==yearStr) {
				result += i.getlongName()+"\n";
			}
		}
		System.out.println(result);
		return result;
	}

	/**
	 * Funzione che, data in input una lettera, restituisce tutte le squadre il cui nome inizia con quella lettera
	 * @param letter
	 * @return
	 * @throws IOException
	 */
	public static String startsWith(String letter) throws IOException {
		char letterChar = letter.charAt(0);
		League newLeague= JsonParser.parseLeague(LEAGUE_DIR	);
		String result = "Club names that start with letter " + letterChar + ":\n";
		for (Team i : newLeague.getTeams()) {
			if (i.getlongName().charAt(0)==letterChar) {
				result += i.getlongName() + "\n";
			}
		}
		System.out.println(result);
		return result;
	}
	/**
	 * Funzione che, data in input una squadra e una o più nazionalità, restituisce tutti i marcatori di nazionalità corrispondente
	 * @param longName, nationality
	 * @return
	 * @throws IOException
	 */
	public static String returnScorersForNationality(String longName, String nationality) throws IOException{
		String result = longName + ":\n";
		Scorers scorers= JsonParser.parseScorers(SCORERS_DIR);
		for (Scorer i : scorers.getScorers()) {
			if (i.getTeam().getlongName().equals(longName) && i.getPlayer().getNationality().equals(nationality)) {
					result+=i.getPlayer().getName()+"\n";
			}
		}
		if(result.equals(longName + ":\n"))
			result+="There are no scorers";
		return result;
	}
	//TODO
	public static String positionFilter(String position, String teamName) throws IOException {
		String result = "";
		Scorers scorers = Requests.returnLeagueScorers();
		return result;
	}

	public static String positionFilter(String team, String position1, String position2) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String positionFilter(String team, String position1, String position2, String position3) {
		// TODO Auto-generated method stub
		return null;
	}
}
