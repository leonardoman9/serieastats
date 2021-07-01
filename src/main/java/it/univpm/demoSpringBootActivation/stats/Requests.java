package it.univpm.demoSpringBootActivation.stats;

import java.io.IOException;

import it.univpm.demoSpringBootActivation.exceptions.MissingTeamException;
import it.univpm.demoSpringBootActivation.model.Dataset;
import it.univpm.demoSpringBootActivation.model.JsonParser;
import it.univpm.demoSpringBootActivation.model.League;
import it.univpm.demoSpringBootActivation.model.Scorers;
import it.univpm.demoSpringBootActivation.model.Team;

public class Requests {
	public static League returnLeague(boolean showTeams) throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/teams");
		League newLeague = new League();
		newLeague = JsonParser.parseLeague(result);
		if (showTeams==true) System.out.println(newLeague.toString());
			else System.out.println(newLeague.toStringNoTeams());
		return newLeague;
	}
	public static Team returnTeam(String nomeTeam) throws IOException, MissingTeamException {
	    String firstResult = Dataset.download("https://api.football-data.org/v2/competitions/SA/teams");
		League newLeague = new League();
		newLeague = JsonParser.parseLeague(firstResult);
		int teamId = newLeague.lookForId(nomeTeam);
		//if(teamId==-1)
		//	{throw new MissingTeamException(nomeTeam);}
		String result = Dataset.download("https://api.football-data.org/v2/teams/" + teamId);
		Team newTeam = new Team();
		newTeam = JsonParser.parseTeam(result);
		System.out.println(newTeam+"\n");
		return newTeam;		
	}
	public static Scorers returnLeagueScorers() throws IOException {
		String result = Dataset.download("https://api.football-data.org/v2/competitions/SA/scorers?limit=100");
		Scorers scorers = new Scorers();
		scorers = JsonParser.parseScorers(result);
		System.out.println(scorers);
		return scorers;
	}
}
