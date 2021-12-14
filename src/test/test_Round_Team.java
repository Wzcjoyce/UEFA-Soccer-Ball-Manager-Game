package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Championship_Stage.Round_Team;
import Club.Club;
import soccer_manager.Championship;

/**
 * Test cases for Round_Team class
 * @author Zuocheng Wang
 *
 */
public class test_Round_Team {
	
	Round_Team final_team;
	Round_Team semi_final_team;
	Championship UEFA_test;
	Club Chelsea;
	Club Manchester_City;
	Club Liverpool;
	Club Manchester_United;
	
	@Before
	public void init()
	{
		UEFA_test = new Championship();
		Chelsea = UEFA_test.getClub("Chelsea");
		Manchester_City = UEFA_test.getClub("Manchester City");
		Liverpool = UEFA_test.getClub("Liverpool");
		Manchester_United = UEFA_test.getClub("Manchester United");
		
		final_team = new Round_Team("Final", 2);
		final_team.club_list.add(Chelsea);
		final_team.club_list.add(Manchester_City);
		
		semi_final_team = new Round_Team("Semi Final", 2);
		semi_final_team.club_list.add(Chelsea);
		semi_final_team.club_list.add(Manchester_City);
		semi_final_team.club_list.add(Liverpool);
		semi_final_team.club_list.add(Manchester_United);

		
	}
	
	@Test
	public void testSet_Champion()
	{
		Chelsea.final_goals = 1;
		Manchester_City.final_goals = 0;
		
		final_team.set_Champion();
		
		assertEquals("Chelsea", final_team.win_team_list.get(0).getClubName());
	}
	
	@Test
	public void testset_semi_final_Win_team_list()
	{
		Chelsea.semi_final_away_goals = 1;
		Chelsea.semi_final_home_goals = 1;
		Manchester_City.semi_final_away_goals = 0;
		Manchester_City.semi_final_home_goals = 2;
		
		Manchester_United.semi_final_away_goals = 1;
		Manchester_United.semi_final_home_goals = 1;
		Liverpool.semi_final_away_goals = 3;
		Liverpool.semi_final_home_goals = 4;
		
		semi_final_team.set_semi_final_Win_team_list();;
		
		assertEquals("Chelsea", semi_final_team.win_team_list.get(0).getClubName());
		assertEquals("Liverpool", semi_final_team.win_team_list.get(1).getClubName());
	}
}
