package database;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Class from load Player data from csv file
 * The csv file was downloaded from following link:
 * 
 * https://www.kaggle.com/stefanoleone992/fifa-21-complete-player-dataset
 * 
 * @author Zuocheng Wang
 *
 */
public class LoadDatabase {
	
	String[][] array;

	public LoadDatabase() throws IOException
	{
		List<String[]> row_data = new ArrayList<String[]>();
		String Line_String;
		
		FileInputStream database_file;

		database_file = new FileInputStream("processed_player_2021.csv");
		BufferedReader Input = new BufferedReader(new InputStreamReader(database_file));
		
		
		Line_String = Input.readLine();
		while (Line_String != null) {
			row_data.add(Line_String.split(","));
			Line_String = Input.readLine();
		}
		
		array = new String[row_data.size()][0];
		row_data.toArray(array);
		Input.close();
	}

	/**
	 * getter of 2D String array
	 * @return
	 */
	public String[][] getArray() {
		return array;
	}

}
