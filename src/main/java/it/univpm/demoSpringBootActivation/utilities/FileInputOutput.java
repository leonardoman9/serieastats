package it.univpm.demoSpringBootActivation.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileInputOutput {
	public static void toFile(String string, String fileName) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		writer.write(string);
		writer.close();
	}
	public static String toString(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		 String line="{";
		 while(reader.read()!=-1) {
			 String c = reader.readLine();
			 line+=c;
		 }
		 reader.close();
		 return line;
	}
}
