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
public class Filters {
	/**
	 * Funzione che chiama le API per ottenere una stringa con formato JSON e deserializzarla in un oggetto di tipo Team
	 * @param nomeTeam
	 * @return
	 * @throws IOException
	 * @throws MissingTeamException
	 */
	public static Team returnTeam(String nomeTeam) throws IOException, MissingTeamException { //ex richiesa
		File leagueFile = new File("league.json");
		League newLeague = JsonParser.parseLeague("league.json"); // TODO ???'
		int teamId = newLeague.lookForId(nomeTeam);
		if(teamId==-1)
			{throw new MissingTeamException(nomeTeam);}
		String result = Dataset.download("https://api.football-data.org/v2/teams/" + teamId);
		FileInputOutput.toFile(result,  "team"+teamId+".json");
		Team newTeam = JsonParser.parseTeam("team"+teamId+".json");
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
		League newLeague = JsonParser.parseLeague("league.json");
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
		League newLeague= JsonParser.parseLeague("league.json");
		String result = "Club names that start with letter " + letterChar + ":\n";
		for (Team i : newLeague.getTeams()) {
			if (i.getlongName().charAt(0)==letterChar) {
				result += i.getlongName() + "\n";
			}
		}
		System.out.println(result);
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
