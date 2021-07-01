package it.univpm.demoSpringBootActivation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {
	@JsonProperty("id")
	private int teamId;
	@JsonProperty("name")
	private String longName;
	@JsonProperty("shortName")
	private String shortName;
	@JsonProperty("tla")
	private String tla;
	@JsonProperty("crestUrl")
	private String crestUrl;
	@JsonProperty("phone")
	private String phone;
	@JsonProperty("website")
	private String website;
	@JsonProperty("email")
	private String email;
	@JsonProperty("address")
	private String address;
	@JsonProperty("founded")
	private int founded;
	@JsonProperty("clubColors")
	private String clubColors;
	@JsonProperty("venue")
	private String venue;	
public Team(int teamId, 
			String longName, 
			String shortName, 
			String tla, 
			String crestUrl, 
			String phone, 
			String website,
			String email, 
			String address, 
			int founded, 
			String clubColors, 
			String venue) {
		super();
		this.teamId = teamId;
		this.longName = longName;
		this.shortName = shortName;
		this.tla = tla;
		this.crestUrl = crestUrl;
		this.phone = phone;
		this.website = website;
		this.email = email;
		this.address = address;
		this.founded = founded;
		this.clubColors = clubColors;
		this.venue = venue;
	}


	public Team() {
		// TODO Auto-generated constructor stub
	}

	public int getteamId() {
		return teamId;
	}


	public void setId(int teamId) {
		this.teamId = teamId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClubColors() {
		return clubColors;
	}
	
	public void setClubColors(String clubColors) {
		this.clubColors = clubColors;
	}

	
	public String getlongName() {
		return longName;
	}
	public void setlongName(String longName) {
		this.longName = longName;
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
	
	public String toString() {
		String result;
		result = "Teamid: \t"+this.getteamId()+"\n"+
				"Team Name: \t" + this.getlongName() + "\n" +
				"Short Name: \t" + this.getShortName() + "\n" +
				"Abbreviation: \t" + this.getTla() + "\n" +
				"CrestUrl: \t" + this.getCrestUrl() + "\n" +
				"Phone: \t\t" + this.getPhone() + "\n" +
				"Website: \t" + this.getWebsite() + "\n" +
				"Email: \t\t" + this.getEmail() + "\n" +
				"Address: \t" + this.getAddress() + "\n" +
				"Founded: \t" + (this.getFounded()) + "\n" +
				"Club Colours: \t" + this.getClubColors() + "\n" +
				"Venue: \t\t" + this.getVenue();
		return result;	
	}
}
