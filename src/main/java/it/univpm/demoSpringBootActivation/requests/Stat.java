package it.univpm.demoSpringBootActivation.requests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import it.univpm.demoSpringBootActivation.exceptions.MissingTeamException;
import it.univpm.demoSpringBootActivation.model.*;
import it.univpm.demoSpringBootActivation.utilities.*;
/**
 * Classe contenente metodi statici per effettuare statistiche
 * @author leonardomannini
 *
 */
public class Stat implements Directories{
	/**
	 * Funzione che, dato in input un anno, restituisce tutte le squadre fondate dopo quell'anno
	 * @param yearFounded Anno minimo di fondazione delle squadre
	 * @return result Elenco di squadre fondate dopo l'anno <code>yearFounded</code>
	 * @throws IOException se accade qualche errore di I/O
	 */
	public static String returnFoundedAfter(String yearFounded) throws IOException{
		String result="Teams founded after " + yearFounded + ":\n\n";
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
			return "ERROR: insert a valid year as input.";
		}
		return result;
		
	}
	/**
	 * Funzione che recupera e stampa tutti gli stadi della Serie A.
	 * @return newLeague.countVenues() Elenco di Stadi della Serie A
	 * @throws IOException se accade qualche errore di I/O
	 */
	public static String returnVenues() throws IOException {
		League newLeague = JsonParser.parseLeague(LEAGUE_DIR);
		return newLeague.toStringVenues();
	}
	/**
	 * Funzione che recupera e stampa tutti gli stadi della Serie A contando quante sqaudre diverse giocano
	 * in ognuno di questi.
	 * @return result Elenco di stadi e numero di squadre diverse che ci giocano le partite "in casa"
	 * @throws IOException se accade qualche errore di I/O
	 */
	public static String returnTeamsVenues() throws IOException {
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
	 * @param longName Nome della squadra di cui visualizzare i marcatori
	 * @return Elenco di marcatori della squadra
	 * @throws IOException se accade qualche errore di I/O
	 */
	public static String returnTeamScorers(String longName) throws IOException {
		String result;
		boolean correctName = false;
		Scorers scorers = JsonParser.parseScorers(SCORERS_DIR);
		result = "";
		result = longName + ":\n\n";
		for (Scorer i : scorers.getScorers()) {
			if (i.getTeam().getlongName().equals(longName)) {
				result += i.getPlayer().toString() + i.toString() +"\n";
				correctName = true;
				
			}
		}
		if(correctName) {
			result+="Total: " + scorers.getSize(longName) + " scorers.\n";
			return result;
		}
		else return "There is not a team called "+longName+".";
	}
	/**
	 *Funzione che recupera e stampa tutte le nazionalità dei marcatori di una determinata squadra scelta dall'utente
	 * 
	 * @param longName Nome della squadra di cui visualizzare la nazionalità dei marcatori
	 * @return result Elenco di marcatori di una certa nazionalità di una squadra
	 * @throws IOException se accade qualche errore di I/O
	 */
	public static String returnTeamNationalities(String longName) throws IOException {
		String result="";
		boolean correctName = false;
		Scorers scorers = JsonParser.parseScorers(SCORERS_DIR);
		List<String> nationalities = new ArrayList<String>();
		result = longName + ":\n";
		for (Scorer i : scorers.getScorers()) {
			if (i.getTeam().getlongName().equals(longName)&&!nationalities.contains(i.getPlayer().getNationality())) {
				nationalities.add(i.getPlayer().getNationality());
				result+= i.getPlayer().getNationality()+"\n";
				correctName = true;
			}
		}	
		if(correctName) {
			result+="Total: " + nationalities.size()+" nationalities\n";
			return result;
		}
		else return "There is not a team called "+longName+".";
		
	}
	/**
	 * Funzione che recupera e stampa marcatori di una certa nazionalità di una determinata squadra scelta dall'utente
	 * 
	 * @param longName Nome della squadra di cui visualizzare e contare le diverse nazionalità dei marcatori
	 * @return  result Elenco di nazionalità diverse per numero di marcatori che ne fanno parte
	 * @throws IOException se accade qualche errore di I/O
	 */
	public static String returnCountNationalities(String longName) throws IOException {
		String result = "";
		boolean correctName = false;
		Scorers scorers = JsonParser.parseScorers(SCORERS_DIR);
		List<String> nationalities = new ArrayList<String>();
		List<Integer> count = new ArrayList<Integer>();		
		for (Scorer i : scorers.getScorers()) {
			if (i.getTeam().getlongName().equals(longName)) {
				correctName = true;
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
		if(correctName) {
			result = "Number of "+longName+" players for different nationalities:\n";
			for(int i=0; i<nationalities.size(); i++) {
				result = result + nationalities.get(i)+": "+count.get(i)+"\n";
			}
			return result;
		}
		else return "There is not a team called "+longName+".";
	}
	/**
	 * Funzione che restituisce tutti i marcatori di una determinata squadra con un età minore di 28 anni.
	 * @param longName Nome della squadra di cui visualizzare i marcatori con età minore di 28 anni
	 * @return result Elenco di marcatori la cui età è minore di 28 anni
	 * @throws IOException se accade qualche errore di I/O
	 */
	public static String returnYoungScorers(String longName)  throws IOException {
		String result ="";
		boolean correctName= false;
		int n=0;
		Scorers scorersp= JsonParser.parseScorers(SCORERS_DIR);
		List<Scorer>  scorers = new ArrayList<Scorer>();
		result = longName + ":\n\n";
		for (Scorer i : scorersp.getScorers()) {
			if (i.getTeam().getlongName().equals(longName)) {
				scorers.add(i);
				correctName = true;
			}
		}
		for (Scorer i : scorers) {
			DateOfBirth a = AgeCalculator.parseDate(i.getPlayer().getDateOfBirth());
			if(28 > (Calendar.getInstance().get(Calendar.YEAR) - a.getYear())) {
				result += i.getPlayer().toString() +"\n";
				n++;
			}
			
		}
		if(correctName) {
			result+="Total: " + n +" scorers younger than 28 years old	\n";
			return result;
		}
		else throw new MissingTeamException(longName);
			//return "There is not a team called "+longName+".";
	}
}