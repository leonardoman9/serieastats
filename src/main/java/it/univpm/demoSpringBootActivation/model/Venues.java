package it.univpm.demoSpringBootActivation.model;

import java.util.HashSet;

@SuppressWarnings({ "hiding", "serial" })
public class Venues<String> extends HashSet<String>{
	public int numberOfVenues() {
		return this.size();
	}
	public java.lang.String toString() {
		java.lang.String result="";
		for (String i : this) {
			result+=(i+"\n");
			
		}
		return result;
	}
}
