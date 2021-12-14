package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Club.Manager;

import Club.Tactics;

/**
 * Test cases for Manager Class
 * @author Zuocheng Wang
 *
 */
public class TestManager {
	Manager m1;

	@Before
	public void init() 
	{
		m1 = new Manager("Thomas Tuchel", 10000000 ,47, "Germany", 4, 5 ,1 , Tactics.counter_attack );
	}
	
	@Test
	public void testgetDefender_num() 
	{
		assertEquals(4, m1.getDefender_num());
	}
	
	@Test
	public void testgetMidfielder_num() 
	{
		assertEquals(5, m1.getMidfielder_num());
	}
	
	@Test
	public void testgetAttacker_num() 
	{
		assertEquals(1, m1.getAttacker_num());
	}
	
	@Test
	public void testsetDefender_num() 
	{
		m1.setDefender_num(3);
		assertEquals(3, m1.getDefender_num());
	}
	
	@Test
	public void testsetMidfielder_num() 
	{
		m1.setMidfielder_num(4);
		assertEquals(4, m1.getMidfielder_num());
	}
	
	@Test
	public void testsetAttacker_num() 
	{
		m1.setAttacker_num(3);
		assertEquals(3, m1.getAttacker_num());
	}
	
	@Test
	public void testgetName() 
	{
		assertEquals("Thomas Tuchel", m1.getName());
	}
	
	@Test
	public void testgetAge() 
	{
		assertEquals(47, m1.getAge());
	}
}
