package it.univpm.demoSpringBootActivation.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONObject;
public class Dataset {
	static public String download(String url) throws IOException {
		UrlConnection urlc = new UrlConnection(url);
		BufferedReader in = new BufferedReader(new InputStreamReader(urlc.con.getInputStream()));
				String line = in.readLine();
				String json = "";
				while (line != null) {
				    json+=line;
				    json+="\n";
				    line = in.readLine();
				}
		in.close();
		urlc.con.disconnect();
		return json;
	}
}
