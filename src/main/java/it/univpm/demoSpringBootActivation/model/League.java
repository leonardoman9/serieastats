package it.univpm.demoSpringBootActivation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class League extends Competition{
	@JsonProperty("count")
	private int count = 0;
	@JsonProperty("competition")
	private Competition competition;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Competition getCompetition() {
		return competition;
	}
	public void setCompetition(Competition competition) {
		this.competition = competition;
	}
	public Season getSeason() {
		return season;
	}
	public void setSeason(Season season) {
		this.season = season;
	}
	public Team[] getTeams() {
		return Teams;
	}
	public void setTeams(Team[] teams) {
		Teams = teams;
	}
	@JsonProperty("season")
	private Season season;
	@JsonProperty("teams")
	private Team[] Teams;
	public League() {
	}
	@Override
	public String toString() {
		String result = "";
		result = "Number of Teams: \t" + count + "\n" +
				"Competition Area: \t " + this.competition.getArea().getName() + "\n" +
				"Competition Name: \t" + this.competition.getName() + "\n" + 
				"Competition Code: \t" + this.competition.getCode() + "\n" +
				"Competition Plan: \t" + this.competition.getPlan() + "\n" + 
				"Start date: \t\t" + this.season.getStartDate() + "\n" +
				"End date: \t\t" + this.season.getEndDate() + "\n" +
				"Winner: \t\t" + this.season.getWinner().getlongName() + "\n" + 
				"TLA: \t\t\t" + this.season.getWinner().getTla() + "\n" +
				"Crest Url: \t\t" + this.season.getWinner().getCrestUrl() + "\n";
		for(Team i : Teams) {
			System.out.println(i.toString());
			System.out.println("\n");
		}
		return result;
	}
	public String toStringNoTeams() {
		String result = "";
		result = "Number of Teams: \t" + count + "\n" +
				"Competition Area: \t" + this.competition.getArea().getName() + "\n" +
				"Competition Name: \t" + this.competition.getName() + "\n" + 
				"Competition Code: \t" + this.competition.getCode() + "\n" +
				"Competition Plan: \t" + this.competition.getPlan() + "\n" + 
				"Start date: \t" + this.season.getStartDate() + "\n" +
				"End date: \t" + this.season.getEndDate() + "\n" +
				"Winner: \t" + this.season.getWinner().getlongName() + "\n" + 
				"TLA: \t" + this.season.getWinner().getTla() + "\n" +
				"Crest Url: \t" + this.season.getWinner().getCrestUrl() + "\n";
		return result;
	}
	
	public int lookForId(String shortName) {
		for(Team t : Teams) {
			if(t.getShortName().equals(shortName)) return t.getteamId();
		}
		return -1;
	}
	public String countVenues() {
		Venues<String> Venues = new Venues<String>();
		for(Team t : this.Teams) {
			Venues.add(t.getVenue());
		}
		return  Venues.toString();
	}
	
	
}
