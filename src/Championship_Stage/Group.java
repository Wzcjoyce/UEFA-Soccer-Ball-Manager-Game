package Championship_Stage;

import java.util.ArrayList;

import Club.Club;

/**
 * Class that hold teams in a group during group stage
 * @author Zuocheng Wang
 *
 */
public class Group {

	private String Group_name;
	private  ArrayList<Club> club_list;
	
	private Club group_1st;
	private Club group_2nd;
	private Club group_3rd;
	private Club group_4th;
	
	/**
	 * constructor of Group class
	 * @param Group_name
	 * @param club_list
	 */
	public Group(String Group_name, ArrayList<Club> club_list)
	{
		this.Group_name = Group_name;
		
		if(club_list.size() != 4)
		{
			throw new IllegalArgumentException();
		}
		this.club_list = club_list;
		
		group_1st = club_list.get(0);
		group_2nd = club_list.get(1);
		group_3rd = club_list.get(2);
		group_4th = club_list.get(3);

	}

	/**
	 * getter of group name
	 * @return Group_name String
	 */
	public String getGroup_name() {
		return Group_name;
	}

	/**
	 * getter of club Arraylist 
	 * @return ArrayList club_list
	 */
	public ArrayList<Club> getClub_list() {
		return club_list;
	}
	
	/**
	 * Get 1st of the group
	 * @return
	 */
	public Club getGroup_1st() {
		return group_1st;
	}

	/**
	 * set 1st of the group
	 * based on points and net goals
	 */
	public void set_real_Group_1st() {
		
		int highest_points = 0;
		int net_goal = 0;
		int total_goal = 0;
		
		for(Club i:this.club_list)
		{
			if(i.getGroup_points() > highest_points)
			{
				group_1st = i;
				net_goal = group_1st.getGroup_total_net_goal();
				total_goal = group_1st.getGroup_total_goal();
				highest_points = i.getGroup_points();
			}
			else if(i.getGroup_points() == highest_points && i.getGroup_total_net_goal() > net_goal)
			{
				group_1st = i;
				net_goal = group_1st.getGroup_total_net_goal();
				total_goal = group_1st.getGroup_total_goal();
			}
			else if(i.getGroup_points() == highest_points && i.getGroup_total_net_goal() == net_goal && i.getGroup_total_goal() > total_goal)
			{
				group_1st = i;
				net_goal = group_1st.getGroup_total_net_goal();
				total_goal = group_1st.getGroup_total_goal();
			}
		}
		
	}

	/**
	 * get 2nd of the group
	 * based on points and net goals
	 */
	public Club getGroup_2nd() {
		return group_2nd;
	}
	
	/**
	 * set 2nd of the group
	 * based on points and net goals
	 */
	public void set_real_Group_2nd() {
		
		ArrayList<Club> temp_club_list = new ArrayList<Club>();
		int highest_points = 0;
		int net_goal = 0;
		int total_goal = 0;
		
		for(Club j:club_list)
		{
			if(j.getClubName() != group_1st.getClubName() )
			{
				temp_club_list.add(j);
			}
		}
		
		
		for(Club i:temp_club_list)
		{
			if(i.getGroup_points() > highest_points)
			{
				group_2nd = i;
				net_goal = group_2nd.getGroup_total_net_goal();
				total_goal = group_2nd.getGroup_total_goal();
				highest_points = i.getGroup_points();
			}
			else if(i.getGroup_points() == highest_points && i.getGroup_total_net_goal() > net_goal)
			{
				group_2nd = i;
				net_goal = group_2nd.getGroup_total_net_goal();
				total_goal = group_2nd.getGroup_total_goal();
			}
			else if(i.getGroup_points() == highest_points && i.getGroup_total_net_goal() == net_goal && i.getGroup_total_goal() > total_goal)
			{
				group_2nd = i;
				net_goal = group_2nd.getGroup_total_net_goal();
				total_goal = group_2nd.getGroup_total_goal();
			}
		}
	}

	/**
	 * getter of 3rd of the group
	 */
	public Club getGroup_3rd() {
		return group_3rd;
	}
	
	
	/**
	 * setter of 3rd of the group
	 * based on points and net goals
	 */
	public void set_real_Group_3rd() {
		
		ArrayList<Club> temp_club_list = new ArrayList<Club>();
		int highest_points = 0;
		int net_goal = 0;
		int total_goal = 0;
		
		for(Club j:club_list)
		{
			if(j.getClubName() != group_1st.getClubName() && j.getClubName() != group_2nd.getClubName() )
			{
				temp_club_list.add(j);
			}
		}
		
		
		for(Club i:temp_club_list)
		{
			if(i.getGroup_points() > highest_points)
			{
				group_3rd = i;
				net_goal = group_3rd.getGroup_total_net_goal();
				total_goal = group_3rd.getGroup_total_goal();
				highest_points = i.getGroup_points();
			}
			else if(i.getGroup_points() == highest_points && i.getGroup_total_net_goal() > net_goal)
			{
				group_3rd = i;
				net_goal = group_3rd.getGroup_total_net_goal();
				total_goal = group_3rd.getGroup_total_goal();
			}
			else if(i.getGroup_points() == highest_points && i.getGroup_total_net_goal() == net_goal && i.getGroup_total_goal() > total_goal)
			{
				group_3rd = i;
				net_goal = group_3rd.getGroup_total_net_goal();
				total_goal = group_3rd.getGroup_total_goal();
			}
		}
	}

	/**
	 * getter of 4th of the group
	 */
	public Club getGroup_4th() {
		return group_4th;
	}
	
	/**
	 * setter of 4th of the group
	 * based on points and net goals
	 */
	public void set_real_Group_4th() {
		
		for(Club j:club_list)
		{
			if(j.getClubName() != group_1st.getClubName() && j.getClubName() != group_2nd.getClubName() && j.getClubName() != group_3rd.getClubName() )
			{
				group_4th = j;
			}
		}
	}


}
