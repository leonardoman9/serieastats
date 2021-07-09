package it.univpm.demoSpringBootActivation.utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Classe per gestire la connessione ed effettuare l'autenticazione nelle API
 * @author leonardomannini
 *
 */
public class UrlConnection {
	/**
	 * URL dove effettuare la richiesta
	 */
	String url;
	/**
	 * @see HttpURLConnection
	 */
	HttpURLConnection con;
	/**
	 * Costruttore della classe
	 * @param url Url a cui effettuare la richiesta
	 */
	public UrlConnection(String url) {
		try {
			URL Url = new URL(url);
			this.con = (HttpURLConnection) Url.openConnection();
					con.setRequestProperty("X-Auth-Token", "85f94a3f96e1441aa9702acaeea4e1df");
					con.setRequestMethod("GET");
		} catch (MalformedURLException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (IllegalStateException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (ProtocolException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
