package it.univpm.demoSpringBootActivation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Scorers {
	@JsonProperty("count")
	private int count;
	@JsonProperty("competition")
	private Competition competition;
	@JsonProperty("season")
	private League league;
	@JsonProperty("scorers")
	private Scorer[] scorers;
	public Scorers() {
		
	}
	public Scorers(int count, Competition competition, League league, Scorer[] scorers) {
		super();
		this.count = count;
		this.competition = competition;
		this.league = league;
		this.scorers = scorers;
	}
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
	public League getLeague() {
		return league;
	}
	public void setLeague(League league) {
		this.league = league;
	}
	public Scorer[] getScorers() {
		return scorers;
	}
	public void setScorers(Scorer[] scorers) {
		this.scorers = scorers;
	}
	public String toString() {
		String result = "";
		for (Scorer i : scorers) {
			result+= i.getPlayer().getName() + ": " + i.getNumberOfGoals() + " goals" + " (" + i.getTeam().getlongName()+")\n";
		}
		return result;
	}
}
