package Schedule;

import java.util.ArrayList;

import Championship_Stage.Group;
import Club.Club;
import soccer_manager.GameController;
import soccer_manager.Game_Date;

/**
 * Class for storing all group events variables
 * @author Zuocheng Wang
 *
 */
public class Group_events implements Events {
	
	public ArrayList<Event> group_events;
	public ArrayList<Game_Date> event_dates;
	public Group group;
	public static int Group_events_year = 2020;
	
	/**
	 * group events constructor
	 * @param group
	 */
	public Group_events(Group group)
	{
		event_dates = new ArrayList<Game_Date>();
		
		event_dates.add(new Game_Date(Group_events_year, 11, 5)); // 1 2
		event_dates.add(new Game_Date(Group_events_year, 10, 21)); // 1 3
		event_dates.add(new Game_Date(Group_events_year, 12, 9)); // 1 4
		
		
		event_dates.add(new Game_Date(Group_events_year, 11, 25)); // 2 1
		event_dates.add(new Game_Date(Group_events_year, 12, 9)); // 2 3
		event_dates.add(new Game_Date(Group_events_year, 10, 21)); // 2 4
		
		
		event_dates.add(new Game_Date(Group_events_year, 12, 3)); // 3 1
		event_dates.add(new Game_Date(Group_events_year, 10, 29)); // 3 2
		event_dates.add(new Game_Date(Group_events_year, 11, 5)); // 3 4
		
		event_dates.add(new Game_Date(Group_events_year, 10, 29)); // 4 1
		event_dates.add(new Game_Date(Group_events_year, 12, 3)); // 4 2
		event_dates.add(new Game_Date(Group_events_year, 11, 25)); // 4 3
		
		group_events = new ArrayList<Event>();
		
		this.group = group;
	}
	
	/**
	 * getter of group events Arraylist
	 * @return ArrayList
	 */
	public ArrayList<Event> getGroup_events() {
		return group_events;
	}

	/**
	 * method which generate group events
	 */
	public void generate_events()
	{
		int counter = 0;
		
		for(Club i:group.getClub_list())
		{
			for(Club j:group.getClub_list())
			{
				if(! (i.getClubName()).equals(j.getClubName()))
				{
					group_events.add(new Event(i, j, event_dates.get(counter)));
					counter++;
				}
			}
		}
	}

}
 