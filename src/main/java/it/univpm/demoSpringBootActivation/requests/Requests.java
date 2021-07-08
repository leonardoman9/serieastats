package it.univpm.demoSpringBootActivation.requests;
	
import java.io.FileNotFoundException;
import java.io.IOException;

import it.univpm.demoSpringBootActivation.exceptions.MissingTeamException;
import it.univpm.demoSpringBootActivation.model.League;
import it.univpm.demoSpringBootActivation.model.Scorer;
import it.univpm.demoSpringBootActivation.model.Scorers;
import it.univpm.demoSpringBootActivation.utilities.Dataset;
import it.univpm.demoSpringBootActivation.utilities.FileInputOutput;
import it.univpm.demoSpringBootActivation.utilities.JsonParser;
/**
 * Classe contenente i diversi tipi di richiesta da effettuare alle API per ottenere i dati richiesti
 * @author Luca Ranucci
 * @author Leonardo Mannini
 *
 */
public class Requests implements Directories{
	/**
	 * Funzione che chiama le API per ottenere una stringa con formato JSON e deserializzarla in un oggetto di tipo League
	 * @param showTeams Parametro booleano per decidere se mostrare tutte le squadre della serie A (true) (di default è true), o mostrare solo informazioni riguardo la competizione (false)
	 * @return Oggetto di tipo League popolato dalle informazioni sulla Serie A
	 * @throws IOException
	 */
	public static League returnLeague() throws IOException, FileNotFoundException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/teams");
		FileInputOutput.toFile(result, LEAGUE_DIR);
		return JsonParser.parseLeague(LEAGUE_DIR);
	}
	
	/**
	 * Funzione che chiama le API per ottenere una stringa con formato JSON e deserializzarla in un oggetto di tipo Scorers
	 * @return
	 * @throws IOException
	 */
	public static Scorers returnLeagueScorers()  throws IOException, FileNotFoundException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/scorers?limit=100"); //SE AUMENTO IL LIMIT, NON FUNZIONA /scorersForPosition
		FileInputOutput.toFile(result, SCORERS_DIR);
		return JsonParser.parseScorers(SCORERS_DIR);
	}
	/*
	 * Funzione utilizzata per scaricare i due file "league.json" e "scorers.json" tramite le due richieste dei metodi returnLeague() e returnLeagueScorers(),
	 * per avere un Dataset su cui lavorare ad ogni avvio del programma
	 */
	@SuppressWarnings("unused")
	public static void doRequests() throws IOException, MissingTeamException, FileNotFoundException {
		League leagueFile = Requests.returnLeague();
		Scorers leagueScorers = Requests.returnLeagueScorers();
		}
	
}
