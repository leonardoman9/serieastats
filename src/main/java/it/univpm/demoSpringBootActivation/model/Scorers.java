package it.univpm.demoSpringBootActivation.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Classe che rappresenta tutti i marcatori di una competizione.
 * @author leonardomannini
 *
 */
public class Scorers {
	@JsonProperty("count")
	private int count;
	@JsonProperty("competition")
	private Competition competition;
	@JsonProperty("season")
	private League league;
	@JsonProperty("scorers")
	private ArrayList<Scorer> scorers;
	public Scorers() {
		
	}
	public Scorers(int count, Competition competition, League league, ArrayList<Scorer> scorers) {
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
	public ArrayList<Scorer> getScorers() {
		return scorers;
	}
	public void setScorers(ArrayList<Scorer> scorers) {
		this.scorers = scorers;
	}
	public String toString() {
		String result = "";
		for (Scorer i : scorers) {
			result+= i.getPlayer().getName() + ": " + i.getNumberOfGoals() + " goals" + " (" + i.getTeam().getlongName()+")\n";
		}
		return result;
	}
	/**
	 * Funzione che popola un HashSet Nationalities per rappresentare tutti i diversi possibili di nazionalità,
	 * per poi stamparli senza ripetizioni
	 * @return
	 */
	public String countNationalities() {
		Nationalities<String> Nationalities = new Nationalities<String>();
		for(Scorer s : scorers) {
			Nationalities.add(s.getPlayer().getNationality());
		}
		return  Nationalities.toString();
	}
}

