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
 * view class for showing UEFA round of 16 results
 * @author Zuocheng Wang
 */
public class Round_16_View extends JFrame implements ActionListener {
	JButton go_back_to_main_menu;
	JButton go_back_to_UEFA_view;
	JTextPane Round_16_title;
	
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
	JPanel team_logo_panel9;
	JPanel team_logo_panel10;
	JPanel team_logo_panel11;
	JPanel team_logo_panel12;
	JPanel team_logo_panel13;
	JPanel team_logo_panel14;
	JPanel team_logo_panel15;
	JPanel team_logo_panel16;
	
	Championship championship;
	Round_Team round_16_teams;

	
	public static String Round_of_16_Score_results = "UEFA Round of 16 Result:\n\n";
	
	/**
	 * Constructor of Round of 16 view
	 * @param game_play_main_menu
	 * @param UEFA_view
	 */
	public Round_16_View(Game_Play_Main_Menu game_play_main_menu, UEFA_button_View UEFA_view)
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
		
		Round_16_title = new JTextPane();
		Round_16_title.setBounds(171, 11, 510, 67);
		Round_16_title.setEditable(false);
		Round_16_title.setForeground(new Color(255, 255, 255));
		Round_16_title.setBackground(new Color(100, 149, 237));
		Round_16_title.setFont(new Font("Times New Roman", Font.BOLD, 34));
		Round_16_title.setText("UEFA Round of 16 Match Results");
		getContentPane().add(Round_16_title);
		
		Game_Score_scroll_panel = new JScrollPane();
		Game_Score_scroll_panel.setBounds(237, 89, 309, 383);
		Game_Score_scroll_panel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(Game_Score_scroll_panel);
		
		Game_Score_panel = new JTextPane();
		Game_Score_scroll_panel.setViewportView(Game_Score_panel);
		Game_Score_panel.setEditable(false);
		Game_Score_panel.setBackground(new Color(240, 255, 240));
		Game_Score_panel.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		Game_Score_panel.setForeground(new Color(0, 0, 0));
		
		Game_Score_panel.setText(Round_of_16_Score_results);
		
		championship = GameController.UEFA;
		
		if(championship.round_of_16_teams.club_list.size() != 0)
		{
			round_16_teams = championship.getRound_of_16_teams();
			
			team_logo_panel1 = new JPanel()
			{
				public void paintComponent(Graphics graphic)
			    {
			        Image image = new ImageIcon(round_16_teams.getClub_list().get(0).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(56, 58);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 56, 58, null);
			    }
			};
			team_logo_panel1.setBounds(37, 89, 56, 58);
			getContentPane().add(team_logo_panel1);
			team_logo_panel1.setLayout(null);
			
			
			team_logo_panel2 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_16_teams.getClub_list().get(1).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(56, 58);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 56, 58, null);
				}
			};
			team_logo_panel2.setLayout(null);
			team_logo_panel2.setBounds(129, 89, 56, 58);
			getContentPane().add(team_logo_panel2);
			
			
			team_logo_panel3 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_16_teams.getClub_list().get(2).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(56, 58);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 56, 58, null);
				}
			};
			team_logo_panel3.setLayout(null);
			team_logo_panel3.setBounds(37, 188, 56, 58);
			getContentPane().add(team_logo_panel3);
			
			team_logo_panel4 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_16_teams.getClub_list().get(3).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(56, 58);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 56, 58, null);
				}
			};
			team_logo_panel4.setLayout(null);
			team_logo_panel4.setBounds(129, 188, 56, 58);
			getContentPane().add(team_logo_panel4);
			
			team_logo_panel5 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_16_teams.getClub_list().get(4).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(56, 58);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 56, 58, null);
				}
			};
			team_logo_panel5.setLayout(null);
			team_logo_panel5.setBounds(37, 288, 56, 58);
			getContentPane().add(team_logo_panel5);
			
			team_logo_panel6 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_16_teams.getClub_list().get(5).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(56, 58);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 56, 58, null);
				}
			};
			team_logo_panel6.setLayout(null);
			team_logo_panel6.setBounds(129, 288, 56, 58);
			getContentPane().add(team_logo_panel6);
			
			team_logo_panel7 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_16_teams.getClub_list().get(6).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(56, 58);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 56, 58, null);
				}
			};
			team_logo_panel7.setLayout(null);
			team_logo_panel7.setBounds(37, 390, 56, 58);
			getContentPane().add(team_logo_panel7);
			
			team_logo_panel8= new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_16_teams.getClub_list().get(7).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(56, 58);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 56, 58, null);
				}
			};
			team_logo_panel8.setLayout(null);
			team_logo_panel8.setBounds(129, 390, 56, 58);
			getContentPane().add(team_logo_panel8);
			
			team_logo_panel9 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_16_teams.getClub_list().get(8).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(56, 58);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 56, 58, null);
				}
			};
			team_logo_panel9.setLayout(null);
			team_logo_panel9.setBounds(596, 89, 56, 58);
			getContentPane().add(team_logo_panel9);
			
			team_logo_panel10 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_16_teams.getClub_list().get(9).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(56, 58);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 56, 58, null);
				}
			};
			team_logo_panel10.setLayout(null);
			team_logo_panel10.setBounds(698, 89, 56, 58);
			getContentPane().add(team_logo_panel10);
			
			team_logo_panel11 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_16_teams.getClub_list().get(10).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(56, 58);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 56, 58, null);
				}
			};
			team_logo_panel11.setLayout(null);
			team_logo_panel11.setBounds(596, 188, 56, 58);
			getContentPane().add(team_logo_panel11);
			
			team_logo_panel12 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_16_teams.getClub_list().get(11).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(56, 58);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 56, 58, null);
				}
			};
			team_logo_panel12.setLayout(null);
			team_logo_panel12.setBounds(698, 188, 56, 58);
			getContentPane().add(team_logo_panel12);
			
			team_logo_panel13 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_16_teams.getClub_list().get(12).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(56, 58);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 56, 58, null);
				}
			};
			team_logo_panel13.setLayout(null);
			team_logo_panel13.setBounds(596, 288, 56, 58);
			getContentPane().add(team_logo_panel13);
			
			team_logo_panel14 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_16_teams.getClub_list().get(13).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(56, 58);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 56, 58, null);
				}
			};
			team_logo_panel14.setLayout(null);
			team_logo_panel14.setBounds(698, 288, 56, 58);
			getContentPane().add(team_logo_panel14);
			
			team_logo_panel15 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_16_teams.getClub_list().get(14).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(56, 58);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 56, 58, null);
				}
			};
			team_logo_panel15.setLayout(null);
			team_logo_panel15.setBounds(596, 390, 56, 58);
			getContentPane().add(team_logo_panel15);
			
			team_logo_panel16 = new JPanel() {
				public void paintComponent(Graphics graphic) {
			        Image image = new ImageIcon(round_16_teams.getClub_list().get(15).getClubName() + ".png").getImage();
			        Dimension size = new Dimension(56, 58);
			        setPreferredSize(size);
			        setMinimumSize(size);
			        setMaximumSize(size);
			        setSize(size);
			        getContentPane().setLayout(null);
			        graphic.drawImage(image, 0, 0, 56, 58, null);
				}
			};
			team_logo_panel16.setLayout(null);
			team_logo_panel16.setBounds(698, 390, 56, 58);
			getContentPane().add(team_logo_panel16);
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
