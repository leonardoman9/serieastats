package it.univpm.demoSpringBootActivation.exceptions;

import java.io.IOException;

public class MissingTeamException extends IOException{
	private static final long serialVersionUID = 1L;
	public MissingTeamException(){
		super();
	}
	public MissingTeamException(String msg){
		super(msg + " does not exist.");
	}
}
