package Club;


/**
 * class for hold soccer club's balance account
 * this class is modified from the Account ICE from class
 *
 */
public class Account {

	public double balance;
	
	/**
	 * constructor of Account class
	 */
	public Account(){balance = 0;} 
	
	/**
	 * constructor of account class with one argument
	 * @param balance
	 */
	public Account(double balance)
	{ this.balance=balance;}
	
	/**
	 * getter of balance
	 * @return double balance
	 */
	public double getBalance(){return balance;}
	
	/**
	 * setter of balance
	 * @param balance
	 */
	public void setBalance(double balance){this.balance=balance;}
	
	/**
	 * class to increase balance
	 * @param earn
	 */
	public void increaseBalance(double earn){this.balance += earn;}
	
	/**
	 * class to decrease balance
	 * @param spent
	 */
	public void decreaseBalance(double spent){this.balance -= spent;}
	
	/**
	 * class to print account information
	 */
	public void printAccount()
	{
		System.out.println("Balance = " + balance);
	}
	
	/**
	 * override toString method
	 */
	@Override
	public String toString()
	{
		return String.format("%.0f",balance);
	}
}
