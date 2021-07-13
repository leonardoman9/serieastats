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
	 */
	public static League returnLeague()  {
		League  newLeague = new League();
		try {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/teams");	
		FileInputOutput.toFile(result, LEAGUE_DIR);
		newLeague = JsonParser.parseLeague(LEAGUE_DIR);
		return newLeague;
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Funzione che chiama le API per ottenere una stringa con formato JSON e deserializzarla in un oggetto di tipo <code>Scorers</code>
	 * @return JsonParser.parseScorers(SCORERS_DIR) Oggetto di tipo <code>Scorers</code> popolato dalle informazioni sulla Serie A

	 */
	public static Scorers returnLeagueScorers()  {
		Scorers scorers = new Scorers();
		try {
			String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/scorers?limit=285");
				FileInputOutput.toFile(result, SCORERS_DIR);
				scorers =  JsonParser.parseScorers(SCORERS_DIR);
			}catch (UnknownHostException e1) {
				e1.printStackTrace(); 
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return scorers;
	}
	/**
	 * Funzione utilizzata per scaricare i due file "league.json" e "scorers.json" tramite le due richieste dei metodi <code>returnLeague()</code> e <code>returnLeagueScorers()</code>,
	 * per avere un Dataset su cui lavorare ad ogni avvio del programmay
	 */
	@SuppressWarnings("unused")
	public static void doRequests() {
		League leagueFile = Requests.returnLeague();
		Scorers leagueScorers = Requests.returnLeagueScorers();
	}
}
