package Club;

/**
 * Class for store stadium information
 * @author Zuocheng Wang
 *
 */
public class Stadium {
	
	String stadiumName;
	int capacity;
	
	/**
	 * constructor of Stadium class
	 * @param stadiumName
	 * @param capacity
	 */
	public Stadium(String stadiumName, int capacity)
	{
		this.stadiumName = stadiumName;
		this.capacity = capacity;
	}

	/**
	 * getter of stadium name
	 * @return String
	 */
	public String getStadiumName() {
		return stadiumName;
	}

	/**
	 * setter of stadium name
	 * @param stadiumName
	 */
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	/**
	 * getter of stadium capacity
	 * @return
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * setter of capacity
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * override toString method
	 */
	@Override
	public String toString()
	{
		return "Stadium: " + stadiumName +
				"                        Capacity: " + capacity;
	}

}
