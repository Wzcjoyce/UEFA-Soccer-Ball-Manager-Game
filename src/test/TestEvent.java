package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Club.Club;
import Schedule.Event;
import soccer_manager.Championship;
import soccer_manager.Game_Date;

/**
 * Test cases for Event Class
 * @author Zuocheng Wang
 *
 */
public class TestEvent {
	
	Championship UEFA_test;
	Club Chelsea;
	Club Manchester_City;
	Event test_event;
	
	@Before
	public void init()
	{
		UEFA_test = new Championship();
		Chelsea = UEFA_test.getClub("Chelsea");
		Manchester_City = UEFA_test.getClub("Manchester City");
		test_event = new Event(Chelsea, Manchester_City, new Game_Date(2021, 5, 29));
	}
	
	@Test 
	public void testgetHomeTeam()
	{
		assertEquals( "Chelsea", test_event.getHome_team().getClubName());
	}
	
	@Test 
	public void testgetAwayTeam()
	{
		assertEquals( "Manchester City", test_event.getAway_team().getClubName());
	}

	@Test 
	public void testgetDate()
	{
		assertEquals( "2021/05/29", test_event.getDate().toString());
	}
}
