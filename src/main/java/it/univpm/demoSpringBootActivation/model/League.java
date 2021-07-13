package it.univpm.demoSpringBootActivation.model;

import java.util.HashSet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Caso particolare della classe Competizione, 
 * ovvero classe che rappresenta una Competizione di tipo Campionato (League)
 * @author leonardomannini
 *
 */
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
	private HashSet<String> Venues = new HashSet<String>();
	public League() {
	}
	/**
	 * Funzione che stampa in modo ordinato informazioni riguardanti il campionato di Serie A.
	 */
	public String toStringTeams() {
		String result = "";
		/**
		 * Stampa informazioni per ogni Squadra del campionato
		 */
		for(Team i : Teams) {
			result+=i.toString()+"\n";
		}
		result+="\n";
		return result;
	}
	public String toStringHeader() {
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
		return result;
	}
	public String toStringHeaderAndTeams() {
		String result="";
		result += this.toStringHeader()+"\n" + this.toStringTeams();
		return result;
	}
	/**
	 * Funzione che, a partire dal nome della squadra, restituisce il corrispondente ID.
	 * @param shortName Nome abbrevviato della squadra per effettuare la ricerca.
	 * @return teamId se la ricerca è andata a buon fine, -1 altrimenti
	 */
	public int lookForId(String shortName) {
		for(Team t : Teams) {
			if(t.getShortName().equals(shortName)) return t.getteamId();
		}
		return -1;
	}
	/**
	 * Funzione che stampa gli stadi del campionato, utilizzata nella statistica riguardante gli stadi.
	 * @return Stringa composta dagli stadi in sequenza ordinata.
	 */
	public String toStringVenues() {
		String result = "Venues: \n";
		for(Team t : this.Teams) {
			Venues.add(t.getVenue());
		}
		for(String t: Venues) {
			result+=t+"\n";
		}
		result+="Total: " + countVenues() + " venues.\n";
		return  result;
	}
	
	public int countVenues() {
		for(Team t : this.Teams) {
			Venues.add(t.getVenue());
		}
		return Venues.size();
	}
	
	

	
}
