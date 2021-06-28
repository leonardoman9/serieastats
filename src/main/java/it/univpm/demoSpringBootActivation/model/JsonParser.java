package it.univpm.demoSpringBootActivation.model;

import org.json.JSONObject;
public class JsonParser {
	
	public static Team parseTeam(String jsonObj) {
		JSONObject json = new JSONObject(jsonObj);
		Team newTeam = new Team(
				json.getString("name"),
				json.getString("shortName"),
				json.getString("tla"),
				json.getString("crestUrl"),
				json.getString("phone"),
				json.getString("website"),
				json.getString("email"),
				json.getString("address"),
				json.getInt("founded"),
				json.getString("clubColors"),
				json.getString("venue")
				);
		System.out.println(newTeam);
		return newTeam;
	}
	public static League parseLeague(String jsonObj) {
		JSONObject json = new JSONObject(
				json.getInt("id"),
				json.getString("name");
				json.getString("name");
				)
				
				
				
				
				
		
				);
		System.out.println(newLeague);
		return newLeague;
	}
}
