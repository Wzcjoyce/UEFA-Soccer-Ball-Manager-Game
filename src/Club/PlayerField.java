package Club;

/**
 * Player position enum which only have 5 positions
 * which are attacker , midfielder, defender, goalkeeper and substitute
 * @author Zuocheng Wang
 *
 */
public enum PlayerField {
	
	attacker,
	midfield,
	defender,
	goalkeeper,
	substitute;
	
	public String toString()
	{
		switch (this) 
		{
		case attacker:
			return "attacker";
		case midfield:
			return "midfielder";
		case defender:
			return "defender";
		case goalkeeper:
			return "goalKeeper";
		case substitute:
			return "substitute";
		default: 
			throw new IllegalArgumentException();
		
		}
	}
	
	public static PlayerField toPlayerField(String position)
	{
		switch (position) 
		{
		case "attacker":
			return PlayerField.attacker;
		case "midfielder":
			return PlayerField.midfield;
		case "defender":
			return PlayerField.defender;
		case "goalkeeper":
			return PlayerField.goalkeeper;
		case "substitute":
			return PlayerField.substitute;
		default: 
			throw new IllegalArgumentException();
		
		}
	}

}
