package it.univpm.demoSpringBootActivation.utilities;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import org.joda.time.*;

import it.univpm.demoSpringBootActivation.model.DateOfBirth;
import it.univpm.demoSpringBootActivation.model.Scorer;
public class AgeCalculator {
	@SuppressWarnings("deprecation")
	public static long calculateAge(String dateOfBirthStr) throws Exception {
		String reducedDateOfBirth = reduceDate(dateOfBirthStr);
		String currentDate = reduceDate("2021-07-15");
		DateOfBirth ObjectDateOfBirth = parseDate(reducedDateOfBirth);
		DateOfBirth ObjectCurrentDate = parseDate(currentDate);
		return 0;
		
	}
	
	public static boolean ageCheck(Scorer i) {
		String ageOfBirth = i.getPlayer().getDateOfBirth();
		String year="";
		for (int j=0; ageOfBirth.charAt(j)!='-'; j++) {
			year+=ageOfBirth.charAt(j);
		}
		
		if(2021-(Integer.parseInt(year))<25) return true;
		else return false;
	}
	
	private static long differenceInYears(long difference) {
		return (difference/ (1000 * 60 * 60 * 24 * 365));
	}
	
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
	
	private static String reduceDate(String dateOfBirth) {
		String reducedString="";
		String app="";
		String keep = "";
		for (int i=0; i<4; i++) {
			app+=(dateOfBirth.charAt(i));
		}
		for (int i=4; i<10; i++) {
			keep+=(dateOfBirth.charAt(i));
		}
		app = Integer.toString((Integer.parseInt(app)-1900));
		reducedString+=app;
		reducedString+=keep;
		return reducedString;
	}
}
