package it.univpm.demoSpringBootActivation.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class Dataset {
	static public void download(String url) throws IOException {
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
		JsonParser Parse = new JsonParser(json);
	}
}
