package it.univpm.demoSpringBootActivation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Oggetto che rappresenta una Competizione, nel modo più generico possibile (Campionati, Coppe, ...)
 * @author leonardomannini
 *
 */
public class Competition {
	@JsonProperty("count")
	private int id;
	@JsonProperty("area")
	private Area area;
	@JsonProperty("name")
	private String name;
	@JsonProperty("code")
	private String code;
	@JsonProperty("plan")
	private String plan;
	@JsonProperty("lastUpdated")
	private String lastUpdated;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}
