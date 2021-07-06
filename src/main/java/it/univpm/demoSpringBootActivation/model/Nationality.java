package it.univpm.demoSpringBootActivation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe che rappresenta il concetto di Nazionalità
 * @author leonardomannini
 *
 */
public class Nationality {
	@JsonProperty("nationality")
	private String nationalityName;
	public Nationality(String nationalityName) {
		this.nationalityName = nationalityName;
	}

	public String getNationalityName() {
		return this.nationalityName;
	}

	public void setNationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
	}
	public String toString()  {
			return this.nationalityName;	
	}
}
