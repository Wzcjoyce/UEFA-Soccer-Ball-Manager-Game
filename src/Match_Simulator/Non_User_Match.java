package Match_Simulator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import Club.Club;
import Club.Player;
import Club.Tactics;
import soccer_manager.Clubs;
import soccer_manager.GameController;

/**
 * class for simulate non_user controlled game between two clubs
 * @author Zuocheng Wang
 *
 */
public class Non_User_Match {
	
	public Club Home_team;
	public Club Away_team;
	
	private LinkedList<Player> Home_midfielders;
	private LinkedList<Player> Home_attackers;
	private LinkedList<Player> Home_defenders;
	private LinkedList<Player> Home_goalkeeper;
	
	private int Home_midfielder_mean_passing;
	private int Home_midfielder_mean_dribble;
	private int Home_midfielder_mean_shooting;
	private int Home_midfielder_mean_intercept;
	private int Home_midfielder_mean_stealing;
	
	private int Away_midfielder_mean_passing;
	private int Away_midfielder_mean_dribble;
	private int Away_midfielder_mean_shooting;
	private int Away_midfielder_mean_intercept;
	private int Away_midfielder_mean_stealing;
	
	private int Away_attacker_mean_passing;
	private int Away_attacker_mean_dribble;
	private int Away_attacker_mean_shooting;
	private int Away_attacker_mean_intercept;
	private int Away_attacker_mean_stealing;
	
	private int Home_attacker_mean_passing;
	private int Home_attacker_mean_dribble;
	private int Home_attacker_mean_shooting;
	private int Home_attacker_mean_intercept;
	private int Home_attacker_mean_stealing;
	
	private int Away_defender_mean_passing;
	private int Away_defender_mean_dribble;
	private int Away_defender_mean_shooting;
	private int Away_defender_mean_intercept;
	private int Away_defender_mean_stealing;
	
	private int Home_defender_mean_passing;
	private int Home_defender_mean_dribble;
	private int Home_defender_mean_shooting;
	private int Home_defender_mean_intercept;
	private int Home_defender_mean_stealing;
	
	private int Home_goalkeeper_skill;
	private int Away_goalkeeper_skill;

	private LinkedList<Player> Away_midfielders;
	private LinkedList<Player> Away_attackers;
	private LinkedList<Player> Away_defenders;
	private LinkedList<Player> Away_goalkeeper;
	
	private Tactics Home_tactics;
	private Tactics Away_tactics;
	
	private int Home_num_attacker;
	private int Away_num_attacker;
	private int Home_num_midfielder;
	private int Away_num_midfielder;
	private int Home_num_defender;
	private int Away_num_defender;
	
	private int Home_passing_tactic_factor;
	private int Home_dribble_tactic_factor; 
	private int Home_shooting_tactic_factor; 
	private int Home_intercept_tactic_factor; 
	private int Home_stealing_tactic_factor;
	private int Home_goalkeeper_tactic_factor;
	
	private int Away_passing_tactic_factor;
	private int Away_dribble_tactic_factor; 
	private int Away_shooting_tactic_factor; 
	private int Away_intercept_tactic_factor; 
	private int Away_stealing_tactic_factor;
	private int Away_goalkeeper_tactic_factor;
	
	public int home_goal;
	public int away_goal;
	
	int home_passing_minimal_requirement;
	int home_dribble_minimal_requirement;
	int home_passing_dribble_threshold;
	int away_passing_minimal_requirement;
	int away_dribble_minimal_requirement;
	int away_passing_dribble_threshold;
	
	public LinkedList<Player> score_player_list;
	public LinkedList<Integer> score_player_list_score_num;
	public LinkedList<Club> score_player_club_list;
	
	/*
	// TODO Non_user match simulator test
	public static void main(String[] args) {
		
		GameController controller = new GameController();
		
		Club team1 = controller.UEFA.getClub("Bayern Munich");
		Club team2 = controller.UEFA.getClub("Red Bull Salzburg");
		
		team1.getDefault_Starting_lineup_defender();
		team1.getDefault_Starting_lineup_attacker();
		team1.getDefault_Starting_lineup_midfielder();
		team1.getDefault_Starting_lineup_goalkeeper();
		
		team2.getDefault_Starting_lineup_defender();
		team2.getDefault_Starting_lineup_attacker();
		team2.getDefault_Starting_lineup_midfielder();
		team2.getDefault_Starting_lineup_goalkeeper();
		
		Non_User_Match match = new Non_User_Match(team1, team2);
		
		match.match_simulator();
		System.out.println("result score: " +  match.home_goal + " : " + match.away_goal);
	}*/

	/**
	 * getter of home goal
	 * @return int
	 */
	public int getHome_goal() {
		return home_goal;
	}

	/**
	 * getter of away goal
	 * @return int
	 */
	public int getAway_goal() {
		return away_goal;
	}

	/**
	 * constructor of Non_User_Match class
	 * @param Home_team
	 * @param Away_team
	 */
	public Non_User_Match(Club Home_team, Club Away_team)
	{
		this.Home_team = Home_team;
		this.Away_team = Away_team;
		
		this.Home_midfielders = this.Home_team.getStarting_lineup_midfielder();
		this.Home_attackers = this.Home_team.getStarting_lineup_attacker();
		this.Home_defenders = this.Home_team.getStarting_lineup_defender();
		this.Home_goalkeeper = this.Home_team.getStarting_lineup_goalkeeper();
		
		this.Away_midfielders = this.Away_team.getStarting_lineup_midfielder();
		this.Away_attackers = this.Away_team.getStarting_lineup_attacker();
		this.Away_defenders = this.Away_team.getStarting_lineup_defender();
		this.Away_goalkeeper = this.Away_team.getStarting_lineup_goalkeeper();
		
		Home_tactics = this.Home_team.getTeamTactics();
		Away_tactics = this.Away_team.getTeamTactics();
		
		Home_num_attacker = this.Home_team.getClub_manager().getAttacker_num();
		Away_num_attacker = this.Away_team.getClub_manager().getAttacker_num();
		
		Home_num_midfielder = this.Home_team.getClub_manager().getMidfielder_num();
		Away_num_midfielder = this.Away_team.getClub_manager().getMidfielder_num();
		
		Home_num_defender = this.Home_team.getClub_manager().getDefender_num();
		Away_num_defender = this.Away_team.getClub_manager().getDefender_num();
		
		Home_midfielder_mean_passing = (int) Home_team.getStarting_lineup_midfielder().stream().mapToInt(p->p.getPassing_skill()).average().getAsDouble();
		Home_midfielder_mean_dribble = (int) Home_team.getStarting_lineup_midfielder().stream().mapToInt(p->p.getDribbling_skill()).average().getAsDouble();
		Home_midfielder_mean_shooting = (int) Home_team.getStarting_lineup_midfielder().stream().mapToInt(p->p.getShooting_skill()).average().getAsDouble();
		Home_midfielder_mean_intercept = (int) Home_team.getStarting_lineup_midfielder().stream().mapToInt(p->p.getIntercept_skill()).average().getAsDouble();
		Home_midfielder_mean_stealing = (int) Home_team.getStarting_lineup_midfielder().stream().mapToInt(p->p.getStealing_skill()).average().getAsDouble();
		
		Home_attacker_mean_passing = (int) Home_team.getStarting_lineup_attacker().stream().mapToInt(p->p.getPassing_skill()).average().getAsDouble();
		Home_attacker_mean_dribble = (int) Home_team.getStarting_lineup_attacker().stream().mapToInt(p->p.getDribbling_skill()).average().getAsDouble();
		Home_attacker_mean_shooting = (int) Home_team.getStarting_lineup_attacker().stream().mapToInt(p->p.getShooting_skill()).average().getAsDouble();
		Home_attacker_mean_intercept = (int) Home_team.getStarting_lineup_attacker().stream().mapToInt(p->p.getIntercept_skill()).average().getAsDouble();
		Home_attacker_mean_stealing = (int) Home_team.getStarting_lineup_attacker().stream().mapToInt(p->p.getStealing_skill()).average().getAsDouble();
		
		Home_defender_mean_passing = (int) Home_team.getStarting_lineup_defender().stream().mapToInt(p->p.getPassing_skill()).average().getAsDouble();
		Home_defender_mean_dribble = (int) Home_team.getStarting_lineup_defender().stream().mapToInt(p->p.getDribbling_skill()).average().getAsDouble();
		Home_defender_mean_shooting = (int) Home_team.getStarting_lineup_defender().stream().mapToInt(p->p.getShooting_skill()).average().getAsDouble();
		Home_defender_mean_intercept = (int) Home_team.getStarting_lineup_defender().stream().mapToInt(p->p.getIntercept_skill()).average().getAsDouble();
		Home_defender_mean_stealing = (int) Home_team.getStarting_lineup_defender().stream().mapToInt(p->p.getStealing_skill()).average().getAsDouble();
		
		Away_midfielder_mean_passing = (int) Away_team.getStarting_lineup_midfielder().stream().mapToInt(p->p.getPassing_skill()).average().getAsDouble();
		Away_midfielder_mean_dribble = (int) Away_team.getStarting_lineup_midfielder().stream().mapToInt(p->p.getDribbling_skill()).average().getAsDouble();
		Away_midfielder_mean_shooting = (int) Away_team.getStarting_lineup_midfielder().stream().mapToInt(p->p.getShooting_skill()).average().getAsDouble();
		Away_midfielder_mean_intercept = (int) Away_team.getStarting_lineup_midfielder().stream().mapToInt(p->p.getIntercept_skill()).average().getAsDouble();
		Away_midfielder_mean_stealing = (int) Away_team.getStarting_lineup_midfielder().stream().mapToInt(p->p.getStealing_skill()).average().getAsDouble();
		
		Away_attacker_mean_passing = (int) Away_team.getStarting_lineup_attacker().stream().mapToInt(p->p.getPassing_skill()).average().getAsDouble();
		Away_attacker_mean_dribble = (int) Away_team.getStarting_lineup_attacker().stream().mapToInt(p->p.getDribbling_skill()).average().getAsDouble();
		Away_attacker_mean_shooting = (int) Away_team.getStarting_lineup_attacker().stream().mapToInt(p->p.getShooting_skill()).average().getAsDouble();
		Away_attacker_mean_intercept = (int) Away_team.getStarting_lineup_attacker().stream().mapToInt(p->p.getIntercept_skill()).average().getAsDouble();
		Away_attacker_mean_stealing = (int) Away_team.getStarting_lineup_attacker().stream().mapToInt(p->p.getStealing_skill()).average().getAsDouble();
		
		Away_defender_mean_passing = (int) Away_team.getStarting_lineup_defender().stream().mapToInt(p->p.getPassing_skill()).average().getAsDouble();
		Away_defender_mean_dribble = (int) Away_team.getStarting_lineup_defender().stream().mapToInt(p->p.getDribbling_skill()).average().getAsDouble();
		Away_defender_mean_shooting = (int) Away_team.getStarting_lineup_defender().stream().mapToInt(p->p.getShooting_skill()).average().getAsDouble();
		Away_defender_mean_intercept = (int) Away_team.getStarting_lineup_defender().stream().mapToInt(p->p.getIntercept_skill()).average().getAsDouble();
		Away_defender_mean_stealing = (int) Away_team.getStarting_lineup_defender().stream().mapToInt(p->p.getStealing_skill()).average().getAsDouble();
		
		Home_goalkeeper_skill = Home_team.getStarting_lineup_goalkeeper().get(0).getGoalkeeper_skill();
		Away_goalkeeper_skill = Away_team.getStarting_lineup_goalkeeper().get(0).getGoalkeeper_skill();
		
		this.Determine_factor_for_Home_team();
		this.Determine_factor_for_Away_team();
		
		home_goal = 0;
		away_goal = 0;
		
		set_Away_Passing_dribble_minimal_requirement();
		set_Home_Passing_dribble_minimal_requirement();
		
		score_player_list = new LinkedList<Player>();
		score_player_list_score_num = new LinkedList<Integer>();
		score_player_club_list = new LinkedList<Club>();
	
		

	}
	
	/**
	 * match simulator method
	 */
	public void match_simulator()
	{
		Random random_value = new Random();
		int determination_result; 
		int pass_to_attacker_or_shooting_determination_result;
		
		boolean Home_control_ball = true;
		boolean Away_control_ball = false;
		
		int home_midfielder_pass_count = 0;
		int away_midfielder_pass_count = 0;
		int home_midfielder_dribble_count = 0;
		int away_midfielder_dribble_count = 0;
		
		int overallcount = 0;
		
		while(true)
		{
			
			// home control ball
			while(Home_control_ball == true && Away_control_ball == false )
			{
				determination_result = random_value.nextInt(10);
				if(determination_result < this.home_passing_dribble_threshold)
				{
					if (midfielder_home_passing_away_intercept() == true)
					{
						home_midfielder_pass_count++;
						if(home_midfielder_pass_count > this.home_passing_minimal_requirement)
						{
							if(midfielder_home_defender_away_passing_battle() == true)
							{
								if(attacker_home_shooting_away_goalkeep() == true)
								{
									home_goal += 1;
									Random random_value_for_score_player = new Random();
									int score_player_result = random_value_for_score_player.nextInt(Home_team.getClub_manager().getAttacker_num());
									Player temp = Home_team.getStarting_lineup_attacker().get(score_player_result);
									Club temp_club = Home_team;
									this.set_score_list(temp, temp_club);
									Home_control_ball = false;
									Away_control_ball = true;
									break;
								}
								else
								{
									Home_control_ball = false;
									Away_control_ball = true;
									break;
								}
							}
						}
					}
					else
					{
						Home_control_ball = false;
						Away_control_ball = true;
						break;
					}
				}
				
				else
				{
					if (midfielder_home_dribble_away_stealing() == true)
					{
						home_midfielder_dribble_count++;
						if(home_midfielder_dribble_count > this.home_dribble_minimal_requirement)
						{
							pass_to_attacker_or_shooting_determination_result = random_value.nextInt(7);
							if(pass_to_attacker_or_shooting_determination_result < 3)
							{
								if(midfielder_home_defender_away_passing_battle() == true)
								{
									if(attacker_home_shooting_away_goalkeep() == true)
									{
										home_goal += 1;
										Random random_value_for_score_player = new Random();
										int score_player_result = random_value_for_score_player.nextInt(Home_team.getClub_manager().getAttacker_num());
										Player temp = Home_team.getStarting_lineup_attacker().get(score_player_result);
										Club temp_club = Home_team;
										this.set_score_list(temp, temp_club);
										Home_control_ball = false;
										Away_control_ball = true;
										break;
									}
									else
									{
										Home_control_ball = false;
										Away_control_ball = true;
										break;
									}
								}
							}
							
							else if (pass_to_attacker_or_shooting_determination_result >= 3 && pass_to_attacker_or_shooting_determination_result < 5)
							{
								if(midfielder_home_shooting_away_goalkeep() == true)
								{
									home_goal += 1;
									Random random_value_for_score_player = new Random();
									int score_player_result = random_value_for_score_player.nextInt(Home_team.getClub_manager().getMidfielder_num());
									Player temp = Home_team.getStarting_lineup_midfielder().get(score_player_result);
									Club temp_club = Home_team;
									this.set_score_list(temp, temp_club);
									Home_control_ball = false;
									Away_control_ball = true;
									break;
								}
								else
								{
									Home_control_ball = false;
									Away_control_ball = true;
									break;
								}
							}
							else
							{
								Random random_for_defender = new Random();
								int random_for_defender_result = random_for_defender.nextInt(5);
								if(random_for_defender_result == 1)
								{
									Random random_value_for_score_player = new Random();
									int score_player_result = random_value_for_score_player.nextInt(Home_team.getClub_manager().getDefender_num());
									Player temp = Home_team.getDefault_Starting_lineup_defender().get(score_player_result);
									Club temp_club = Home_team;
									this.set_score_list(temp, temp_club);
								}
							}
						}
					}
				}
			}
			
			
			// Away control ball
			while(Away_control_ball == true && Home_control_ball == false )
			{
				determination_result = random_value.nextInt(10);
				if(determination_result < this.away_passing_dribble_threshold)
				{
					if (midfielder_away_passing_home_intercept() == false)
					{
						away_midfielder_pass_count++;
						if(away_midfielder_pass_count > this.away_passing_minimal_requirement)
						{
							if(midfielder_away_defender_home_passing_battle() == false)
							{
								if(attacker_away_shooting_home_goalkeep() == false)
								{
									away_goal += 1;
									Random random_value_for_score_player = new Random();
									int score_player_result = random_value_for_score_player.nextInt(Away_team.getClub_manager().getAttacker_num());
									Player temp = Away_team.getStarting_lineup_attacker().get(score_player_result);
									Club temp_club = Away_team;
									this.set_score_list(temp, temp_club);
									Home_control_ball = true;
									Away_control_ball = false;
									break;
								}
								else
								{
									Home_control_ball = true;
									Away_control_ball = false;
									break;
								}
							}
						}
					}
					else
					{
						Home_control_ball = true;
						Away_control_ball = false;
						break;
					}
				}
				
				else
				{
					if (midfielder_away_dribble_home_stealing() == false)
					{
						away_midfielder_dribble_count++;
						if(away_midfielder_dribble_count > this.away_dribble_minimal_requirement)
						{
							pass_to_attacker_or_shooting_determination_result = random_value.nextInt(7);
							if(pass_to_attacker_or_shooting_determination_result < 3)
							{
								if(midfielder_away_defender_home_passing_battle() == false)
								{
									if(attacker_away_shooting_home_goalkeep() == false)
									{
										away_goal += 1;
										Random random_value_for_score_player = new Random();
										int score_player_result = random_value_for_score_player.nextInt(Away_team.getClub_manager().getAttacker_num());
										Player temp = Away_team.getStarting_lineup_attacker().get(score_player_result);
										Club temp_club = Away_team;
										this.set_score_list(temp, temp_club);
										Home_control_ball = true;
										Away_control_ball = false;
										break;
									}
									else
									{
										Home_control_ball = false;
										Away_control_ball = true;
										break;
									}
								}
							}
							
							else if (pass_to_attacker_or_shooting_determination_result >= 3 && pass_to_attacker_or_shooting_determination_result < 5)
							{
								if(midfielder_away_shooting_home_goalkeep() == false)
								{
									away_goal += 1;
									Random random_value_for_score_player = new Random();
									int score_player_result = random_value_for_score_player.nextInt(Away_team.getClub_manager().getMidfielder_num());
									Player temp = Away_team.getStarting_lineup_midfielder().get(score_player_result);
									Club temp_club = Away_team;
									this.set_score_list(temp, temp_club);
									Home_control_ball = true;
									Away_control_ball = false;
									break;
								}
								else
								{
									Home_control_ball = true;
									Away_control_ball = false;
									break;
								}
							}
							else
							{
								Random random_for_defender = new Random();
								int random_for_defender_result = random_for_defender.nextInt(5);
								if(random_for_defender_result == 1)
								{
									Random random_value_for_score_player = new Random();
									int score_player_result = random_value_for_score_player.nextInt(Away_team.getClub_manager().getDefender_num());
									Player temp = Away_team.getDefault_Starting_lineup_defender().get(score_player_result);
									Club temp_club = Away_team;
									this.set_score_list(temp, temp_club);
								}
							}
						}
					}
				}

			}
			
			
			home_midfielder_pass_count = 0;
			away_midfielder_pass_count = 0;
			home_midfielder_dribble_count = 0;
			away_midfielder_dribble_count = 0;
			
			overallcount++;
			
			if(overallcount == 5)
			{
				break;
			}
			
		}
	}
	
	
	private boolean midfielder_home_passing_away_intercept()
	{
		Random random_value = new Random();
		int Home_tactic_factor_result = random_value.nextInt(this.Home_passing_tactic_factor);
		int Away_tactic_factor_result = random_value.nextInt(this.Away_intercept_tactic_factor);
		int Home_uncertainty_factor_result = random_value.nextInt(20) - 10;
		int Away_uncertainty_factor_result = random_value.nextInt(20) - 10;
		
		int home_advantage_result = random_value.nextInt(10);
		
		int Home_result = Home_midfielder_mean_passing + Home_midfielder_mean_dribble+  Home_tactic_factor_result + Home_uncertainty_factor_result + home_advantage_result;
		int Away_result = Away_midfielder_mean_intercept + Away_midfielder_mean_stealing + Away_tactic_factor_result + Away_uncertainty_factor_result;
		
		if(Home_result >  Away_result)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
	private boolean midfielder_away_passing_home_intercept()
	{
		Random random_value = new Random();
		int Home_tactic_factor_result = random_value.nextInt(this.Home_intercept_tactic_factor);
		int Away_tactic_factor_result = random_value.nextInt(this.Away_passing_tactic_factor);
		int Home_uncertainty_factor_result = random_value.nextInt(20) - 10;
		int Away_uncertainty_factor_result = random_value.nextInt(20) - 10;
		
		int home_advantage_result = random_value.nextInt(10);
		
		int Home_result = Home_midfielder_mean_intercept + Home_midfielder_mean_stealing+ Home_tactic_factor_result + Home_uncertainty_factor_result + home_advantage_result;
		int Away_result = Away_midfielder_mean_passing +  Away_midfielder_mean_dribble+ Away_tactic_factor_result + Away_uncertainty_factor_result;
		
		if(Home_result >  Away_result)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
	
	private boolean midfielder_home_dribble_away_stealing()
	{
		Random random_value = new Random();
		int Home_tactic_factor_result = random_value.nextInt(this.Home_dribble_tactic_factor);
		int Away_tactic_factor_result = random_value.nextInt(this.Away_stealing_tactic_factor);
		int Home_uncertainty_factor_result = random_value.nextInt(20) - 10;
		int Away_uncertainty_factor_result = random_value.nextInt(20) - 10;
		
		int home_advantage_result = random_value.nextInt(10);
		
		int Home_result = Home_midfielder_mean_dribble + Home_midfielder_mean_passing + Home_tactic_factor_result + Home_uncertainty_factor_result + home_advantage_result;
		int Away_result = Away_midfielder_mean_stealing + Away_midfielder_mean_intercept + Away_tactic_factor_result + Away_uncertainty_factor_result;
		
		if( Home_result > Away_result)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
	private boolean midfielder_away_dribble_home_stealing()
	{
		Random random_value = new Random();
		int Home_tactic_factor_result = random_value.nextInt(this.Home_stealing_tactic_factor);
		int Away_tactic_factor_result = random_value.nextInt(this.Away_dribble_tactic_factor);
		int Home_uncertainty_factor_result = random_value.nextInt(20) - 10;
		int Away_uncertainty_factor_result = random_value.nextInt(20) - 10;
		
		int home_advantage_result = random_value.nextInt(15);
	
		
		int Home_result = Home_midfielder_mean_stealing + Home_midfielder_mean_intercept + Home_tactic_factor_result + Home_uncertainty_factor_result + home_advantage_result;
		int Away_result = Away_midfielder_mean_dribble + Away_midfielder_mean_passing + Away_tactic_factor_result + Away_uncertainty_factor_result;
		
		if( Home_result > Away_result)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
	
	private boolean midfielder_home_shooting_away_goalkeep()
	{
		Random random_value = new Random();
		int Home_tactic_factor_result = random_value.nextInt(this.Home_shooting_tactic_factor);
		int Away_tactic_factor_result = random_value.nextInt(this.Away_goalkeeper_tactic_factor);
		int Home_uncertainty_factor_result = random_value.nextInt(20) - 10;
		int Away_uncertainty_factor_result = random_value.nextInt(20) - 10;
		
		int goalkeeper_over_performance_result = random_value.nextInt(6);
		
		int Home_result = Home_midfielder_mean_shooting + Home_tactic_factor_result + Home_uncertainty_factor_result;
		int Away_result = Away_goalkeeper_skill + Away_tactic_factor_result + Away_uncertainty_factor_result + goalkeeper_over_performance_result;
		
		if( Home_result > Away_result)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
	private boolean midfielder_away_shooting_home_goalkeep()
	{
		Random random_value = new Random();
		int Home_tactic_factor_result = random_value.nextInt(this.Home_goalkeeper_tactic_factor);
		int Away_tactic_factor_result = random_value.nextInt(this.Away_shooting_tactic_factor);
		int Home_uncertainty_factor_result = random_value.nextInt(20) - 10;
		int Away_uncertainty_factor_result = random_value.nextInt(20) - 10;
		
		int goalkeeper_over_performance_result = random_value.nextInt(8);
		
		int Home_result = Home_goalkeeper_skill + Home_tactic_factor_result + Home_uncertainty_factor_result + goalkeeper_over_performance_result;
		int Away_result = Away_midfielder_mean_shooting + Away_tactic_factor_result + Away_uncertainty_factor_result;
		
		if( Home_result > Away_result)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
	private boolean midfielder_home_defender_away_passing_battle()
	{
		Random random_value = new Random();
		int Home_tactic_factor_result = random_value.nextInt(this.Home_passing_tactic_factor);
		int Away_tactic_factor_result = random_value.nextInt(this.Away_intercept_tactic_factor);
		int Home_uncertainty_factor_result = random_value.nextInt(20) - 10;
		int Away_uncertainty_factor_result = random_value.nextInt(20) - 10;
		
		int home_advantage_result = random_value.nextInt(15);
		
		int Home_result = Home_midfielder_mean_passing + Home_tactic_factor_result + Home_uncertainty_factor_result + home_advantage_result;
		int Away_result = Away_defender_mean_intercept + Away_tactic_factor_result + Away_uncertainty_factor_result;
		
		if( Home_result > Away_result)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
	
	private boolean midfielder_away_defender_home_passing_battle()
	{
		Random random_value = new Random();
		int Home_tactic_factor_result = random_value.nextInt(this.Home_intercept_tactic_factor);
		int Away_tactic_factor_result = random_value.nextInt(this.Away_passing_tactic_factor);
		int Home_uncertainty_factor_result = random_value.nextInt(20) - 10;
		int Away_uncertainty_factor_result = random_value.nextInt(20) - 10;
		
		int home_advantage_result = random_value.nextInt(15);
		
		int Home_result = Home_midfielder_mean_intercept + Home_tactic_factor_result + Home_uncertainty_factor_result + home_advantage_result;
		int Away_result = Away_defender_mean_passing + Away_tactic_factor_result + Away_uncertainty_factor_result;
		
		if( Home_result > Away_result)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
	
	
	private boolean attacker_home_shooting_away_goalkeep()
	{
		Random random_value = new Random();
		int Home_tactic_factor_result = random_value.nextInt(this.Home_dribble_tactic_factor);
		int Away_tactic_factor_result = random_value.nextInt(this.Away_stealing_tactic_factor);
		int Home_uncertainty_factor_result = random_value.nextInt(20) - 10;
		int Away_uncertainty_factor_result = random_value.nextInt(20) - 10;
		
		int Home_dribble_result = Home_attacker_mean_dribble + Home_tactic_factor_result + Home_uncertainty_factor_result;
		int Away_stealing_result = Away_defender_mean_stealing + Away_tactic_factor_result + Away_uncertainty_factor_result;
		
		
		int Home_tactic_factor_shooting_result = random_value.nextInt(this.Home_shooting_tactic_factor);
		int Away_tactic_factor_goalkeep_result = random_value.nextInt(this.Away_goalkeeper_tactic_factor);
		int Home_uncertainty_factor_shooting_result = random_value.nextInt(20) - 10;
		int Away_uncertainty_factor_goalkeep_result = random_value.nextInt(20) - 10;
		
		int goalkeeper_over_performance_result = random_value.nextInt(6);
		
		int Home_attacker_shooting_result = Home_attacker_mean_shooting + Home_tactic_factor_shooting_result + Home_uncertainty_factor_shooting_result;
		int Away_goalkeep_result = Away_goalkeeper_skill + Away_tactic_factor_goalkeep_result + Away_uncertainty_factor_goalkeep_result + goalkeeper_over_performance_result;
		
		if( Home_dribble_result > Away_stealing_result)
		{
			if((Home_attacker_shooting_result) > Away_goalkeep_result)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			if((Home_attacker_shooting_result - 10) > Away_goalkeep_result)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	
	}
	
	
	
	private boolean attacker_away_shooting_home_goalkeep()
	{
		Random random_value = new Random();
		int Home_tactic_factor_result = random_value.nextInt(this.Home_stealing_tactic_factor);
		int Away_tactic_factor_result = random_value.nextInt(this.Away_dribble_tactic_factor);
		int Home_uncertainty_factor_result = random_value.nextInt(20) - 10;
		int Away_uncertainty_factor_result = random_value.nextInt(20) - 10;
		
		int Home_stealing_result = Home_defender_mean_stealing + Home_tactic_factor_result + Home_uncertainty_factor_result;
		int Away_dribble_result = Away_attacker_mean_dribble + Away_tactic_factor_result + Away_uncertainty_factor_result;
		
		
		int Home_tactic_factor_goalkeep_result = random_value.nextInt(this.Home_goalkeeper_tactic_factor);
		int Away_tactic_factor_shooting_result = random_value.nextInt(this.Away_shooting_tactic_factor);
		int Home_uncertainty_factor_goalkeep_result = random_value.nextInt(20) - 10;
		int Away_uncertainty_factor_shooting_result = random_value.nextInt(20) - 10;
		
		int goalkeeper_over_performance_result = random_value.nextInt(5);
		
		int Home_goalkeep_result = Home_goalkeeper_skill + Home_tactic_factor_goalkeep_result + Home_uncertainty_factor_goalkeep_result + goalkeeper_over_performance_result;
		int Away_attacker_shooting_result = Away_attacker_mean_shooting + Away_tactic_factor_shooting_result + Away_uncertainty_factor_shooting_result;
		
		if( Away_dribble_result > Home_stealing_result)
		{
			if((Away_attacker_shooting_result) > Home_goalkeep_result)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		else
		{
			if((Away_attacker_shooting_result - 10) > Home_goalkeep_result)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	
	}
	
	
	private void Determine_factor_for_Home_team()
	{
		if(this.Home_tactics == Tactics.park_the_bus)
		{
			Home_passing_tactic_factor = 1;
			Home_dribble_tactic_factor = 1; 
			Home_shooting_tactic_factor = 1; 
			Home_intercept_tactic_factor = 40; 
			Home_stealing_tactic_factor = 40;
			Home_goalkeeper_tactic_factor = 40;
		}
		else if(this.Home_tactics == Tactics.counter_attack)
		{
			Home_passing_tactic_factor = 10;
			Home_dribble_tactic_factor = 10; 
			Home_shooting_tactic_factor = 20; 
			Home_intercept_tactic_factor = 30; 
			Home_stealing_tactic_factor = 30;
			Home_goalkeeper_tactic_factor = 30;
		}
		else if(this.Home_tactics == Tactics.balance)
		{
			Home_passing_tactic_factor = 20;
			Home_dribble_tactic_factor = 20; 
			Home_shooting_tactic_factor = 20; 
			Home_intercept_tactic_factor = 20; 
			Home_stealing_tactic_factor = 20;
			Home_goalkeeper_tactic_factor = 20;
		}
		else if(this.Home_tactics == Tactics.tiki_taka)
		{
			Home_passing_tactic_factor = 40;
			Home_dribble_tactic_factor = 20; 
			Home_shooting_tactic_factor = 10; 
			Home_intercept_tactic_factor = 25; 
			Home_stealing_tactic_factor = 10;
			Home_goalkeeper_tactic_factor = 10;
		}
		
		else if(this.Home_tactics == Tactics.attacking)
		{
			Home_passing_tactic_factor = 30;
			Home_dribble_tactic_factor = 25; 
			Home_shooting_tactic_factor = 30; 
			Home_intercept_tactic_factor = 1; 
			Home_stealing_tactic_factor = 1;
			Home_goalkeeper_tactic_factor = 10;
		}
		
		else if(this.Home_tactics == Tactics.all_out)
		{
			Home_passing_tactic_factor = 30;
			Home_dribble_tactic_factor = 40; 
			Home_shooting_tactic_factor = 35; 
			Home_intercept_tactic_factor = 1; 
			Home_stealing_tactic_factor = 1;
			Home_goalkeeper_tactic_factor = 1;
		}
	}
	
	private void Determine_factor_for_Away_team()
	{
		if(this.Away_tactics == Tactics.park_the_bus)
		{
			Away_passing_tactic_factor = 1;
			Away_dribble_tactic_factor = 1; 
			Away_shooting_tactic_factor = 1; 
			Away_intercept_tactic_factor = 40; 
			Away_stealing_tactic_factor = 40;
			Away_goalkeeper_tactic_factor = 40;
		}
		else if(this.Away_tactics == Tactics.counter_attack)
		{
			Away_passing_tactic_factor = 10;
			Away_dribble_tactic_factor = 10; 
			Away_shooting_tactic_factor = 20; 
			Away_intercept_tactic_factor = 30; 
			Away_stealing_tactic_factor = 30;
			Away_goalkeeper_tactic_factor = 30;
		}
		else if(this.Away_tactics == Tactics.balance)
		{
			Away_passing_tactic_factor = 20;
			Away_dribble_tactic_factor = 20; 
			Away_shooting_tactic_factor = 20; 
			Away_intercept_tactic_factor = 20; 
			Away_stealing_tactic_factor = 20;
			Away_goalkeeper_tactic_factor = 20;
		}
		else if(this.Away_tactics == Tactics.tiki_taka)
		{
			Away_passing_tactic_factor = 40;
			Away_dribble_tactic_factor = 30; 
			Away_shooting_tactic_factor = 10; 
			Away_intercept_tactic_factor = 25; 
			Away_stealing_tactic_factor = 10;
			Away_goalkeeper_tactic_factor = 10;
		}
		
		else if(this.Away_tactics == Tactics.attacking)
		{
			Away_passing_tactic_factor = 30;
			Away_dribble_tactic_factor = 25; 
			Away_shooting_tactic_factor = 30; 
			Away_intercept_tactic_factor = 1; 
			Away_stealing_tactic_factor = 1;
			Away_goalkeeper_tactic_factor = 10;
		}
		
		else if(this.Away_tactics == Tactics.all_out)
		{
			Away_passing_tactic_factor = 30;
			Away_dribble_tactic_factor = 40; 
			Away_shooting_tactic_factor = 35; 
			Away_intercept_tactic_factor = 1; 
			Away_stealing_tactic_factor = 1;
			Away_goalkeeper_tactic_factor = 1;
		}
	}
	
	private void set_Away_Passing_dribble_minimal_requirement()
	{
		if(this.Away_team.getTeamTactics() == Tactics.all_out)
		{
			away_passing_minimal_requirement = 4;
			away_dribble_minimal_requirement = 2;
			away_passing_dribble_threshold = 3;
		}
		else if(this.Away_team.getTeamTactics() == Tactics.attacking)
		{
			away_passing_minimal_requirement = 5;
			away_dribble_minimal_requirement = 4;
			away_passing_dribble_threshold = 4;
		}
		else if( this.Away_team.getTeamTactics() == Tactics.balance)
		{
			away_passing_minimal_requirement = 5;
			away_dribble_minimal_requirement = 5;
			away_passing_dribble_threshold = 5;
		}
		else if(this.Away_team.getTeamTactics() == Tactics.tiki_taka)
		{
			away_passing_minimal_requirement = 7;
			away_dribble_minimal_requirement = 4;
			away_passing_dribble_threshold = 7;
		}
		else if(this.Away_team.getTeamTactics() == Tactics.counter_attack)
		{
			away_passing_minimal_requirement = 4;
			away_dribble_minimal_requirement = 5;
			away_passing_dribble_threshold = 4;
		} 
		else if(this.Away_team.getTeamTactics() == Tactics.park_the_bus)
		{
			away_passing_minimal_requirement = 4;
			away_dribble_minimal_requirement = 7;
			away_passing_dribble_threshold = 3;
		} 
	}
	
	private void set_Home_Passing_dribble_minimal_requirement()
	{
		if(this.Home_team.getTeamTactics() == Tactics.all_out)
		{
			home_passing_minimal_requirement = 4;
			home_dribble_minimal_requirement = 2;
			home_passing_dribble_threshold = 3;
		}
		else if(this.Home_team.getTeamTactics() == Tactics.attacking)
		{
			home_passing_minimal_requirement = 5;
			home_dribble_minimal_requirement = 4;
			home_passing_dribble_threshold = 4;
		}
		else if( this.Home_team.getTeamTactics() == Tactics.balance)
		{
			home_passing_minimal_requirement = 5;
			home_dribble_minimal_requirement = 5;
			home_passing_dribble_threshold = 5;
		}
		else if(this.Home_team.getTeamTactics() == Tactics.tiki_taka)
		{
			home_passing_minimal_requirement = 7;
			home_dribble_minimal_requirement = 4;
			home_passing_dribble_threshold = 7;
		}
		else if(this.Home_team.getTeamTactics() == Tactics.counter_attack)
		{
			home_passing_minimal_requirement = 4;
			home_dribble_minimal_requirement = 5;
			home_passing_dribble_threshold = 4;
		} 
		else if(this.Home_team.getTeamTactics() == Tactics.park_the_bus)
		{
			home_passing_minimal_requirement = 4;
			home_dribble_minimal_requirement = 7;
			home_passing_dribble_threshold = 3;
		} 
	}
	
	/**
	 * method for setting the score player
	 * @param temp_player
	 * @param temp_club
	 */
	public void set_score_list(Player temp_player, Club temp_club)
	{
		
		if(score_player_list.contains(temp_player))
		{
			for(int i = 0; i < score_player_list.size(); i++)
			{
				if(temp_player.getName() == score_player_list.get(i).getName())
				{
					score_player_list_score_num.set(i, score_player_list_score_num.get(i) + 1);
				}
			}
		}
		else
		{
			score_player_list.add(temp_player);
			score_player_club_list.add(temp_club);
			score_player_list_score_num.add(1);
		}
		
	}
	
	/**
	 * toString method
	 */
	@Override
	public String toString()
	{
		return "result score: " +  home_goal + " : " + away_goal;
	}
		
}
	

