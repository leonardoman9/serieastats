package it.univpm.demoSpringBootActivation.model;

import org.json.JSONObject;

import com.google.gson.Gson;

public class JsonParser {
	public static void JsonParser(String json) {
		// parsing into a Java Object
		League serieA = new Gson().fromJson(json, League.class);
		System.out.println(serieA.getTeams());
	}
}
