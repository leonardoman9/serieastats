package it.univpm.demoSpringBootActivation.model;

import org.json.JSONObject;

import com.google.gson.Gson;

public class JsonParser {
	JSONObject jsonObject;
	public JsonParser(String json) {
		this.jsonObject = new JSONObject(json);
		System.out.println(this.jsonObject);
	}
}
