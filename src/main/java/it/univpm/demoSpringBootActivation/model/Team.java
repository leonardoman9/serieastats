package it.univpm.demoSpringBootActivation.model;

public class Team {
	private int teamId;
	private String name;
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

public Team(int teamId, String name, String shortName, String tla, String crestUrl, String phone, String website,
			String email, String address, int founded, String clubColors, String venue) {
		super();
		this.teamId = teamId;
		this.name = name;
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

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
				"Team Name: \t" + this.getName() + "\n" +
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
