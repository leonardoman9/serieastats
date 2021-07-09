package it.univpm.demoSpringBootActivation.utilities;

import it.univpm.demoSpringBootActivation.model.*;
/**
 * Classe per deserializzare una stringa contenente una data
 * @see DateOfBirth
 *
 */
public class AgeCalculator {
	/**
	 * Metodo per ritornare una data salvata in un oggetto DateOfBirth
	 * @param date Data in formato stringa
	 * @return DateOf Data in formato DateOfBirth
	 */
	public static DateOfBirth parseDate(String date) {
		String first = "";
		String second = "";
		String third = "";
		int i=0;
		try {
			while (i<10&&date.charAt(i)!='-') {
				first += date.charAt(i);
				i++;
			}
			i++;
			while (i<10&&date.charAt(i)!='-') {
				second += date.charAt(i);
				i++;
			}
			i++;
			while (i<10&&date.charAt(i)!='-') {
				third += date.charAt(i);
				i++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		DateOfBirth DateOf = new DateOfBirth(first, second, third);
		return DateOf;
	}
	
}
