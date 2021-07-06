package it.univpm.demoSpringBootActivation.requests;

import java.io.IOException;

import it.univpm.demoSpringBootActivation.model.*;
import it.univpm.demoSpringBootActivation.utilities.*;
/**
 * Classe contenente  metodi statici per realizzare filtri
 * @author leonardomannini
 *
 */
public class Filters {
	/**
	 * Funzione che, dato in input un anno, restituisce tutte le squadre fondate dopo quell'anno
	 * @param year
	 * @return
	 * @throws IOException
	 */
	public static String foundedYearFilter(String year) throws IOException{
		int yearStr =Integer.parseInt(year);
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/teams");
		League newLeague = new League();
		newLeague = JsonParser.parseLeague(result);
		result = year + ":\n";
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
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/teams");
		League newLeague = new League();
		newLeague = JsonParser.parseLeague(result);
		result = "Club names that start with letter " + letterChar + ":\n";
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
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/scorers?limit=100");
		Scorers scorers = new Scorers();
		scorers = JsonParser.parseScorers(result);
		result = "";
		
		
		
		return result;
	}
}