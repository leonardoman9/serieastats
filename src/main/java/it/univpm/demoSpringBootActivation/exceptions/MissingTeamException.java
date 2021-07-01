package it.univpm.demoSpringBootActivation.exceptions;

public class MissingTeamException extends Exception{
	private static final long serialVersionUID = 1L;
	public MissingTeamException(){
		super();
	}
	public MissingTeamException(String msg){
		super(msg + " does not exist.");
	}
}
