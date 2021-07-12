package it.univpm.demoSpringBootActivation.utilities;

public class Positions {
	public static boolean isPosition(String position) {
		for(String i : positions) {
			if (i.equals(position)) return true;
		}
		return false;
	}
	public static String[] positions = new String[]{"Attacker", "Midfielder", "Defender", "Goalkeeper"};
}
