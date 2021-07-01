package it.univpm.demoSpringBootActivation.exceptions;

public class NoNationalityException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9204615679004044262L;
	public NoNationalityException() {
		System.out.println("No Nationality for this Player.");
	}
	public NoNationalityException(Exception e) {
		System.out.println(e);
	}
}
