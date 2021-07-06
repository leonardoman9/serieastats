package it.univpm.demoSpringBootActivation.utilities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.demoSpringBootActivation.model.*;
public class JsonParser {

	

	/**
	 * Funzione che effettua la deserializzazione, da una stringa (json) ad un oggetto
	 * @param jsonObj
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@JsonIgnoreProperties
	public static Team parseTeam(String jsonObj) throws JsonMappingException, JsonProcessingException {
		// JSONObject json = new JSONObject(jsonObj);
		Team newTeam = new Team();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		newTeam = objectMapper.readValue(jsonObj, Team.class);
		return newTeam;
	}
	/**
	 * 
	 * @param jsonObj
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@JsonIgnoreProperties
	public static League parseLeague(String jsonObj) throws JsonMappingException, JsonProcessingException {
		// JSONObject json = new JSONObject(jsonObj);
		League newLeague = new League();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		newLeague = objectMapper.readValue(jsonObj, League.class);
		return newLeague;
	}
	/**
	 * 
	 * @param jsonObj
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@JsonIgnoreProperties
	public static Scorers parseScorers(String jsonObj) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Scorers scorers = objectMapper.readValue(jsonObj, Scorers.class);
		return scorers;
		
	}
	
}
