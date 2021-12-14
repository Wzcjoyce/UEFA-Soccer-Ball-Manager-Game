package soccer_manager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import Club.Club;
import Club.Player;
import Club.PlayerField;
import GUI.Final_View;
import GUI.GameStatus;
import GUI.Game_Play_Main_Menu;
import GUI.Group_detail_view;
import GUI.Main;
import GUI.Round_16_View;
import GUI.Round_8_View;
import GUI.Semi_Final_View;
import GUI.TeamSelectionView;
import Schedule.Event;
import Schedule.Group_events;
import Schedule.Round_events;

/**
 * Controller of this program
 * @author Zuocheng Wang
 *
 */
public class GameController {
	
    public static String team_name = "Chelsea";
    public static String user_name = " ";
    public static int user_age = 30;
    public static String user_nationality = "USA";
    public static GameStatus status = GameStatus.MAIN_MENU;
    
	public static Game_Date current_date;
	public static int current_event_date_index = 0;
    public static Event next_user_event;
    
    public static Championship UEFA;
    
    public static boolean tsubasa_add = false;
    protected Main menu;
    protected TeamSelectionView team_selection_screen;
    protected Game_Play_Main_Menu Game_Play_main_menu;
    
    /**
     * constructor of GameController class
     */
    public GameController()
    {
		this.current_date = new Game_Date();
		
    	menu = new Main();
    	team_selection_screen = new TeamSelectionView(team_name);
    	
    	UEFA = new Championship();

    }
    
    /**
     * method that start the game main menu
     */
    public void start_main_game_menu()
    {
       	Game_Play_main_menu = new Game_Play_Main_Menu();
    	Game_Play_main_menu.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
    	Game_Play_main_menu.setSize(800, 600);
    	Game_Play_main_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Game_Play_main_menu.setLocationRelativeTo(null);
    }
	
	/**
	 * method for pause the battle arena
	 * @param pause_time
	 */
	public static void pauseGame(int pause_time)
	{
		try {
	          Thread.sleep(pause_time);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	}
	
	/**
	 * method for lock the main thread until certain game status has been met
	 * @param status
	 */
	public static void LockGame_until_Given_Status(GameStatus status)
	{
		while(true)
		{
			GameController.pauseGame(200);
			if(GameController.status == status)
			{
				break;
			}
		}
	}
	
	/**
	 * method for converting player information read from CSV into 2D object array
	 * @return Object[][]
	 */
	public static Object[][] getUserTeam_database()
	{
		Club userclub = GameController.UEFA.getUserClub(GameController.team_name);
		List<Player>  user_player_list = userclub.getPlayer_LinkedList();
		ArrayList<ArrayList<Object>> database_2Darray = new ArrayList<ArrayList<Object>>();
		int teamsize = (int) userclub.getTeamSize();
		ArrayList<Object> TempList;	
	
		for(Player j:user_player_list)
		{
			TempList = new ArrayList<Object>();
			TempList.add(j.name);
			TempList.add( j.age);
			TempList.add(j.nationality);
			TempList.add( j.shirt_Number);
			TempList.add(j.getShooting_skill());
			TempList.add( j.getDribbling_skill());
			TempList.add( j.getPassing_skill());
			TempList.add( j.getIntercept_skill());
			TempList.add( j.getStealing_skill());
			TempList.add( j.getGoalkeeper_skill());
			TempList.add( j.getStamina());
			TempList.add( j.getAnnualPay());
			TempList.add( j.getValue());
			database_2Darray.add(TempList);
		}


		
		Object[][] newArray = new Object[teamsize][13];
		
 
	    for(int m = 0; m < teamsize; m++)
	    {
	    	for(int n = 0; n < 13; n++)
	    	{
	    		newArray[m][n] = database_2Darray.get(m).get(n);
	    	}
	    }
	    
		return newArray;
		
	}
	
	/**
	 * method for getting players data based on team name
	 * @param selected_team_name
	 * @return Object[][]
	 */
	public static Object[][] getTeam_database(String selected_team_name)
	{
		Club selected_club = GameController.UEFA.getUserClub(selected_team_name);
		List<Player>  selected_player_list = selected_club.getPlayer_LinkedList();
		ArrayList<ArrayList<Object>> database_2Darray = new ArrayList<ArrayList<Object>>();
		int teamsize = (int) selected_club.getTeamSize();
		ArrayList<Object> TempList;	
	
		for(Player j:selected_player_list)
		{
			TempList = new ArrayList<Object>();
			TempList.add(j.name);
			TempList.add( j.age);
			TempList.add(j.nationality);
			TempList.add( j.shirt_Number);
			TempList.add(j.getShooting_skill());
			TempList.add( j.getDribbling_skill());
			TempList.add( j.getPassing_skill());
			TempList.add( j.getIntercept_skill());
			TempList.add( j.getStealing_skill());
			TempList.add( j.getGoalkeeper_skill());
			TempList.add( j.getStamina());
			TempList.add( j.getAnnualPay());
			TempList.add( j.getValue());
			database_2Darray.add(TempList);
		}


		
		Object[][] newArray = new Object[teamsize][13];
		
 
	    for(int m = 0; m < teamsize; m++)
	    {
	    	for(int n = 0; n < 13; n++)
	    	{
	    		newArray[m][n] = database_2Darray.get(m).get(n);
	    	}
	    }
	    
		return newArray;
		
	}
	
	/**
	 * method for setting user next group event in main game play view
	 */
	public static void set_User_next_event()
	{
		Game_Date next_date = UEFA.game_date.get(current_event_date_index + 1);
		
		if(GameController.status == GameStatus.Group_Stage || GameController.status == GameStatus.GAME_Play_Main_Menu || 
				GameController.status == GameStatus.GAME_RUNNING|| GameController.status == GameStatus.MAIN_MENU
				||GameController.status == GameStatus.Team_Selection)
		{
		
			//Group A
			for(Event i:UEFA.groupA_events.getGroup_events())
			{
				for(Club j: UEFA.groupA_teams.getClub_list())
				{
					if(j.getClubName().equals(team_name) && i.getDate().equals(next_date) 
							&& ((i.getHome_team().getClubName().equals(team_name)) || (i.getAway_team().getClubName().equals(team_name))) )
					{
						GameController.next_user_event = i; // next user event is actually all club's event
					}
				}
			
			}
			
			for(Event i:UEFA.groupB_events.getGroup_events())
			{
				for(Club j: UEFA.groupB_teams.getClub_list())
				{
					if(j.getClubName().equals(team_name) && i.getDate().equals(next_date)
							&& ((i.getHome_team().getClubName().equals(team_name)) || (i.getAway_team().getClubName().equals(team_name))))
					{
						GameController.next_user_event = i;
					}
				}
			
			}
			
			for(Event i:UEFA.groupC_events.getGroup_events())
			{
				for(Club j: UEFA.groupC_teams.getClub_list())
				{
					if(j.getClubName().equals(team_name) && i.getDate().equals(next_date)
							&& ((i.getHome_team().getClubName().equals(team_name)) || (i.getAway_team().getClubName().equals(team_name))))
					{
						GameController.next_user_event = i;
					}
				}
			
			}
			
			for(Event i:UEFA.groupD_events.getGroup_events())
			{
				for(Club j: UEFA.groupD_teams.getClub_list())
				{
					if(j.getClubName().equals(team_name) && i.getDate().equals(next_date)
							&& ((i.getHome_team().getClubName().equals(team_name)) || (i.getAway_team().getClubName().equals(team_name))))
					{
						GameController.next_user_event = i;
					}
				}
			
			}
			
			for(Event i:UEFA.groupE_events.getGroup_events())
			{
				for(Club j: UEFA.groupE_teams.getClub_list())
				{
					if(j.getClubName().equals(team_name) && i.getDate().equals(next_date)
							&& ((i.getHome_team().getClubName().equals(team_name)) || (i.getAway_team().getClubName().equals(team_name))))
					{
						GameController.next_user_event = i;
					}
				}
			
			}
			
			for(Event i:UEFA.groupF_events.getGroup_events())
			{
				for(Club j: UEFA.groupF_teams.getClub_list())
				{
					if(j.getClubName().equals(team_name) && i.getDate().equals(next_date)
							&& ((i.getHome_team().getClubName().equals(team_name)) || (i.getAway_team().getClubName().equals(team_name))))
					{
						GameController.next_user_event = i;
					}
				}
			
			}
			
			for(Event i:UEFA.groupG_events.getGroup_events())
			{
				for(Club j: UEFA.groupG_teams.getClub_list())
				{
					if(j.getClubName().equals(team_name) && i.getDate().equals(next_date)
							&& ((i.getHome_team().getClubName().equals(team_name)) || (i.getAway_team().getClubName().equals(team_name))))
					{
						GameController.next_user_event = i;
					}
				}
			
			}
			
			for(Event i:UEFA.groupH_events.getGroup_events())
			{
				for(Club j: UEFA.groupH_teams.getClub_list())
				{
					if(j.getClubName().equals(team_name) && i.getDate().equals(next_date)
							&& ((i.getHome_team().getClubName().equals(team_name)) || (i.getAway_team().getClubName().equals(team_name))))
					{
						GameController.next_user_event = i;
					}
				}
			
			}
		
		}
	}
		
	/**
	 * method for setting user next Round event in main game play view
	 */
	public static void set_round_user_next_event()
	{
		Game_Date next_date = UEFA.game_date.get(current_event_date_index);
		
		if(GameController.status == GameStatus.Round_16 || GameController.status == GameStatus.Winter_Transfer_Window)
		{
			for(Event i:UEFA.round_16_events.round_events)
			{
				for(Club j: UEFA.round_of_16_teams.club_list)
				{
					if(j.getClubName().equals(team_name) && i.getDate().equals(next_date)
							&& ((i.getHome_team().getClubName().equals(team_name)) || (i.getAway_team().getClubName().equals(team_name))))
					{
						GameController.next_user_event = i;
					}
				}
			
			}
		}
		
		else if(GameController.status == GameStatus.Round_8)
		{
			for(Event i:UEFA.round_8_events.round_events)
			{
				for(Club j: UEFA.round_of_8_teams.club_list)
				{
					if(j.getClubName().equals(team_name) && i.getDate().equals(next_date)
							&& ((i.getHome_team().getClubName().equals(team_name)) || (i.getAway_team().getClubName().equals(team_name))))
					{
						GameController.next_user_event = i;
					}
				}
			
			}
		}
		
		else if(GameController.status == GameStatus.Semi_Final)
		{
			for(Event i:UEFA.semi_final_events.round_events)
			{
				for(Club j: UEFA.semi_final.club_list)
				{
					if(j.getClubName().equals(team_name) && i.getDate().equals(next_date)
							&& ((i.getHome_team().getClubName().equals(team_name)) || (i.getAway_team().getClubName().equals(team_name))))
					{
						GameController.next_user_event = i;
					}
				}
			
			}
		}
		
		else if(GameController.status == GameStatus.Final)
		{
			for(Event i:UEFA.final_events.round_events)
			{
				for(Club j: UEFA.final_team.club_list)
				{
					if(j.getClubName().equals(team_name) && i.getDate().equals(next_date)
							&& ((i.getHome_team().getClubName().equals(team_name)) || (i.getAway_team().getClubName().equals(team_name))))
					{
						GameController.next_user_event = i;
					}
				}
			}
		}
		
	}
	
	/**
	 * method for setting user next group event in main game play view
	 * current_event_date_index plus for eliminate mis-Date bugging
	 */
	public static void set_round_user_next_event_next_date()
	{
		Game_Date next_date = UEFA.game_date.get(current_event_date_index + 1);
		
		if(GameController.status == GameStatus.Round_16 || GameController.status == GameStatus.Winter_Transfer_Window)
		{
			for(Event i:UEFA.round_16_events.round_events)
			{
				for(Club j: UEFA.round_of_16_teams.club_list)
				{
					if(j.getClubName().equals(team_name) && i.getDate().equals(next_date)
							&& ((i.getHome_team().getClubName().equals(team_name)) || (i.getAway_team().getClubName().equals(team_name))))
					{
						GameController.next_user_event = i;
					}
				}
			
			}
		}
		
		else if(GameController.status == GameStatus.Round_8)
		{
			for(Event i:UEFA.round_8_events.round_events)
			{
				for(Club j: UEFA.round_of_8_teams.club_list)
				{
					if(j.getClubName().equals(team_name) && i.getDate().equals(next_date)
							&& ((i.getHome_team().getClubName().equals(team_name)) || (i.getAway_team().getClubName().equals(team_name))))
					{
						GameController.next_user_event = i;
					}
				}
			
			}
		}
		
		else if(GameController.status == GameStatus.Semi_Final)
		{
			for(Event i:UEFA.semi_final_events.round_events)
			{
				for(Club j: UEFA.semi_final.club_list)
				{
					if(j.getClubName().equals(team_name) && i.getDate().equals(next_date)
							&& ((i.getHome_team().getClubName().equals(team_name)) || (i.getAway_team().getClubName().equals(team_name))))
					{
						GameController.next_user_event = i;
					}
				}
			
			}
		}
		
		else if(GameController.status == GameStatus.Final)
		{
			for(Event i:UEFA.final_events.round_events)
			{
				for(Club j: UEFA.final_team.club_list)
				{
					if(j.getClubName().equals(team_name) && i.getDate().equals(next_date)
							&& ((i.getHome_team().getClubName().equals(team_name)) || (i.getAway_team().getClubName().equals(team_name))))
					{
						GameController.next_user_event = i;
					}
				}
			}
		}
		
	}
	
	/**
	 * method for resetting all inforamtion after one season
	 */
	public static void reset_data_from_last_season()
	{
		GameController.UEFA.groupA_events.event_dates.clear();
		GameController.UEFA.groupB_events.event_dates.clear();
		GameController.UEFA.groupC_events.event_dates.clear();
		GameController.UEFA.groupD_events.event_dates.clear();
		GameController.UEFA.groupE_events.event_dates.clear();
		GameController.UEFA.groupF_events.event_dates.clear();
		GameController.UEFA.groupG_events.event_dates.clear();
		GameController.UEFA.groupH_events.event_dates.clear();
		
		GameController.UEFA.round_16_events.event_dates.clear();
		GameController.UEFA.round_8_events.event_dates.clear();
		GameController.UEFA.semi_final_events.event_dates.clear();
		GameController.UEFA.final_events.event_dates.clear();
		
		GameController.UEFA.final_team.club_list.clear();
		GameController.UEFA.semi_final.club_list.clear();
		GameController.UEFA.round_of_8_teams.club_list.clear();
		GameController.UEFA.round_of_16_teams.club_list.clear();
		
		GameController.UEFA.Champion = null;
		
		for(Club i:GameController.UEFA.getClubs_list())
		{
			i.final_goals = 0;
			i.group_lose_num = 0;
			i.group_draw_num = 0;
			i.group_points = 0;
			i.group_total_goal = 0;
			i.group_total_loss_goal = 0;
			i.group_total_net_goal = 0;
			i.group_win_num = 0;
			i.round_16_away_goals = 0;
			i.round_16_home_goals = 0;
			i.round_8_home_goals = 0;
			i.round_8_away_goals = 0;
			i.final_goals = 0;
			i.semi_final_home_goals = 0;
			i.semi_final_away_goals = 0;
		}
		
		Group_events.Group_events_year += 1;
		Round_events.Round_events_year += 1;
		
		GameController.UEFA.generate_group_events();
		
		Group_detail_view.Group_A_Score_results = "UEFA Group Stage Result:\n\n";
		Group_detail_view.Group_B_Score_results = "UEFA Group Stage Result:\n\n";
		Group_detail_view.Group_C_Score_results = "UEFA Group Stage Result:\n\n";
		Group_detail_view.Group_D_Score_results = "UEFA Group Stage Result:\n\n";
		Group_detail_view.Group_E_Score_results = "UEFA Group Stage Result:\n\n";
		Group_detail_view.Group_F_Score_results = "UEFA Group Stage Result:\n\n";
		Group_detail_view.Group_G_Score_results = "UEFA Group Stage Result:\n\n";
		Group_detail_view.Group_H_Score_results = "UEFA Group Stage Result:\n\n";
		
		Round_16_View.Round_of_16_Score_results = "UEFA Round of 16 Result:\n\n";
		Round_8_View.Round_of_8_Score_results = "UEFA Round of 8 Result:\n\n";
		Semi_Final_View.Round_of_semi_final_Score_results = "UEFA Semi-Final Result:\n\n";
		Final_View.Round_of_final_Score_results = "UEFA Final Result:\n\n";
		
		GameController.UEFA.score_list.clear();
		Game_Play_Main_Menu.Year_num += 1;
	}
	
	
}
	
	

