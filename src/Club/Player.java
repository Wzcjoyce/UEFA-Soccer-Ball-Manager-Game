package Club;

/**
 * Player Class hold all Club Player information which extends abstractEmployee abstract class
 * @author Zuocheng
 */
public class Player extends AbstractEmployee {
	
	private int shooting_skill; 
	private int dribbling_skill; 
	private int passing_skill;
	private int Intercept_skill;
	private int Stealing_skill;
	private int goalkeeper_skill;
	private PlayerField best_position;
	public int shirt_Number;
	private double value;
	private int stamina;
	
	private int total_goals;
	private int total_success_keeps;
	
	private boolean control_ball;


	/**
	 * constructor of player class
	 * @param name
	 * @param pay
	 * @param age
	 * @param nationality
	 * @param shooting_skill
	 * @param dribbling_skill
	 * @param passing_skill
	 * @param Intercept_skill
	 * @param Stealing_skill
	 * @param goalkeeper_skill
	 * @param position
	 * @param shirt_Number
	 * @param value
	 */
	public Player(String name, double pay, int age, String nationality, int shooting_skill,
		   int dribbling_skill, int passing_skill, int Intercept_skill, int Stealing_skill,
		   int goalkeeper_skill, PlayerField position, int shirt_Number, double value) {
	   
	    super(name, pay, age, nationality);
	    
	    this.shooting_skill = shooting_skill ; 
	    this.dribbling_skill = dribbling_skill ; 
	    this.passing_skill = passing_skill;
	    this.Intercept_skill = Intercept_skill;
	    this.Stealing_skill = Stealing_skill;
	    this.goalkeeper_skill = goalkeeper_skill;
	    this.best_position = position;
	    this.shirt_Number = shirt_Number;
	    this.value = value;
	    this.stamina = 100;
	    
		this.total_goals = 0;
		this.total_success_keeps = 0;
		this.control_ball = false;
    
    }
	
	
	/**
	 * getter of total goals 
	 * @return
	 */
	public int getTotal_goals() {
		return total_goals;
	}


	/**
	 * setter of total goals
	 * @param total_goals
	 */
	public void setTotal_goals(int total_goals) {
		this.total_goals = total_goals;
	}

	/**
	 * will be used for future development including user match method
	 * @return int
	 */
	public int getTotal_success_keeps() {
		return total_success_keeps;
	}

	/**
	 * will be used for future development including user match method
	 * @param total_success_keeps
	 */
	public void setTotal_success_keeps(int total_success_keeps) {
		this.total_success_keeps = total_success_keeps;
	}

	/**
	 * will be used for future development including user match method
	 * @return boolean
	 */
	public boolean isControl_ball() {
		return control_ball;
	}


	/**
	 * will be used for future development including user match method
	 */
	public void setControl_ball(boolean control_ball) {
		this.control_ball = control_ball;
	}


	/**
	 * will be used for future development including user match method
	 * @return int
	 */
	public int getStamina() {
		return stamina;
	}


	/**
	 * will be used for future development including user match method
	 */
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}


	/**
	 * getter of value
	 * @return double
	 */
	public double getValue() {
		return value;
	}


	/**
	 * setter of player value
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}


	/**
	 * getter of goalkeeper skill
	 * @return int
	 */
	public int getGoalkeeper_skill() {
		return goalkeeper_skill;
	}
	
	/**
	 * setter of goalkeeper skill
	 * @return int
	 */
	public void setGoalkeeper_skill(int goalkeeping_skill) {
		this.goalkeeper_skill = goalkeeping_skill;
	}

	
	/**
	 * Override toString method
	 * @return String
	 */
	@Override
	public String toString()
	{
	    return "\nName: " + this.name +
	    		"\nNationality: " + this.nationality +
	    		"\nage: " + this.age +
	    		"\npay: " + this.pay +
	    		"\nShooting skill: " + this.shooting_skill +
	    		"\nDribbling skill: " + this.dribbling_skill +
	    		"\nPassing skill: " + this.passing_skill +
	    		"\nIntercept skill: " + this.Intercept_skill +
	    		"\nStealing skill: " + this.Stealing_skill +
	    		"\nGoalkeeping skill: " + this.goalkeeper_skill +
	    		"\nBest position: " + this.best_position +
	    		"\nValue: " + this.value +"\n";
	    
	}


	/**
	 * getter of shooting skill
	 * @return int
	 */
    public int getShooting_skill() {
		return shooting_skill;
	}


	/**
	 * setter of shooting skill
	 */
	public void setShooting_skill(int shooting_skill) {
		this.shooting_skill = shooting_skill;
	}


	/**
	 * getter of dribble skill
	 * @return int
	 */
	public int getDribbling_skill() {
		return dribbling_skill;
	}


	/**
	 * setter of dribbling_skill
	 * @param dribbling_skill
	 */
	public void setDribbling_skill(int dribbling_skill) {
		this.dribbling_skill = dribbling_skill;
	}


	/**
	 * getter of passing skill
	 * @return int
	 */
	public int getPassing_skill() {
		return passing_skill;
	}


	/**
	 * setter of passing_skill
	 * @param passing_skill
	 */
	public void setPassing_skill(int passing_skill) {
		this.passing_skill = passing_skill;
	}


	/**
	 * getter of intercept skill
	 * @return int
	 */
	public int getIntercept_skill() {
		return Intercept_skill;
	}


	/**
	 * setter of intercept_skill
	 * @param intercept_skill
	 */
	public void setIntercept_skill(int intercept_skill) {
		Intercept_skill = intercept_skill;
	}


	/**
	 * getter of stealing skill
	 * @return int
	 */
	public int getStealing_skill() {
		return Stealing_skill;
	}



	/**
	 * setter of stealing skill
	 * @param stealing_skill
	 */
	public void setStealing_skill(int stealing_skill) {
		Stealing_skill = stealing_skill;
	}



	/**
	 * getter of best position
	 * @return PlayerField
	 */
	public PlayerField getBest_position() {
		return best_position;
	}

	/**
	 * setter of best position 
	 * @param best_position
	 */
	public void setBest_position(PlayerField best_position) {
		this.best_position = best_position;
	}

	/**
	 * getter of shirt number
	 * @return int
	 */
	public int getShirt_Number() {
		return shirt_Number;
	}

	/**
	 * setter of player shirt number
	 * @param shirt_Number
	 */
	public void setShirt_Number(int shirt_Number) {
		this.shirt_Number = shirt_Number;
	}
	
	/**
	 * getter of player's highest attribute
	 * @return
	 */
	public int getHighestAttribute()
	{
		int highest_attribute = 0;
		if(this.shooting_skill > highest_attribute)
		{
			highest_attribute = shooting_skill;
		}
		
		if(this.dribbling_skill > highest_attribute)
		{
			highest_attribute = dribbling_skill;
		}
		
		if(this.passing_skill > highest_attribute)
		{
			highest_attribute = passing_skill;
		}
		
		if(this.Intercept_skill > highest_attribute)
		{
			highest_attribute = Intercept_skill;
		}
		
		if(this.Stealing_skill > highest_attribute)
		{
			highest_attribute = Stealing_skill;
		}
		
		if(this.goalkeeper_skill > highest_attribute)
		{
			highest_attribute = goalkeeper_skill;
		}
		
		return highest_attribute;
	}

	  
}