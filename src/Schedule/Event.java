package Schedule;

import java.util.ArrayList;
import java.util.LinkedList;

import Club.Club;
import Club.Player;
import Match_Simulator.Non_User_Match;
import soccer_manager.Championship;
import soccer_manager.Game_Date;

/**
 * Class for holding event information
 * which include two Clubs and a Game_Date 
 * @author Zuocheng Wang
 * 
 */
public class Event{
	
	public Club Home_team;
	public Club Away_team;
	public Game_Date date;
	public Non_User_Match non_user_match;
	public boolean event_simulated;
	public int home_team_goal;
	public int away_team_goal;
	
	/**
	 * Event constructor take 3 argument
	 * @param Home_team
	 * @param Away_team
	 * @param date
	 */
	public Event(Club Home_team,Club Away_team, Game_Date date)
	{
		this.Home_team = Home_team;
		this.Away_team = Away_team;
		this.date = date;
		non_user_match = new Non_User_Match(this.Home_team, this.Away_team);
	}
	
	/**
	 * event constructor take 1 argument
	 * @param date
	 */
	public Event(Game_Date date)
	{
		this.Home_team = null;
		this.Away_team = null;
		this.date = date;
		non_user_match = null;
		event_simulated = false;
	}

	/**
	 * getter of home team
	 * @return Club
	 */
	public Club getHome_team() {
		return Home_team;
	}

	/**
	 * setter of home team
	 * @param home_team
	 */
	public void setHome_team(Club home_team) {
		Home_team = home_team;
	}

	/**
	 * getter of Away team
	 * @return Club
	 */
	public Club getAway_team() {
		return Away_team;
	}

	/**
	 * setter of away team
	 * @param away_team
	 */
	public void setAway_team(Club away_team) {
		Away_team = away_team;
	}

	/**
	 * getter of Game Date
	 * @return Game_Date
	 */
	public Game_Date getDate() {
		return date;
	}

	/**
	 * setter of Game Date
	 * @param date
	 */
	public void setDate(Game_Date date) {
		this.date = date;
	}
	
	/**
	 * method simulate group matches
	 */
	public void simulate_group_match()
	{
		non_user_match.match_simulator();
		
		non_user_match.Home_team.getClubAccount().balance += 3000000 + non_user_match.Home_team.getStadium().getCapacity() * 150;
		non_user_match.Away_team.getClubAccount().balance += 3000000;
		
		home_team_goal = non_user_match.home_goal;
		away_team_goal = non_user_match.away_goal;
		
		Home_team.group_total_goal = Home_team.group_total_goal + home_team_goal;
		Home_team.group_total_loss_goal =  Home_team.group_total_loss_goal + away_team_goal;
		Home_team.group_total_net_goal = Home_team.group_total_goal  - Home_team.group_total_loss_goal;

		Away_team.group_total_goal = Away_team.group_total_goal + away_team_goal;
		Away_team.group_total_loss_goal =  Away_team.group_total_loss_goal + home_team_goal;
		Away_team.group_total_net_goal = Away_team.group_total_goal  - Away_team.group_total_loss_goal;

		
		if(home_team_goal > away_team_goal)
		{
			Home_team.group_points = Home_team.group_points + 3;
			Home_team.group_win_num = Home_team.group_win_num + 1;
			Away_team.group_lose_num = Away_team.group_lose_num + 1;
		}
		else if(away_team_goal > home_team_goal)
		{
			Away_team.group_points = Away_team.group_points + 3;
			Away_team.group_win_num = Away_team.group_win_num + 1;
			Home_team.group_lose_num = Home_team.group_lose_num + 1;
		}
		else
		{
			Away_team.group_draw_num= Away_team.group_draw_num + 1;
			Home_team.group_draw_num= Home_team.group_draw_num + 1;
			Away_team.group_points= Away_team.group_points + 1;
			Home_team.group_points= Home_team.group_points + 1;
			
		}
		
		
		this.process_top_score_list();
	}
	
	/**
	 * method for simulating round match(round of 16, round of 8, semi final, final)
	 */
	public void simulate_round_match()
	{

		non_user_match.match_simulator();
		
		home_team_goal = non_user_match.home_goal;
		away_team_goal = non_user_match.away_goal;
		
		if(this.date.equals(new Game_Date(2021, 2, 16)) || this.date.equals(new Game_Date(2021, 3, 9)))
		{
			non_user_match.Home_team.getClubAccount().balance += 5000000 + 4000000 + non_user_match.Home_team.getStadium().getCapacity() * 200;
			non_user_match.Away_team.getClubAccount().balance += 5000000 + 4000000;
			
			Home_team.round_16_home_goals += non_user_match.home_goal;
			Away_team.round_16_away_goals += non_user_match.away_goal;
		}
		else if(this.date.equals(new Game_Date(2021, 4, 7)) || this.date.equals(new Game_Date(2021, 4, 13)))
		{
			non_user_match.Home_team.getClubAccount().balance += 10000000 + 6000000 + non_user_match.Home_team.getStadium().getCapacity() * 250;
			non_user_match.Away_team.getClubAccount().balance += 10000000 + 6000000;
			
			Home_team.round_8_home_goals += non_user_match.home_goal;
			Away_team.round_8_away_goals += non_user_match.away_goal;
		}
		else if(this.date.equals(new Game_Date(2021, 4, 27)) || this.date.equals(new Game_Date(2021, 5, 4)))
		{
			non_user_match.Home_team.getClubAccount().balance += 15000000 + 8000000 + non_user_match.Home_team.getStadium().getCapacity() * 300;
			non_user_match.Away_team.getClubAccount().balance += 15000000 + 8000000;
			
			Home_team.semi_final_home_goals += non_user_match.home_goal;
			Away_team.semi_final_away_goals += non_user_match.away_goal;
		}
		else if(this.date.equals(new Game_Date(2021, 5, 29)))
		{
			non_user_match.Home_team.getClubAccount().balance += 20000000+ 10000000 + 50000 * 500;
			non_user_match.Away_team.getClubAccount().balance += 20000000 + 10000000 + 50000 * 500;
			
			Home_team.final_goals += non_user_match.home_goal;
			Away_team.final_goals += non_user_match.away_goal;
		}
		
		this.process_top_score_list();
		
	}
	
	/**
	 * method which process the top score list
	 */
	public void process_top_score_list()
	{
		boolean contains_already = false;
		
		LinkedList<Object> temp =  new LinkedList<Object>();
		
		for(int i = 0; i < non_user_match.score_player_list.size(); i++)
		{
			for(int j = 0; j < Championship.score_list.size(); j++)
			{
				if(non_user_match.score_player_list.get(i).getName() == ((Player) Championship.score_list.get(j).get(0)).getName())
				{
					contains_already = true;
					Championship.score_list.get(j).set(1, (Integer)(Championship.score_list.get(j).get(1)) + 1);

				}
			}
			
			if(contains_already == false) // exclude user match result here//TODO
			{
				temp.add(non_user_match.score_player_list.get(i));
				temp.add(non_user_match.score_player_list_score_num.get(i));
				temp.add(non_user_match.score_player_club_list.get(i));
				Championship.score_list.add(temp);
			}
			contains_already = false;
			temp =   new LinkedList<Object>();
		}
		
		
		// remove duplicate
		LinkedList<LinkedList<Object>> newList = new LinkedList<LinkedList<Object>>();
		
		for (LinkedList<Object> k : Championship.score_list) {
			  
            if (!newList.contains(k)) {
  
                newList.add(k);
            }
        }
		Championship.score_list = newList;
	}
}
