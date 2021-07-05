package it.univpm.demoSpringBootActivation.model;

import java.util.HashSet;
/**
 * Classe estensione di HashSet che rappresenta in un insieme le diverse nazionalità
 * @author leonardomannini
 *
 * @param <String>
 */
public class Nationalities<String> extends HashSet<String>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2145839179631061856L;
	private Nationality[] nationalities;
		
		public int numberOfNationalities() {
			return this.size();
		}
		public java.lang.String toString() {
			java.lang.String result="";
			for (String i : this) {
				result+=(i+"\n");
				
			}
			return "There are "+ numberOfNationalities()+" different nationalities: "+ "\n" + result;
		}
}
