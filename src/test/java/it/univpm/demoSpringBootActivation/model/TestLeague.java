package it.univpm.demoSpringBootActivation.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import it.univpm.demoSpringBootActivation.requests.Directories;
import it.univpm.demoSpringBootActivation.utilities.JsonParser;

/**
 * JUnit test per i metodi lookForid e counVenues della classe league
 * @author Leonardo Mannini
 * @author Luca Ranucci
 *
 */
class TestLeague implements Directories{
	/**
	 * Set up del beforeEach prima dei test
	 */
	League league = new League();
	@BeforeEach
	void setUp() throws Exception {
		league = JsonParser.parseLeague(LEAGUE_DIR);
	}

	/**
	 * JUnit test del metodo lookForId
	 */
	@Test
	@DisplayName("Checks for correct team id")
	void testLookForId() {
		System.out.println("Checking team id for team Juventus of the SA, should have id = 109.\n");
		assertEquals(109, league.lookForId("Juventus"));
		System.out.println("Checking team id for team Roma of the SA, should have id = 100, asserting if id = 69, should fail.\n");
		assertNotEquals(69, league.lookForId("Roma"));
		System.out.println("Checking team id for team called Pluto (not a team of the SA), should return id = -1.\n");
		assertEquals(-1, league.lookForId("Pluto"));
	}
	/**
	 * JUnit test del metodo countVenues
	 */
	@Test
	@DisplayName("Checks for correct venues count")
	void testCountVenues() {
		System.out.println("Checking if metod countVenues counts all 17 venues.\n");
		assertEquals(17, league.countVenues());
	}
	

}
