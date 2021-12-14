package Club;


/**
 * This interface represents a single employee in the organization.
 */
public interface Employee {
  
	
	/**
	   * getter of employee name
	   * @return double weekly payrate double
	   */
    String getName();


  /**
   * Get the annual pay of this employee as per the organization records
   * @return the annual pay of this employee
   */
    double getAnnualPay();


  
    void printEmployees();


	/**
	   * getter of employee weeklyPay
	   * @return double weekly payrate double
	   */
	double getWeeklyPay();


	/**
	   * getter of employee age
	   * @return String
	   */
	int getAge();
	
	/**
	 * getter of employee Nationality
	 * @return String
	 */
	String getNationality();


}