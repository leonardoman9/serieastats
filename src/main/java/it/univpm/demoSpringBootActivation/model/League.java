package it.univpm.demoSpringBootActivation.model;

public class League {
	private int year;
	private String nation;
	private String name;
	private String emblemUrl;
	private Team winner;
	public League(int year, String nation, String name, String emblemUrl, Team winner) {
		this.year = year;
		this.nation = nation;
		this.name = name;
		this.emblemUrl = emblemUrl;
		this.winner = winner;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmblemUrl() {
		return emblemUrl;
	}
	public void setEmblemUrl(String emblemUrl) {
		this.emblemUrl = emblemUrl;
	}
	public Team getWinner() {
		return winner;
	}
	public void setWinner(Team winner) {
		this.winner = winner;
	}
}
