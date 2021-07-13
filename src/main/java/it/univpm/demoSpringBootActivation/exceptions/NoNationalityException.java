package it.univpm.demoSpringBootActivation.exceptions;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Eccezione lanciata nel caso in cui l'utente faccia una richiesta contenente una nazionalità inesistente.
 * @author Luca Ranucci
 * @author Leonardo Mannini
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="The searched nationality is wrong.")
public class NoNationalityException extends IOException {
	/**
	 * Identificatore univoco dell'eccezione
	 * @see Exception#serialVersionUID
	 */
	private static final long serialVersionUID = -9204615679004044262L;
	/**
	 * Construttore per la classe NoNationalityException
	 */
	public NoNationalityException() {
		super();
	}
	/**
	 * Un altro costruttore per la classe NoNationalityException
	 * @param e Eccezione generata
	 */
	public NoNationalityException(String msg) {
		super(msg + " is not a nationality");
	}
}