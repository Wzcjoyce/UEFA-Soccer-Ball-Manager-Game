package Club;
import java.util.List;
import java.util.function.Predicate;


/**
 * This interface represents an organization. It includes methods that an
 * organization is expected to offer.
 * 
 * Additional comments:
 * This is the organization interface which enforces 
 * some necessary methods to the OrganizationImpl class
 */

public interface Organization {


  void addPlayer(Player newEmployee, String supervisorName);
  
  
  void addManager(Manager newEmployee, String supervisorName);

  /**
   * Get the size of the organization, i.e. the total number of employees in
   * this organization.
   * @return the number of employees in this organization
   */
  int getSize();


  /**
   * Get a list of names of all employees in this organization.
   * @return a list of names of all employees as a list of {@link String}
   */
   List<String> allEmployees();
   
   /**
    * method that print Employees
    */
   void printEmployees();
   
   /**
	* allEmployees method which take predicate as arguments and use the predicate test
	* to filter the employee objects to a list of string with all employees' name
	* @return List of string
	*/
  List<String> allEmployees(Predicate<Employee> predicate);
  
  
  /**
   * get total annual pay of the whole organization
   * @return
   */
  double getTotalPay();
  
  
}