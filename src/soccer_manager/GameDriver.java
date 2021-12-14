package soccer_manager;

import java.util.List;

import Club.Club;
import Club.Player;
import Club.PlayerField;
import GUI.GameStatus;

/**
 * Game Driver Class
 * @author Zuocheng Wang
 *
 */
public class GameDriver {
	
	/**
	 * driver
	 * @param args
	 */
	public static void main(String[] args) {
		
		GameController controller = new GameController();
		controller.menu.start();
		controller.team_selection_screen.setVisible(false);
		
		GameController.LockGame_until_Given_Status(GameStatus.Team_Selection);
		controller.team_selection_screen.setVisible(true);
		
		GameController.LockGame_until_Given_Status(GameStatus.GAME_RUNNING);

		
		controller.UEFA.Swap_manager_with_user(GameController.team_name, GameController.user_name, GameController.user_age, GameController.user_nationality);
		List<Club> club_list = controller.UEFA.getClubs_list();
		Club userclub = GameController.UEFA.getUserClub(GameController.team_name);
		userclub.updateBalance_spent(userclub.getClub_manager().getAnnualPay());
		
		controller.set_User_next_event();

		controller.start_main_game_menu();
		controller.Game_Play_main_menu.setVisible(true);
		
		
	} 
	
}
