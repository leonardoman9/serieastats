package it.univpm.demoSpringBootActivation.exceptions;
/**
 * Eccezione lanciata nel caso in cui l'utente faccia una richiesta contenente il nome di una squadra
 * che non esiste.
 * @author Luca Ranucci
 * @author Leonardo Mannini
 */
public class MissingTeamException extends Exception{
	/**
	 * Identificatore univoco dell'eccezione
	 * @see Exception#serialVersionUID
	 */
	private static final long serialVersionUID = 4031604253338173880L;
	/**
	 * Construttore della classe MissingTeamException
	 */
	public MissingTeamException(){
		super();
	}
	/**
	 * Un altro construttore della classe MissingTeamException
	 * @param msg Squadra inesistente
	 */
	public MissingTeamException(String msg){
		super(msg + " does not exist.");
	}
}
