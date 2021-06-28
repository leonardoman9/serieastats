package it.univpm.demoSpringBootActivation.model;

public class League {
	private int year;
	private String nation;
	private String name;
	private String emblemUrl;
	private String winnerName;
	
	public League(int year, String nation, String name, String emblemUrl, String winnerName) {
		this.year = year;
		this.nation = nation;
		this.name = name;
		this.emblemUrl = emblemUrl;
		this.winnerName = winnerName;
	}
	public League() {
		// TODO Auto-generated constructor stub
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
	public String getWinnerName() {
		return winnerName;
	}
	public void setWinnerName(String winnerName) {
		this.winnerName = winnerName;
	}
}
