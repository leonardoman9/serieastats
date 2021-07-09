package it.univpm.demoSpringBootActivation.requests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import it.univpm.demoSpringBootActivation.model.*;
import it.univpm.demoSpringBootActivation.utilities.*;
/**
 * Classe contenente  metodi statici per effettuare statistiche
 * @author leonardomannini
 *
 */
public class Stat implements Directories{
	/**
	 * Funzione che, dato in input un anno, restituisce tutte le squadre fondate dopo quell'anno
	 * @param yearFounded
	 * @return
	 * @throws IOException
	 */
	public static String returnFoundedAfter(String yearFounded) {
		String result="Teams founded after " + yearFounded + ":\n";
		Team[] Teams;
		int yearFoundedInt, n=0;
		try {
			yearFoundedInt = Integer.parseInt(yearFounded);
			League newLeague = JsonParser.parseLeague(LEAGUE_DIR);
			Teams = newLeague.getTeams();
			for (Team i : Teams) {
				if (i.getFounded() > yearFoundedInt) {
					result+=i.toString()+"\n";
					n++;
				}
			}
			result+= n + " teams founded after year " + yearFounded + ".\n";
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "ERRORE";
		}
		return result;
		
	}
	/**
	 * Funzione che recupera e stampa tutti gli stadi della Serie A.
	 * @return
	 * @throws IOException
	 */
	public static String returnVenues() {
		League newLeague = JsonParser.parseLeague(LEAGUE_DIR);
		return newLeague.countVenues();
	}
	/**
	 * Funzione che recupera e stampa tutti gli stadi della Serie A contando quante sqaudre diverse giocano
	 * in ognuno di questi.
	 * @return
	 * @throws IOException
	 */
	public static String returnTeamsVenues() {
		String result = "";
		League newLeague = JsonParser.parseLeague(LEAGUE_DIR);
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
	public static String returnTeamScorers(String longName) {
		String result;
		Scorers scorers = JsonParser.parseScorers(SCORERS_DIR);
		result = "";
		result = longName + ":\n\n";
		for (Scorer i : scorers.getScorers()) {
			if (i.getTeam().getlongName().equals(longName)) result += i.getPlayer().toString() + i.toString() +"\n";
		}
		result+="Total: " + scorers.getSize(longName) + " scorers.\n";
		return result;
	}
	/**
	 *Funzione che recupera e stampa tutte le nazionalità dei marcatori di una determinata squadra scelta dall'utente
	 * 
	 * @param longName
	 * @return
	 * @throws IOException
	 */
	public static String returnTeamNationalities(String longName) {
		String result="";
		Scorers scorers = JsonParser.parseScorers(SCORERS_DIR);
		List<String> nationalities = new ArrayList<String>();
		result = longName + ":\n";
		for (Scorer i : scorers.getScorers()) {
			if (i.getTeam().getlongName().equals(longName)&&!nationalities.contains(i.getPlayer().getNationality())) {
				nationalities.add(i.getPlayer().getNationality());
				result+= i.getPlayer().getNationality()+"\n";
			}
	}	
		result+="Total: " + nationalities.size()+" nationalities\n";
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
		Scorers scorers = JsonParser.parseScorers(SCORERS_DIR);
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
		result = "Number of "+longName+" players for different nationalities:\n";
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
		int n=0;
		Scorers scorersp= JsonParser.parseScorers(SCORERS_DIR);
		List<Scorer>  scorers = new ArrayList<Scorer>();
		result = longName + ":\n\n";
		for (Scorer i : scorersp.getScorers()) {
			if (i.getTeam().getlongName().equals(longName)) scorers.add(i);
		}
		for (Scorer i : scorers) {
			DateOfBirth a = AgeCalculator.parseDate(i.getPlayer().getDateOfBirth());
			if(28 > (Calendar.getInstance().get(Calendar.YEAR) - a.getYear())) {
				result += i.getPlayer().toString() +"\n";
				n++;
			}
			
		}
		result+="Total: " + n +" scorers younger than 28 years old	\n";
		return result;
	}


	
	

	
}