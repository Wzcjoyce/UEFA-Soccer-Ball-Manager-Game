package test;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import Club.Club;
import Match_Simulator.Non_User_Match;
import soccer_manager.Championship;

/**
 * Test cases for Non-user match
 * @author Zuocheng Wang
 *
 */
public class Test_Non_User_Match {
	Club Chelsea;
	Club Manchester_City;
	Championship UEFA_test;
	
	Non_User_Match match;
	
	@Before
	public void init() 
	{
		UEFA_test = new Championship();
		Chelsea = UEFA_test.getClub("Chelsea");
		Manchester_City = UEFA_test.getClub("Manchester City");
		
		
		match = new Non_User_Match(Chelsea, Manchester_City);
	}
	
	@Test
	public void testHome_team()
	{
		//match.match_simulator();
		assertEquals("Chelsea", match.Home_team.getClubName());
	}
	
	@Test
	public void testAway_team()
	{
		//match.match_simulator();
		assertEquals("Manchester City", match.Away_team.getClubName());
	}
	
	@Test
	public void testtoString()
	{
		match.match_simulator();
		assertEquals("result score: " +  match.home_goal + " : " + match.away_goal, match.toString());
	}

}
