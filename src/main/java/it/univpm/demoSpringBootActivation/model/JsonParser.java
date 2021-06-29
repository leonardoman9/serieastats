package it.univpm.demoSpringBootActivation.model;

import java.awt.Event;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
		return newTeam;
	}
	
	@JsonIgnoreProperties
	public static League parseLeague(String jsonObj) throws JsonMappingException, JsonProcessingException {
		// JSONObject json = new JSONObject(jsonObj);
		League newLeague = new League();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		newLeague = objectMapper.readValue(jsonObj, League.class);
		System.out.println(newLeague.toString());
		return newLeague;
	}
}
