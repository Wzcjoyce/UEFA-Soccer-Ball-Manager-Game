package Championship_Stage;

import java.util.ArrayList;
import java.util.Random;

import Club.Club;

/**
 * Class that hold teams during Round elimination stage
 * @author Zuocheng Wang
 *
 */
public class Round_Team {
	
	private String round_name;
	private int num_teams;
	public ArrayList<Club> club_list;
	public ArrayList<Club> win_team_list;
	

	/**
	 * constructor of Round Team class
	 * @param round_name
	 * @param num_teams
	 */
	public Round_Team(String round_name, int num_teams)
	{
		this.round_name = round_name;
		this.num_teams = num_teams;
		club_list = new ArrayList<Club>();
		win_team_list =  new ArrayList<Club>();	
	}

	/**
	 * get winner team list of associated Round
	 * @return ArrayList win_team_list
	 */
	public ArrayList<Club> getWin_team_list() {
		return win_team_list;
	}

    /**
     * getter of round name
     * @return String round_name
     */
	public String getRound_name() {
		return round_name;
	}

    /**
     * getter of number of team
     * @return int number of teams
     */
	public int getNum_teams() {
		return num_teams;
	}

    /**
     * getter of Club list
     * @return ArrayList
     */
	public ArrayList<Club> getClub_list() {
		return club_list;
	}
	
	/**
	 * set the round 16 winner list
	 */
	public void set_round_16_Win_team_list()
	{
		int i = 0;
		
		for(int j = 0; j < 8; j++)
		{
			int first_team_total_goal = club_list.get(i).round_16_home_goals + club_list.get(i).round_16_away_goals;
			int second_team_total_goal = club_list.get(i + 1).round_16_home_goals + club_list.get(i + 1).round_16_away_goals;
			int first_team_total_point = club_list.get(i).round_16_home_goals + club_list.get(i).round_16_away_goals * 2;
			int second_team_total_point = club_list.get(i + 1).round_16_home_goals + club_list.get(i + 1).round_16_away_goals * 2;
			if( first_team_total_goal > second_team_total_goal)
			{
				win_team_list.add(club_list.get(i));
			}
			else if(second_team_total_goal > first_team_total_goal)
			{
				win_team_list.add(club_list.get(i + 1));
			}
			else
			{
				if(first_team_total_point > second_team_total_point)
				{
					win_team_list.add(club_list.get(i));
				}
				else if(first_team_total_point < second_team_total_point)
				{
					win_team_list.add(club_list.get(i + 1));
				}
				else
				{
					Random random_value = new Random();
					int temp = random_value.nextInt(2);
					if(temp == 0)
					{
						win_team_list.add(club_list.get(i));
					}
					else
					{
						win_team_list.add(club_list.get(i + 1));
					}
				}
			}
			i += 2;
		}
	}
	
	/**
	 * set the round 8 winner list
	 */
	public void set_round_8_Win_team_list()
	{
		int i = 0;
		
		for(int j = 0; j < 4; j++)
		{
			int first_team_total_goal = club_list.get(i).round_8_home_goals + club_list.get(i).round_8_away_goals;
			int second_team_total_goal = club_list.get(i + 1).round_8_home_goals + club_list.get(i + 1).round_8_away_goals;
			int first_team_total_point = club_list.get(i).round_8_home_goals + club_list.get(i).round_8_away_goals * 2;
			int second_team_total_point = club_list.get(i + 1).round_8_home_goals + club_list.get(i + 1).round_8_away_goals * 2;
			if( first_team_total_goal > second_team_total_goal)
			{
				win_team_list.add(club_list.get(i));
			}
			else if(second_team_total_goal > first_team_total_goal)
			{
				win_team_list.add(club_list.get(i + 1));
			}
			else
			{
				if(first_team_total_point > second_team_total_point)
				{
					win_team_list.add(club_list.get(i));
				}
				else if(first_team_total_point < second_team_total_point)
				{
					win_team_list.add(club_list.get(i + 1));
				}
				else
				{
					Random random_value = new Random();
					int temp = random_value.nextInt(2);
					if(temp == 0)
					{
						win_team_list.add(club_list.get(i));
					}
					else
					{
						win_team_list.add(club_list.get(i + 1));
					}
				}
			}
			i += 2;
		}
	}
	
	/**
	 * set the round semi final winner list
	 */
	public void set_semi_final_Win_team_list()
	{
		int i = 0;
		
		for(int j = 0; j < 2; j++)
		{
			int first_team_total_goal = club_list.get(i).semi_final_home_goals + club_list.get(i).semi_final_away_goals;
			int second_team_total_goal = club_list.get(i + 1).semi_final_home_goals + club_list.get(i + 1).semi_final_away_goals;
			int first_team_total_point = club_list.get(i).semi_final_home_goals + club_list.get(i).semi_final_away_goals * 2;
			int second_team_total_point = club_list.get(i + 1).semi_final_home_goals + club_list.get(i + 1).semi_final_away_goals * 2;
			if( first_team_total_goal > second_team_total_goal)
			{
				win_team_list.add(club_list.get(i));
			}
			else if(second_team_total_goal > first_team_total_goal)
			{
				win_team_list.add(club_list.get(i + 1));
			}
			else
			{
				if(first_team_total_point > second_team_total_point)
				{
					win_team_list.add(club_list.get(i));
				}
				else if(first_team_total_point < second_team_total_point)
				{
					win_team_list.add(club_list.get(i + 1));
				}
				else
				{
					Random random_value = new Random();
					int temp = random_value.nextInt(2);
					if(temp == 0)
					{
						win_team_list.add(club_list.get(i));
					}
					else
					{
						win_team_list.add(club_list.get(i + 1));
					}
				}
			}
			i += 2;
		}
	}
	
	/**
	 * set the champion winner list
	 */
	public void set_Champion()
	{
		if( club_list.get(0).final_goals > club_list.get(1).final_goals)
		{
			win_team_list.add( club_list.get(0));
		}
		else if(club_list.get(0).final_goals < club_list.get(1).final_goals)
		{
			win_team_list.add( club_list.get(1));
		}
		else
		{
			while(true)
			{
				Random random_value = new Random();
				int temp = random_value.nextInt(7);
				Random random_value2 = new Random();
				int temp2 = random_value2.nextInt(7);
				
				if ( (club_list.get(0).getStarting_lineup_goalkeeper().get(0).getGoalkeeper_skill() + temp)
						> (club_list.get(1).getStarting_lineup_goalkeeper().get(0).getGoalkeeper_skill() + temp2))
				{
					win_team_list.add( club_list.get(0));
					break;
				}
				else if( (club_list.get(0).getStarting_lineup_goalkeeper().get(0).getGoalkeeper_skill() + temp)
						< (club_list.get(1).getStarting_lineup_goalkeeper().get(0).getGoalkeeper_skill() + temp2))
				{
					win_team_list.add( club_list.get(1));
					break;
				}
			}
		}
	}

}
