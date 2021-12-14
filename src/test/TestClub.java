package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Club.Account;
import Club.Club;
import Club.Manager;
import Club.Player;
import Club.PlayerField;
import Club.Stadium;
import Club.Tactics;

/**
 * Junit test for Club class
 * @author Zuocheng Wang
 *
 */
public class TestClub {
	
	Club Chelsea;
	Player Player_1;
	Player Player_2;

	@Before
	public void init() 
	{
		Stadium s1 = new Stadium("Stamford Bridge Stadium", 40834);
		Account che_rich_club_account = new Account(300000000);
		Chelsea = new Club("Chelsea", che_rich_club_account, "Roman Abramovich", s1, 5);
		Manager m1 = new Manager("Thomas Tuchel", 10000000 ,47, "Germany", 4, 5 ,1 , Tactics.counter_attack );
		Chelsea.addManager(m1);
		
		Player_1 = new Player("player_1", 500000, 30, "USA", 90,
				   90, 70, 70, 70, 70, PlayerField.midfield, 10, 10000000);
		
		Player_2 = new Player("player_2", 500000, 30, "UK", 80,
				   80, 80, 85, 82, 70, PlayerField.midfield, 10, 10000000);
			
	}
	
	@Test
	public void testAddPlayer()
	{
		Chelsea.addPlayer(Player_1);
		Chelsea.addPlayer(Player_2);
		
		assertEquals("player_1", Chelsea.getPlayer_LinkedList().get(0).getName());
		assertEquals("player_2", Chelsea.getPlayer_LinkedList().get(1).getName());
	}
	
	@Test
	public void testremovePlayer()
	{
		Chelsea.addPlayer(Player_1);
		Chelsea.addPlayer(Player_2);
		
		assertEquals("player_1", Chelsea.getPlayer_LinkedList().get(0).getName());
		assertEquals("player_2", Chelsea.getPlayer_LinkedList().get(1).getName());
		
		Chelsea.removePlayer(Player_1);
		assertEquals("player_2", Chelsea.getPlayer_LinkedList().get(0).getName());
		Chelsea.removePlayer(Player_2);
		assertEquals(0, Chelsea.getPlayer_LinkedList().size());
	}
	
	@Test
	public void testSortPlayerbyAttribute()
	{
		Chelsea.addPlayer(Player_1);
		Chelsea.addPlayer(Player_2);
		
		assertEquals("player_1", Chelsea.getPlayer_LinkedList().get(0).getName());
		assertEquals("player_2", Chelsea.getPlayer_LinkedList().get(1).getName());
		
		assertEquals("player_1", Chelsea.sortPlayerbyAttribute("Shooting Skill").get(1).getName());
		assertEquals("player_2", Chelsea.sortPlayerbyAttribute("Stealing Skill").get(1).getName());
	}
	
	@Test
	public void testgetManager()
	{	
		assertEquals("Thomas Tuchel", Chelsea.getClub_manager().getName());

	}
	
	@Test
	public void testgetBalanceAccount()
	{	
		assertEquals(300000000, Chelsea.getClubAccount().balance, 0.001);

	}
	
	@Test
	public void testgetTeamTactic()
	{	
		assertEquals(Tactics.counter_attack, Chelsea.getTeamTactics());

	}
	
}
