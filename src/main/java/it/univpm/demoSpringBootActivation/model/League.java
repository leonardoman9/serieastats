package it.univpm.demoSpringBootActivation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class League {
	@JsonProperty("count")
	private int count = 0;
	@JsonProperty("competition")
	private Competition competition;
	@JsonProperty("season")
	private Season season;
	@JsonProperty("teams")
	private Team[] Teams;
	public League() {
	}
	@Override
	public String toString() {
		String result = "";
		result = "Number of Teams: " + count + "\n" +
				"Competition Area: " + this.competition.getArea().getName() + "\n" +
				"Competition Name: " + this.competition.getName() + "\n" + 
				"Competition Code: " + this.competition.getCode() + "\n" +
				"Competition grade: " + this.competition.getCode() + "\n" + 
				"Start date: " + this.season.getStartDate() + "\n" +
				"End date: " + this.season.getEndDate() + "\n" +
				"Winner: " + this.season.getWinner().getName() + "\n" + 
				this.season.getWinner().toString() + "\n";
		
		for(Team i : Teams) {
			System.out.println(i.toString());
			System.out.println("\n");
		}
		return result;
	}
	
}
