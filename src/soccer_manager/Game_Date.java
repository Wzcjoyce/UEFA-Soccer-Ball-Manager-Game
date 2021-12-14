package soccer_manager;

import java.util.Calendar;
import java.util.GregorianCalendar;

import GUI.Game_Play_Main_Menu;

/**
 * Game Date Class
 * @author Zuocheng Wang
 *
 */
public class Game_Date {
	
	public GregorianCalendar  date;
	public int year;
	public int month;
	public int day;
	
	/**
	 * constructor of Game Date class
	 */
	public Game_Date()
	{
		this.date = new GregorianCalendar(2020, 8, 1);
		
	}
	
	
	/**
	 * constructor of Game Date class
	 * @param year
	 * @param month
	 * @param day
	 */
	public Game_Date(int year, int month, int day)
	{
		this.day = day;
		this.month = month;
		this.year = year;
		this.date = new GregorianCalendar(this.year, this.month, this.day);
	}

	/**
	 * getter of Date
	 * @return GregorianCalendar
	 */
	public GregorianCalendar getDate() {
		return date;
	}

	/**
	 * setter of Date
	 * @param year
	 * @param month
	 * @param day
	 */
	public void setDate(int year, int month, int day){
		
		this.date.set(year, month, day);
	}
	
	/**
	 * override toString method
	 */
	@Override
	public String toString() {
		if(date.get(Calendar.MONTH) == 00)
		{
			return String.format("%d/%02d/%02d", Game_Play_Main_Menu.Year_num, 12, date.get(Calendar.DAY_OF_MONTH));
		}
        return String.format("%d/%02d/%02d", date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
    }
	
	/**
	 * comparsion method
	 * @param date
	 * @return
	 */
	public boolean equals(Game_Date date)
	{
		if (this.date.get(Calendar.YEAR) == date.date.get(Calendar.YEAR) &&
				this.date.get(Calendar.MONTH) == date.date.get(Calendar.MONTH) &&
				this.date.get(Calendar.DAY_OF_MONTH) == date.date.get(Calendar.DAY_OF_MONTH))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
