package it.univpm.demoSpringBootActivation.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class UrlConnection {
	String url;
	HttpURLConnection con;
	public UrlConnection(String url) {
		try {
			URL Url = new URL(url);
			this.con = (HttpURLConnection) Url.openConnection();
					con.setRequestProperty("X-Auth-Token", "85f94a3f96e1441aa9702acaeea4e1df");
					con.setRequestMethod("GET");
			//int status = con.getResponseCode();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}