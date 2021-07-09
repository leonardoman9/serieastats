package it.univpm.demoSpringBootActivation.exceptions;
/**
 * Eccezione lanciata nel caso in cui l'utente faccia una richiesta contenente una nazionalità inesistente
 * o di cui non ne fa parte alcun marcatore.
 * @author Luca Ranucci
 * @author Leonardo Mannini
 */
public class NoNationalityException extends Exception {
	/**
	 * Identificatore univoco dell'eccezione
	 * @see Exception#serialVersionUID
	 */
	private static final long serialVersionUID = -9204615679004044262L;
	/**
	 * Construttore per la classe NoNationalityException
	 */
	public NoNationalityException() {
		System.out.println("No Nationality for this Player.");
	}
	/**
	 * Un altro costruttore per la classe NoNationalityException
	 * @param e Eccezione generata
	 */
	public NoNationalityException(Exception e) {
		System.out.println(e);
	}
}
