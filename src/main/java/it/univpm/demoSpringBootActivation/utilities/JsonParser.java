package it.univpm.demoSpringBootActivation.utilities;


import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
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
	public static League parseLeague(String jsonObjPath) {
		String jsonObj = FileInputOutput.toString(jsonObjPath);
		League newLeague = new League();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			newLeague = objectMapper.readValue(jsonObj, League.class);
		} catch (JsonProcessingException e) {
			System.out.println("Error while mapping the json file to a League object\n");
			e.printStackTrace();
		} 
		return newLeague;
	}
	

	/**
	 * Funzione che effettua la deserializzazione, da una stringa (json) ad un oggetto
	 * @param jsonObj
	 * @return
	 * @throws IOException 
	 */
	@JsonIgnoreProperties
	public static Team parseTeam(String jsonObjPath) {
		// JSONObject json = new JSONObject(jsonObj);
		String jsonObj = FileInputOutput.toString(jsonObjPath);
		Team newTeam = new Team();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			newTeam = objectMapper.readValue(jsonObj, Team.class);
		} catch (JsonProcessingException e) {
			System.out.println("Error while mapping the json file to a Team object\n");
			e.printStackTrace();
		}
		return newTeam;
	}

	/**
	 * 
	 * @param jsonObj
	 * @return
	 * @throws IOException 
	 */
	@JsonIgnoreProperties
	public static Scorers parseScorers(String jsonObjPath) {
		String jsonObj = FileInputOutput.toString(jsonObjPath);
		Scorers scorers = new Scorers();
		try {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		scorers = objectMapper.readValue(jsonObj, Scorers.class);
		} catch (JsonProcessingException e) {
			System.out.println("Error while mapping the json file to a Scorers object\n");
			e.printStackTrace();
		}
		return scorers;
	}
	
}
