package it.univpm.demoSpringBootActivation.utilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
/**
 * Classe con un metodo statico per effettuare il download del dataset
 * @author Leonardo Mannini
 * @author Luca Ranucci
 *
 */
public class Dataset {
	/**
	 * Funzione che, dato un URL di richiesta alle API, restituisce la risposta in una stringa
	 * @param url	Una stringa contenente URL a cui effettuare la richiestsa
	 * @return json	Stringa json contenente la risposta
	 * @throws UnknownHostException In caso di errore di connessione all'URL
	 * @throws IOException In caso di errori di I/O
	 */
	static public String download(String url) throws UnknownHostException, IOException{
		try {
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
		catch (IOException e) {
			System.out.println("Error: Invalid url");
			e.printStackTrace();
			return e.toString();
		}
	}
}
