package it.univpm.demoSpringBootActivation.model;

public class Team {
	private String teamName;
	private String shortName;
	private String tla;
	private String crestUrl;
	private String address;
	private int founded;
	private String venue;

	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getTla() {
		return tla;
	}
	public void setTla(String tla) {
		this.tla = tla;
	}
	public String getCrestUrl() {
		return crestUrl;
	}
	public void setCrestUrl(String crestUrl) {
		this.crestUrl = crestUrl;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getFounded() {
		return founded;
	}
	public void setFounded(int founded) {
		this.founded = founded;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
}
