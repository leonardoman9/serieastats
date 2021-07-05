package it.univpm.demoSpringBootActivation.model;

import java.util.HashSet;

@SuppressWarnings({ "hiding", "serial" })
/**
 * Classe estensione di HashSet che rappresenta in un insieme i diversi Stadi.
 * @author leonardomannini
 *
 * @param <String>
 */
public class Venues<String> extends HashSet<String>{
	
	public int numberOfVenues() {
		return this.size();
	}
	public java.lang.String toString() {
		java.lang.String result="";
		for (String i : this) {
			result+=(i+"\n");
		}
		return "There are "+ numberOfVenues() +" different venues: "+ "\n" + result;
	}
}
