package it.univpm.demoSpringBootActivation.model;

public class Season {
	private String startDate;
	private String endDate;
	private int currentMatchday;
	private WinnerTeam winner;
	
	public Season() {}
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
	public int getCurrentMatchday() {
		return currentMatchday;
	}
	public void setCurrentMatchday(int currentMatchday) {
		this.currentMatchday = currentMatchday;
	}
	public WinnerTeam getWinner() {
		return winner;
	}
	public void setWinner(WinnerTeam winner) {
		this.winner = winner;
	}
	public Season(String startDate, String endDate, int currentMatchday, WinnerTeam winner) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.currentMatchday = currentMatchday;
		this.winner = winner;
	}
	
}
