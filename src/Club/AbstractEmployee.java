package Club;

/**
 * abstract class for all employee which extended by player class and manager class
 * @author Zuocheng Wang
 *
 */
public abstract class AbstractEmployee implements Employee {
	
	public String name; 
	public double pay;
	public double weekly_pay;
	public int age;
	public String nationality;
	
	public AbstractEmployee(String name, double pay, int age, String nationality)
	{
		this.name = name; 
		this.pay = pay;
		this.weekly_pay = this.pay /4;
		this.age = age;
		this.nationality = nationality;
	}
	
	  /**
	   * Get the name of this employee
	   * @return the name of this employee as a string
	   */
	public String getName()
	{
		return this.name;
	}
	
	
   /**
    * getter of Annual pay
    */
	public double getAnnualPay()
	{
		return this.pay;
	}

	
	/**
	 * getter of Annual pay
	 */
	public double getWeeklyPay()
	{
		return this.weekly_pay;
	}
	 
	/**
	 * toString method
	 */
	@Override
	public String toString()
	{
		return "Name: " + name + "\nNationality: " + nationality + "\nage: " + age + "\npay: " + pay +"\n";
	}
	  
	public void printEmployees()
	{
		System.out.println(this);
	}
	
	
	/**
	   * getter of employee age
	   * @return String
	   */
	public int getAge()
	{
		return this.age;
	}
	
	/**
	 * getter of employee Nationality
	 * @return String
	 */
	public String getNationality()
	{
		return this.nationality;
	}



}
