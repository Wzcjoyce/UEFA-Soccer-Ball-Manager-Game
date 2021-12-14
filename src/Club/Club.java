/*
This class has to be redesigned to use the generic tree node system instead of the former system. 
I've included a backup of this file in case it is useful to you. 
You'll need to populate the body based on the module and add the requested additional functionality.
*/

package Club;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import Championship_Stage.Group;


/**
 * Club class which is for holding all club information
 * @author Zuocheng
 */
public class Club {
	
	private String ClubName;
	private Account ClubAccount;
	private String nameCEO;
	private LinkedList<Player> player_list;
	private LinkedList<Player> Overview_Starting_lineup;
	private LinkedList<Player> Starting_lineup_attacker;
	private LinkedList<Player> Starting_lineup_midfielder;
	private LinkedList<Player> Starting_lineup_defender;
	private LinkedList<Player> Starting_lineup_goalkeeper;
	private Manager club_manager;
	private Stadium stadium;
	private int Charm_level;
	
	//group_stage_variables
	public int group_points;
	public int group_win_num;
	public int group_lose_num;
	public int group_draw_num;
	public int group_total_goal;
	public int group_total_loss_goal;
	public int group_total_net_goal;
	
	
	private ArrayList<Club> group_played_opponent_list;
	private Group group_teams;
	private ArrayList<Club> group_teams_except_self;

	//round_of_16_variables
	public	int round_16_home_goals;
	public	int round_16_away_goals;
	public Club round_of_16_opponent;
	
	//round_of_8_variables
	public	int round_8_home_goals;
	public	int round_8_away_goals;
	public Club round_of_8_opponent;
	
	//round_semi_final_variables
	public int semi_final_home_goals;
	public	int semi_final_away_goals;
	public Club semi_final_opponent;
	
	//final_variables
	public int final_goals;
	public Club final_opponent;
	
	// matchup schedule LinkedList
	public LinkedList<Club> match_schedule;
	public Club next_opponent;
	
	/**
	 * Constructor of Club class
	 * @param ClubName
	 * @param ClubAccount
	 * @param nameCEO
	 * @param stadium
	 * @param Charm_level
	 */
	public Club(String ClubName, Account ClubAccount, String nameCEO, Stadium stadium, int Charm_level)  // 1-6
	{
		this.ClubName = ClubName;
		this.ClubAccount = ClubAccount;
		this.nameCEO = nameCEO;
		this.club_manager = null;
		player_list = new LinkedList<Player>();
		this.stadium = stadium;
		this.Charm_level = Charm_level;
		Overview_Starting_lineup = new LinkedList<Player>();
		Starting_lineup_attacker = new LinkedList<Player>();
		Starting_lineup_midfielder = new LinkedList<Player>();
		Starting_lineup_defender = new LinkedList<Player>();
		Starting_lineup_goalkeeper = new LinkedList<Player>();
		
		//group_stage_variables
		group_points = 0;
		group_win_num = 0;
		group_lose_num = 0;
		group_draw_num = 0;
		group_total_goal = 0;
		group_total_loss_goal = 0;
		group_total_net_goal = 0;
		group_played_opponent_list = new ArrayList<Club>();
		
		//round_of_16_variables
		round_16_home_goals = 0;
		round_16_away_goals = 0;
		
		//round_of_8_variables
		round_8_home_goals = 0;
		round_8_away_goals = 0;
		
		//round_semi_final_variables
		semi_final_home_goals = 0;
		semi_final_away_goals = 0;
		
		this.final_goals = 0;
		

	}
	
	/**
	 * getter of club's number of draw game in group
	 * @return int
	 */
	public int getGroup_draw_num() {
		return group_draw_num;
	}

	/**
	 * setter of club's number of draw game in group
	 */
	public void setGroup_draw_num(int group_draw_num) {
		this.group_draw_num = group_draw_num;
	}

	/**
	 * getter of club's opponent list
	 * @return ArrayList
	 */
	public ArrayList<Club> getGroup_played_opponent_list() {
		return group_played_opponent_list;
	}

	/**
	 * setter of club's opponent list
	 */
	public void setGroup_played_opponent_list(ArrayList<Club> group_played_opponent_list) {
		this.group_played_opponent_list = group_played_opponent_list;
	}

	/**
	 * getter of club's opponent list
	 * @return ArrayList
	 */
	public Club getRound_of_16_opponent() {
		return round_of_16_opponent;
	}

	/**
	 * setter of club's opponent list round of 16
	 */
	public void setRound_of_16_opponent(Club round_of_16_opponent) {
		this.round_of_16_opponent = round_of_16_opponent;
	}

	/**
	 * getter of club's opponent list round of 8
	 * @return ArrayList
	 */
	public Club getRound_of_8_opponent() {
		return round_of_8_opponent;
	}

	/**
	 * setter of club's opponent list round of 8
	 */
	public void setRound_of_8_opponent(Club round_of_8_opponent) {
		this.round_of_8_opponent = round_of_8_opponent;
	}

	/**
	 * getter of club's opponent list semi final
	 * @return ArrayList
	 */
	public Club getSemi_final_opponent() {
		return semi_final_opponent;
	}

	/**
	 * setter of club's opponent list semi final
	 */
	public void setSemi_final_opponent(Club semi_final_opponent) {
		this.semi_final_opponent = semi_final_opponent;
	}

	/**
	 * getter of club's opponent list final
	 * @return Club
	 */
	public Club getFinal_opponent() {
		return final_opponent;
	}

	/**
	 * setter of club's opponent list final
	 */
	public void setFinal_opponent(Club final_opponent) {
		this.final_opponent = final_opponent;
	}

	/**
	 * getter of club's point in group stage
	 * @return int
	 */
	public int getGroup_points() {
		return group_points;
	}

	/**
	 * setter of club's point in group stage
	 */
	public void setGroup_points(int group_points) {
		this.group_points = group_points;
	}

	/**
	 * getter of club's number of win
	 * @return int
	 */
	public int getGroup_win_num() {
		return group_win_num;
	}

	/**
	 * setter of club's number of win
	 */
	public void setGroup_win_num(int group_win_num) {
		this.group_win_num = group_win_num;
	}

	/**
	 * getter of club's number of lose
	 * @return int
	 */
	public int getGroup_lose_num() {
		return group_lose_num;
	}

	/**
	 * setter of club's number of lose
	 */
	public void setGroup_lose_num(int group_lose_num) {
		this.group_lose_num = group_lose_num;
	}

	/**
	 * getter of club's total goal
	 * @return int
	 */
	public int getGroup_total_goal() {
		return group_total_goal;
	}

	/**
	 * setter of club's total goal
	 */
	public void setGroup_total_goal(int group_total_goal) {
		this.group_total_goal = group_total_goal;
	}

	/**
	 * getter of club's total loss goal
	 * @return int
	 */
	public int getGroup_total_loss_goal() {
		return group_total_loss_goal;
	}

	/**
	 * setter of group total loss goal
	 * @param group_total_loss_goal
	 */
	public void setGroup_total_loss_goal(int group_total_loss_goal) {
		this.group_total_loss_goal = group_total_loss_goal;
	}

	/**
	 * getter of group total net goal
	 */
	public int getGroup_total_net_goal() {
		return group_total_net_goal;
	}

	/**
	 * setter of group total net goal
	 * @param group_total_net_goal
	 */
	public void setGroup_total_net_goal(int group_total_net_goal) {
		this.group_total_net_goal = group_total_net_goal;
	}

	/**
	 * getter of round 16 home goal
	 */
	public int getRound_16_home_goals() {
		return round_16_home_goals;
	}

	/**
	 * setter of round of 16 home goals
	 * @param round_16_home_goals
	 */
	public void setRound_16_home_goals(int round_16_home_goals) {
		this.round_16_home_goals = round_16_home_goals;
	}

	/**
	 * getter of round 16 away goal
	 */
	public int getRound_16_away_goals() {
		return round_16_away_goals;
	}

	/**
	 * setter of round of 16 away goals
	 * @param round_16_away_goals
	 */
	public void setRound_16_away_goals(int round_16_away_goals) {
		this.round_16_away_goals = round_16_away_goals;
	}

	/**
	 * getter of round 8 home goal
	 */
	public int getRound_8_home_goals() {
		return round_8_home_goals;
	}

	/**
	 * setter of round of 8 home goals
	 * @param round_8_home_goals
	 */
	public void setRound_8_home_goals(int round_8_home_goals) {
		this.round_8_home_goals = round_8_home_goals;
	}

	/**
	 * getter of round 8 away goal
	 */
	public int getRound_8_away_goals() {
		return round_8_away_goals;
	}

	/**
	 * setter of round of 8 away goals
	 * @param round_8_away_goals
	 */
	public void setRound_8_away_goals(int round_8_away_goals) {
		this.round_8_away_goals = round_8_away_goals;
	}


	/**
	 * getter of semi final home goal
	 */
	public int getSemi_final_home_goals() {
		return semi_final_home_goals;
	}

	/**
	 * setter of semi final home goals
	 * @param semi_final_home_goals
	 */
	public void setSemi_final_home_goals(int semi_final_home_goals) {
		this.semi_final_home_goals = semi_final_home_goals;
	}

	/**
	 * getter of semi final away goal
	 */
	public int getSemi_final_away_goals() {
		return semi_final_away_goals;
	}

	/**
	 * setter of final away goal
	 * @param semi_final_away_goals
	 */
	public void setSemi_final_away_goals(int semi_final_away_goals) {
		this.semi_final_away_goals = semi_final_away_goals;
	}

	/**
	 * override toString method
	 * @return String 
	 */
	@Override
	public String toString()
	{

		return "Club Name: " + ClubName + "\n" +
				"Club Balance available for transfer: " + ClubAccount.getBalance() + " €\n" +
				"CEO: " + nameCEO + "\n" +
				"Stadium: " + stadium + "\n";
	}
	
	/**
	 * get detailed team string information
	 * @return String
	 */
	public String toDetailedString()
	{
		return "Club: " + ClubName+
				"\nBalance for transfer: " + ClubAccount.toString() + " €\n" +
				stadium + "\nFormation: " + this.getTeamFormationString()
				+"\nTactical: " + this.getTeamTactics().toString();
	}

	/**
	 * getter of team charm level
	 */
	public int getCharm_level() {
		return Charm_level;
	}


	/**
	 * setter of charm level
	 * @param charm_level
	 */
	public void setCharm_level(int charm_level) {
		Charm_level = charm_level;
	}

	/**
	 * getter of team stadium composition
	 * @return Stadium 
	 */
	public Stadium getStadium() {
		return stadium;
	}


	/**
	 * addPlayer takes one argument
	 * @param newEmployee
	 */
	public void addPlayer(Player newEmployee)
	{
		player_list.add(newEmployee);
	}
	
	/**
	 * remove Player
	 * @param Employee
	 */
	public void removePlayer(Player Employee)
	{
		player_list.remove(Employee);
	}
	
	/**
	 * addManager takes one argument
	 * @param newEmployee
	 */
	public void addManager(Manager newEmployee)
	{
		this.club_manager = newEmployee;
	}
	
	
	/**
	 * removeManager takes one argument
	 * @param Employee
	 */
	public void removeManager(Manager Employee)
	{
		player_list.remove(Employee);
	}
	

	/**
	 * getter of club name
	 * @return string name of club
	 */
	public String getClubName() {
		return ClubName;
	}

	/**
	 * getter of club account object
	 * @return Account
	 */
	public Account getClubAccount() {
		return ClubAccount;
	}

	/**
	 * setter of club account
	 * @param clubAccount
	 */
	public void setClubAccount(Account clubAccount) {
		ClubAccount = clubAccount;
	}

	/**
	 * getter of CEO name
	 * @return String
	 */
	public String getNameCEO() {
		return nameCEO;
	}

	/**
	 * setter of CEO name
	 * @param nameCEO
	 */
	public void setNameCEO(String nameCEO) {
		this.nameCEO = nameCEO;
	}

	/**
	 * setter of club name
	 * @param clubName
	 */
	public void setClubName(String clubName) {
		ClubName = clubName;
	}


	/**
	 * getter of club's player linked list
	 * @return
	 */
	public LinkedList<Player> getPlayer_LinkedList() {
		return player_list;
	}
	
	/**
	 * getter of Player name list
	 * @return String array
	 */
	public String[] getPlayer_NameList() {
		List<String> NameList = new ArrayList<String>();
		
		for (int i = 0; i < (int)this.getTeamSize(); i++)
		{
			NameList.add(player_list.get(i).getName());
		}
		
		String[] stringArray = NameList.toArray(new String[0]);
		
		return stringArray;
	}
	
	/**
	 * method for get player based on player name
	 * @param name
	 * @return Player
	 */
	public Player getPlayer(String name) {
		List temp_player_list = (List) player_list.stream().filter(e->(e.getName() == name)).collect(Collectors.toList());
		return (Player) temp_player_list.get(0);
	}


	public void setPlayer_list(LinkedList<Player> player_list) {
		this.player_list = player_list;
	}


	/**
	 * method for get Manager
	 * @return Manager
	 */
	public Manager getClub_manager() {
		return club_manager;
	}


	public void setClub_manager(Manager club_manager) {
		this.club_manager = club_manager;
	}
	
	/**
	 * print Player method
	 */
	public void printPlayers()
	{
		for (Player i:player_list)
		{
			System.out.println(i.getName());
		}
	}
	
	/**
	 * Print Player position Name list method
	 * @return String
	 */
	public String PlayerPositionNameList(PlayerField field)
	{
		String temp = "";
		for (Player i:player_list)
		{
			if(field == i.getBest_position())
			{temp += i.getShirt_Number() +". "  + i.getName() + "      ";}
		}
		
		return temp;
	}
	
	/**
	 * Print attacker position Name list method
	 * @return String
	 */
	public String Print_PlayerPosition_attacker_LineUp_NameList()
	{
		String temp = "";
		for (Player i:this.getDefault_Starting_lineup_attacker())
		{
			temp += + i.getShirt_Number() +". "  + i.getName() + "      ";
		}
		
		return temp;
	}
	
	/**
	 * Print current attacker position Name list method
	 * @return String
	 */
	public String Print_current_PlayerPosition_attacker_LineUp_NameList()
	{
		String temp = "";
		for (Player i:this.Starting_lineup_attacker)
		{
			temp += i.getShirt_Number() +". "  + i.getName() + "      ";
		}
		
		return temp;
	}
	
	
	/**
	 * Print midfielder position Name list method
	 * @return String
	 */
	public String Print_PlayerPosition_midfielder_LineUp_NameList()
	{
		String temp = "";
		for (Player i:this.getDefault_Starting_lineup_midfielder())
		{
			temp += i.getShirt_Number() +". "  + i.getName() + "      ";
		}
		
		return temp;
	}
	
	/**
	 * Print current midfielder position Name list method
	 * @return String
	 */
	public String Print_current_PlayerPosition_midfielder_LineUp_NameList()
	{
		String temp = "";
		for (Player i:this.Starting_lineup_midfielder)
		{
			temp += i.getShirt_Number() +". "  + i.getName() + "      ";
		}
		
		return temp;
	}
	
	
	/**
	 * Print  defender position Name list method
	 * @return String
	 */
	public String Print_PlayerPosition_defender_LineUp_NameList()
	{
		String temp = "";
		for (Player i:this.getDefault_Starting_lineup_defender())
		{
			temp += i.getShirt_Number() +". "  + i.getName() + "      ";
		}
		
		return temp;
	}
	
	/**
	 * Print current defender position Name list method
	 * @return String
	 */
	public String Print_current_PlayerPosition_defender_LineUp_NameList()
	{
		String temp = "";
		for (Player i:this.Starting_lineup_defender)
		{
			temp += i.getShirt_Number() +". "  + i.getName() + "      ";
		}
		
		return temp;
	}
	
	
	/**
	 * Print goalkeeper position Name list method
	 * @return String
	 */
	public String Print_PlayerPosition_goalkeeper_LineUp_NameList()
	{
		String temp = "";
		for (Player i:this.getDefault_Starting_lineup_goalkeeper())
		{
			temp += i.getShirt_Number() +". "  + i.getName() + "      ";
		}
		
		return temp;
	}
	
	/**
	 * Print current goalkeeper position Name list method
	 * @return String
	 */
	public String Print_current_PlayerPosition_goalkeeper_LineUp_NameList()
	{
		String temp = "";
		for (Player i:this.Starting_lineup_goalkeeper)
		{
			temp += i.getShirt_Number() +". "  + i.getName() + "      ";
		}
		
		return temp;
	}
	
	/**
	 * getter of player name list
	 * @return String
	 */
	public String PlayerNameList()
	{
		String temp = "";
		for (Player i:player_list)
		{
			temp += i.getShirt_Number() +"." + i.getName() + "      ";
		}
		
		return temp;
	}
	
	
	/**
	 * get total annual pay including players and manager
	 * @return double total annual
	 */
	public double getTotalAnnualPay()
	{
		double players_pay = 0;
		
		for (Player i:player_list)
		{
			players_pay += i.getAnnualPay();
		}
		
		return players_pay;
	}
	
	/**
	 * getter of team size
	 * @return int size of team (number of player)
	 */
	public double getTeamSize()
	{
		return this.player_list.size();
	}
	
	/**
	 * class which sort the player list based on given attribute
	 * @param attribute_name String name of skill
	 * @return List sorted list of player
	 */
	public List<Player> sortPlayerbyAttribute(String attribute_name)
	{
		if (attribute_name == "Shooting Skill")
		{
			return this.player_list.stream().sorted(Comparator.comparing(p -> p.getShooting_skill())).collect(Collectors.toList());
		}
		else if (attribute_name == "Dribbling Skill")
		{
			return this.player_list.stream().sorted(Comparator.comparing(p -> p.getDribbling_skill())).collect(Collectors.toList());
		}
		else if (attribute_name == "Passing Skill")
		{
			return this.player_list.stream().sorted(Comparator.comparing(p -> p.getPassing_skill())).collect(Collectors.toList());
		}
		else if (attribute_name == "Intercept Skill")
		{
			return this.player_list.stream().sorted(Comparator.comparing(p -> p.getIntercept_skill())).collect(Collectors.toList());
		}
		else if (attribute_name == "Stealing Skill")
		{
			return this.player_list.stream().sorted(Comparator.comparing(p -> p.getStealing_skill())).collect(Collectors.toList());
		}
		else if (attribute_name == "Goalkeeper Skill")
		{
			return this.player_list.stream().sorted(Comparator.comparing(p -> p.getGoalkeeper_skill())).collect(Collectors.toList());
		}
		else if (attribute_name == "Age")
		{
			return this.player_list.stream().sorted(Comparator.comparing(p -> p.getAge())).collect(Collectors.toList());
		}
		else if (attribute_name == "Pay")
		{
			return this.player_list.stream().sorted(Comparator.comparing(p -> ((AbstractEmployee) p).getAnnualPay())).collect(Collectors.toList());
		}
		else if (attribute_name == "Value")
		{
			return this.player_list.stream().sorted(Comparator.comparing(p -> p.getValue())).collect(Collectors.toList());
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * update account after money spent
	 * @param spent
	 */
	public void updateBalance_spent(double spent)
	{
		this.getClubAccount().decreaseBalance(spent);
	}
	
	/**
	 * update account after money earn
	 * @param earn
	 */
	public void updateBalance_earn(double earn)
	{
		this.getClubAccount().increaseBalance(earn);
	}
	
	
	/**
	 * getter of team tactics
	 */
	public Tactics getTeamTactics()
	{
		return this.club_manager.getTactics();
	}
	
	/**
	 * getter of team formation in String
	 * @return String
	 */
	public String getTeamFormationString()
	{
		return this.club_manager.getDefender_num() + "-" + this.club_manager.getMidfielder_num() + "-" + this.club_manager.getAttacker_num();
	}
	
	/**
	 * getter of default attacker starting lineup
	 * @return LinkedList
	 */
	public LinkedList<Player> getDefault_Starting_lineup_attacker()
	{
		 List<Player> sorted_list = sortPlayerbyAttribute("Shooting Skill");
		 int size = sorted_list.size();
		 int num_attackers = this.getClub_manager().getAttacker_num();
		 
		 Starting_lineup_attacker = new LinkedList<Player>();
		 
		 for(int i = 0; i < size; i++)
		 {
			 if(!( Starting_lineup_attacker.contains(sorted_list.get(size - (i + 1)))
					 ||Starting_lineup_defender.contains(sorted_list.get(size - (i + 1)))
					 ||   Starting_lineup_midfielder.contains(sorted_list.get(size - (i + 1))) ))
			 {
				 if (Starting_lineup_attacker.size() < num_attackers) 
				 {
					 Starting_lineup_attacker.add(sorted_list.get(size - (i + 1)));
				 }
			 }
		 }
		 
		 return Starting_lineup_attacker;
	}
	
	/**
	 * getter of default midfielder starting lineup
	 * @return LinkedList
	 */
	public LinkedList<Player> getDefault_Starting_lineup_midfielder()
	{
		 List<Player> sorted_list = sortPlayerbyAttribute("Dribbling Skill");
		 int size = sorted_list.size();
		 int num_midfielder = this.getClub_manager().getMidfielder_num();
		 
		 
		 Starting_lineup_midfielder.clear();
		 
		 for(int i = 0; i < size; i++)
		 {
			 if(!(Starting_lineup_attacker.contains(sorted_list.get(size - (i + 1)))
					 ||Starting_lineup_defender.contains(sorted_list.get(size - (i + 1)))
					 || Starting_lineup_midfielder.contains(sorted_list.get(size - (i + 1))) ))
			 {
				 if (Starting_lineup_midfielder.size() < num_midfielder) 
				 {
					 
					 Starting_lineup_midfielder.add(sorted_list.get(size - (i + 1)));
				 }
			 }
		}
		 
		 return Starting_lineup_midfielder;
	}
	
	/**
	 * getter of default defender starting lineup
	 * @return LinkedList
	 */
	public LinkedList<Player> getDefault_Starting_lineup_defender()
	{
		 List<Player> sorted_list = sortPlayerbyAttribute("Stealing Skill");
		 int size = sorted_list.size();
		 int num_defender = this.getClub_manager().getDefender_num();
		 
		 Starting_lineup_defender.clear();
		 
		 for(int i = 0; i < size; i++)
		 {
			 if(!(    Starting_lineup_attacker.contains(sorted_list.get(size - (i + 1)))
					 ||Starting_lineup_defender.contains(sorted_list.get(size - (i + 1)))
					 ||   Starting_lineup_midfielder.contains(sorted_list.get(size - (i + 1))) ))
			 {
				 if (Starting_lineup_defender.size() < num_defender )
				 {
					 Starting_lineup_defender.add(sorted_list.get(size - (i + 1)));
				 }
			 }
		 }
		 
		 return Starting_lineup_defender;
	}
	
	/**
	 * getter of default goalkeeper starting lineup
	 * @return LinkedList
	 */
	public LinkedList<Player> getDefault_Starting_lineup_goalkeeper()
	{
		 List<Player> sorted_list = sortPlayerbyAttribute("Goalkeeper Skill");
		 int size = sorted_list.size();
		 
		 Starting_lineup_goalkeeper.clear();
		 Starting_lineup_goalkeeper.add(sorted_list.get(size - 1));
		 
		 Starting_lineup_goalkeeper.get(0).setBest_position(PlayerField.goalkeeper);
		 return Starting_lineup_goalkeeper;
	}
	
	
	/**
	 * getter of default overview starting lineup
	 * @return LinkedList
	 */
	public LinkedList<Player> getDefault_Overview_Starting_lineup()
	{
		for (Player i:Starting_lineup_goalkeeper)
		{
			Overview_Starting_lineup.add(i);
		}
		for (Player i:Starting_lineup_defender)
		{
			Overview_Starting_lineup.add(i);
		}
		for (Player i:Starting_lineup_midfielder)
		{
			Overview_Starting_lineup.add(i);
		}
		for (Player i:Starting_lineup_attacker)
		{
			Overview_Starting_lineup.add(i);
		}
		
		return Overview_Starting_lineup;
	}
	
	/**
	 * getter of current overview starting lineup
	 * @return LinkedList
	 */
	public LinkedList<Player> getOverview_Starting_lineup() {
		return Overview_Starting_lineup;
	}

	/**
	 * getter of current attacker starting lineup
	 * @return LinkedList
	 */
	public LinkedList<Player> getStarting_lineup_attacker() {
		return Starting_lineup_attacker;
	}

	/**
	 * getter of current midfielder starting lineup
	 * @return LinkedList
	 */
	public LinkedList<Player> getStarting_lineup_midfielder() {
		return Starting_lineup_midfielder;
	}

	/**
	 * getter of current defender starting lineup
	 * @return LinkedList
	 */
	public LinkedList<Player> getStarting_lineup_defender() {
		return Starting_lineup_defender;
	}

	/**
	 * getter of current goalkeeper starting lineup
	 * @return LinkedList
	 */
	public LinkedList<Player> getStarting_lineup_goalkeeper() {
		return Starting_lineup_goalkeeper;
	}
	
	/**
	 * class for adding attacker to staring lineup
	 * @param player_name
	 */
	public void add_to_Attacker_LineUp(String player_name)
	{
		if (Starting_lineup_attacker.size() == this.getClub_manager().getAttacker_num())
		{
			Starting_lineup_attacker.clear();
		}
		
		Player selected_player = this.getPlayer(player_name);
		

		
		if(!Starting_lineup_attacker.contains(selected_player))
		{
			Starting_lineup_attacker.add(selected_player);
		}
		
		if(Starting_lineup_midfielder.contains(selected_player))
		{
			Starting_lineup_midfielder.remove(selected_player);
		}
		
		if(Starting_lineup_defender.contains(selected_player))
		{
			Starting_lineup_defender.remove(selected_player);
		}
		
		if(Starting_lineup_goalkeeper.contains(selected_player))
		{
			Starting_lineup_goalkeeper.remove(selected_player);
		}
		
	}
	
	/**
	 * class for adding midfielder to staring lineup
	 * @param player_name
	 */
	public void add_to_Midfielder_LineUp(String player_name)
	{
		if (Starting_lineup_midfielder.size() == this.getClub_manager().getMidfielder_num())
		{
			Starting_lineup_midfielder.clear();
		}
		
		Player selected_player = this.getPlayer(player_name);
		
		
		if(!Starting_lineup_midfielder.contains(selected_player))
		{
			Starting_lineup_midfielder.add(selected_player);
		}
		
		if(Starting_lineup_attacker.contains(selected_player))
		{
			Starting_lineup_attacker.remove(selected_player);
		}
		
		if(Starting_lineup_defender.contains(selected_player))
		{
			Starting_lineup_defender.remove(selected_player);
		}
		
		if(Starting_lineup_goalkeeper.contains(selected_player))
		{
			Starting_lineup_goalkeeper.remove(selected_player);
		}
	}
	
	/**
	 * class for adding defender to staring lineup
	 * @param player_name
	 */
	public void add_to_Defender_LineUp(String player_name)
	{
		if (Starting_lineup_defender.size() == this.getClub_manager().getDefender_num())
		{
			Starting_lineup_defender.clear();
		}
		
		Player selected_player = this.getPlayer(player_name);
		
		
		if(!Starting_lineup_defender.contains(selected_player))
		{
			Starting_lineup_defender.add(selected_player);
		}
		
		if(Starting_lineup_attacker.contains(selected_player))
		{
			Starting_lineup_attacker.remove(selected_player);
		}
		
		if(Starting_lineup_midfielder.contains(selected_player))
		{
			Starting_lineup_midfielder.remove(selected_player);
		}
		
		if(Starting_lineup_goalkeeper.contains(selected_player))
		{
			Starting_lineup_goalkeeper.remove(selected_player);
		}
	}
	
	/**
	 * class for adding goalkeeper to staring lineup
	 * @param player_name
	 */
	public void add_to_goalkeeper_LineUp(String player_name)
	{
		if (Starting_lineup_goalkeeper.size() == 1)
		{
			Starting_lineup_goalkeeper.clear();
		}
		
		Player selected_player = this.getPlayer(player_name);
		
		if(!Starting_lineup_goalkeeper.contains(selected_player))
		{
			Starting_lineup_goalkeeper.add(selected_player);
		}
		
		if(Starting_lineup_attacker.contains(selected_player))
		{
			Starting_lineup_attacker.remove(selected_player);
		}
		
		if(Starting_lineup_midfielder.contains(selected_player))
		{
			Starting_lineup_midfielder.remove(selected_player);
		}
		
		if(Starting_lineup_defender.contains(selected_player))
		{
			Starting_lineup_defender.remove(selected_player);
		}
	}
	
	/**
	 * getter of group 
	 * @return Group
	 */
	public Group getGroup_teams() {
		return group_teams;
	}

	/**
	 * setter of group 
	 */
	public void setGroup_teams(Group group_teams) {
		this.group_teams = group_teams;
	}
	
	/**
	 * setter of group except self
	 */
	public void setGroup_teams_except_self()
	{
		ArrayList<Club> temp_club_list = new ArrayList<Club>();
		
		for(Club i:this.group_teams.getClub_list())
		{
			if(i.getClubName() != this.getClubName())
			{
				temp_club_list.add(i);
			}
		}
		
		group_teams_except_self = temp_club_list;
	}

}
