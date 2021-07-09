package it.univpm.demoSpringBootActivation.exceptions;
import java.io.IOException;
/**
 *  Eccezione per gestire l'assenza di una squadra ricercata o l'errato inserimento del nome di una squadra
*/
public class MissingTeamException extends IOException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Costruttore della classe MissingTeamException
	 */
	public MissingTeamException(){
		super();
	}
	/**
	 * Un altro costruttore della classe MissingTeamException
	 * @param msg Messaggio da visualizzare
	 */
	public MissingTeamException(String msg){
		super(msg + " does not exist.");
	}
}
