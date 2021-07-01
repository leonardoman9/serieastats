package it.univpm.demoSpringBootActivation.stats;

import java.io.IOException;

import it.univpm.demoSpringBootActivation.model.Dataset;
import it.univpm.demoSpringBootActivation.model.JsonParser;
import it.univpm.demoSpringBootActivation.model.League;
import it.univpm.demoSpringBootActivation.model.Scorer;
import it.univpm.demoSpringBootActivation.model.Scorers;
import it.univpm.demoSpringBootActivation.model.Team;

public class Stat {
	public static String returnFoundedAfter(String yearFounded) throws IOException {
		String result;
		int yearFoundedInt = Integer.parseInt(yearFounded);
		Team[] Teams;
		result = Dataset.download("https://api.football-data.org/v2/competitions/SA/teams");
		League newLeague = JsonParser.parseLeague(result);
		Teams = newLeague.getTeams();
		for (Team i : Teams) {
			if (i.getFounded() > yearFoundedInt) {
				System.out.print(i.getShortName()+ ":");
				if(i.getShortName().length()<7) System.out.print("\t"); 
				System.out.println("\t" + i.getFounded());
			}
		}
		return result;
	}
	
	public static String returnVenues() throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/teams");
		League newLeague = new League();
		newLeague = JsonParser.parseLeague(result);
		System.out.println(newLeague.countVenues());
		return newLeague.countVenues();
	}
	
	public static String returnTeamScorers(String longName) throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/scorers?limit=100");
		Scorers scorers = new Scorers();
		scorers = JsonParser.parseScorers(result);
		result = longName + ":\n";
		for (Scorer i : scorers.getScorers()) {
			if (i.getTeam().getlongName().equals(longName)) result += i.getPlayer().getName() + ": " + i.getNumberOfGoals()+ "\n"; //TODO non funziona, i.getName() è sempre null (?)
		}
		System.out.println(result);
		return result;
	}
	
	public static String returnTeamsVenues() throws IOException {
		
		
		return null;
	}

	
}