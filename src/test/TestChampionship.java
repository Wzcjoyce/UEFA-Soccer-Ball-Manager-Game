package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import soccer_manager.Championship;


/**
 * Test cases for Championship Class
 * @author Zuocheng Wang
 *
 */
public class TestChampionship {
	Championship UEFA_test;

	@Before
	public void init() 
	{
		UEFA_test = new Championship();
			
	}
	
	@Test
	public void testgetClubList()
	{
		assertEquals(32, UEFA_test.getClubs_list().size());
	}
	
	@Test
	public void testgetClub()
	{
		assertEquals("Manchester United", UEFA_test.getClub("Manchester United").getClubName());
	}
	
}
