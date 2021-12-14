package Club;


/**
 * Manager Class hold all Club manger information which extends abstractEmployee abstract class
 * @author Zuocheng Wang
 *
 */
public class Manager extends AbstractEmployee{
	
	public int attacker_num;
	public int midfielder_num; 
	public int defender_num; 
	public Tactics tactics;
	
	/**
	 * constructor of manager class
	 * @param name
	 * @param pay
	 * @param age
	 * @param nationality
	 * @param defender_num
	 * @param midfielder_num
	 * @param attacker_num
	 * @param tactics
	 */
	public Manager(String name, double pay, int age, String nationality, int defender_num,
			int midfielder_num, int attacker_num, Tactics tactics)
	{
		super(name, pay, age, nationality);
		this.attacker_num = attacker_num;
		this.midfielder_num = midfielder_num;
		this.defender_num = defender_num;
		this.tactics = tactics;
	}

	/**
	 * getter of attacker num
	 * @return int number of attacker
	 */
	public int getAttacker_num() {
		return attacker_num;
	}

	/**
	 * setter of attacker number
	 * @param attacker_num
	 */
	public void setAttacker_num(int attacker_num) {
		this.attacker_num = attacker_num;
	}

	/**
	 * getter of midfielder num
	 * @return int number of midfielder
	 */
	public int getMidfielder_num() {
		return midfielder_num;
	}

	/**
	 * setter of midfielder num
	 * @param midfielder_num
	 */
	public void setMidfielder_num(int midfielder_num) {
		this.midfielder_num = midfielder_num;
	}

	/**
	 * getter of defender num
	 * @return int number of defender
	 */
	public int getDefender_num() {
		return defender_num;
	}

	/**
	 * setter of num of defender
	 * @param defender_num
	 */
	public void setDefender_num(int defender_num) {
		this.defender_num = defender_num;
	}

	/**
	 * getter of tactic
	 * @return Tactics
	 */
	public Tactics getTactics() {
		return tactics;
	}

	/**
	 * setter of tactics
	 * @param tactics
	 */
	public void setTactics(Tactics tactics) {
		this.tactics = tactics;
	}
	
	/**
	 * getter of annual pay
	 * @return double annual pay
	 */
	public double getAnnualPay() {
		return this.pay * 52;
	}

}
