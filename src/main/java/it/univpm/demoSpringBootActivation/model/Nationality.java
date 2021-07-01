package it.univpm.demoSpringBootActivation.model;
public class Nationality {
	private String nationalityName;

	public Nationality(String nationalityName) {
		super();
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
