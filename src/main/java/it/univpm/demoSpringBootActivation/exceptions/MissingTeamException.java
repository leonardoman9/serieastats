package it.univpm.demoSpringBootActivation.exceptions;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 *  Eccezione per gestire l'assenza di una squadra ricercata o l'errato inserimento del nome di una squadra
*/
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="There is no team with that name") 
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
