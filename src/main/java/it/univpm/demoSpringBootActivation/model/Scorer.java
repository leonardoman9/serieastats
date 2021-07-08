package it.univpm.demoSpringBootActivation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Classe che estende Player e rappresenta i marcatori.
 * @author leonardomannini
 *
 */
public class Scorer extends Player{
	
	private int numberOfGoals;

	@JsonProperty("player")
	private Player player;
	@JsonProperty("team")
	private Team team;
	
	public Scorer () {
		super();
	}
	public Scorer(Player player, Team team, int numberOfGoals) {
		super();
		this.player = player;
		this.team = team;
		this.numberOfGoals = numberOfGoals;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public int getNumberOfGoals() {
		return numberOfGoals;
	}
	public void setNumberOfGoals(int numberOfGoals) {
		this.numberOfGoals = numberOfGoals;
	}
	
	public String toString() {
		String result="";
		result += "Number of Goals: " + this.numberOfGoals + "\n";
		return result;
	}
}
