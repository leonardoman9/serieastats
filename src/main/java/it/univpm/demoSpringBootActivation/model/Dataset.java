package it.univpm.demoSpringBootActivation.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class Dataset {
	static public void download() throws IOException {
		URL url = new URL("http://api.football-data.org/v2/competitions/SA/teams");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("X-Auth-Token", "85f94a3f96e1441aa9702acaeea4e1df");
		con.setRequestMethod("GET");
		int status = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String line = in.readLine();
				String json = "";
				while (line != null) {
				    json+=line;
				    json+="\n";
				    line = in.readLine();
				}
		in.close();
		con.disconnect();
		System.out.println(json);
		JsonParser.JsonParser(json);
	}
}
