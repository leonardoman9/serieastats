package it.univpm.demoSpringBootActivation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class League {
	@JsonProperty("count")
	private int count = 0;
	/*private int year;
	private String country;
	private String name;
	private int currMatchDay;
	private Season season;*/
	@JsonProperty("teams")
	private Team[] Teams;
	public League() {
	}
	@Override
	public String toString() {
		String result = "";
		result+=count;
		result+="\n";
		for(Team i : Teams) {
			System.out.println(i.toString());
			System.out.println("\n");
		}
		return result;
	}
	
}
