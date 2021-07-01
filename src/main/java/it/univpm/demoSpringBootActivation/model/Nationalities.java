package it.univpm.demoSpringBootActivation.model;

import java.util.HashSet;

public class Nationalities<String> extends HashSet<String>{
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
