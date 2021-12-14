package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Club.Player;
import Club.PlayerField;

/**
 * Test cases for Player Class
 * @author Zuocheng Wang
 *
 */
public class testPlayer {

	Player Player_1;
	Player Player_2;

	@Before
	public void init() 
	{
		Player_1 = new Player("player_1", 500000, 30, "USA", 90,
				   90, 70, 70, 70, 70, PlayerField.midfield, 10, 10000000);
		
		Player_2 = new Player("player_2", 500000, 30, "UK", 80,
				   80, 80, 85, 82, 90, PlayerField.goalkeeper, 10, 10000000);
	}
	
	@Test
	public void testgetBestPosition()
	{
		assertEquals(PlayerField.midfield ,Player_1.getBest_position());
		assertEquals(PlayerField.goalkeeper ,Player_2.getBest_position());
	}
	
	@Test
	public void testgetShootingSkill()
	{
		assertEquals(90 ,Player_1.getShooting_skill());
	}
	
	@Test
	public void testgetGoalkeeper_skill()
	{
		assertEquals(90 ,Player_2.getGoalkeeper_skill());
	}
	
	@Test
	public void testgetNationality()
	{
		assertEquals("UK" ,Player_2.getNationality());
	}
	
	@Test
	public void testgetAge()
	{
		assertEquals(30 ,Player_2.getAge());
	}
	
	@Test
	public void testgetjersyNumber()
	{
		assertEquals(10 ,Player_2.getShirt_Number());
	}
	

}
