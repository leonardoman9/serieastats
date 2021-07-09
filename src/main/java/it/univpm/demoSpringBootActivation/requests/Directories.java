package it.univpm.demoSpringBootActivation.requests;
/**
 * Interfaccia utilizzata per salvare e condividere con tutte le altre classi
 * le directories su cui salvare i file json recuperati tramite le richieste alle API
 * 
 * 
 * @author Leonardo Mannini
 * @author Luca Ranucci
 */
public interface Directories {
	/**
	 * Percorso del file league.json
	 */
	String LEAGUE_DIR = "src/main/resources/data/league.json";
	/**
	 * Percorso del file scorers.json
	 */
	String SCORERS_DIR = "src/main/resources/data/scorers.json";
	/**
	 * Percorso dei file team(teamid).json
	 */
	String TEAM_DIR = "src/main/resources/data";
}