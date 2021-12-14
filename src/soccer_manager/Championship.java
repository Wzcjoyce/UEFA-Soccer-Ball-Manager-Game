package soccer_manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import Championship_Stage.Group;
import Championship_Stage.Round_Team;
import Club.Account;
import Club.Club;
import Club.Manager;
import Club.Player;
import Club.PlayerField;
import Club.Stadium;
import Club.Tactics;
import GUI.Final_View;
import GUI.GameStatus;
import GUI.Group_detail_view;
import GUI.Round_16_View;
import GUI.Round_8_View;
import GUI.Semi_Final_View;
import Schedule.Event;
import Schedule.Group_events;
import Schedule.Round_events;
import database.LoadDatabase;

/**
 * Class store all clubs and all events variables
 * this is the main model of this program
 * @author Zuocheng Wang
 *
 */
public class Championship {
	

	public ArrayList<Game_Date> game_date;
	
	private LinkedList<Club> clubs_list;
	private String[][] Player_database;
	
	public static boolean Transfer_window_open;
	
	public Group groupA_teams;
	public Group groupB_teams;
	public Group groupC_teams;
	public Group groupD_teams;
	public Group groupE_teams;	
	public Group groupF_teams;
	public Group groupG_teams;
	public Group groupH_teams;	
	public Round_Team round_of_16_teams;
	public Round_Team round_of_8_teams;
	public Round_Team semi_final;
	public Round_Team final_team;
	
	
	public Group_events groupA_events;
	public Group_events groupB_events;
	public Group_events groupC_events;
	public Group_events groupD_events;
	public Group_events groupE_events;
	public Group_events groupF_events;
	public Group_events groupG_events;
	public Group_events groupH_events;
	
	public Round_events round_16_events;
	public Round_events round_8_events;
	public Round_events semi_final_events;
	public Round_events final_events;
	
	public Club Champion;
	
	public static LinkedList<LinkedList<Object>> score_list;
	
	/**
	 * championship constructor
	 */
	public Championship()
	{
		
		//Add all 32 clubs to this Championship;
		Clubs clubs_object = new Clubs();
		clubs_list = new LinkedList<Club> ();
		clubs_list = clubs_object.clubs_list;
		
		score_list = new LinkedList<LinkedList<Object>>();
		
		this.Transfer_window_open = true;
		
		
		//load player database
		try {
			LoadDatabase database = new LoadDatabase();
			Player_database = database.getArray();
			this.addPlayer_from_database(); //iteratively use data in csv file to create player objects for each team.
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < 32; i++)
		{
			clubs_list.get(i).getDefault_Starting_lineup_attacker();
			clubs_list.get(i).getDefault_Starting_lineup_defender();
			clubs_list.get(i).getDefault_Starting_lineup_midfielder();
			clubs_list.get(i).getDefault_Starting_lineup_goalkeeper();
		}
		
    	ArrayList<Club> group_A_arraylist = new ArrayList<Club>();
    	group_A_arraylist.add(clubs_object.bayernmunich);
    	group_A_arraylist.add(clubs_object.Atletico_Madrid);
    	group_A_arraylist.add(clubs_object.Red_Bull_Salzburg);
    	group_A_arraylist.add(clubs_object.Lokomotiv_Moscow);
		groupA_teams = new Group("A", group_A_arraylist);
		for (Club i: groupA_teams.getClub_list() )
		{
			i.setGroup_teams(groupA_teams);
			i.setGroup_teams_except_self();
		}
		
		
		ArrayList<Club> group_B_arraylist = new ArrayList<Club>();
		group_B_arraylist.add(clubs_object.Real_Madrid);
		group_B_arraylist.add(clubs_object.Borussia_Mionchengladbach);
		group_B_arraylist.add(clubs_object.Shakhtar_Donetsk);
		group_B_arraylist.add(clubs_object.Inter_Milan);
		groupB_teams = new Group("B", group_B_arraylist);
		for (Club i: groupB_teams.getClub_list() )
		{
			i.setGroup_teams(groupB_teams);
			i.setGroup_teams_except_self();
		}
		
		ArrayList<Club> group_C_arraylist = new ArrayList<Club>();
		group_C_arraylist.add(clubs_object.Manchester_City);
		group_C_arraylist.add(clubs_object.Porto);
		group_C_arraylist.add(clubs_object.Olympiacos);
		group_C_arraylist.add(clubs_object.Marseille);
		groupC_teams = new Group("C", group_C_arraylist);
		for (Club i: groupC_teams.getClub_list() )
		{
			i.setGroup_teams(groupC_teams);
			i.setGroup_teams_except_self();
		}
		
		ArrayList<Club> group_D_arraylist = new ArrayList<Club>();
		group_D_arraylist.add(clubs_object.Liverpool);
		group_D_arraylist.add(clubs_object.Atalanta);
		group_D_arraylist.add(clubs_object.Ajax);
		group_D_arraylist.add(clubs_object.midtjylland);
		groupD_teams = new Group("D", group_D_arraylist);
		for (Club i: groupD_teams.getClub_list() )
		{
			i.setGroup_teams(groupD_teams);
			i.setGroup_teams_except_self();
		}
		
		ArrayList<Club> group_E_arraylist = new ArrayList<Club>();
		group_E_arraylist.add(clubs_object.Chelsea);
		group_E_arraylist.add(clubs_object.Sevilla);
		group_E_arraylist.add(clubs_object.Spartak_Moscow);
		group_E_arraylist.add(clubs_object.rennes);
		groupE_teams = new Group("E", group_E_arraylist);
		for (Club i: groupE_teams.getClub_list() )
		{
			i.setGroup_teams(groupE_teams);
			i.setGroup_teams_except_self();
		}
		
		ArrayList<Club> group_F_arraylist = new ArrayList<Club>();
		group_F_arraylist.add(clubs_object.Borussia_Dortmund);
		group_F_arraylist.add(clubs_object.Lazio);
		group_F_arraylist.add(clubs_object.Club_Brugge);
		group_F_arraylist.add(clubs_object.CSKA_Moscow);
		groupF_teams = new Group("F", group_F_arraylist);
		for (Club i: groupF_teams.getClub_list() )
		{
			i.setGroup_teams(groupF_teams);
			i.setGroup_teams_except_self();
		}
		
		ArrayList<Club> group_G_arraylist = new ArrayList<Club>();
		group_G_arraylist.add(clubs_object.Juventus);
		group_G_arraylist.add(clubs_object.Barcelona);
		group_G_arraylist.add(clubs_object.Dynamo_Kyiv);
		group_G_arraylist.add(clubs_object.Benfica);
		groupG_teams = new Group("G", group_G_arraylist);
		for (Club i: groupG_teams.getClub_list() )
		{
			i.setGroup_teams(groupG_teams);
			i.setGroup_teams_except_self();
		}
		
		ArrayList<Club> group_H_arraylist = new ArrayList<Club>();
		group_H_arraylist.add(clubs_object.Paris_Saint_Germain);
		group_H_arraylist.add(clubs_object.RB_Leipzig);
		group_H_arraylist.add(clubs_object.Manchester_United);
		group_H_arraylist.add(clubs_object.Galatasaray);
		groupH_teams = new Group("H", group_H_arraylist);
		for (Club i: groupH_teams.getClub_list() )
		{
			i.setGroup_teams(groupH_teams);
			i.setGroup_teams_except_self();
		}
		
		this.generate_group_events();
		
		game_date = new ArrayList<Game_Date>();
		
		this.add_date(2020);
		
		round_of_16_teams = new Round_Team("Round of 16", 16);
		round_of_8_teams = new Round_Team("Round of 8", 8);
		semi_final  = new Round_Team("Semi-Final", 4);
		final_team = new Round_Team("Final", 2);
		
		round_16_events = new Round_events(round_of_16_teams);
		round_8_events = new Round_events(round_of_8_teams);
		semi_final_events = new Round_events(semi_final);
		final_events = new Round_events(final_team);
	}
	

	/**
	 * getter of club lists 
	 * @return LinkedList of Club
	 */
	public LinkedList<Club> getClubs_list() {
		return clubs_list;
	}
	
	/**
	 * add player objects created based on database read from csv file
	 * to the associate Club class
	 */
	public void addPlayer_from_database()
	{
		for (Club club:clubs_list)
			for (String[] row: Player_database) 
			{
				if (row[13].equals(club.getClubName()))
				{
					double pay = Double.parseDouble(row[1]);
					int age = Integer.parseInt(row[2]);
					int shooting = Integer.parseInt(row[4]);
					int passing = Integer.parseInt(row[5]);
					int dribbling = Integer.parseInt(row[6]);
					int intercept = Integer.parseInt(row[7]);
					int stealing = Integer.parseInt(row[8]);
					int goalkeeper = Integer.parseInt(row[9]);
					int jersy_num = Integer.parseInt(row[11]);
					double value = Double.parseDouble(row[12]);
					PlayerField position = PlayerField.toPlayerField(row[10]);
					Player new_player = new Player(row[0], pay, age, row[3], shooting, passing, dribbling, intercept,
							stealing, goalkeeper, position, jersy_num,value);
					club.addPlayer(new_player);
				}
			}
	}
	
	/**
	 * Method to Change manager with user after user make the team selection
	 * @param UserClubName name of club
	 * @param userName name of manager
	 * @param age age of manager
	 * @param nationality nationality of manager
	 */
	public void Swap_manager_with_user(String UserClubName, String userName, int age, String nationality)
	{
		for (Club i:clubs_list)
		{
			if(i.getClubName() == UserClubName)
			{

				int attack_num = i.getClub_manager().getAttacker_num();
				int midfield_num = i.getClub_manager().getMidfielder_num();
				int defend_num = i.getClub_manager().getDefender_num();
				Tactics tactic = i.getClub_manager().getTactics();
				i.removeManager(i.getClub_manager());
				Manager user = new Manager(userName, 2000000, age, nationality
						, defend_num, midfield_num, attack_num, tactic);
				i.addManager(user);
			}
		}
		
		GameController.status = GameStatus.GAME_Play_Main_Menu;
	}

	/**
	 * method to get user's club object
	 * @param UserClubName name of user's club
	 * @return Club 
	 */
	public Club getUserClub(String UserClubName)
	{
		Stadium temp_stadium = new Stadium("", 0);
		Account temp_account = new Account(0);
		Club temp = new Club("", temp_account, "", temp_stadium, 5);;
		for (Club i:clubs_list)
		{
			if(i.getClubName() == UserClubName)
			{

				temp = i;
			}
		}
		
		return temp;
	}
	
	/**
	 * method to determine if the transfer offer can be accpeted or not
	 * @param tranfer_Player Player about to transfer
	 * @param offer_price offered price
	 * @param transfer_in_club potential transfer in club
	 * @return boolean
	 */
	public static boolean Transfer_determination(Player tranfer_Player,  double offer_price, Club transfer_in_club)
	{
		boolean transfer_success = false;
		int charm_level = transfer_in_club.getCharm_level();
		Random transfer_random_num = new Random();
		int max = 100;
		int result = transfer_random_num.nextInt(max) + 1;
		
		int transfer_player_highest_attribute = tranfer_Player.getHighestAttribute();
		
		if(transfer_player_highest_attribute > 94)
		{
			if(offer_price > 2* tranfer_Player.getValue())
			{
				if(result + (charm_level*3)  > 70)
				{
					transfer_success = true;
				}
			}
			else if(offer_price > 1.5* tranfer_Player.getValue())
			{
				if(result  + (charm_level*3)  > 90)
				{
					transfer_success = true;
				}
			}
			else if(offer_price > 1 * tranfer_Player.getValue())
			{
				if(result  + (charm_level*3) > 98)
				{
					transfer_success = true;
				}
			}
		}
		
		else if(transfer_player_highest_attribute > 89)
		{
			if(offer_price > 2* tranfer_Player.getValue())
			{
				if(result  + (charm_level*3)  > 50)
				{
					transfer_success = true;
				}
			}
			else if(offer_price > 1.5* tranfer_Player.getValue())
			{
				if(result  + (charm_level*3)  > 70)
				{
					transfer_success = true;
				}
			}
			else if(offer_price > 1 * tranfer_Player.getValue())
			{
				if(result  + (charm_level*3)  > 90)
				{
					transfer_success = true;
				}
			}
		}
		
		else if(transfer_player_highest_attribute > 84)
		{
			if(offer_price > 2* tranfer_Player.getValue())
			{
				if(result  + (charm_level*3)  > 30)
				{
					transfer_success = true;
				}
			}
			else if(offer_price > 1.5* tranfer_Player.getValue())
			{
				if(result  + (charm_level*3)  > 50)
				{
					transfer_success = true;
				}
			}
			else if(offer_price > 1 * tranfer_Player.getValue())
			{
				if(result  + (charm_level*3) > 70)
				{
					transfer_success = true;
				}
			}
		}
		
		else if(transfer_player_highest_attribute > 79)
		{
			if(offer_price > 2* tranfer_Player.getValue())
			{
				if(result  + (charm_level*3)  > 10)
				{
					transfer_success = true;
				}
			}
			else if(offer_price > 1.5* tranfer_Player.getValue())
			{
				if(result  + (charm_level*3) > 30)
				{
					transfer_success = true;
				}
			}
			else if(offer_price > 1 * tranfer_Player.getValue())
			{
				if(result + (charm_level*3)  > 50)
				{
					transfer_success = true;
				}
			}
		}
		
		else
		{
			if(offer_price > 2* tranfer_Player.getValue())
			{
				if(result  + (charm_level*3) > 10)
				{
					transfer_success = true;
				}
			}
			else if(offer_price > 1.5* tranfer_Player.getValue())
			{
				if(result  + (charm_level*3)  > 20)
				{
					transfer_success = true;
				}
			}
			else if(offer_price > 1 * tranfer_Player.getValue())
			{
				if(result  + (charm_level*3)  > 30)
				{
					transfer_success = true;
				}
			}
		}
		
		return transfer_success;
	}
	
	/**
	 * method of transfer player between clubs
	 * @param Tranfer_in_ClubName name of transfer in club
	 * @param Tranfer_out_ClubName name of transfer out club
	 * @param Transfer_Player name of transfer player
	 */
	public void Transfer(String Tranfer_in_ClubName, String Tranfer_out_ClubName, String Transfer_Player)
	{
		Club transfer_in_club = this.getClub(Tranfer_in_ClubName);
		Club transfer_out_club = this.getClub(Tranfer_out_ClubName);
		
		Player transfer_player = transfer_out_club.getPlayer(Transfer_Player);
		
		transfer_out_club.removePlayer(transfer_player);
		transfer_in_club.addPlayer(transfer_player);

	}
	
	/**
	 * getter of club
	 * @param ClubName name of club
	 * @return Club club object
	 */
	public Club getClub(String ClubName)
	{
		Stadium temp_stadium = new Stadium("", 0);
		Account temp_account = new Account(0);
		Club temp = new Club("", temp_account, "", temp_stadium, 5);;
		for (Club i:clubs_list)
		{
			if(i.getClubName() == ClubName)
			{

				temp = i;
			}
		}
		
		return temp;

	}

	/**
	 * getter of group A
	 * @return Group
	 */
	public Group getGroupA_teams() {
		return groupA_teams;
	}

	/**
	 * setter of group A
	 * @param groupA_teams Group
	 */
	public void setGroupA_teams(Group groupA_teams) {
		this.groupA_teams = groupA_teams;
	}

	/**
	 * getter of group B
	 * @return Group
	 */
	public Group getGroupB_teams() {
		return groupB_teams;
	}

	/**
	 * setter of group B
	 * @param groupB_teams
	 */
	public void setGroupB_teams(Group groupB_teams) {
		this.groupB_teams = groupB_teams;
	}

	/**
	 * getter of group C
	 * @return Group
	 */
	public Group getGroupC_teams() {
		return groupC_teams;
	}

	/**
	 * setter of group C
	 * @param groupC_teams
	 */
	public void setGroupC_teams(Group groupC_teams) {
		this.groupC_teams = groupC_teams;
	}

	/**
	 * getter of group D
	 * @return Group
	 */
	public Group getGroupD_teams() {
		return groupD_teams;
	}

	/**
	 * setter of group D
	 * @param groupD_teams
	 */
	public void setGroupD_teams(Group groupD_teams) {
		this.groupD_teams = groupD_teams;
	}

	/**
	 * getter of group E
	 * @return Group
	 */
	public Group getGroupE_teams() {
		return groupE_teams;
	}

	/**
	 * setter of group E
	 * @param groupE_teams
	 */
	public void setGroupE_teams(Group groupE_teams) {
		this.groupE_teams = groupE_teams;
	}

	/**
	 * getter of group F
	 * @return Group
	 */
	public Group getGroupF_teams() {
		return groupF_teams;
	}

	/**
	 * setter of group F
	 * @param groupF_teams
	 */
	public void setGroupF_teams(Group groupF_teams) {
		this.groupF_teams = groupF_teams;
	}

	/**
	 * getter of group G
	 * @return Group
	 */
	public Group getGroupG_teams() {
		return groupG_teams;
	}

	/**
	 * setter of group F
	 * @param groupG_teams
	 */
	public void setGroupG_teams(Group groupG_teams) {
		this.groupG_teams = groupG_teams;
	}

	/**
	 * getter of group H
	 * @return Group
	 */
	public Group getGroupH_teams() {
		return groupH_teams;
	}

	/**
	 * setter of group H
	 * @param groupH_teams
	 */
	public void setGroupH_teams(Group groupH_teams) {
		this.groupH_teams = groupH_teams;
	} 

	/**
	 * getter of round of 16
	 * @return Round_Team
	 */
	public Round_Team getRound_of_16_teams() {
		return round_of_16_teams;
	}

	/**
	 * setter of round of 16
	 */
	public void setRound_of_16_teams() {
		
		Random random_value = new Random();
		
		this.round_of_16_teams.club_list.add(this.groupA_teams.getGroup_1st());
		int game_opponent_num = random_value.nextInt(8);
		int temp1;
		int temp2;
		int temp3;
		int temp4;
		int temp5;
		int temp6;
		int temp7;
		
		while(game_opponent_num == 0)
		{
			game_opponent_num = random_value.nextInt(8);
		}
		temp1 = game_opponent_num;
		this.add_group_2nd_to_round_16_teams(game_opponent_num);
		
		
		game_opponent_num = random_value.nextInt(8);
		this.round_of_16_teams.club_list.add(this.groupB_teams.getGroup_1st());
		while(game_opponent_num == 1  || game_opponent_num == temp1 )
		{
			game_opponent_num = random_value.nextInt(8);
		}
		temp2 = game_opponent_num;
		this.add_group_2nd_to_round_16_teams(game_opponent_num);
		
		game_opponent_num = random_value.nextInt(8);
		this.round_of_16_teams.club_list.add(this.groupC_teams.getGroup_1st());
		while(game_opponent_num == 2 || game_opponent_num == temp1 || game_opponent_num == temp2 )
		{
			game_opponent_num = random_value.nextInt(8);
		}
		temp3 = game_opponent_num;
		this.add_group_2nd_to_round_16_teams(game_opponent_num);
		
		game_opponent_num = random_value.nextInt(8);
		this.round_of_16_teams.club_list.add(this.groupD_teams.getGroup_1st());
		while(game_opponent_num == 3 || game_opponent_num == temp1 || game_opponent_num == temp2 ||
				game_opponent_num == temp3)
		{
			game_opponent_num = random_value.nextInt(8);
		}
		temp4 = game_opponent_num;
		this.add_group_2nd_to_round_16_teams(game_opponent_num);
		
		game_opponent_num = random_value.nextInt(8);
		this.round_of_16_teams.club_list.add(this.groupE_teams.getGroup_1st());
		while(game_opponent_num == 4 || game_opponent_num == temp1 || game_opponent_num == temp2 ||
				game_opponent_num == temp3 ||game_opponent_num == temp4)
		{
			game_opponent_num = random_value.nextInt(8);
		}
		temp5 = game_opponent_num;
		this.add_group_2nd_to_round_16_teams(game_opponent_num);
		
		game_opponent_num = random_value.nextInt(8);
		this.round_of_16_teams.club_list.add(this.groupF_teams.getGroup_1st());
		while(game_opponent_num == 5 || game_opponent_num == temp1 || game_opponent_num == temp2 ||
				game_opponent_num == temp3 ||game_opponent_num == temp4 ||game_opponent_num == temp5)
		{
			game_opponent_num = random_value.nextInt(8);
		}
		temp6 = game_opponent_num;
		this.add_group_2nd_to_round_16_teams(game_opponent_num);
		
		game_opponent_num = random_value.nextInt(8);
		this.round_of_16_teams.club_list.add(this.groupG_teams.getGroup_1st());
		while(game_opponent_num == 6 || game_opponent_num == temp1 || game_opponent_num == temp2 ||
				game_opponent_num == temp3 ||game_opponent_num == temp4 ||game_opponent_num == temp5
				|| game_opponent_num == temp6)
		{
			game_opponent_num = random_value.nextInt(8);
		}
		temp7 = game_opponent_num;
		this.add_group_2nd_to_round_16_teams(game_opponent_num);
		
		game_opponent_num = random_value.nextInt(8);
		this.round_of_16_teams.club_list.add(this.groupH_teams.getGroup_1st());
		while(game_opponent_num == 7 || game_opponent_num == temp1 || game_opponent_num == temp2 ||
				game_opponent_num == temp3 ||game_opponent_num == temp4 ||game_opponent_num == temp5
				|| game_opponent_num == temp6 ||game_opponent_num == temp7 )
		{
			game_opponent_num = random_value.nextInt(8);
		}
		this.add_group_2nd_to_round_16_teams(game_opponent_num);
	
	}
	
	/**
	 * method add group 2nd to round of 16 teams
	 * @param game_opponent_num
	 */
	public void add_group_2nd_to_round_16_teams(int game_opponent_num)
	{
		if(game_opponent_num == 0)
		{
			round_of_16_teams.club_list.add(this.groupA_teams.getGroup_2nd());
		}
		else if(game_opponent_num == 1)
		{
			round_of_16_teams.club_list.add(this.groupB_teams.getGroup_2nd());
		}
		else if(game_opponent_num == 2)
		{
			round_of_16_teams.club_list.add(this.groupC_teams.getGroup_2nd());
		}
		else if(game_opponent_num == 3)
		{
			round_of_16_teams.club_list.add(this.groupD_teams.getGroup_2nd());
		}
		else if(game_opponent_num == 4)
		{
			round_of_16_teams.club_list.add(this.groupE_teams.getGroup_2nd());
		}
		else if(game_opponent_num == 5)
		{
			round_of_16_teams.club_list.add(this.groupF_teams.getGroup_2nd());
		}
		else if(game_opponent_num == 6)
		{
			round_of_16_teams.club_list.add(this.groupG_teams.getGroup_2nd());
		}
		else if(game_opponent_num == 7)
		{
			round_of_16_teams.club_list.add(this.groupH_teams.getGroup_2nd());
		}
	}
	
	/**
	 * getter of round of 8 teams
	 * @return Round_Team
	 */
	public Round_Team getRound_of_8_teams() {
		return round_of_8_teams;
	}

	/**
	 * setter of round of 8 teams
	 */
	public void setRound_of_8_teams() {
		round_of_16_teams.set_round_16_Win_team_list();
		this.round_of_8_teams.club_list = round_of_16_teams.win_team_list;
	}

	/**
	 * setter of semi final
	 */
	public void setSemi_final() {
		round_of_8_teams.set_round_8_Win_team_list();
		this.semi_final.club_list = round_of_8_teams.win_team_list;
	}
	
	/**
	 * getter of semi final
	 * @return Round_Team
	 */
	public Round_Team getSemi_final() {
		return semi_final;
	}

	/**
	 * getter of  final round team
	 * @return Round_Team
	 */
	public Round_Team getFinal_team() {
		return final_team;
	}
	
	/**
	 * setter of final round team
	 */
	public void setFinal_team() {
		semi_final.set_semi_final_Win_team_list();
		this.final_team.club_list = semi_final.win_team_list;
	}
	
	/**
	 * getter of final round team
	 * @return Club
	 */
	public Club getChampion()
	{
		final_team.set_Champion();
		Champion = final_team.win_team_list.get(0);
		return Champion;
	}
	
	/**
	 * method run the round match events
	 * @param event_date Match date
	 * @param Event_team_num number of teams in that events
	 */
	public void Run_round_match_events(Game_Date event_date, int Event_team_num)
	{
		
		if(Event_team_num == 16)
		{
			Round_16_View.Round_of_16_Score_results = Round_16_View.Round_of_16_Score_results + "\n\n" + event_date + ":\n";
			for (Event i:round_16_events.round_events)
			{
				if(i.date.equals(event_date))
				{
					i.simulate_round_match();
					Round_16_View.Round_of_16_Score_results = Round_16_View.Round_of_16_Score_results + "\n"+ i.Home_team.getClubName() + " home: \n" + i.Home_team.getStadium().getStadiumName()+ "\n" +
							i.Home_team.getClubName() + "  " + i.home_team_goal + " : " + i.away_team_goal+ "  "+i.Away_team.getClubName() +"\n\n";
					System.out.println(i.Home_team.getClubName() + "  " + i.home_team_goal + "  :   " + i.away_team_goal +" " + i.Away_team.getClubName());
				}
			}
		}
		else if(Event_team_num == 8)
		{
			Round_8_View.Round_of_8_Score_results = Round_8_View.Round_of_8_Score_results + "\n\n" + event_date + ":\n";
			for (Event i:round_8_events.round_events)
			{
				if(i.date.equals(event_date))
				{
					i.simulate_round_match();
					Round_8_View.Round_of_8_Score_results = Round_8_View.Round_of_8_Score_results+ "\n"+ i.Home_team.getClubName() + " home:  \n" + i.Home_team.getStadium().getStadiumName()+ "\n"+
							i.Home_team.getClubName() + "  " + i.home_team_goal + " : " + i.away_team_goal+ "  "+i.Away_team.getClubName() +"\n\n";
					System.out.println(i.Home_team.getClubName() + "  " + i.home_team_goal + "  :   " + i.away_team_goal +  " " + i.Away_team.getClubName());
				}
			}
		}
		else if(Event_team_num == 4)
		{
			Semi_Final_View.Round_of_semi_final_Score_results = Semi_Final_View.Round_of_semi_final_Score_results + "\n\n" + event_date + ":\n";
			for (Event i:semi_final_events.round_events)
			{
				if(i.date.equals(event_date))
				{
					i.simulate_round_match();
					Semi_Final_View.Round_of_semi_final_Score_results = Semi_Final_View.Round_of_semi_final_Score_results + "\n"+ i.Home_team.getClubName() + " home:  \n" + i.Home_team.getStadium().getStadiumName()+ "\n" +
							i.Home_team.getClubName() + "  " + i.home_team_goal + " : " + i.away_team_goal+ "  "+i.Away_team.getClubName() +"\n\n";
					System.out.println(i.Home_team.getClubName() + "  " + i.home_team_goal + "  :   " +  + i.away_team_goal  +" " + i.Away_team.getClubName());
				}
			}
		}
		
		else if(Event_team_num == 2)
		{
			Final_View.Round_of_final_Score_results = Final_View.Round_of_final_Score_results + "\n\n" + event_date + ":\n";
			for (Event i:final_events.round_events)
			{
				if(i.date.equals(event_date))
				{
					i.simulate_round_match();
					Final_View.Round_of_final_Score_results = Final_View.Round_of_final_Score_results + "\n"+ "Stadium:  \n" + "Dragon Stadium"+ "\n" +
							i.Home_team.getClubName() + "  " + i.home_team_goal + " : " + i.away_team_goal+ "  "+i.Away_team.getClubName() +"\n\n";
				
					this.getChampion();
					
					GameController.UEFA.sort_score_list();
					
					Final_View.Round_of_final_Score_results = Final_View.Round_of_final_Score_results + "\n"
							+"The Champion is: " + "\n" + Champion.getClubName() + "\n\n" +
							"The Golden Boots Player is:" + "\n" + ((Player)this.score_list.getLast().get(0)).getName()
							+ "\nfrom  " + ((Club)this.score_list.getLast().get(2)).getClubName()+ "\nScore:   " + (this.score_list.getLast().get(1)) + "  goals";
					
					System.out.println(i.Home_team.getClubName() + "  " + i.home_team_goal + "  :   " +  + i.away_team_goal + " " + i.Away_team.getClubName());
				}
			}
		}
		
	}

	/**
	 * method run the group match events
	 * @param event_date
	 */
	public void Run_group_match_events(Game_Date event_date)
	{
		Group_detail_view.Group_A_Score_results = Group_detail_view.Group_A_Score_results + "\n\n" + event_date + ":\n";
		Group_detail_view.Group_B_Score_results = Group_detail_view.Group_B_Score_results + "\n\n" +event_date + ":\n";
		Group_detail_view.Group_C_Score_results = Group_detail_view.Group_C_Score_results + "\n\n" +event_date + ":\n";
		Group_detail_view.Group_D_Score_results = Group_detail_view.Group_D_Score_results + "\n\n" +event_date + ":\n";
		Group_detail_view.Group_E_Score_results = Group_detail_view.Group_E_Score_results + "\n\n" +event_date + ":\n";
		Group_detail_view.Group_F_Score_results = Group_detail_view.Group_F_Score_results + "\n\n" +event_date + ":\n";
		Group_detail_view.Group_G_Score_results = Group_detail_view.Group_G_Score_results + "\n\n" +event_date + ":\n";
		Group_detail_view.Group_H_Score_results = Group_detail_view.Group_H_Score_results + "\n\n" +event_date + ":\n";
		
		for (Event i:groupA_events.group_events)
		{
			if(i.date.equals(event_date))
			{
				i.simulate_group_match();
				Group_detail_view.Group_A_Score_results = Group_detail_view.Group_A_Score_results + 
						i.Home_team.getClubName() + "  " + i.home_team_goal + " : " + i.away_team_goal+ "  "+i.Away_team.getClubName() +"\n";
			}
		}
		
		groupA_teams.set_real_Group_1st();
		groupA_teams.set_real_Group_2nd();
		groupA_teams.set_real_Group_3rd();
		groupA_teams.set_real_Group_4th();
		
		for (Event i:groupB_events.group_events)
		{
			if(i.date.equals(event_date))
			{
				i.simulate_group_match();
				Group_detail_view.Group_B_Score_results = Group_detail_view.Group_B_Score_results +
						i.Home_team.getClubName() + "  " + i.home_team_goal + " : " + i.away_team_goal+ "  "+i.Away_team.getClubName() +"\n";
			}
		}
		
		groupB_teams.set_real_Group_1st();
		groupB_teams.set_real_Group_2nd();
		groupB_teams.set_real_Group_3rd();
		groupB_teams.set_real_Group_4th();
		
		for (Event i:groupC_events.group_events)
		{
			if(i.date.equals(event_date))
			{
				i.simulate_group_match();
				Group_detail_view.Group_C_Score_results = Group_detail_view.Group_C_Score_results +
						i.Home_team.getClubName() + "  " + i.home_team_goal + " : " + i.away_team_goal+ "  "+i.Away_team.getClubName() +"\n";
			}
		}
		
		groupC_teams.set_real_Group_1st();
		groupC_teams.set_real_Group_2nd();
		groupC_teams.set_real_Group_3rd();
		groupC_teams.set_real_Group_4th();
		
		for (Event i:groupD_events.group_events)
		{
			if(i.date.equals(event_date))
			{
				i.simulate_group_match();
				Group_detail_view.Group_D_Score_results = Group_detail_view.Group_D_Score_results +
						i.Home_team.getClubName() + "  " + i.home_team_goal + " : " + i.away_team_goal+ "  "+i.Away_team.getClubName() +"\n";
			}
		}
		
		groupD_teams.set_real_Group_1st();
		groupD_teams.set_real_Group_2nd();
		groupD_teams.set_real_Group_3rd();
		groupD_teams.set_real_Group_4th();
		
		
		for (Event i:groupE_events.group_events)
		{
			if(i.date.equals(event_date))
			{
				i.simulate_group_match();
				Group_detail_view.Group_E_Score_results = Group_detail_view.Group_E_Score_results +
						i.Home_team.getClubName() + "  " + i.home_team_goal + " : " + i.away_team_goal+ "  "+i.Away_team.getClubName() +"\n";
			}
		}
		
		groupE_teams.set_real_Group_1st();
		groupE_teams.set_real_Group_2nd();
		groupE_teams.set_real_Group_3rd();
		groupE_teams.set_real_Group_4th();
		
		for (Event i:groupF_events.group_events)
		{
			if(i.date.equals(event_date))
			{
				i.simulate_group_match();
				Group_detail_view.Group_F_Score_results = Group_detail_view.Group_F_Score_results +
						i.Home_team.getClubName() + "  " + i.home_team_goal + " : " + i.away_team_goal+ "  "+i.Away_team.getClubName() +"\n";
			}
		}
		
		groupF_teams.set_real_Group_1st();
		groupF_teams.set_real_Group_2nd();
		groupF_teams.set_real_Group_3rd();
		groupF_teams.set_real_Group_4th();
		
		for (Event i:groupG_events.group_events)
		{
			if(i.date.equals(event_date))
			{
				i.simulate_group_match();
				Group_detail_view.Group_G_Score_results = Group_detail_view.Group_G_Score_results +
						i.Home_team.getClubName() + "  " + i.home_team_goal + " : " + i.away_team_goal+ "  "+i.Away_team.getClubName() +"\n";
			}
		}
		
		groupG_teams.set_real_Group_1st();
		groupG_teams.set_real_Group_2nd();
		groupG_teams.set_real_Group_3rd();
		groupG_teams.set_real_Group_4th();
		
		for (Event i:groupH_events.group_events)
		{
			if(i.date.equals(event_date))
			{
				i.simulate_group_match();
				Group_detail_view.Group_H_Score_results = Group_detail_view.Group_H_Score_results +
						i.Home_team.getClubName() + "  " + i.home_team_goal + " : " + i.away_team_goal+ "  "+i.Away_team.getClubName() +"\n";
			}
		}
		
		groupH_teams.set_real_Group_1st();
		groupH_teams.set_real_Group_2nd();
		groupH_teams.set_real_Group_3rd();
		groupH_teams.set_real_Group_4th();
		
		/*
		//TODO for testing
		System.out.println("\n\n");
		
		for(int i = 0; i < Championship.score_list.size(); i++)
		{
			System.out.println(((Player)Championship.score_list.get(i).get(0)).getName() +" goals: " +Championship.score_list.get(i).get(1));
		} */
	}
	
	/**
	 * method for process the top score list
	 */
	public static void sort_score_list()
	{
		List<LinkedList<Object>> temp_score_list = score_list.stream().sorted((s1, s2)->(( (Integer) s1.get(1)).compareTo((Integer) s2.get(1)))).collect(Collectors.toList());
		
		LinkedList<LinkedList<Object>> temp = new LinkedList<LinkedList<Object>>();
		
		for(int i = 0; i < temp_score_list.size(); i++)
		{
			temp.add(temp_score_list.get(i));
		}
		
		score_list = temp;
	}
	
	/**
	 * method for add Game Date
	 * @param year
	 */
	public void add_date(int year)
	{
		game_date.add(new Game_Date(year, 10, 21));
		game_date.add(new Game_Date(year, 10, 29));
		game_date.add(new Game_Date(year, 11, 5));
		game_date.add(new Game_Date(year, 11, 25));
		game_date.add(new Game_Date(year, 12, 3));
		game_date.add(new Game_Date(year, 12, 9));
		
		//round 16
		game_date.add(new Game_Date(year+1, 2, 16));
		game_date.add(new Game_Date(year+1, 3, 9));
		
		//round 8
		game_date.add(new Game_Date(year+1, 4, 7));
		game_date.add(new Game_Date(year+1, 4, 13));
		
		//semi final
		game_date.add(new Game_Date(year+1, 4, 27));
		game_date.add(new Game_Date(year+1, 5, 4));
		
		//final
		game_date.add(new Game_Date(year+1, 5, 29));
	}
	
	/**
	 * method for generate group events
	 */
	public void generate_group_events()
	{
		groupA_events = new Group_events(groupA_teams);
		groupA_events.generate_events();
		
		groupB_events = new Group_events(groupB_teams);
		groupB_events.generate_events();
		
		groupC_events = new Group_events(groupC_teams);
		groupC_events.generate_events();
		
		groupD_events = new Group_events(groupD_teams);
		groupD_events.generate_events();
		
		groupE_events = new Group_events(groupE_teams);
		groupE_events.generate_events();
		
		groupF_events = new Group_events(groupF_teams);
		groupF_events.generate_events();
		
		groupG_events = new Group_events(groupG_teams);
		groupG_events.generate_events();
		
		groupH_events = new Group_events(groupH_teams);
		groupH_events.generate_events();
	}

}
