package it.univpm.demoSpringBootActivation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Classe che rappresenta un giocatore.
 * @author leonardomannini
 *
 */
public class Player {
	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("dateOfBirth")
	private String dateOfBirth;
	@JsonProperty("nationality")
	private String nationality;
	@JsonProperty("position")
	private String position;
	@JsonProperty("shirtNumber")
	private String shirtNumber;
	@JsonProperty("lastUpdated")
	private String lastUpdated;
	public Player() {
		
	}
	public Player(int id, String name, String firstName, String lastName, String dateOfBirth, String nationality,
			String position, String shirtNumber, String lastUpdated) {
		super();
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
		this.position = position;
		this.shirtNumber = shirtNumber;
		this.lastUpdated = lastUpdated;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getShirtNumber() {
		return shirtNumber;
	}
	public void setShirtNumber(String shirtNumber) {
		this.shirtNumber = shirtNumber;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String toString() {
		String result="";
		result += "Full Name: " + this.getName() + "\n" +
				   "Date Of Birth: " + this.getDateOfBirth() + "\n"+
				   "Nationality: " + this.getNationality() + "\n" +
				   "Position: " + this.getPosition() + "\n";
		return result;
	}
	
}
