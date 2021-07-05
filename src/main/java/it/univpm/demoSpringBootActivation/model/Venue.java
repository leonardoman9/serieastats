package it.univpm.demoSpringBootActivation.model;
/**
 * Classe che rappresenta uno Stadio
 * @author leonardomannini
 *
 */
public class Venue {
	private String venueName;

	public Venue(String venueName) {
		super();
		this.venueName = venueName;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
}
