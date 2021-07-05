package it.univpm.demoSpringBootActivation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Oggetto utile per rappresentare le informazioni di una competizioni, 
 * contenente informazioni riguardo la zona dove si svolge la competizione, e l'id di quella zona
 * @author leonardomannini
 *
 */
public class Area {
	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;
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
}
