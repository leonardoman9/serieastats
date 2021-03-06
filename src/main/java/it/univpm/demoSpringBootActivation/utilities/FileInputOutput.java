package it.univpm.demoSpringBootActivation.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe per gesire la lettura/scrittura di file json
 * @author leonardomannini
 *
 */
public class FileInputOutput {
	/**
	 * Metodo per salvare una stringa in un file
	 * @param string Stringa da salvare
	 * @param fileName Percorso dove salvare il file
	 * @throws FileNotFoundException se il file nel percorso indicato non esiste
	 */
	public static void toFile(String string, String fileName) throws FileNotFoundException{
	try {
		BufferedWriter writer;
			writer = new BufferedWriter(new FileWriter(fileName));
			writer.write(string);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Metodo per memorizzare in una stringa il contenuto di un file di testo
	 * @param fileName Directory del file da leggere
	 * @return line Stringa contenente il file letto
	 */
	public static String toString(String fileName)  {
		BufferedReader reader;
		String line="{";
		try {
			reader = new BufferedReader(new FileReader(fileName));
		 while(reader.read()!=-1) {
			 String c = reader.readLine();
			 line+=c;
			 
		 }
		 reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + fileName + " path not found.\n");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error while reading file " + fileName);
			e.printStackTrace();
		}
		 return line;
	}
}