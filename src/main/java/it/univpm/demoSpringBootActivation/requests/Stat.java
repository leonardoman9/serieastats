package it.univpm.demoSpringBootActivation.requests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import it.univpm.demoSpringBootActivation.model.*;
import it.univpm.demoSpringBootActivation.utilities.*;
/**
 * Classe contenente  metodi statici per effettuare statistiche
 * @author leonardomannini
 *
 */
public class Stat {
	/**
	 * Funzione che, dato in input un anno, restituisce tutte le squadre fondate dopo quell'anno
	 * @param yearFounded
	 * @return
	 * @throws IOException
	 */
	public static String returnFoundedAfter(String yearFounded) throws IOException {
		String result;
		int yearFoundedInt = Integer.parseInt(yearFounded);
		Team[] Teams;
		result = Dataset.download("https://api.football-data.org/v2/competitions/SA/teams");
		League newLeague = JsonParser.parseLeague(result);
		Teams = newLeague.getTeams();
		for (Team i : Teams) {
			if (i.getFounded() > yearFoundedInt) {
				System.out.print(i.getShortName()+ ":");
				if(i.getShortName().length()<7) System.out.print("\t"); 
				System.out.println("\t" + i.getFounded());
			}
		}
		return result;
	}
	/**
	 * Funzione che recupera e stampa tutti gli stadi della Serie A.
	 * @return
	 * @throws IOException
	 */
	public static String returnVenues() throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/teams");
		League newLeague = new League();
		newLeague = JsonParser.parseLeague(result);
		System.out.println(newLeague.countVenues());
		return newLeague.countVenues();
	}
	/**
	 * Funzione che recupera e stampa tutti gli stadi della Serie A contando quante sqaudre diverse giocano
	 * in ognuno di questi.
	 * @return
	 * @throws IOException
	 */
	public static String returnTeamsVenues() throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/teams");
		League newLeague = new League();
		newLeague = JsonParser.parseLeague(result);
		List<String> stadi = new ArrayList<String>();
		List<Integer> squadre = new ArrayList<Integer>();
		for(Team t: newLeague.getTeams()) {
			if(!stadi.contains(t.getVenue())) {
				stadi.add(t.getVenue());
				squadre.add(1);
			}
			else {
				int index=stadi.indexOf(t.getVenue());
				squadre.set(index, squadre.get(index)+1);
			}
		}
		System.out.println("How many teams play in each venue: ");
		result="";
		for(int i=0; i<stadi.size(); i++) {
			result = result + stadi.get(i)+": "+squadre.get(i)+"\n";
		}
		System.out.println(result);
		return result;
	}
	
	/**
	 * Funzione che recupera e stampa tutti i marcatori di una determinata squadra scelta dall'utente
	 * @param longName
	 * @return
	 * @throws IOException
	 */
	public static String returnTeamScorers(String longName) throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/scorers?limit=100");
		Scorers scorers = new Scorers();
		scorers = JsonParser.parseScorers(result);
		result = "";
		result = longName + ":\n";
		for (Scorer i : scorers.getScorers()) {
			if (i.getTeam().getlongName().equals(longName)) result += i.getPlayer().getName() + ": " + i.getNumberOfGoals()+ "\n"; //TODO non funziona, i.getName() è sempre null (?)
		}
		System.out.println("The 100 best SA scorers: \n");
		System.out.println(result);
		return result;
	}
	/**
	 *Funzione che recupera e stampa tutte le nazionalità dei marcatori di una determinata squadra scelta dall'utente
	 * 
	 * @param longName
	 * @return
	 * @throws IOException
	 */
	public static String returnTeamNationalities(String longName) throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/scorers?limit=100");
		Scorers scorers = new Scorers();
		scorers = JsonParser.parseScorers(result);
		result = longName + ":\n";
		HashMap nationalityCounter = new HashMap();
		
		for (Scorer i : scorers.getScorers()) {
			if (i.getTeam().getlongName().equals(longName)) {
				result+= i.getPlayer().getNationality().toString()+"\n";
			}
	}	
		System.out.println(result+"\n");
		return result;
	}
	/**
	 *Funzione che recupera e stampa marcatori di una certa nazionalità di una determinata squadra scelta dall'utente
	 * 
	 * @param longName
	 * @return
	 * @throws IOException
	 */
	public static String returnCountNationalities(String longName) throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/scorers?limit=100");
		Scorers scorers = new Scorers();
		scorers = JsonParser.parseScorers(result);
		List<String> nationalities = new ArrayList<String>();
		List<Integer> count = new ArrayList<Integer>();		
		for (Scorer i : scorers.getScorers()) {
			if (i.getTeam().getlongName().equals(longName)) {
				if(!nationalities.contains(i.getPlayer().getNationality())) {
					nationalities.add(i.getPlayer().getNationality());
					count.add(1);
				}
				else {
					int index=nationalities.indexOf(i.getPlayer().getNationality());
					count.set(index, count.get(index)+1);
				}
			}
		}	
		result = "Number of "+longName+" players of different nationalaties:\n";
		for(int i=0; i<nationalities.size(); i++) {
			result = result + nationalities.get(i)+": "+count.get(i)+"\n";
		}
		System.out.println(result+"\n");
		return result;
	}
	/*
	for(int i=0; i<stadi.size(); i++) {
		result = result + stadi.get(i)+": "+squadre.get(i)+"\n";
	}
	System.out.println(result);
	return result;
	*/
	/**
	 * Funzione che restituisce tutti i marcatori di una determinata squadra con un età minore di 28 anni.
	 * @param longName
	 * @return
	 * @throws IOException
	 */
	public static String youngScorers(String longName)  throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/scorers?limit=100");
		Scorers scorersp= new Scorers();
		scorersp = JsonParser.parseScorers(result);
		List<Scorer>  scorers = new ArrayList<Scorer>();
		result = longName + ":\n";
		for (Scorer i : scorersp.getScorers()) {
			if (i.getTeam().getlongName().equals(longName)) scorers.add(i);
		}
		for (Scorer i : scorers) {
			DateOfBirth a = AgeCalculator.parseDate(i.getPlayer().getDateOfBirth());
			if(28 > (2021 - a.getYear())) {
				int year = 2021-a.getYear();
				result += i.getPlayer().getName() + ": " + year + " years"+"\n";
				System.out.println(i.getPlayer().getName() + ": " + year + " years");
			}
			
		}
		return result;
	}


	
}