package it.univpm.demoSpringBootActivation.requests;
	
import java.io.IOException;

import it.univpm.demoSpringBootActivation.exceptions.MissingTeamException;
import it.univpm.demoSpringBootActivation.model.*;
import it.univpm.demoSpringBootActivation.utilities.*;
/**
 * Classe contenente i diversi tipi di richiesta da effettuare alle API per ottenere i dati richiesti
 *
 */
public class Requests implements Directories{
	/**
	 * Funzione che chiama le API per ottenere una stringa con formato JSON e deserializzarla in un oggetto di tipo League
	 * @param showTeams Parametro booleano per decidere se mostrare tutte le squadre della serie A (true) (di default è true), o mostrare solo informazioni riguardo la competizione (false)
	 * @return Oggetto di tipo League popolato dalle informazioni sulla Serie A
	 * @throws IOException
	 */
	public static League returnLeague() throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/teams");
		FileInputOutput.toFile(result, LEAGUE_DIR);
		League newLeague = new League();
		newLeague = JsonParser.parseLeague(LEAGUE_DIR);
		return newLeague;
	}
	
	/**
	 * Funzione che chiama le API per ottenere una stringa con formato JSON e deserializzarla in un oggetto di tipo Scorers
	 * @return
	 * @throws IOException
	 */
	public static Scorers returnLeagueScorers()  throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/scorers?limit=100"); //SE AUMENTO IL LIMIT, NON FUNZIONA /scorersForPosition
		FileInputOutput.toFile(result, SCORERS_DIR);
		Scorers scorers = new Scorers();
		scorers = JsonParser.parseScorers(SCORERS_DIR);
		result = "The 100 best SA scorers: \n";
		for (Scorer i : scorers.getScorers()) {
				result+= i.getPlayer().getName()+ ": " + i.getNumberOfGoals() + " goals" + " (" + i.getTeam().getlongName()+")\n";
		}	
		return scorers;
	}
	@SuppressWarnings("unused")
	public static void doRequests() throws IOException, MissingTeamException {
		League leagueFile = Requests.returnLeague();
		Scorers leagueScorers = Requests.returnLeagueScorers();
		}
	
}
