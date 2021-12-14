package GUI;

import javax.swing.JFrame;


import Club.Club;
import Club.Player;
import Club.PlayerField;
import Club.Tactics;
import Schedule.Event;
import Schedule.Round_events;
import soccer_manager.Championship;
import soccer_manager.GameController;
import soccer_manager.Game_Date;
import soccer_manager.Generate_Board_Talk;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

/**
 * Game Play main menu view class (GUI)
 * @author Zuocheng Wang
 *
 */
public class Game_Play_Main_Menu extends JFrame implements ActionListener  {
	
	//Overview, board email and main buttons;
	private JTextPane current_formation_text_area;
	private JTable player_table;
	private JScrollPane player_table_scroll;
	private JTable Other_Club_player_table;
	private JScrollPane Other_Club_player_table_scroll;
	private JPanel show_panel;
	private JButton overview;
	private JButton Board;
	private JButton Squad_info;
	private JButton Tactic;
	private JButton Transfer;
	private JButton Continue;
	private JButton Other_clubs;
	private JButton UEFA;
	private JTextPane Board_talk;
	
	//Other Club variable
	private JButton confirm_team_selection;
	private JComboBox comboBox;
	private JPanel panel_for_comboxBox;
	private JLabel Select_team_to_review;
	private String selected_team;
	private Object[][] selected_team_data;
	private JPanel UEFA_small_logo_1;

	//Tactics variable
	private String tactic_selected_player;
	private String tactic_tendency;
	private JTextPane user_club_Player_info_area;
	private JComboBox player_list_combobox;
	private JButton Review_Player_Info;
	private JButton Restore_default_lineup;
	private JComboBox tactic_tendency_selection;
	private JButton Add_to_Defender_button;
	private JButton Add_to_Midfielder_button;
	private JButton Add_to_Attacker_button;
	private JButton Add_to_goalkeeper_button;
	private JButton confirm_tactic;
	private Player selected_Player;
	
	//Transfer variable
	private JLabel Select_Player_to_review_transfer;
	private JButton confirm_player_selection_transfer;
	private JComboBox comboBox_transfer;
	private JButton confirm_team_selection_transfer;
	private String selected_trasnfer_player;
	
	public static double offer;
	public static Club transfer_out_club;
	public static Player transfer_player;
	
	public static int Year_num = 2020;;
	
	
	Event next_user_event;
	Club home_team;
	Club away_team;
	JTextPane Date_and_next_game;
	
	JPanel Home_team_logo;
	JPanel Away_team_logo;

	/**
	 * Constructor of Game Play Main Menu view
	 */
	public Game_Play_Main_Menu()
	{
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(100, 149, 237));
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel selection_panel = new JPanel();
		selection_panel.setBackground(new Color(100, 149, 237));
		selection_panel.setBounds(0, 0, 184, 571);
		getContentPane().add(selection_panel);
		
		overview = new JButton("Overview");
		overview.addActionListener(this);
		overview.setBounds(24, 24, 137, 42);
		overview.setForeground(new Color(255, 99, 71));
		overview.setBackground(new Color(255, 255, 255));
		overview.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		

		selection_panel.setLayout(null);
		selection_panel.add(overview);
		
	
		Board = new JButton("Board Email");
		Board.addActionListener(this);
		Board.setBounds(24, 90, 137, 42);
		Board.setForeground(new Color(255, 99, 71));
		Board.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		Board.setBackground(Color.WHITE);
		selection_panel.add(Board);
		

		Squad_info = new JButton("Squad");
		Squad_info.addActionListener(this);
		Squad_info.setBounds(24, 229, 137, 42);
		Squad_info.setForeground(new Color(255, 99, 71));
		Squad_info.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		Squad_info.setBackground(Color.WHITE);
		selection_panel.add(Squad_info);
		
		
		Tactic = new JButton("Tactic");	
		Tactic.addActionListener(this);
		Tactic.setForeground(new Color(255, 99, 71));
		Tactic.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		Tactic.setBackground(Color.WHITE);
		Tactic.setBounds(24, 298, 137, 42);
		selection_panel.add(Tactic);
		
		
		Transfer = new JButton("Transfer");
		Transfer.addActionListener(this);
		Transfer.setForeground(new Color(255, 99, 71));
		Transfer.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		Transfer.setBackground(Color.WHITE);
		Transfer.setBounds(24, 366, 137, 42);
		selection_panel.add(Transfer);
		

		UEFA = new JButton("UEFA");
		UEFA.addActionListener(this);
		UEFA.setForeground(new Color(255, 99, 71));
		UEFA.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		UEFA.setBackground(Color.WHITE);
		UEFA.setBounds(24, 159, 137, 42);
		selection_panel.add(UEFA);
		

		Other_clubs = new JButton("Other Clubs");
		Other_clubs.addActionListener(this);
		Other_clubs.setForeground(new Color(255, 99, 71));
		Other_clubs.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		Other_clubs.setBackground(Color.WHITE);
		Other_clubs.setBounds(24, 435, 137, 42);
		selection_panel.add(Other_clubs);
		

		Continue = new JButton("Next Match");	
		Continue.addActionListener(this);
		Continue.setForeground(new Color(255, 99, 71));
		Continue.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		Continue.setBackground(Color.WHITE);
		Continue.setBounds(24, 502, 137, 42);
		selection_panel.add(Continue);
		
		
		//show panel part
		show_panel = new MyImage(194, 59);
		show_panel.setBounds(194, 59, 576, 487);
		getContentPane().add(show_panel);
		show_panel.setLayout(null);

		
		//add game_play_overview.png background
		((MyImage)show_panel).addPicture("game_play_overview.png");
		Graphics temp_graphic = show_panel.getGraphics();
		if(temp_graphic != null)
		{
			show_panel.paint(temp_graphic);
		}
		
		
		//Draw small UEFA logo
		JPanel UEFA_small_logo = new JPanel()
		{
		    public void paintComponent(Graphics graphic)
		    {
		        Image image = new ImageIcon("UEFA.png").getImage();
		        Dimension size = new Dimension(60, 55);
		        setPreferredSize(size);
		        setMinimumSize(size);
		        setMaximumSize(size);
		        setSize(size);
		        getContentPane().setLayout(null);
		        graphic.drawImage(image, 0, 0, 60, 55, null);
		    }
		};
		UEFA_small_logo.setBounds(194, 0, 60, 55);
		getContentPane().add(UEFA_small_logo);
		
		
		JPanel UEFA_small_logo_2 = new JPanel()
		{
		    public void paintComponent(Graphics graphic)
		    {
		        Image image = new ImageIcon("UEFA.png").getImage();
		        Dimension size = new Dimension(60, 55);
		        setPreferredSize(size);
		        setMinimumSize(size);
		        setMaximumSize(size);
		        setSize(size);
		        getContentPane().setLayout(null);
		        graphic.drawImage(image, 0, 0, 60, 55, null);
		    }
		};
		UEFA_small_logo_2.setBounds(710, 0, 60, 55);
		getContentPane().add(UEFA_small_logo_2);
		
		
		
		this.next_user_event = GameController.next_user_event;
		home_team =  next_user_event.getHome_team();
		away_team =  next_user_event.getAway_team();
		
		Home_team_logo = new JPanel() 
		{
		    public void paintComponent(Graphics graphic)
		    {
		        Image image = new ImageIcon(home_team.getClubName() + ".png").getImage();
		        Dimension size = new Dimension(60, 55);
		        setPreferredSize(size);
		        setMinimumSize(size);
		        setMaximumSize(size);
		        setSize(size);
		        getContentPane().setLayout(null);
		        graphic.drawImage(image, 0, 0, 60, 55, null);
		    }
		};
		
		Home_team_logo.setBounds(282, 0, 60, 55);
		getContentPane().add(Home_team_logo);
		
		Away_team_logo = new JPanel()
		{
		    public void paintComponent(Graphics graphic)
		    {
		        Image image = new ImageIcon(away_team.getClubName() + ".png").getImage();
		        Dimension size = new Dimension(60, 55);
		        setPreferredSize(size);
		        setMinimumSize(size);
		        setMaximumSize(size);
		        setSize(size);
		        getContentPane().setLayout(null);
		        graphic.drawImage(image, 0, 0, 60, 55, null);
		    }
		};
		
		Away_team_logo.setBounds(623, 0, 60, 55);
		getContentPane().add(Away_team_logo);
		
		Date_and_next_game = new JTextPane();
		Date_and_next_game.setForeground(new Color(0, 0, 0));
		Date_and_next_game.setBackground(new Color(100, 149, 237));
		Date_and_next_game.setFont(new Font("Sitka Heading", Font.PLAIN, 14));
		Date_and_next_game.setEditable(false);
		Date_and_next_game.setBounds(377, 0, 239, 55);
		getContentPane().add(Date_and_next_game);
		Date_and_next_game.setText("Current Date:" + GameController.current_date + "\n"
				+ home_team.getClubName() + " vs " + away_team.getClubName() + "\n" 
				+ "Game Date:" + GameController.next_user_event.getDate());
		
		
		getContentPane().setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent game_play_menu) {
		
		 JButton game_play_buttons = (JButton) game_play_menu.getSource();
		 
		 if(game_play_buttons == overview)
		 {
			 GameController.pauseGame(200);
			 this.call_overview();
		 }
		 else if (game_play_buttons == Squad_info)
		 {
			 GameController.pauseGame(200);
			 this.call_squad();
		 }
		 else if (game_play_buttons == Board)
		 {
			 GameController.pauseGame(200);
			 this.call_Board();
		 }
		
		 //other club button
		 else if (game_play_buttons == Other_clubs)
		 {
			 GameController.pauseGame(200);
			 this.call_Other_clubs();
		 }
		 else if (game_play_buttons == confirm_team_selection)
		 {
			 GameController.pauseGame(200);
			 this.show_other_club();
		 }
		 
		 // tactic button
		 else if (game_play_buttons == Tactic)
		 {
			 GameController.pauseGame(200);
			 this.call_Tactic();
		 }
		 else if (game_play_buttons == Restore_default_lineup )
		 {
			 GameController.pauseGame(200);
			 this.call_Default();
		 }
		 else if(game_play_buttons == Review_Player_Info )
		 {
			 GameController.pauseGame(300);
			 call_Tactic_review_player();
		 }
		 else if(game_play_buttons == confirm_tactic)
		 {
			 GameController.pauseGame(300);
			 call_Confirm_Tactic();
		 }
		 else if(game_play_buttons == Add_to_Defender_button) 
		 {
			 GameController.pauseGame(300);
			 call_Add_DF();
		 }
		 else if(game_play_buttons == Add_to_Midfielder_button)
		 {
			 GameController.pauseGame(300);
			 call_Add_MF();
		 }
		 else if(game_play_buttons == Add_to_Attacker_button)
		 {
			 GameController.pauseGame(300);
			 call_Add_ATT();
		 }
		 else if(game_play_buttons == Add_to_goalkeeper_button)
		 {
			 GameController.pauseGame(300);
			 call_Add_GK();
		 }
		 else if(game_play_buttons == Restore_default_lineup)
		 {
			 GameController.pauseGame(300);
			 call_Add_GK();
		 }
		 
		 // transfer button
		 else if (game_play_buttons == Transfer)
		 {
			 GameController.pauseGame(200);
			 this.call_Transfer();
		 }
		 else if (game_play_buttons == confirm_team_selection_transfer)
		 {
			 GameController.pauseGame(200);
			 this.show_other_club_in_Transfer();
		 }
		 
		 else if (game_play_buttons == confirm_player_selection_transfer)
		 {
			 GameController.pauseGame(200);
			 
			 if(GameController.UEFA.Transfer_window_open == true)
			 {
				 this.call_transfer_player();
			 } else {
				 String window_closed = "Transfer Window is closed now";
				Music_Background window_closed_bgm_image = new Music_Background("window_closed.wav", "window_closed.png", window_closed);
				window_closed_bgm_image.play();
			 }
		 }
		 
		 // UEFA button
		 else if (game_play_buttons == UEFA)
		 {
			 GameController.pauseGame(200);
			 UEFA_button_View UEFA_view = new UEFA_button_View(this);
			 UEFA_view.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
			 UEFA_view.setSize(800, 600);
			 UEFA_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 UEFA_view.setLocationRelativeTo(null);
			 UEFA_view.setVisible(true);
		 }
		 
		 // Continue button
		 else if (game_play_buttons == Continue)
		 {
			 GameController.pauseGame(200);
			 this.hide_all();
			 if(GameController.status == GameStatus.GAME_Play_Main_Menu)
			 {
				 GameController.pauseGame(200);
				 GameController.UEFA.Transfer_window_open = false;
				 GameController.current_date = GameController.UEFA.game_date.get(GameController.current_event_date_index + 1);
				 GameController.current_event_date_index += 1;
				 GameController.UEFA.Run_group_match_events(GameController.current_date);
				 GameController.status = GameStatus.Group_Stage;
				 GameController.set_User_next_event();
				 check_group_game_result();
				 this.update_date_panel();
				 
			 }
			 else if(GameController.status == GameStatus.Group_Stage && !(GameController.current_date.equals(new Game_Date(Year_num, 12, 9))))
			 {
				 GameController.pauseGame(300);
				 GameController.current_date = GameController.UEFA.game_date.get(GameController.current_event_date_index + 1);
				 GameController.current_event_date_index += 1;
				 GameController.UEFA.Run_group_match_events(GameController.current_date);
				 
				 check_group_game_result();
				 GameController.set_User_next_event();
				 this.update_date_panel();
			 } 
			 else if(GameController.status == GameStatus.Group_Stage && GameController.current_date.equals(new Game_Date(Year_num, 12, 9)))
			 {
				 GameController.pauseGame(700);
				 GameController.current_date = new Game_Date(Year_num+1, 1, 1);
				 GameController.UEFA.Transfer_window_open = true;
				 GameController.status = GameStatus.Winter_Transfer_Window;
				 GameController.UEFA.setRound_of_16_teams();
				 if(Year_num != 2020)
				 {
					 GameController.UEFA.round_16_events = new Round_events(GameController.UEFA.round_of_16_teams);
				 }
				 GameController.UEFA.round_16_events.generate_events();
				 this.update_date_panel();
				 
				 String window_open = "Transfer Window is open now\nclick Transfer Button to make transfer";
				 Music_Background window_closed_bgm_image = new Music_Background("transfer_bgm.wav", "transfer_window_open.png", window_open);
				 window_closed_bgm_image.play();
			 }
			 else if(GameController.status == GameStatus.Winter_Transfer_Window && GameController.current_date.equals(new Game_Date(Year_num+1, 1, 1)))
			 {
				 GameController.pauseGame(200);
				 GameController.status = GameStatus.Round_16;
				 GameController.set_round_user_next_event();
				 this.update_date_panel();
			 } 
			 else if(GameController.status == GameStatus.Round_16 && GameController.current_date.equals(new Game_Date(Year_num+1, 1, 1)))
			 {
				 GameController.pauseGame(200);
				 GameController.current_date = GameController.UEFA.game_date.get(GameController.current_event_date_index + 1);
				 GameController.current_event_date_index += 1;
				 GameController.UEFA.Transfer_window_open = false;
				 
				 String window_closed = "Transfer Window is closed now";
				 Music_Background window_closed_bgm_image = new Music_Background("window_closed.wav", "window_closed.png", window_closed);
				 window_closed_bgm_image.play();
					
				 GameController.set_round_user_next_event();
				 this.update_date_panel();
				
			 } 
			 else if(GameController.status == GameStatus.Round_16 && GameController.current_date.equals(new Game_Date(Year_num+1, 2, 16)))
			 {
				 GameController.pauseGame(200);
				 GameController.UEFA.Run_round_match_events(GameController.current_date, 16);
				 GameController.current_date = GameController.UEFA.game_date.get(GameController.current_event_date_index + 1);
				 GameController.current_event_date_index += 1;
				 GameController.set_round_user_next_event();
				 this.update_date_panel(); 
			 }
			 else if(GameController.status == GameStatus.Round_16 && GameController.current_date.equals(new Game_Date(Year_num+1, 3, 9)))
			 {
				 GameController.pauseGame(200);
				 GameController.UEFA.Run_round_match_events(GameController.current_date, 16);
				 GameController.current_date = GameController.UEFA.game_date.get(GameController.current_event_date_index + 1);
				 GameController.current_event_date_index += 1;
				 GameController.UEFA.setRound_of_8_teams();
				 if(Year_num != 2020)
				 {
					 GameController.UEFA.round_8_events = new Round_events(GameController.UEFA.round_of_8_teams);
				 }
				 GameController.UEFA.round_8_events.generate_events();
				 GameController.status = GameStatus.Round_8;
				 GameController.set_round_user_next_event();
				 this.update_date_panel();
				 
			 }
			 else if(GameController.status == GameStatus.Round_8 && GameController.current_date.equals(new Game_Date(Year_num+1, 4, 7)))
			 {
				 GameController.pauseGame(200);
				 GameController.UEFA.Run_round_match_events(GameController.current_date, 8);
				 GameController.current_date = GameController.UEFA.game_date.get(GameController.current_event_date_index + 1);
				 GameController.current_event_date_index += 1;
				 GameController.set_round_user_next_event();
				 this.update_date_panel();
			 }
			 else if(GameController.status == GameStatus.Round_8 && GameController.current_date.equals(new Game_Date(Year_num+1, 4, 13)))
			 {
				 GameController.pauseGame(200);
				 GameController.UEFA.Run_round_match_events(GameController.current_date, 8);
				 GameController.current_date = GameController.UEFA.game_date.get(GameController.current_event_date_index + 1);
				 GameController.current_event_date_index += 1;
				 GameController.status = GameStatus.Semi_Final;
				 GameController.UEFA.setSemi_final();
				 if(Year_num != 2020)
				 {
					 GameController.UEFA.semi_final_events = new Round_events(GameController.UEFA.semi_final);
				 }
				 GameController.UEFA.semi_final_events.generate_events();
				 this.goal_success();
				 GameController.set_round_user_next_event();
				 this.update_date_panel();
			 }
			 else if(GameController.status == GameStatus.Semi_Final && GameController.current_date.equals(new Game_Date(Year_num+1, 4, 27)))
			 {
				 GameController.pauseGame(200);
				 GameController.UEFA.Run_round_match_events(GameController.current_date, 4);
				 GameController.current_date = GameController.UEFA.game_date.get(GameController.current_event_date_index + 1);
				 GameController.current_event_date_index += 1;
				 GameController.set_round_user_next_event();
				 this.update_date_panel();
			 }
			 else if(GameController.status == GameStatus.Semi_Final && GameController.current_date.equals(new Game_Date(Year_num+1, 5, 4)))
			 {
				 GameController.pauseGame(200);
				 GameController.UEFA.Run_round_match_events(GameController.current_date, 4);
				 GameController.status = GameStatus.Final;
				 GameController.current_date = GameController.UEFA.game_date.get(GameController.current_event_date_index + 1);
				 GameController.current_event_date_index += 1;
				 GameController.UEFA.setFinal_team();
				 if(Year_num != 2020)
				 {
					 GameController.UEFA.final_events = new Round_events(GameController.UEFA.final_team);
				 }
				 GameController.UEFA.final_events.generate_events();
				 GameController.set_round_user_next_event();
				 this.update_date_panel();
			 }
	
			 else if(GameController.status == GameStatus.Final && !GameController.current_date.equals(new Game_Date(Year_num+1, 8, 1)))
			 {
				 GameController.pauseGame(200);
				 GameController.UEFA.Run_round_match_events(GameController.current_date, 2);
				 this.champion_success();
				 GameController.UEFA.Transfer_window_open = true;
				 GameController.current_date = new Game_Date(Year_num+1, 8, 1);
				 this.update_date_panel();
			 }
			 else if(GameController.status == GameStatus.Final && GameController.current_date.equals(new Game_Date(Year_num+1, 8, 1)))
			 {
				 GameController.pauseGame(200);
				 String window_open = "Transfer Window is open now\nclick Transfer Button to make transfer";
				 Music_Background window_closed_bgm_image = new Music_Background("transfer_bgm.wav", "transfer_window_open.png", window_open);
				 window_closed_bgm_image.play();
				 GameController.status = GameStatus.GAME_Play_Main_Menu;
				 GameController.UEFA.add_date(Year_num+1);
				 Generate_Board_Talk.CEO_talk = Board_talk_enum.Welcome;
				 GameController.reset_data_from_last_season();
			 }
			
		 }
		
	}
	
	/**
	 * method for handling click overview button
	 */
	private void call_overview()
	{
		this.hide_all();
		current_formation_text_area = new JTextPane();
		current_formation_text_area.setBackground(new Color(224, 255, 255)); 
		current_formation_text_area.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		current_formation_text_area.setEditable(false);
		current_formation_text_area.setForeground(new Color(0, 0, 128));
		current_formation_text_area.setBounds(0, 0, 576, 487);//38, 30, 500, 427);
		show_panel.add(current_formation_text_area);
		
		Club userclub = GameController.UEFA.getUserClub(GameController.team_name);
		current_formation_text_area.setText(userclub.toDetailedString() + "\nManager: "+ GameController.user_name +"\n\nAttackers: \n" + userclub.PlayerPositionNameList(PlayerField.attacker)
		+ "\n\nMidfielders:\n" + userclub.PlayerPositionNameList(PlayerField.midfield)
		+ "\n\nDefenders:\n" + userclub.PlayerPositionNameList(PlayerField.defender)
		+ "\n\nGoalKeepers:\n" + userclub.PlayerPositionNameList(PlayerField.goalkeeper) 
		+ "\n\nSubstitutes:\n" + userclub.PlayerPositionNameList(PlayerField.substitute)); 
	}
	
	/**
	 * method for handling click squad button
	 */
	private void call_squad()
	{
		this.hide_all();
		Object[][] user_team_data = GameController.getUserTeam_database();
		Object title[] = {"Name", "Age","Nationality","Jersy Number","Shooting skill","Dribbling skill","Passing skill",
					"Intercept skill", "Stealing skill", "Goalkeeper skill", "Stamina", "Annual Pay", "Player Value"};
	
		player_table = new JTable(user_team_data, title);
		player_table.setBackground(new Color(224, 255, 255));
		player_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
		
		player_table_scroll = new JScrollPane(player_table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		getContentPane().remove(show_panel);
		getContentPane().add(player_table_scroll);
		player_table_scroll.setBounds(194, 59, 576, 487);
		player_table.setFillsViewportHeight(true);
		
	}
	
	/**
	 * method for handling click board button
	 */
	private void call_Board()
	{
		this.hide_all();
		Generate_Board_Talk board_talk = new Generate_Board_Talk();
		String board_talk_text = board_talk.generate();
		Board_talk = new JTextPane();
		Board_talk.setText(board_talk_text);
		Board_talk.setForeground(new Color(0, 0, 128));
		Board_talk.setBackground(new Color(224, 255, 255));
		Board_talk.setFont(new Font("Arial", Font.ITALIC, 14));
		Board_talk.setEditable(false);
		Board_talk.setBounds(0, 0, 576, 487);//38, 30, 500, 427);
		show_panel.add(Board_talk);
		
	}
	
	/**
	 * method for handling click other clubs button
	 */
	private void call_Other_clubs()
	{
		this.hide_all_without_showpanel();
		
		
		panel_for_comboxBox = new JPanel();
		panel_for_comboxBox.setBounds(194, 59, 580, 52);
		panel_for_comboxBox.setLayout(null);
		panel_for_comboxBox.setBackground(new Color(100, 149, 237));
		
		String[] team_choices = { "Chelsea","Atletico Madrid","Bayern Munich",
                "Lokomotiv Moscow","Red Bull Salzburg", "Real Madrid",
                "Borussia Mionchengladbach", "Shakhtar Donetsk", "Inter Milan",
                "Manchester City", "Porto", "Olympiacos","Marseille","Liverpool",
                "Atalanta", "Ajax", "Midtjylland", "Sevilla", "Spartak Moscow",
                "Rennes","Borussia Dortmund", "Lazio", "Club Brugge","PFC CSKA Moscow",
                "Juventus", "Barcelona", "Dynamo Kyiv", "Benfica", "Paris Saint-Germain",
                "RB Leipzig", "Manchester United", "Galatasaray"};
		
		comboBox = new JComboBox<String>(team_choices);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setBounds(130, 10, 180, 25);

		
		Select_team_to_review = new JLabel("Select Club:");
		Select_team_to_review.setFont(new Font("Arial", Font.BOLD, 15));
		Select_team_to_review.setForeground(new Color(255, 99, 71));
		Select_team_to_review.setBounds(10, 10, 120, 25);
		
		confirm_team_selection = new JButton("Show Team Squad");
		confirm_team_selection.setFont(new Font("Arial", Font.PLAIN, 14));
		confirm_team_selection.setBounds(330, 10, 180, 25);
		confirm_team_selection.addActionListener(this);
		
		
		selected_team = (String) comboBox.getSelectedItem();
		
		selected_team_data = GameController.getTeam_database(selected_team);
		Object title[] = {"Name", "Age","Nationality","Jersy Number","Shooting skill","Dribbling skill","Passing skill",
					"Intercept skill", "Stealing skill", "Goalkeeper skill", "Stamina", "Annual Pay", "Player Value"};
	
		Other_Club_player_table = new JTable(selected_team_data, title);
		Other_Club_player_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
		
		Other_Club_player_table_scroll = new JScrollPane(Other_Club_player_table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		getContentPane().remove(show_panel);
		getContentPane().add(Other_Club_player_table_scroll);
		getContentPane().add(panel_for_comboxBox);
		panel_for_comboxBox.add(comboBox);
		panel_for_comboxBox.add(Select_team_to_review);
		panel_for_comboxBox.add(confirm_team_selection);
		
		Other_Club_player_table_scroll.setBounds(222, 122, 521, 413); 
		Other_Club_player_table.setBackground(new Color(224, 255, 255));
		Other_Club_player_table.setFillsViewportHeight(true);
		
	} 
	
	/**
	 * method for update the showing panel
	 */
	private void hide_all()
	{
		getContentPane().add(show_panel);
		GameController.pauseGame(200);
		if(!show_panel.isVisible())
		{
			show_panel.setVisible(true);
		}
		
		if(panel_for_comboxBox != null)
		{
			panel_for_comboxBox.setVisible(false);
		}
		if (player_table_scroll != null)
		{
			player_table_scroll.setVisible(false);
		}
		
		if (current_formation_text_area != null)
		{
			current_formation_text_area.setVisible(false);
		}
		
		if (Board_talk != null)
		{
			Board_talk.setVisible(false);
		}
		
		
		// following two if condition for handling the other club button
		if (Other_Club_player_table_scroll != null)
		{
			Other_Club_player_table_scroll.setVisible(false);
			comboBox.setVisible(false);
		} 
		if (panel_for_comboxBox != null)
		{
			panel_for_comboxBox.setVisible(false);
			comboBox.setVisible(false);
		} 
		if(Select_team_to_review != null)
		{
			Select_team_to_review.setVisible(false);
		}
		
		if (confirm_team_selection != null)
		{
			confirm_team_selection.setVisible(false);
		}
		
		// remove tactic menu
		if (user_club_Player_info_area != null)
		{
			user_club_Player_info_area.setVisible(false);
			player_list_combobox.setVisible(false);
			Review_Player_Info.setVisible(false);
			Restore_default_lineup.setVisible(false);
			tactic_tendency_selection.setVisible(false);
			Add_to_Defender_button.setVisible(false);
			Add_to_Midfielder_button.setVisible(false);
			Add_to_Attacker_button.setVisible(false);
			Add_to_goalkeeper_button.setVisible(false);
			confirm_tactic.setVisible(false);
			getContentPane().remove(user_club_Player_info_area);
			getContentPane().remove(player_list_combobox);
			getContentPane().remove(Review_Player_Info);
			getContentPane().remove(Restore_default_lineup);
			getContentPane().remove(tactic_tendency_selection);
			getContentPane().remove(Add_to_Defender_button);
			getContentPane().remove(Add_to_Midfielder_button);
			getContentPane().remove(Add_to_Attacker_button);
			getContentPane().remove(Add_to_goalkeeper_button);
			getContentPane().remove(confirm_tactic);
		}
		
		if (Select_team_to_review != null)
		{
			Select_team_to_review.setVisible(false);
		}
		
		if(confirm_team_selection != null)
		{
			confirm_team_selection.setVisible(false);
		}
		
	
	}
	
	private void hide_all_without_showpanel()
	{
		if(panel_for_comboxBox != null)
		{
			panel_for_comboxBox.setVisible(false);
		}
		if (show_panel != null)
		{
			show_panel.setVisible(false);
		}
		if (player_table_scroll != null)
		{
			player_table_scroll.setVisible(false);
		}
		
		if (current_formation_text_area != null)
		{
			current_formation_text_area.setVisible(false);
		}
		
		if (Board_talk != null)
		{
			Board_talk.setVisible(false);
		}
		
		
		// following two if condition for handling the other club button
		if (Other_Club_player_table_scroll != null)
		{
			Other_Club_player_table_scroll.setVisible(false);
		}
		if (panel_for_comboxBox != null)
		{
			panel_for_comboxBox.setVisible(false);
			comboBox.setVisible(false);
			getContentPane().remove(panel_for_comboxBox);
		} 
		
		// remove tactic menu
		if (user_club_Player_info_area != null)
		{
			user_club_Player_info_area.setVisible(false);
			player_list_combobox.setVisible(false);
			Review_Player_Info.setVisible(false);
			Restore_default_lineup.setVisible(false);
			tactic_tendency_selection.setVisible(false);
			Add_to_Defender_button.setVisible(false);
			Add_to_Midfielder_button.setVisible(false);
			Add_to_Attacker_button.setVisible(false);
			Add_to_goalkeeper_button.setVisible(false);
			confirm_tactic.setVisible(false);
			getContentPane().remove(user_club_Player_info_area);
			getContentPane().remove(player_list_combobox);
			getContentPane().remove(Review_Player_Info);
			getContentPane().remove(Restore_default_lineup);
			getContentPane().remove(tactic_tendency_selection);
			getContentPane().remove(Add_to_Defender_button);
			getContentPane().remove(Add_to_Midfielder_button);
			getContentPane().remove(Add_to_Attacker_button);
			getContentPane().remove(Add_to_goalkeeper_button);
			getContentPane().remove(confirm_tactic);
		}
		
		if (Select_team_to_review != null)
		{
			Select_team_to_review.setVisible(false);
		}
		
		if(confirm_team_selection != null)
		{
			confirm_team_selection.setVisible(false);
		}
	
	}
	
	private void hide_all_without_showpanel_for_transfer()
	{
		if(panel_for_comboxBox != null)
		{
			panel_for_comboxBox.setVisible(false);
		}
		if (show_panel != null)
		{
			show_panel.setVisible(false);
		}
		if (player_table_scroll != null)
		{
			player_table_scroll.setVisible(false);
		}
		
		if (current_formation_text_area != null)
		{
			current_formation_text_area.setVisible(false);
		}
		
		if (Board_talk != null)
		{
			Board_talk.setVisible(false);
		}
		
		
		// following two if condition for handling the other club button
		if (Other_Club_player_table_scroll != null)
		{
			Other_Club_player_table_scroll.setVisible(false);
		}
		if (panel_for_comboxBox != null)
		{
			panel_for_comboxBox.setVisible(false);
			comboBox.setVisible(false);
			Select_team_to_review.setVisible(false);
			confirm_team_selection.setVisible(false);
			getContentPane().remove(panel_for_comboxBox);
		} 
		
		// remove tactic menu
		if (user_club_Player_info_area != null)
		{
			user_club_Player_info_area.setVisible(false);
			player_list_combobox.setVisible(false);
			Review_Player_Info.setVisible(false);
			Restore_default_lineup.setVisible(false);
			tactic_tendency_selection.setVisible(false);
			Add_to_Defender_button.setVisible(false);
			Add_to_Midfielder_button.setVisible(false);
			Add_to_Attacker_button.setVisible(false);
			Add_to_goalkeeper_button.setVisible(false);
			confirm_tactic.setVisible(false);
			getContentPane().remove(user_club_Player_info_area);
			getContentPane().remove(player_list_combobox);
			getContentPane().remove(Restore_default_lineup);
			getContentPane().remove(tactic_tendency_selection);
			getContentPane().remove(Add_to_Defender_button);
			getContentPane().remove(Add_to_Midfielder_button);
			getContentPane().remove(Add_to_Attacker_button);
			getContentPane().remove(Add_to_goalkeeper_button);
			getContentPane().remove(confirm_tactic);
		}
		
		if(Review_Player_Info != null)
		{
			Review_Player_Info.setVisible(false);
		}
		
	
	}
	
	/**
	 * method for handling click other club button
	 */
	private void show_other_club()
	{
		if (Other_Club_player_table_scroll != null)
		{
			Other_Club_player_table_scroll.setVisible(false);
		}
		
		selected_team = (String) comboBox.getSelectedItem();
		
		selected_team_data = GameController.getTeam_database(selected_team);
		Object title[] = {"Name", "Age","Nationality","Jersy Number","Shooting skill","Dribbling skill","Passing skill",
					"Intercept skill", "Stealing skill", "Goalkeeper skill", "Stamina", "Annual Pay", "Player Value"};
	
		Other_Club_player_table = new JTable(selected_team_data, title);
		Other_Club_player_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
		
		Other_Club_player_table_scroll = new JScrollPane(Other_Club_player_table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		getContentPane().remove(show_panel);
		getContentPane().add(Other_Club_player_table_scroll);
		getContentPane().add(panel_for_comboxBox);
		panel_for_comboxBox.add(comboBox);
		panel_for_comboxBox.add(Select_team_to_review);
		panel_for_comboxBox.add(confirm_team_selection);
		
		
		Other_Club_player_table_scroll.setBounds(222, 122, 521, 413); 
		Other_Club_player_table.setBackground(new Color(224, 255, 255));
		Other_Club_player_table.setFillsViewportHeight(true);
	}
	
	
	/**
	 * method for handling click tactic button
	 */
	private void call_Tactic()
	{
		Club userclub = GameController.UEFA.getUserClub(GameController.team_name);
		this.hide_all_without_showpanel();
		
		
		current_formation_text_area = new JTextPane();
		current_formation_text_area.setBackground(new Color(224, 255, 255)); 
		current_formation_text_area.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		current_formation_text_area.setEditable(false);
		current_formation_text_area.setForeground(new Color(0, 0, 128));
		current_formation_text_area.setBounds(486, 223, 290, 323);//(292, 164, 284, 323);
		getContentPane().add(current_formation_text_area);
		
		String[] Name_list = userclub.getPlayer_NameList();
		player_list_combobox = new JComboBox(Name_list);
		player_list_combobox.setBounds(214, 83, 106, 27);//(33, 24, 106, 27);
		getContentPane().add(player_list_combobox);
		tactic_selected_player = (String) player_list_combobox.getSelectedItem();
		
		Review_Player_Info = new JButton("Review Player");
		Review_Player_Info.setBounds(344, 83, 120, 27);//(163, 24, 106, 27);
		Review_Player_Info.addActionListener(this);
		getContentPane().add(Review_Player_Info);
		
		Restore_default_lineup = new JButton("Default");
		Restore_default_lineup.setBounds(485, 83, 106, 27);//(163, 24, 106, 27);
		Restore_default_lineup.addActionListener(this);
		getContentPane().add(Restore_default_lineup);
		
		String[] tactics_list = {"Park the Bus","Counter Attack", "Balance", "Tiki Taka", "Attacking", "All-out"};
		tactic_tendency_selection = new JComboBox(tactics_list);
		tactic_tendency_selection.setBounds(620, 83, 138, 27);//(350, 24, 138, 27);
		getContentPane().add(tactic_tendency_selection);
		tactic_tendency = (String) tactic_tendency_selection.getSelectedItem();
		
		confirm_tactic = new JButton("Confirm Tactic");
		confirm_tactic.setBounds(620, 130, 138, 27);//(20, 108, 106, 27);
		confirm_tactic.addActionListener(this);
		getContentPane().add(confirm_tactic);
		
		Add_to_Defender_button = new JButton("Add DF");
		Add_to_Defender_button.setBounds(214, 187, 106, 27);//(20, 108, 106, 27);
		Add_to_Defender_button.addActionListener(this);
		getContentPane().add(Add_to_Defender_button);
		
		Add_to_Midfielder_button = new JButton("Add MF");
		Add_to_Midfielder_button.setBounds(357, 187, 106, 27); //(163, 108, 106, 27);
		Add_to_Midfielder_button.addActionListener(this);
		getContentPane().add(Add_to_Midfielder_button);
		
		Add_to_Attacker_button = new JButton("Add ATT");
		Add_to_Attacker_button.setBounds(504, 187, 106, 27); //(310, 108, 106, 27);
		Add_to_Attacker_button.addActionListener(this);
		getContentPane().add(Add_to_Attacker_button);
		
		Add_to_goalkeeper_button = new JButton("Add GK");
		Add_to_goalkeeper_button.setBounds(654, 187, 106, 27); //(460, 110, 106, 27);
		Add_to_goalkeeper_button.addActionListener(this);
		getContentPane().add(Add_to_goalkeeper_button);
		
		
	
		current_formation_text_area.setText(GameController.team_name + " Default Starting Line Up:" + "\nAttackers: \n" + userclub.Print_current_PlayerPosition_attacker_LineUp_NameList()
		+ "\n\nMidfielders:\n" + userclub.Print_current_PlayerPosition_midfielder_LineUp_NameList()
		+ "\n\nDefenders:\n" + userclub.Print_current_PlayerPosition_defender_LineUp_NameList()
		+ "\n\nGoalKeepers:\n" + userclub.Print_current_PlayerPosition_goalkeeper_LineUp_NameList()
		+ "\n\nTeam Tactics:  " + userclub.getTeamTactics()); 
		
		user_club_Player_info_area = new JTextPane();
		selected_Player = userclub.getPlayer(tactic_selected_player);
		user_club_Player_info_area.setText("Review Selected Player Information:\n" + selected_Player.toString());
		user_club_Player_info_area.setForeground(new Color(0, 0, 128));
		user_club_Player_info_area.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		user_club_Player_info_area.setEditable(false);
		user_club_Player_info_area.setBackground(new Color(224, 255, 255));
		user_club_Player_info_area.setBounds(204, 223, 270, 323);//(10, 164, 284, 323);
		getContentPane().add(user_club_Player_info_area);
	}
	
	/**
	 * method for handling click review button
	 */
	private void call_Tactic_review_player()
	{
		Club userclub = GameController.UEFA.getUserClub(GameController.team_name);
		
		if (user_club_Player_info_area != null)
		{
			user_club_Player_info_area.setVisible(false);
		}
		
		
		tactic_selected_player = (String) player_list_combobox.getSelectedItem();
		getContentPane().add(player_list_combobox);
		
		
		user_club_Player_info_area = new JTextPane();
		selected_Player = userclub.getPlayer(tactic_selected_player);
		user_club_Player_info_area.setText("Review Selected Player Information:\n" + selected_Player.toString());
		user_club_Player_info_area.setForeground(new Color(0, 0, 128));
		user_club_Player_info_area.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		user_club_Player_info_area.setEditable(false);
		user_club_Player_info_area.setBackground(new Color(224, 255, 255));
		user_club_Player_info_area.setBounds(204, 223, 270, 323);//(10, 164, 284, 323);
		getContentPane().add(user_club_Player_info_area);
	}
	
	
	/**
	 * method for handling click confirm button in tactic view
	 */
	private void call_Confirm_Tactic()
	{
		Club userclub = GameController.UEFA.getUserClub(GameController.team_name);
		
		if (current_formation_text_area != null)
		{
			current_formation_text_area.setVisible(false);
		}
		
		
		tactic_tendency = (String) tactic_tendency_selection.getSelectedItem();
		getContentPane().add(tactic_tendency_selection);
		Tactics tactic = Tactics.toTactic(tactic_tendency);
		userclub.getClub_manager().setTactics(tactic);
		
		current_formation_text_area = new JTextPane();
		current_formation_text_area.setBackground(new Color(224, 255, 255)); 
		current_formation_text_area.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		current_formation_text_area.setEditable(false);
		current_formation_text_area.setForeground(new Color(0, 0, 128));
		current_formation_text_area.setBounds(486, 223, 290, 323);//(292, 164, 284, 323);
		
		current_formation_text_area.setText(GameController.team_name + " Current Starting Line Up:" + "\nAttackers: \n" + userclub.Print_current_PlayerPosition_attacker_LineUp_NameList()
		+ "\n\nMidfielders:\n" + userclub.Print_current_PlayerPosition_midfielder_LineUp_NameList()
		+ "\n\nDefenders:\n" + userclub.Print_current_PlayerPosition_defender_LineUp_NameList()
		+ "\n\nGoalKeepers:\n" + userclub.Print_current_PlayerPosition_goalkeeper_LineUp_NameList()
		+ "\n\nTeam Tactics:  " + userclub.getTeamTactics()); 
		
		getContentPane().add(current_formation_text_area);
	}
	
	/**
	 * method for handling click Add DF button in tactic view
	 */
	private void call_Add_DF()
	{
		Club userclub = GameController.UEFA.getUserClub(GameController.team_name);
		
		if (current_formation_text_area != null)
		{
			current_formation_text_area.setVisible(false);
			user_club_Player_info_area.setVisible(false);
		}
		
		tactic_selected_player = (String) player_list_combobox.getSelectedItem();
		getContentPane().add(player_list_combobox);
		
		user_club_Player_info_area = new JTextPane();
		selected_Player = userclub.getPlayer(tactic_selected_player);
		user_club_Player_info_area.setText("Review Selected Player Information:\n" + selected_Player.toString());
		user_club_Player_info_area.setForeground(new Color(0, 0, 128));
		user_club_Player_info_area.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		user_club_Player_info_area.setEditable(false);
		user_club_Player_info_area.setBackground(new Color(224, 255, 255));
		user_club_Player_info_area.setBounds(204, 223, 270, 323);//(10, 164, 284, 323);
		getContentPane().add(user_club_Player_info_area);
		
		
		current_formation_text_area = new JTextPane();
		current_formation_text_area.setBackground(new Color(224, 255, 255)); 
		current_formation_text_area.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		current_formation_text_area.setEditable(false);
		current_formation_text_area.setForeground(new Color(0, 0, 128));
		current_formation_text_area.setBounds(486, 223, 290, 323);//(292, 164, 284, 323);
		
		userclub.add_to_Defender_LineUp(tactic_selected_player);
		
		
		current_formation_text_area.setText(GameController.team_name + " Current Starting Line Up:" + "\nAttackers: \n" + userclub.Print_current_PlayerPosition_attacker_LineUp_NameList()
		+ "\n\nMidfielders:\n" + userclub.Print_current_PlayerPosition_midfielder_LineUp_NameList()
		+ "\n\nDefenders:\n" + userclub.Print_current_PlayerPosition_defender_LineUp_NameList()
		+ "\n\nGoalKeepers:\n" + userclub.Print_current_PlayerPosition_goalkeeper_LineUp_NameList()
		+ "\n\nTeam Tactics:  " + userclub.getTeamTactics()); 
		
		getContentPane().add(current_formation_text_area);
	}
	
	/**
	 * method for handling click Add MF button in tactic view
	 */
	private void call_Add_MF()
	{
		Club userclub = GameController.UEFA.getUserClub(GameController.team_name);
		
		if (current_formation_text_area != null)
		{
			current_formation_text_area.setVisible(false);
			user_club_Player_info_area.setVisible(false);
		}
		
		tactic_selected_player = (String) player_list_combobox.getSelectedItem();
		getContentPane().add(player_list_combobox);
		
		user_club_Player_info_area = new JTextPane();
		selected_Player = userclub.getPlayer(tactic_selected_player);
		user_club_Player_info_area.setText("Review Selected Player Information:\n" + selected_Player.toString());
		user_club_Player_info_area.setForeground(new Color(0, 0, 128));
		user_club_Player_info_area.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		user_club_Player_info_area.setEditable(false);
		user_club_Player_info_area.setBackground(new Color(224, 255, 255));
		user_club_Player_info_area.setBounds(204, 223, 270, 323);//(10, 164, 284, 323);
		getContentPane().add(user_club_Player_info_area);
		
		
		current_formation_text_area = new JTextPane();
		current_formation_text_area.setBackground(new Color(224, 255, 255)); 
		current_formation_text_area.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		current_formation_text_area.setEditable(false);
		current_formation_text_area.setForeground(new Color(0, 0, 128));
		current_formation_text_area.setBounds(486, 223, 290, 323);//(292, 164, 284, 323);
		
		userclub.add_to_Midfielder_LineUp(tactic_selected_player);
		
		
		current_formation_text_area.setText(GameController.team_name + " Current Starting Line Up:" + "\nAttackers: \n" + userclub.Print_current_PlayerPosition_attacker_LineUp_NameList()
		+ "\n\nMidfielders:\n" + userclub.Print_current_PlayerPosition_midfielder_LineUp_NameList()
		+ "\n\nDefenders:\n" + userclub.Print_current_PlayerPosition_defender_LineUp_NameList()
		+ "\n\nGoalKeepers:\n" + userclub.Print_current_PlayerPosition_goalkeeper_LineUp_NameList()
		+ "\n\nTeam Tactics:  " + userclub.getTeamTactics()); 
		
		getContentPane().add(current_formation_text_area);
	}
	
	/**
	 * method for handling click Add ATT button in tactic view
	 */
	private void call_Add_ATT()
	{
		Club userclub = GameController.UEFA.getUserClub(GameController.team_name);
		
		if (current_formation_text_area != null)
		{
			current_formation_text_area.setVisible(false);
			user_club_Player_info_area.setVisible(false);
		}
		
		tactic_selected_player = (String) player_list_combobox.getSelectedItem();
		getContentPane().add(player_list_combobox);
		
		user_club_Player_info_area = new JTextPane();
		selected_Player = userclub.getPlayer(tactic_selected_player);
		user_club_Player_info_area.setText("Review Selected Player Information:\n" + selected_Player.toString());
		user_club_Player_info_area.setForeground(new Color(0, 0, 128));
		user_club_Player_info_area.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		user_club_Player_info_area.setEditable(false);
		user_club_Player_info_area.setBackground(new Color(224, 255, 255));
		user_club_Player_info_area.setBounds(204, 223, 270, 323);//(10, 164, 284, 323);
		getContentPane().add(user_club_Player_info_area);
		
		
		current_formation_text_area = new JTextPane();
		current_formation_text_area.setBackground(new Color(224, 255, 255)); 
		current_formation_text_area.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		current_formation_text_area.setEditable(false);
		current_formation_text_area.setForeground(new Color(0, 0, 128));
		current_formation_text_area.setBounds(486, 223, 290, 323);//(292, 164, 284, 323);
		
		userclub.add_to_Attacker_LineUp(tactic_selected_player);
		
		
		current_formation_text_area.setText(GameController.team_name + " Current Starting Line Up:" + "\nAttackers: \n" + userclub.Print_current_PlayerPosition_attacker_LineUp_NameList()
		+ "\n\nMidfielders:\n" + userclub.Print_current_PlayerPosition_midfielder_LineUp_NameList()
		+ "\n\nDefenders:\n" + userclub.Print_current_PlayerPosition_defender_LineUp_NameList()
		+ "\n\nGoalKeepers:\n" + userclub.Print_current_PlayerPosition_goalkeeper_LineUp_NameList()
		+ "\n\nTeam Tactics:  " + userclub.getTeamTactics()); 
		
		getContentPane().add(current_formation_text_area);
	}
	
	
	private void call_Add_GK()
	{
		Club userclub = GameController.UEFA.getUserClub(GameController.team_name);
		
		if (current_formation_text_area != null)
		{
			current_formation_text_area.setVisible(false);
			user_club_Player_info_area.setVisible(false);
		}
		
		tactic_selected_player = (String) player_list_combobox.getSelectedItem();
		getContentPane().add(player_list_combobox);
		
		user_club_Player_info_area = new JTextPane();
		selected_Player = userclub.getPlayer(tactic_selected_player);
		user_club_Player_info_area.setText("Review Selected Player Information:\n" + selected_Player.toString());
		user_club_Player_info_area.setForeground(new Color(0, 0, 128));
		user_club_Player_info_area.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		user_club_Player_info_area.setEditable(false);
		user_club_Player_info_area.setBackground(new Color(224, 255, 255));
		user_club_Player_info_area.setBounds(204, 223, 270, 323);//(10, 164, 284, 323);
		getContentPane().add(user_club_Player_info_area);
		
		
		current_formation_text_area = new JTextPane();
		current_formation_text_area.setBackground(new Color(224, 255, 255)); 
		current_formation_text_area.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		current_formation_text_area.setEditable(false);
		current_formation_text_area.setForeground(new Color(0, 0, 128));
		current_formation_text_area.setBounds(486, 223, 290, 323);//(292, 164, 284, 323);
		
		userclub.add_to_goalkeeper_LineUp(tactic_selected_player);
		
		
		current_formation_text_area.setText(GameController.team_name + " Current Starting Line Up:" + "\nAttackers: \n" + userclub.Print_current_PlayerPosition_attacker_LineUp_NameList()
		+ "\n\nMidfielders:\n" + userclub.Print_current_PlayerPosition_midfielder_LineUp_NameList()
		+ "\n\nDefenders:\n" + userclub.Print_current_PlayerPosition_defender_LineUp_NameList()
		+ "\n\nGoalKeepers:\n" + userclub.Print_current_PlayerPosition_goalkeeper_LineUp_NameList()
		+ "\n\nTeam Tactics:  " + userclub.getTeamTactics()); 
		
		getContentPane().add(current_formation_text_area);
	}
	
	/**
	 * method for handling click Default button in tactic view
	 */
	private void call_Default()
	{
		Club userclub = GameController.UEFA.getUserClub(GameController.team_name);
		
		if (current_formation_text_area != null)
		{
			current_formation_text_area.setVisible(false);
		}
		
		current_formation_text_area = new JTextPane();
		current_formation_text_area.setBackground(new Color(224, 255, 255)); 
		current_formation_text_area.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		current_formation_text_area.setEditable(false);
		current_formation_text_area.setForeground(new Color(0, 0, 128));
		current_formation_text_area.setBounds(486, 223, 290, 323);//(292, 164, 284, 323);
		
		userclub.getDefault_Starting_lineup_attacker();
		userclub.getDefault_Starting_lineup_midfielder();
		userclub.getDefault_Starting_lineup_defender();
		userclub.getDefault_Starting_lineup_goalkeeper();
		
		current_formation_text_area.setText(GameController.team_name + " Current Starting Line Up:" + "\nAttackers: \n" + userclub.Print_PlayerPosition_attacker_LineUp_NameList()
		+ "\n\nMidfielders:\n" + userclub.Print_PlayerPosition_midfielder_LineUp_NameList()
		+ "\n\nDefenders:\n" + userclub.Print_PlayerPosition_defender_LineUp_NameList()
		+ "\n\nGoalKeepers:\n" + userclub.Print_PlayerPosition_goalkeeper_LineUp_NameList()
		+ "\n\nTeam Tactics:  " + userclub.getTeamTactics()); 
		
		getContentPane().add(current_formation_text_area);
	}
	
	/**
	 * method for handling click Transfer button
	 */
	private void call_Transfer()
	{
		this.hide_all_without_showpanel();
		
		Championship championship = GameController.UEFA;
		
		panel_for_comboxBox = new JPanel();
		panel_for_comboxBox.setBounds(194, 59, 580, 112);
		panel_for_comboxBox.setLayout(null);
		panel_for_comboxBox.setBackground(new Color(100, 149, 237));
		
		String[] team_choices = { "Chelsea","Atletico Madrid","Bayern Munich",
                "Lokomotiv Moscow","Red Bull Salzburg", "Real Madrid",
                "Borussia Mionchengladbach", "Shakhtar Donetsk", "Inter Milan",
                "Manchester City", "Porto", "Olympiacos","Marseille","Liverpool",
                "Atalanta", "Ajax", "Midtjylland", "Sevilla", "Spartak Moscow",
                "Rennes","Borussia Dortmund", "Lazio", "Club Brugge","PFC CSKA Moscow",
                "Juventus", "Barcelona", "Dynamo Kyiv", "Benfica", "Paris Saint-Germain",
                "RB Leipzig", "Manchester United", "Galatasaray"};
		
		team_choices = remove_from_string_array(GameController.team_name, team_choices);
		
		comboBox = new JComboBox<String>(team_choices);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setBounds(130, 10, 180, 25);
		
		Select_team_to_review = new JLabel("Select Club:");
		Select_team_to_review.setFont(new Font("Arial", Font.BOLD, 15));
		Select_team_to_review.setForeground(new Color(255, 99, 71));
		Select_team_to_review.setBounds(10, 10, 120, 25);
		
		confirm_team_selection_transfer = new JButton("Show Team Squad");
		confirm_team_selection_transfer.setFont(new Font("Arial", Font.PLAIN, 14));
		confirm_team_selection_transfer.setBounds(330, 10, 180, 25);
		confirm_team_selection_transfer.addActionListener(this);
		
		Select_Player_to_review_transfer = new JLabel("Select Player:");
		Select_Player_to_review_transfer.setFont(new Font("Arial", Font.BOLD, 15));
		Select_Player_to_review_transfer.setForeground(new Color(255, 99, 71));
		Select_Player_to_review_transfer.setBounds(10, 45, 120, 25);
		
		selected_team = (String) comboBox.getSelectedItem();
		String[] player_choices = championship.getClub(selected_team).getPlayer_NameList();
				
		comboBox_transfer = new JComboBox<String>(player_choices);
		comboBox_transfer.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_transfer.setBounds(130, 45, 180, 25);
		
		confirm_player_selection_transfer = new JButton("Submit offer");
		confirm_player_selection_transfer.setFont(new Font("Arial", Font.PLAIN, 14));
		confirm_player_selection_transfer.setBounds(330, 45, 180, 25);
		confirm_player_selection_transfer.addActionListener(this);
		
		
		//selected_team = (String) comboBox.getSelectedItem();
		
		selected_team_data = GameController.getTeam_database(selected_team);
		Object title[] = {"Name", "Age","Nationality","Jersy Number","Shooting skill","Dribbling skill","Passing skill",
					"Intercept skill", "Stealing skill", "Goalkeeper skill", "Stamina", "Annual Pay", "Player Value"};
	
		Other_Club_player_table = new JTable(selected_team_data, title);
		Other_Club_player_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
		
		Other_Club_player_table_scroll = new JScrollPane(Other_Club_player_table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		getContentPane().remove(show_panel);
		getContentPane().add(Other_Club_player_table_scroll);
		getContentPane().add(panel_for_comboxBox);
		panel_for_comboxBox.add(comboBox);
		panel_for_comboxBox.add(comboBox_transfer);
		panel_for_comboxBox.add(Select_team_to_review);
		panel_for_comboxBox.add(confirm_team_selection_transfer);
		panel_for_comboxBox.add(Select_Player_to_review_transfer);
		panel_for_comboxBox.add(confirm_player_selection_transfer);
		
		Other_Club_player_table_scroll.setBounds(222, 182, 521, 353); 
		Other_Club_player_table.setBackground(new Color(224, 255, 255));
		Other_Club_player_table.setFillsViewportHeight(true);
		
	} 
	
	
	private void show_other_club_in_Transfer()
	{
		Championship championship = GameController.UEFA;
		
		if (Other_Club_player_table_scroll != null)
		{
			Other_Club_player_table_scroll.setVisible(false);
			comboBox_transfer.setVisible(false);
		}
		
		selected_team = (String) comboBox.getSelectedItem();
		
		selected_team_data = GameController.getTeam_database(selected_team);
		Object title[] = {"Name", "Age","Nationality","Jersy Number","Shooting skill","Dribbling skill","Passing skill",
					"Intercept skill", "Stealing skill", "Goalkeeper skill", "Stamina", "Annual Pay", "Player Value"};
	
		Other_Club_player_table = new JTable(selected_team_data, title);
		Other_Club_player_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
		
		Other_Club_player_table_scroll = new JScrollPane(Other_Club_player_table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		String[] player_choices = championship.getClub(selected_team).getPlayer_NameList();
				
		comboBox_transfer = new JComboBox<String>(player_choices);
		comboBox_transfer.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_transfer.setBounds(130, 45, 180, 25);
		
		
		getContentPane().remove(show_panel);
		getContentPane().add(Other_Club_player_table_scroll);
		getContentPane().add(panel_for_comboxBox);
		panel_for_comboxBox.add(comboBox);
		panel_for_comboxBox.add(comboBox_transfer);
		panel_for_comboxBox.add(Select_team_to_review);
		panel_for_comboxBox.add(confirm_team_selection_transfer);
		panel_for_comboxBox.add(Select_Player_to_review_transfer);
		panel_for_comboxBox.add(confirm_player_selection_transfer);
		
		selected_trasnfer_player = (String) comboBox_transfer.getSelectedItem();
		
		Other_Club_player_table_scroll.setBounds(222, 182, 521, 353); 
		Other_Club_player_table.setBackground(new Color(224, 255, 255));
		Other_Club_player_table.setFillsViewportHeight(true);
	}
	
	private void call_transfer_player()
	{
		Championship championship = GameController.UEFA;
		
		if (Other_Club_player_table_scroll != null)
		{
			Other_Club_player_table_scroll.setVisible(false);
		}
		
		selected_team = (String) comboBox.getSelectedItem();
		
		selected_team_data = GameController.getTeam_database(selected_team);
		Object title[] = {"Name", "Age","Nationality","Jersy Number","Shooting skill","Dribbling skill","Passing skill",
					"Intercept skill", "Stealing skill", "Goalkeeper skill", "Stamina", "Annual Pay", "Player Value"};
	
		Other_Club_player_table = new JTable(selected_team_data, title);
		Other_Club_player_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
		
		Other_Club_player_table_scroll = new JScrollPane(Other_Club_player_table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		String[] player_choices = championship.getClub(selected_team).getPlayer_NameList();
				
		
		
		getContentPane().remove(show_panel);
		getContentPane().add(Other_Club_player_table_scroll);
		getContentPane().add(panel_for_comboxBox);
		panel_for_comboxBox.add(comboBox);
		panel_for_comboxBox.add(comboBox_transfer);
		panel_for_comboxBox.add(Select_team_to_review);
		panel_for_comboxBox.add(confirm_team_selection_transfer);
		panel_for_comboxBox.add(Select_Player_to_review_transfer);
		panel_for_comboxBox.add(confirm_player_selection_transfer);
		
		selected_trasnfer_player = (String) comboBox_transfer.getSelectedItem();
		
		Other_Club_player_table_scroll.setBounds(222, 182, 521, 353); 
		Other_Club_player_table.setBackground(new Color(224, 255, 255));
		Other_Club_player_table.setFillsViewportHeight(true);
		
		transfer_out_club = GameController.UEFA.getClub(selected_team);
		try {
			transfer_player = transfer_out_club.getPlayer(selected_trasnfer_player);
			Club user_club = GameController.UEFA.getUserClub(GameController.team_name);
			GameController.pauseGame(1000);
			Transfer_window transfer_window = new Transfer_window(this, transfer_out_club, user_club, transfer_player);
			transfer_window.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
			transfer_window.setSize(800, 600);
			transfer_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			transfer_window.setLocationRelativeTo(null);	
		} 
		catch (Exception e)
		{
			System.out.println("Cannot transfer player from other team!");
		}	
	}
	
	
	public static double AskforOffer(String transfer_player_name, String club_Name)
	{
		transfer_out_club = GameController.UEFA.getClub(club_Name);
		transfer_player = transfer_out_club.getPlayer(transfer_player_name);
		double offer;

		
		while(true)
		{
			try {
				
				ImageIcon conference_room = new ImageIcon("conference_room.png");
				String value_string = String.format("%.0f", transfer_player.getValue());
				String offer_string = (String)JOptionPane.showInputDialog(null, 
		               "Type  your  offer  amount  for  " + transfer_player.getName() + "\n" 
		               + "His  estimated  value  is  " + value_string +"  €",
		               "Please Type your offer amount",
		               JOptionPane.PLAIN_MESSAGE,
		               conference_room,            
		               null, 
		               null
		            );
				
				offer = Double.parseDouble(offer_string);
				
				if (offer > GameController.UEFA.getUserClub(GameController.team_name).getClubAccount().getBalance())
				{
					throw new IllegalArgumentException();
				}
				
				String confirm = (String)JOptionPane.showInputDialog(null,
			               "Are  you  sure  you  want  to  offer " + offer_string + " €  for " +transfer_player.getName() + "\n"
			               + "type  yes  or  Yes  to  continue  otherwise  cancel  this  offer", 
			               "Are you sure?", 
			               JOptionPane.PLAIN_MESSAGE,
			               conference_room,            
			               null, 
			               null
			            );
				
				if (confirm.equals("yes") || confirm.equals("Yes"))
				{
					return offer;
				}
				else
				{
					return (Double) null;
				}
				
			} 
			catch(NumberFormatException e)
			{
				System.out.println("Please type a number");
			}
			catch(IllegalArgumentException e)
			{
				JOptionPane.showMessageDialog(null, "Cannot make this offer since Insufficient Fund!"
						,"Cannot make this offer",JOptionPane.INFORMATION_MESSAGE, null);
				System.out.println("Insufficient Fund!");
			}
		}
		
	}
	
	private String[] remove_from_string_array(String name, String[] string_array)
	{
		List<String> list = new ArrayList<String>(Arrays.asList(string_array));
		list.remove(name);
		return string_array = list.toArray(new String[0]);
	}
	
	private void update_date_panel()
	{
		Date_and_next_game.setVisible(false);
		Date_and_next_game = new JTextPane();
		Date_and_next_game.setForeground(new Color(0, 0, 0));
		Date_and_next_game.setBackground(new Color(100, 149, 237));
		Date_and_next_game.setFont(new Font("Sitka Heading", Font.PLAIN, 14));
		Date_and_next_game.setEditable(false);
		Date_and_next_game.setBounds(377, 0, 239, 55);
		getContentPane().add(Date_and_next_game);
		
		this.next_user_event = GameController.next_user_event;
		home_team =  next_user_event.getHome_team();
		away_team =  next_user_event.getAway_team();
		Date_and_next_game.setText("Current Date:" + GameController.current_date + "\n"
				+ home_team.getClubName() + " vs " + away_team.getClubName() + "\n" 
				+ "Game Date:" + GameController.next_user_event.getDate());
		
		Home_team_logo.setVisible(false);
		Home_team_logo = new JPanel() 
		{
		    public void paintComponent(Graphics g)
		    {
		        Image img = new ImageIcon(home_team.getClubName() + ".png").getImage();
		        Dimension size = new Dimension(60, 55);
		        setPreferredSize(size);
		        setMinimumSize(size);
		        setMaximumSize(size);
		        setSize(size);
		        getContentPane().setLayout(null);
		        g.drawImage(img, 0, 0, 60, 55, null);
		    }
		};
		
		Home_team_logo.setBounds(282, 0, 60, 55);
		getContentPane().add(Home_team_logo);
		
		Away_team_logo.setVisible(false);
		Away_team_logo = new JPanel()
		{
		    public void paintComponent(Graphics g)
		    {
		        Image img = new ImageIcon(away_team.getClubName() + ".png").getImage();
		        Dimension size = new Dimension(60, 55);
		        setPreferredSize(size);
		        setMinimumSize(size);
		        setMaximumSize(size);
		        setSize(size);
		        getContentPane().setLayout(null);
		        g.drawImage(img, 0, 0, 60, 55, null);
		    }
		};
		
		Away_team_logo.setBounds(623, 0, 60, 55);
		getContentPane().add(Away_team_logo);
	}
	
	
	private void check_group_game_result()
	{
		 
		this.setVisible(false);			
		UEFA_button_View UEFA_view = new UEFA_button_View(this);
		UEFA_view.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
		UEFA_view.setSize(800, 600);
		UEFA_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UEFA_view.setLocationRelativeTo(null);
		UEFA_view.setVisible(false);
		Group_view group_view_window = new Group_view(this, UEFA_view);
		group_view_window.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
		group_view_window.setSize(800, 600);
		group_view_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		group_view_window.setLocationRelativeTo(null);
		group_view_window.setVisible(true);
	}
	
	private void goal_success()
	{
		if (GameController.UEFA.semi_final.club_list.contains(GameController.UEFA.getUserClub(GameController.team_name)))
		{
			Generate_Board_Talk.CEO_talk = Board_talk_enum.goal_successful;
		}
		else
		{
			Generate_Board_Talk.CEO_talk = Board_talk_enum.goal_fail;
		}
		
	}
	
	
	private void champion_success()
	{
		if (GameController.UEFA.Champion.getClubName().equals(GameController.team_name))
		{
			Generate_Board_Talk.CEO_talk = Board_talk_enum.Champion;
			String champion_text =GameController.team_name + " is the Champion of UEFA !";
			Music_Background champion = new Music_Background("start.wav", "Main_menu.png", champion_text);
			champion.play();
		}
		
	}
}
