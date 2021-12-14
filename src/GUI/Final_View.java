package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import Championship_Stage.Round_Team;
import soccer_manager.Championship;
import soccer_manager.GameController;

/**
 * UEFA Final result view class (GUI)
 * @author Zuocheng Wang
 *
 */
public class Final_View extends JFrame implements ActionListener {
	JButton go_back_to_main_menu;
	JButton go_back_to_UEFA_view;
	JTextPane final_title;
	
	Game_Play_Main_Menu game_play_main_menu;
	UEFA_button_View UEFA_view;
	JTextPane Game_Score_panel;
	JScrollPane Game_Score_scroll_panel;
	
	JPanel team_logo_panel1;
	JPanel team_logo_panel2;
	
	Championship championship;
	Round_Team final_teams;

	
	public static String Round_of_final_Score_results = "UEFA Semi-Final Result:\n\n";
	
	/**
	 * Constructor of Final Result View
	 * @param game_play_main_menu main menu view
	 * @param UEFA_view UEFA view
	 */
	public Final_View(Game_Play_Main_Menu game_play_main_menu, UEFA_button_View UEFA_view)
	{
		this.game_play_main_menu = game_play_main_menu;
		this.UEFA_view = UEFA_view;
		
		this.game_play_main_menu.setVisible(false);
		this.UEFA_view.setVisible(false);
		
		getContentPane().setBackground(new Color(100, 149, 237));
		
		go_back_to_main_menu = new JButton("Main Menu");
		go_back_to_main_menu.setBounds(623, 489, 131, 32);
		go_back_to_main_menu.setFont(new Font("Sitka Display", Font.BOLD | Font.ITALIC, 12));
		go_back_to_main_menu.setBackground(new Color(240, 255, 240));
		go_back_to_main_menu.addActionListener(this);
		getContentPane().setLayout(null);
		getContentPane().add(go_back_to_main_menu);
		
		go_back_to_UEFA_view = new JButton("Previous Page");
		go_back_to_UEFA_view.setBounds(447, 489, 144, 32);
		go_back_to_UEFA_view.setFont(new Font("Sitka Display", Font.BOLD | Font.ITALIC, 12));
		go_back_to_UEFA_view.setBackground(new Color(240, 255, 240));
		go_back_to_UEFA_view.addActionListener(this);
		getContentPane().add(go_back_to_UEFA_view);
		
		final_title = new JTextPane();
		final_title.setBounds(171, 11, 510, 67);
		final_title.setEditable(false);
		final_title.setForeground(new Color(255, 255, 255));
		final_title.setBackground(new Color(100, 149, 237));
		final_title.setFont(new Font("Times New Roman", Font.BOLD, 34));
		final_title.setText("UEFA Final Results");
		getContentPane().add(final_title);
		
		Game_Score_scroll_panel = new JScrollPane();
		Game_Score_scroll_panel.setBounds(237, 89, 309, 383);
		Game_Score_scroll_panel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(Game_Score_scroll_panel);
		
		Game_Score_panel = new JTextPane();
		Game_Score_scroll_panel.setViewportView(Game_Score_panel);
		Game_Score_panel.setEditable(false);
		Game_Score_panel.setBackground(new Color(240, 255, 240));
		Game_Score_panel.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		Game_Score_panel.setForeground(new Color(0, 0, 0));
		
		Game_Score_panel.setText(Round_of_final_Score_results);
		
		championship = GameController.UEFA;
		
		if(championship.final_team.club_list.size() != 0)
		{
			final_teams = championship.getFinal_team();
			
			team_logo_panel1 = new JPanel()
			{
				public void paintComponent(Graphics graphic)
			    {
			        Image image = new ImageIcon(final_teams.getClub_list().get(0).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(131, 137);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 131, 137, null);
			    }
			};
			team_logo_panel1.setBounds(52, 117, 131, 137);
			getContentPane().add(team_logo_panel1);
			team_logo_panel1.setLayout(null);
			
			
			team_logo_panel2 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(final_teams.getClub_list().get(1).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(131, 137);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 131, 137, null);
				}
			};
			team_logo_panel2.setLayout(null);
			team_logo_panel2.setBounds(596, 308, 131, 137);
			getContentPane().add(team_logo_panel2);
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton round_16_view_button = (JButton) e.getSource();
		if(round_16_view_button == go_back_to_main_menu)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			this.dispose();
			game_play_main_menu.setVisible(true);
		}
		else if(round_16_view_button == go_back_to_UEFA_view)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			this.dispose();
			UEFA_view.setVisible(true);
		}
		
	}
}