package soccer_manager;

import Club.Club;
import GUI.Board_talk_enum;

/**
 * Class for generate board talk
 * @author Zuocheng Wang
 *
 */
public class Generate_Board_Talk {


	public static Board_talk_enum CEO_talk = Board_talk_enum.Welcome;
	public Club userclub;
	
	/**
	 * constructor of board talk class
	 */
	public Generate_Board_Talk()
	{
		this.userclub = GameController.UEFA.getUserClub(GameController.team_name);
	}
	
	//Welcome, Group_Stage_Review, Round_16_Review, Round_8_Reivew, Semi_Final_Review, Final_Review
	/**
	 * method for generating associated message from board to user
	 * @return
	 */
	public String generate()
	{
		Club user_club = GameController.UEFA.getUserClub(GameController.team_name);
		
		if (CEO_talk == Board_talk_enum.goal_successful)
		{
			return "Dear " + GameController.user_name + "\n\n"
					+ "Congratuation on your performance!" + "\n\n"
					+ "You have reached my UEFA's goal of this season which is the Semi-Final.  "
					+ "As I promised at begining, I will provide more fund in the next transfer window" +
					"\nHope you can keep your performance and make us Champion this season" + 
					"\n\n\nThank you\n" + user_club.getClubName() + " Board Director\n" + user_club.getNameCEO();
		}
		else if (CEO_talk == Board_talk_enum.goal_fail)
		{
			return "Dear " + GameController.user_name + "\n\n"
					+ "You did not reached my UEFA's goal of this season which is the Semi-Final."
					+ "Therefore, I will not provide more fund in the next transfer window.\n" +
					"\nHope you can do better job next season" + 
					"\n\n\nThank you\n" + user_club.getClubName()+" Board Director\n" + user_club.getNameCEO();
		}
		else if (CEO_talk == Board_talk_enum.Champion)
		{
			return "Dear " + GameController.user_name + "\n\n\n"
					+ "Congratuation!" + "\n\n"
					+ "You made us the Champion of the Europe! We are obviously the best team."
					+ "I will provide even more fund in the next transfer window" +
					"\nHope you can keep your performance next season!" + 
					"\n\n\n\nThank you\n" + user_club.getClubName()+" Board Director\n" + user_club.getNameCEO();
		}
		else
		{
		
			return "Dear Mr./Ms." + GameController.user_name + "\n\n\n"
				+ "Welcome to "+ GameController.team_name + "!\n\n"
				+ "I am looking forward to seeing how your leadership and determination can get the best out of the players."
				+ "I will judge your success in the UEFA Champion League." + "\n\nMy goal for this season is to at least reach the Semi-Final."
				+ " If this goal can be reached, then I will provide more fund in the next transfer window. " +
				"However, failing the object may not be enough to satisfy our criteria." + 
				"\n\n\n\nThank you\n" + user_club.getClubName()+" Board Director\n" + user_club.getNameCEO();
		}
	}
	
	

}
