package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Championship_Stage.Group;
import Club.Club;
import soccer_manager.Clubs;

/**
 * Test cases for Group class
 * @author Zuocheng Wang
 *
 */
public class Test_Group {
	
	private Group groupE_teams;
	Clubs clubs_object;
	
	@Before
	public void init()
	{
		clubs_object = new Clubs();
		ArrayList<Club> group_E_arraylist = new ArrayList<Club>();
		group_E_arraylist.add(clubs_object.Chelsea);
		group_E_arraylist.add(clubs_object.Sevilla);
		group_E_arraylist.add(clubs_object.Spartak_Moscow);
		group_E_arraylist.add(clubs_object.rennes);
		groupE_teams = new Group("E", group_E_arraylist);
		
	}
	
	@Test
	public void testSet_real_Group_1st()
	{
		clubs_object.Chelsea.group_points = 12;
		clubs_object.Sevilla.group_points = 10;
		
		groupE_teams.set_real_Group_1st();
		groupE_teams.set_real_Group_2nd();
		

		assertEquals("Chelsea", groupE_teams.getGroup_1st().getClubName());
		
		clubs_object.Chelsea.group_points = 12;
		clubs_object.Sevilla.group_points = 12;
		
		clubs_object.Chelsea.group_total_net_goal = 10;
		clubs_object.Sevilla.group_total_net_goal = 8;
		
		groupE_teams.set_real_Group_1st();
		groupE_teams.set_real_Group_2nd();
		
		assertEquals("Chelsea", groupE_teams.getGroup_1st().getClubName());
		
	}
	
	@Test
	public void testSet_real_Group_2nd()
	{
		clubs_object.Chelsea.group_points = 12;
		clubs_object.Sevilla.group_points = 10;
		
		groupE_teams.set_real_Group_1st();
		groupE_teams.set_real_Group_2nd();
		
		assertEquals("Sevilla", groupE_teams.getGroup_2nd().getClubName());
		
	}
	
	@Test
	public void testSet_real_Group_3rd()
	{
		clubs_object.Chelsea.group_points = 12;
		clubs_object.Sevilla.group_points = 10;
		clubs_object.Spartak_Moscow.group_points = 8;
		
		groupE_teams.set_real_Group_1st();
		groupE_teams.set_real_Group_2nd();
		groupE_teams.set_real_Group_3rd();
		
		assertEquals("Spartak Moscow", groupE_teams.getGroup_3rd().getClubName());
		
	}
	
	@Test
	public void testSet_real_Group_4th()
	{
		clubs_object.Chelsea.group_points = 12;
		clubs_object.Sevilla.group_points = 10;
		clubs_object.Spartak_Moscow.group_points = 8;
		clubs_object.rennes.group_points = 0;
		
		groupE_teams.set_real_Group_1st();
		groupE_teams.set_real_Group_2nd();
		groupE_teams.set_real_Group_3rd();
		groupE_teams.set_real_Group_4th();
		
		assertEquals("Rennes", groupE_teams.getGroup_4th().getClubName());
		
	}
}
