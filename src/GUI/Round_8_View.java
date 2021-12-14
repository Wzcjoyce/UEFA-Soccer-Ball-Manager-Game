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
import Schedule.Round_events;
import soccer_manager.Championship;
import soccer_manager.GameController;

/**
 * view class for showing UEFA round of 8 results
 * @author Zuocheng Wang
 */
public class Round_8_View extends JFrame implements ActionListener {
	JButton go_back_to_main_menu;
	JButton go_back_to_UEFA_view;
	JTextPane Round_8_title;
	
	Game_Play_Main_Menu game_play_main_menu;
	UEFA_button_View UEFA_view;
	JTextPane Game_Score_panel;
	JScrollPane Game_Score_scroll_panel;
	
	JPanel team_logo_panel1;
	JPanel team_logo_panel2;
	JPanel team_logo_panel3;
	JPanel team_logo_panel4;
	JPanel team_logo_panel5;
	JPanel team_logo_panel6;
	JPanel team_logo_panel7;
	JPanel team_logo_panel8;
	
	Championship championship;
	Round_Team round_8_teams;

	
	public static String Round_of_8_Score_results = "UEFA Round of 8 Result:\n\n";
	
	/**
	 * Constructor of round of 8 view
	 * @param game_play_main_menu
	 * @param UEFA_view
	 */
	public Round_8_View(Game_Play_Main_Menu game_play_main_menu, UEFA_button_View UEFA_view)
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
		
		Round_8_title = new JTextPane();
		Round_8_title.setBounds(171, 11, 510, 67);
		Round_8_title.setEditable(false);
		Round_8_title.setForeground(new Color(255, 255, 255));
		Round_8_title.setBackground(new Color(100, 149, 237));
		Round_8_title.setFont(new Font("Times New Roman", Font.BOLD, 34));
		Round_8_title.setText("UEFA Round of 8 Match Results");
		getContentPane().add(Round_8_title);
		
		Game_Score_scroll_panel = new JScrollPane();
		Game_Score_scroll_panel.setBounds(237, 89, 309, 383);
		Game_Score_scroll_panel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(Game_Score_scroll_panel);
		
		Game_Score_panel = new JTextPane();
		Game_Score_scroll_panel.setViewportView(Game_Score_panel);
		Game_Score_panel.setEditable(false);
		Game_Score_panel.setBackground(new Color(240, 255, 240));
		Game_Score_panel.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		Game_Score_panel.setForeground(new Color(0, 0, 0));
		
		Game_Score_panel.setText(Round_of_8_Score_results);
		
		championship = GameController.UEFA;
		
		if(championship.round_of_8_teams.club_list.size() != 0)
		{
			round_8_teams = championship.getRound_of_8_teams();
			
			team_logo_panel1 = new JPanel()
			{
				public void paintComponent(Graphics graphic)
			    {
			        Image image = new ImageIcon(round_8_teams.getClub_list().get(0).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(74, 79);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 74, 79, null);
			    }
			};
			team_logo_panel1.setBounds(22, 150, 74, 79);
			getContentPane().add(team_logo_panel1);
			team_logo_panel1.setLayout(null);
			
			
			team_logo_panel2 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_8_teams.getClub_list().get(1).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(74, 79);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 74, 79, null);
				}
			};
			team_logo_panel2.setLayout(null);
			team_logo_panel2.setBounds(680, 150, 74, 79);
			getContentPane().add(team_logo_panel2);
			
			
			team_logo_panel3 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_8_teams.getClub_list().get(2).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(74, 79);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 74, 79, null);
				}
			};
			team_logo_panel3.setLayout(null);
			team_logo_panel3.setBounds(134, 150, 74, 79);
			getContentPane().add(team_logo_panel3);
			
			team_logo_panel4 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_8_teams.getClub_list().get(3).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(74, 79);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 74, 79, null);
				}
			};
			team_logo_panel4.setLayout(null);
			team_logo_panel4.setBounds(574, 150, 74, 79);
			getContentPane().add(team_logo_panel4);
			
			team_logo_panel5 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_8_teams.getClub_list().get(4).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(74, 79);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 74, 79, null);
				}
			};
			team_logo_panel5.setLayout(null);
			team_logo_panel5.setBounds(22, 307, 74, 79);
			getContentPane().add(team_logo_panel5);
			
			team_logo_panel6 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_8_teams.getClub_list().get(5).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(74, 79);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 74, 79, null);
				}
			};
			team_logo_panel6.setLayout(null);
			team_logo_panel6.setBounds(574, 307, 74, 79);
			getContentPane().add(team_logo_panel6);
			
			team_logo_panel7 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_8_teams.getClub_list().get(6).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(74, 79);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 74, 79, null);
				}
			};
			team_logo_panel7.setLayout(null);
			team_logo_panel7.setBounds(134, 307, 74, 79);
			getContentPane().add(team_logo_panel7);
			
			team_logo_panel8= new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_8_teams.getClub_list().get(7).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(74, 79);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 74, 79, null);
				}
			};
			team_logo_panel8.setLayout(null);
			team_logo_panel8.setBounds(680, 307, 74, 79);
			getContentPane().add(team_logo_panel8);
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
