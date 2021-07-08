package it.univpm.demoSpringBootActivation.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileInputOutput {
	public static void toFile(String string, String fileName) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
		
		writer.write(string);
		writer.close();
		} catch (IOException e) {
			System.out.println("Error while writing into file " + fileName);
			e.printStackTrace();
		}
	}
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
