package it.univpm.demoSpringBootActivation.utilities;


import it.univpm.demoSpringBootActivation.model.*;
public class AgeCalculator {
	
	public static DateOfBirth parseDate(String date) {
		
		String first = "";
		String second = "";
		String third = "";
		int i=0;
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
		DateOfBirth DateOf = new DateOfBirth(first, second, third);
		
		
		return DateOf;
	}
}

