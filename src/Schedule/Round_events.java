package Schedule;

import java.util.ArrayList;
import java.util.LinkedList;

import Championship_Stage.Group;
import Championship_Stage.Round_Team;
import Club.Club;
import soccer_manager.Game_Date;

/**
 * Class for storing all Round events variables
 * @author Zuocheng Wang
 *
 */
public class Round_events implements Events {
	
	public ArrayList<Event> round_events;
	public ArrayList<Game_Date> event_dates;
	public Round_Team round_team;
	public static int Round_events_year = 2021;
	
	/**
	 * constructor of round team
	 * @param round_team
	 */
	public Round_events(Round_Team round_team)
	{
		event_dates = new ArrayList<Game_Date>();
		this.round_team = round_team;
		
		if(round_team.getNum_teams() == 16)
		{
			//round 16
			event_dates.add(new Game_Date(Round_events_year, 2, 16));
			event_dates.add(new Game_Date(Round_events_year, 3, 9));
		}
		else if(round_team.getNum_teams() == 8)
		{
			//round 8
			event_dates.add(new Game_Date(Round_events_year, 4, 7));
			event_dates.add(new Game_Date(Round_events_year, 4, 13));
		}
		else if(round_team.getNum_teams() == 4)
		{
			//semi final
			event_dates.add(new Game_Date(Round_events_year, 4, 27));
			event_dates.add(new Game_Date(Round_events_year, 5, 4));
		}
		else if(round_team.getNum_teams() == 2)
		{
			//final
			event_dates.add(new Game_Date(Round_events_year, 5, 29));
		}
		
		round_events = new ArrayList<Event>();
	}

	/**
	 * getter of round_events
	 */
	@Override
	public ArrayList<Event> getGroup_events() {
		return this.round_events;
	}

	/**
	 * method generate round events
	 */
	@Override
	public void generate_events() 
	{
		
		if(round_team.getNum_teams() == 16)
		{
			//round 16
			round_events.add(new Event(round_team.club_list.get(0), round_team.club_list.get(1), event_dates.get(0)));
			round_events.add(new Event(round_team.club_list.get(2), round_team.club_list.get(3), event_dates.get(0)));
			round_events.add(new Event(round_team.club_list.get(4), round_team.club_list.get(5), event_dates.get(0)));
			round_events.add(new Event(round_team.club_list.get(6), round_team.club_list.get(7), event_dates.get(0)));
			round_events.add(new Event(round_team.club_list.get(8), round_team.club_list.get(9), event_dates.get(0)));
			round_events.add(new Event(round_team.club_list.get(10), round_team.club_list.get(11), event_dates.get(0)));
			round_events.add(new Event(round_team.club_list.get(12), round_team.club_list.get(13), event_dates.get(0)));
			round_events.add(new Event(round_team.club_list.get(14), round_team.club_list.get(15), event_dates.get(0)));
			
			round_events.add(new Event(round_team.club_list.get(1), round_team.club_list.get(0), event_dates.get(1)));
			round_events.add(new Event(round_team.club_list.get(3), round_team.club_list.get(2), event_dates.get(1)));
			round_events.add(new Event(round_team.club_list.get(5), round_team.club_list.get(4), event_dates.get(1)));
			round_events.add(new Event(round_team.club_list.get(7), round_team.club_list.get(6), event_dates.get(1)));
			round_events.add(new Event(round_team.club_list.get(9), round_team.club_list.get(8), event_dates.get(1)));
			round_events.add(new Event(round_team.club_list.get(11), round_team.club_list.get(10), event_dates.get(1)));
			round_events.add(new Event(round_team.club_list.get(13), round_team.club_list.get(12), event_dates.get(1)));
			round_events.add(new Event(round_team.club_list.get(15), round_team.club_list.get(14), event_dates.get(1)));

		}
		else if(round_team.getNum_teams() == 8)
		{
			//round 8
			round_events.add(new Event(round_team.club_list.get(0), round_team.club_list.get(1), event_dates.get(0)));
			round_events.add(new Event(round_team.club_list.get(2), round_team.club_list.get(3), event_dates.get(0)));
			round_events.add(new Event(round_team.club_list.get(4), round_team.club_list.get(5), event_dates.get(0)));
			round_events.add(new Event(round_team.club_list.get(6), round_team.club_list.get(7), event_dates.get(0)));
			
			round_events.add(new Event(round_team.club_list.get(1), round_team.club_list.get(0), event_dates.get(1)));
			round_events.add(new Event(round_team.club_list.get(3), round_team.club_list.get(2), event_dates.get(1)));
			round_events.add(new Event(round_team.club_list.get(5), round_team.club_list.get(4), event_dates.get(1)));
			round_events.add(new Event(round_team.club_list.get(7), round_team.club_list.get(6), event_dates.get(1)));

		}
		else if(round_team.getNum_teams() == 4)
		{
			//semi final
			round_events.add(new Event(round_team.club_list.get(0), round_team.club_list.get(1), event_dates.get(0)));
			round_events.add(new Event(round_team.club_list.get(2), round_team.club_list.get(3), event_dates.get(0)));
			
			round_events.add(new Event(round_team.club_list.get(1), round_team.club_list.get(0), event_dates.get(1)));
			round_events.add(new Event(round_team.club_list.get(3), round_team.club_list.get(2), event_dates.get(1)));
		}
		else if(round_team.getNum_teams() == 2)
		{
			//final
			round_events.add(new Event(round_team.club_list.get(0), round_team.club_list.get(1), event_dates.get(0)));
		}
	}

}
