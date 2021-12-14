package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Club.Stadium;

/**
 * Test cases for Stadium Class
 * @author Zuocheng Wang
 *
 */
public class TestStadium {
	Stadium s1;
	
	@Before
	public void init()
	{
		s1 = new Stadium("Stamford Bridge Stadium", 40834);
	}
	
	@Test
	public void testgetStadiumName()
	{
		assertEquals("Stamford Bridge Stadium", s1.getStadiumName());
	}
	
	@Test
	public void testgetCapacity()
	{
		assertEquals(40834, s1.getCapacity());
	}
	
	@Test
	public void testtoString()
	{
		assertEquals("Stadium: Stamford Bridge Stadium                        "
				+ "Capacity: 40834", s1.toString());
	}
}
