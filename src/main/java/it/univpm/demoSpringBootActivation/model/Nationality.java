package it.univpm.demoSpringBootActivation.model;
/**
 * Classe che rappresenta il concetto di Nazionalità
 * @author leonardomannini
 *
 */
public class Nationality {
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
