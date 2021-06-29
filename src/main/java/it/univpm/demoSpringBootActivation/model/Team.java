package it.univpm.demoSpringBootActivation.model;

public class Team {
	private String teamName;
	private String shortName;
	private String tla;
	private String crestUrl;
	private String phone;
	private String website;
	private String email;
	private String address;
	private int founded;
	private String clubColors;
	private String venue;	

public Team(String teamName, String shortName, String tla, String crestUrl, String phone, String website,
			String email, String address, int founded, String clubColors, String venue) {
		super();
		this.teamName = teamName;
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
	
	public String toString() {
		String result;
		result = "Team Name = " + this.getTeamName() + "\n" +
				"Short Name = " + this.getShortName() + "\n" +
				"Tla = " + this.getTla() + "\n" +
				"CrestUrl = " + this.getCrestUrl() + "\n" +
				"Phone = " + this.getPhone() + "\n" +
				"Website = " + this.getWebsite() + "\n" +
				"Email = " + this.getEmail() + "\n" +
				"Address = " + this.getAddress() + "\n" +
				"Founded = " + (this.getFounded()) + "\n" +
				"Club Colours = " + this.getClubColors() + "\n" +
				"Venue = " + this.getVenue();
		return result;
				
		
	}
}
