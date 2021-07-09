package it.univpm.demoSpringBootActivation.utilities;


import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.demoSpringBootActivation.model.*;
/**
 * Classe per effettuare il parsing dei file Json
 * @author Leonardo Mannini
 * @author Luca Ranucci
 *
 */
public class JsonParser {
	/**
	 * Metodo che a partire dal percorso di un file json ne ritorna un oggetto parsato League
	 * @param jsonObjPath Directory del file da parsare
	 * @return newLeague Oggetto parsato
	 * @throws IOException se accadono errori di I/O
	 */
	@JsonIgnoreProperties
	public static League parseLeague(String jsonObjPath) throws IOException{
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
	 * Metodo che a partire dal percorso di un file json ne ritorna un oggetto parsato Team
	 * @param jsonObjPath Directory del file da parsare
	 * @return newTeam Oggetto parsato
	 * @throws IOException se accadono errori di I/O
	 */
	@JsonIgnoreProperties
	public static Team parseTeam(String jsonObjPath) throws IOException{
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
	 * Metodo che a partire dal percorso di un file json ne ritorna un oggetto parsato Scorers
	 * @param jsonObjPath Directory del file da parsare
	 * @return Scorers Oggetto parsato
	 * @throws IOException se accadono errori di I/O
	 */
	@JsonIgnoreProperties
	public static Scorers parseScorers(String jsonObjPath) throws IOException{
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
