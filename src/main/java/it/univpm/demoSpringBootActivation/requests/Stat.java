package it.univpm.demoSpringBootActivation.requests;

import java.io.IOException;
import java.util.ArrayList;
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
		String result="";
		int yearFoundedInt = Integer.parseInt(yearFounded);
		Team[] Teams;
		League newLeague = Requests.returnLeague();
		Teams = newLeague.getTeams();
		for (Team i : Teams) {
			if (i.getFounded() > yearFoundedInt) {
				result+=i.getShortName()+ ":";
				if(i.getShortName().length()<7) result+="\t"; 
				result+="\t" + i.getFounded()+"\n";
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
		League newLeague = Requests.returnLeague();
		return newLeague.countVenues();
	}
	/**
	 * Funzione che recupera e stampa tutti gli stadi della Serie A contando quante sqaudre diverse giocano
	 * in ognuno di questi.
	 * @return
	 * @throws IOException
	 */
	public static String returnTeamsVenues() throws IOException {
		String result = "";
		League newLeague = Requests.returnLeague();
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
		result+="How many teams play in each venue: \n";
		for(int i=0; i<stadi.size(); i++) {
			result = result + stadi.get(i)+": "+squadre.get(i)+"\n";
		}
		return result;
	}
	
	/**
	 * Funzione che recupera e stampa tutti i marcatori di una determinata squadra scelta dall'utente
	 * @param longName
	 * @return
	 * @throws IOException
	 */
	public static String returnTeamScorers(String longName) throws IOException {
		String result;
		Scorers scorers = Requests.returnLeagueScorers();
		result = "";
		result = longName + ":\n";
		for (Scorer i : scorers.getScorers()) {
			if (i.getTeam().getlongName().equals(longName)) result += i.getPlayer().getName() + ": " + i.getNumberOfGoals()+ "\n"; //TODO non funziona, i.getName() è sempre null (?)
		}
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
		String result="";
		Scorers scorers = Requests.returnLeagueScorers();
		result = longName + ":\n";
		for (Scorer i : scorers.getScorers()) {
			if (i.getTeam().getlongName().equals(longName)) {
				result+= i.getPlayer().getNationality().toString()+"\n";
			}
	}	
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
		String result = "";
		Scorers scorers = Requests.returnLeagueScorers();
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
		return result;
	}
	/**
	 * Funzione che restituisce tutti i marcatori di una determinata squadra con un età minore di 28 anni.
	 * @param longName
	 * @return
	 * @throws IOException
	 */
	public static String returnYoungScorers(String longName)  throws IOException {
		String result ="";
		Scorers scorersp= Requests.returnLeagueScorers();
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
			}
			
		}
		return result;
	}


	
}