package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Club.Account;
import Club.Club;
import Match_Simulator.Non_User_Match;
import soccer_manager.Championship;

/**
 * Test cases for Account Class
 * @author Zuocheng Wang
 *
 */
public class testAccount {
	Club Chelsea;
	Club Manchester_City;
	Championship UEFA_test;
	Account account1;
	Account account2;
	
	Non_User_Match match;
	
	@Before
	public void init() 
	{
		UEFA_test = new Championship();
		Chelsea = UEFA_test.getClub("Chelsea");
		account1 = Chelsea.getClubAccount();
		Manchester_City = UEFA_test.getClub("Manchester City");
		account2 = Manchester_City.getClubAccount();
	}
	
	@Test
	public void test_getBanlance()
	{
		assertEquals(300000000, account1.getBalance(), 0.001);
		assertEquals(300000000, account2.getBalance(), 0.001);
	}
	
	@Test
	public void increaseAccount()
	{
		account1.increaseBalance(300000000);
		assertEquals(600000000, account1.getBalance(), 0.001);
	}
	
	@Test
	public void decreaseAccount()
	{
		account2.decreaseBalance(100000000);
		assertEquals(200000000, account2.getBalance(), 0.001);
	}
}
