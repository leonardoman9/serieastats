package it.univpm.demoSpringBootActivation.utilities;


import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.demoSpringBootActivation.model.*;
public class JsonParser {
	/**
	 * 
	 * @param jsonObj
	 * @return
	 * @throws IOException 
	 */
	@JsonIgnoreProperties
	public static League parseLeague(String jsonObjPath) throws IOException {
		String jsonObj = FileInputOutput.toString(jsonObjPath);
		League newLeague = new League();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		newLeague = objectMapper.readValue(jsonObj, League.class); 
		return newLeague;
	}
	

	/**
	 * Funzione che effettua la deserializzazione, da una stringa (json) ad un oggetto
	 * @param jsonObj
	 * @return
	 * @throws IOException 
	 */
	@JsonIgnoreProperties
	public static Team parseTeam(String jsonObjPath) throws IOException {
		// JSONObject json = new JSONObject(jsonObj);
		String jsonObj = FileInputOutput.toString(jsonObjPath);
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
	 * @throws IOException 
	 */
	@JsonIgnoreProperties
	public static Scorers parseScorers(String jsonObjPath) throws IOException {
		String jsonObj = FileInputOutput.toString(jsonObjPath);
		Scorers scorers = new Scorers();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		scorers = objectMapper.readValue(jsonObj, Scorers.class);
		return scorers;
		
	}
	
}
