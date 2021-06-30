package it.univpm.demoSpringBootActivation.exceptions;

public class MissingTeamException extends Exception{
	public MissingTeamException(){
		super();
	}
	public MissingTeamException(String msg){
		super(msg);
	}
}
