package it.univpm.demoSpringBootActivation.requests;
	
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;

import it.univpm.demoSpringBootActivation.model.*;
import it.univpm.demoSpringBootActivation.utilities.*;
/**
 * Classe contenente i diversi tipi di richiesta da effettuare alle API per ottenere i dati richiesti
 * @author Luca Ranucci
 * @author Leonardo Mannini
 */
public class Requests implements Directories{
	/**
	 * Construttore vuoto
	 */
	public Requests() {}
	/**
	 * Funzione che chiama le API per ottenere una stringa con formato JSON e deserializzarla in un oggetto di tipo <code>League</code>
	 * @return JsonParser.parseLeague(LEAGUE_DIR) Oggetto di tipo League popolato dalle informazioni sulla Serie A
	 * @throws FileNotFoundException Se il file <code>LEAGUE_DIR</code> non è nella directory
	 * @throws UnknownHostException Se la connessione alle API fallisce
	 */
	public static League returnLeague() throws FileNotFoundException, UnknownHostException {
		League  newLeague = new League();
		try {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/teams");
		FileInputOutput.toFile(result, LEAGUE_DIR);
		newLeague = JsonParser.parseLeague(LEAGUE_DIR);
		return newLeague;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newLeague;
	}
	
	/**
	 * Funzione che chiama le API per ottenere una stringa con formato JSON e deserializzarla in un oggetto di tipo <code>Scorers</code>
	 * @return JsonParser.parseScorers(SCORERS_DIR) Oggetto di tipo <code>Scorers</code> popolato dalle informazioni sulla Serie A
	 * @throws FileNotFoundException Se il file <code>SCORERS_DIR</code> non è nella directory
	 * @throws UnknownHostException Se la connessione alle API fallisce
	 */
	public static Scorers returnLeagueScorers() throws FileNotFoundException, UnknownHostException {
		Scorers scorers = new Scorers();
		try {
			String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/scorers?limit=100"); //SE AUMENTO IL LIMIT, NON FUNZIONA /scorersForPosition
			FileInputOutput.toFile(result, SCORERS_DIR);
			scorers =  JsonParser.parseScorers(SCORERS_DIR);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return scorers;
	}
	/**
	 * Funzione utilizzata per scaricare i due file "league.json" e "scorers.json" tramite le due richieste dei metodi <code>returnLeague()</code> e <code>returnLeagueScorers()</code>,
	 * per avere un Dataset su cui lavorare ad ogni avvio del programma
	 * @throws FileNotFoundException Se <code>SCORERS_DIR</code> o <code>LEAGUE_DIR</code> non sono nella directory
	 */
	@SuppressWarnings("unused")
	public static void doRequests() throws FileNotFoundException {
		try {
		League leagueFile = Requests.returnLeague();
		Scorers leagueScorers = Requests.returnLeagueScorers();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
