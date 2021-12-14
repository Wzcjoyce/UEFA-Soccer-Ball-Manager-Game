package Club;

/**
 * Club Tactic enum which contains 6 possibabilities
 * which are park the bus, counter attack, balance, tiki taka, attacking and all-out
 * @author Zuocheng Wang
 *
 */
public enum Tactics {
	
	park_the_bus,
	counter_attack,
	balance,
	tiki_taka,
	attacking,
	all_out;
	
	/**
	 * toString method
	 */
	@Override
	public String toString()
	{
		switch(this) 
		{
			case park_the_bus:
				return "Park the Bus";
			case counter_attack:
				return "Counter Attack";
			case balance:
				return "Balance";
			case tiki_taka:
				return "Tiki Taka";
			case attacking:
				return "Attacking";
			case all_out:
				return "All-out";
			default:
				return "";
		}				
	}
	
	/**
	 * static class convert tactics to associated String
	 * @param Tactic_name
	 * @return STRING
	 */
	public static Tactics toTactic(String Tactic_name)
	{
		switch(Tactic_name) 
		{
			case "Park the Bus":
				return park_the_bus;
			case "Counter Attack":
				return counter_attack;
			case "Balance":
				return balance;
			case "Tiki Taka":
				return tiki_taka;
			case "Attacking":
				return attacking;
			case "All-out":
				return all_out;
			default:
				return null;
		}				
	}

}
