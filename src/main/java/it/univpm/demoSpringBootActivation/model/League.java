package it.univpm.demoSpringBootActivation.model;

public class League {
	private int numSquadre;
	private String areaName;
	private String leagueName;
	private String startDate;
	private String endDate;
	private Team[] teams;
	
	public League(int numSquadre,
				  String areaName,
				  String leagueName,
				  String startDate,
				  String endDate,
				  Team[] teams) {
		this.areaName=areaName;
		this.leagueName=leagueName;
		this.startDate=startDate;
		this.endDate=endDate;
		this.teams=teams;
	}
	public int getNumSquadre() {
		return numSquadre;
	}
	public void setNumSquadre(int numSquadre) {
		this.numSquadre = numSquadre;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Team[] getTeams() {
		return teams;
	}
	public void setTeams(Team[] teams) {
		this.teams = teams;
	}
}
