package GUI;

import javax.swing.JFrame;

import Championship_Stage.Group;
import Championship_Stage.Round_Team;
import Schedule.Group_events;
import soccer_manager.Championship;
import soccer_manager.GameController;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * Group stage general information view class (GUI)
 * @author Zuocheng Wang
 *
 */
public class Group_view extends JFrame implements ActionListener {
	
	Championship championship;
	
	public Group groupA_teams;
	public Group groupB_teams;
	public Group groupC_teams;
	public Group groupD_teams;
	public Group groupE_teams;	
	public Group groupF_teams;
	public Group groupG_teams;
	public Group groupH_teams;
	
	Group_events groupA_events;
	Group_events groupB_events;
	Group_events groupC_events;
	Group_events groupD_events;
	Group_events groupE_events;
	Group_events groupF_events;
	Group_events groupG_events;
	Group_events groupH_events;
	
	JButton Group_A_button;
	JButton Group_B_button;
	JButton Group_C_button;
	JButton Group_D_button;
	JButton Group_E_button;
	JButton Group_F_button;
	JButton Group_G_button;
	JButton Group_H_button;
	
	JTextPane GroupA_Text;
	JTextPane GroupB_Text;
	JTextPane GroupC_Text;
	JTextPane GroupD_Text;
	JTextPane GroupE_Text;
	JTextPane GroupF_Text;
	JTextPane GroupG_Text;
	JTextPane GroupH_Text;
	
	JTextPane txtpnChampionsLeagueGroup;
	
	JButton go_back_to_main_menu;
	JButton go_back_to_UEFA_view;
	
	Game_Play_Main_Menu game_play_main_menu;
	UEFA_button_View UEFA_view;
	
	/**
	 * Constructor of overall group view
	 * @param game_play_main_menu
	 * @param UEFA_view
	 */
	public Group_view(Game_Play_Main_Menu game_play_main_menu, UEFA_button_View UEFA_view)
	{
		this.game_play_main_menu = game_play_main_menu;
		this.UEFA_view = UEFA_view;
		
		this.game_play_main_menu.setVisible(false);
		this.UEFA_view.setVisible(false);
		
		championship = GameController.UEFA;
		
		groupA_teams = championship.getGroupA_teams();
		groupB_teams = championship.getGroupB_teams();
		groupC_teams = championship.getGroupC_teams();
		groupD_teams = championship.getGroupD_teams();
		groupE_teams = championship.getGroupE_teams();
		groupF_teams = championship.getGroupF_teams();
		groupG_teams = championship.getGroupG_teams();
		groupH_teams = championship.getGroupH_teams();
		
		groupA_events = championship.groupA_events;
		groupB_events = championship.groupB_events;
		groupC_events = championship.groupC_events;
		groupD_events = championship.groupD_events;
		groupE_events = championship.groupE_events;
		groupF_events = championship.groupF_events;
		groupG_events = championship.groupG_events;
		groupH_events = championship.groupH_events;
		
		getContentPane().setBackground(new Color(100, 149, 237));
		getContentPane().setLayout(null);
		
		Group_A_button = new JButton("Group A");
		Group_A_button.setBackground(new Color(240, 255, 240));
		Group_A_button.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 11));
		Group_A_button.setBounds(32, 87, 107, 23);
		Group_A_button.addActionListener(this);
		getContentPane().add(Group_A_button);
		
		GroupA_Text = new JTextPane();
		GroupA_Text.setForeground(new Color(0, 0, 128));
		GroupA_Text.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GroupA_Text.setEditable(false);
		GroupA_Text.setBackground(new Color(135, 206, 250));
		GroupA_Text.setBounds(32, 121, 144, 116);
		getContentPane().add(GroupA_Text);
		GroupA_Text.setText(groupA_teams.getClub_list().get(0).getClubName() + "\n" +"\n"
							+groupA_teams.getClub_list().get(1).getClubName() + "\n" +"\n"
							+groupA_teams.getClub_list().get(2).getClubName() + "\n" +"\n"
							+groupA_teams.getClub_list().get(3).getClubName() + "\n");
		
		
		Group_B_button = new JButton("Group B");
		Group_B_button.setBackground(new Color(240, 255, 240));
		Group_B_button.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 11));
		Group_B_button.setBounds(224, 87, 107, 23);
		Group_B_button.addActionListener(this);
		getContentPane().add(Group_B_button);

		
		GroupB_Text = new JTextPane();
		GroupB_Text.setForeground(new Color(0, 0, 128));
		GroupB_Text.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GroupB_Text.setEditable(false);
		GroupB_Text.setBackground(new Color(135, 206, 250));
		GroupB_Text.setBounds(224, 121, 144, 116);
		getContentPane().add(GroupB_Text);
		GroupB_Text.setText(groupB_teams.getClub_list().get(0).getClubName() + "\n" +"\n"
				+groupB_teams.getClub_list().get(1).getClubName() + "\n" +"\n"
				+groupB_teams.getClub_list().get(2).getClubName() + "\n" +"\n"
				+groupB_teams.getClub_list().get(3).getClubName() + "\n");
		
		Group_C_button = new JButton("Group C");
		Group_C_button.setBackground(new Color(240, 255, 240));
		Group_C_button.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 11));
		Group_C_button.setBounds(418, 87, 107, 23);
		Group_C_button.addActionListener(this);
		getContentPane().add(Group_C_button);
		
		GroupC_Text = new JTextPane();
		GroupC_Text.setForeground(new Color(0, 0, 128));
		GroupC_Text.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GroupC_Text.setEditable(false);
		GroupC_Text.setBackground(new Color(135, 206, 250));
		GroupC_Text.setBounds(418, 121, 144, 116);
		getContentPane().add(GroupC_Text);
		GroupC_Text.setText(groupC_teams.getClub_list().get(0).getClubName() + "\n" +"\n"
				+groupC_teams.getClub_list().get(1).getClubName() + "\n" +"\n"
				+groupC_teams.getClub_list().get(2).getClubName() + "\n" +"\n"
				+groupC_teams.getClub_list().get(3).getClubName() + "\n");
		
		Group_D_button = new JButton("Group D");
		Group_D_button.setBackground(new Color(240, 255, 240));
		Group_D_button.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 11));
		Group_D_button.setBounds(611, 87, 107, 23);
		Group_D_button.addActionListener(this);
		getContentPane().add(Group_D_button);
		
		GroupD_Text = new JTextPane();
		GroupD_Text.setForeground(new Color(0, 0, 128));
		GroupD_Text.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GroupD_Text.setEditable(false);
		GroupD_Text.setBackground(new Color(135, 206, 250));
		GroupD_Text.setBounds(610, 121, 144, 116);
		getContentPane().add(GroupD_Text);
		GroupD_Text.setText(groupD_teams.getClub_list().get(0).getClubName() + "\n" +"\n"
				+groupD_teams.getClub_list().get(1).getClubName() + "\n" +"\n"
				+groupD_teams.getClub_list().get(2).getClubName() + "\n" +"\n"
				+groupD_teams.getClub_list().get(3).getClubName() + "\n");
		
		Group_E_button = new JButton("Group E");
		Group_E_button.setBackground(new Color(240, 255, 240));
		Group_E_button.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 11));
		Group_E_button.setBounds(32, 284, 107, 23);
		Group_E_button.addActionListener(this);
		getContentPane().add(Group_E_button);
		
		GroupE_Text = new JTextPane();
		GroupE_Text.setForeground(new Color(0, 0, 128));
		GroupE_Text.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GroupE_Text.setEditable(false);
		GroupE_Text.setBackground(new Color(135, 206, 250));
		GroupE_Text.setBounds(32, 318, 144, 116);
		getContentPane().add(GroupE_Text);
		GroupE_Text.setText(groupE_teams.getClub_list().get(0).getClubName() + "\n" +"\n"
				+groupE_teams.getClub_list().get(1).getClubName() + "\n" +"\n"
				+groupE_teams.getClub_list().get(2).getClubName() + "\n" +"\n"
				+groupE_teams.getClub_list().get(3).getClubName() + "\n");
		
		Group_F_button = new JButton("Group F");
		Group_F_button.setBackground(new Color(240, 255, 240));
		Group_F_button.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 11));
		Group_F_button.setBounds(224, 284, 107, 23);
		Group_F_button.addActionListener(this);
		getContentPane().add(Group_F_button);
		
		GroupF_Text = new JTextPane();
		GroupF_Text.setForeground(new Color(0, 0, 128));
		GroupF_Text.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GroupF_Text.setEditable(false);
		GroupF_Text.setBackground(new Color(135, 206, 250));
		GroupF_Text.setBounds(224, 318, 144, 116);
		getContentPane().add(GroupF_Text);
		GroupF_Text.setText(groupF_teams.getClub_list().get(0).getClubName() + "\n" +"\n"
				+groupF_teams.getClub_list().get(1).getClubName() + "\n" +"\n"
				+groupF_teams.getClub_list().get(2).getClubName() + "\n" +"\n"
				+groupF_teams.getClub_list().get(3).getClubName() + "\n");
		
		Group_G_button = new JButton("Group G");
		Group_G_button.setBackground(new Color(240, 255, 240));
		Group_G_button.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 11));
		Group_G_button.setBounds(418, 284, 107, 23);
		Group_G_button.addActionListener(this);
		getContentPane().add(Group_G_button);

		
		GroupG_Text = new JTextPane();
		GroupG_Text.setForeground(new Color(0, 0, 128));
		GroupG_Text.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GroupG_Text.setEditable(false);
		GroupG_Text.setBackground(new Color(135, 206, 250));
		GroupG_Text.setBounds(418, 318, 144, 116);
		getContentPane().add(GroupG_Text);
		GroupG_Text.setText(groupG_teams.getClub_list().get(0).getClubName() + "\n" +"\n"
				+groupG_teams.getClub_list().get(1).getClubName() + "\n" +"\n"
				+groupG_teams.getClub_list().get(2).getClubName() + "\n" +"\n"
				+groupG_teams.getClub_list().get(3).getClubName() + "\n");
		
		Group_H_button = new JButton("Group H");
		Group_H_button.setBackground(new Color(240, 255, 240));
		Group_H_button.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 11));
		Group_H_button.setBounds(611, 284, 107, 23);
		Group_H_button.addActionListener(this);
		getContentPane().add(Group_H_button);
		
		GroupH_Text = new JTextPane();
		GroupH_Text.setForeground(new Color(0, 0, 128));
		GroupH_Text.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GroupH_Text.setEditable(false);
		GroupH_Text.setBackground(new Color(135, 206, 250));
		GroupH_Text.setBounds(610, 318, 144, 116);
		getContentPane().add(GroupH_Text);
		GroupH_Text.setText(groupH_teams.getClub_list().get(0).getClubName() + "\n" +"\n"
				+groupH_teams.getClub_list().get(1).getClubName() + "\n" +"\n"
				+groupH_teams.getClub_list().get(2).getClubName() + "\n" +"\n"
				+groupH_teams.getClub_list().get(3).getClubName() + "\n");
		
		txtpnChampionsLeagueGroup = new JTextPane();
		txtpnChampionsLeagueGroup.setEditable(false);
		txtpnChampionsLeagueGroup.setForeground(new Color(255, 255, 255));
		txtpnChampionsLeagueGroup.setBackground(new Color(100, 149, 237));
		txtpnChampionsLeagueGroup.setFont(new Font("Times New Roman", Font.BOLD, 34));
		txtpnChampionsLeagueGroup.setText("CHAMPIONS LEAGUE GROUP DRAW");
		txtpnChampionsLeagueGroup.setBounds(77, 11, 641, 67);
		getContentPane().add(txtpnChampionsLeagueGroup);
		
		go_back_to_main_menu = new JButton("Main Menu");
		go_back_to_main_menu.setFont(new Font("Sitka Display", Font.BOLD | Font.ITALIC, 12));
		go_back_to_main_menu.setBackground(new Color(240, 255, 240));
		go_back_to_main_menu.setBounds(623, 489, 131, 32);
		go_back_to_main_menu.addActionListener(this);
		getContentPane().add(go_back_to_main_menu);
		
		go_back_to_UEFA_view = new JButton("Previous Page");
		go_back_to_UEFA_view.setFont(new Font("Sitka Display", Font.BOLD | Font.ITALIC, 12));
		go_back_to_UEFA_view.setBackground(new Color(240, 255, 240));
		go_back_to_UEFA_view.setBounds(447, 489, 144, 32);
		go_back_to_UEFA_view.addActionListener(this);
		getContentPane().add(go_back_to_UEFA_view);
		
		JPanel image = new JPanel()
		{
		    public void paintComponent(Graphics g)
		    {
		        Image img = new ImageIcon("UEFA.png").getImage();
		        Dimension size = new Dimension(96, 90);
		        setPreferredSize(size);
		        setMinimumSize(size);
		        setMaximumSize(size);
		        setSize(size);
		        getContentPane().setLayout(null);
		        g.drawImage(img, 0, 0, 96, 90, null);
		    }
		};
		image.setBackground(new Color(100, 149, 237));
		image.setBounds(10, 460, 96, 90);
		getContentPane().add(image);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent group_view) {
		JButton group_view_button = (JButton) group_view.getSource();
		if(group_view_button == go_back_to_main_menu)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			this.dispose();
			game_play_main_menu.setVisible(true);
		}
		else if(group_view_button == go_back_to_UEFA_view)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			this.dispose();
			UEFA_view.setVisible(true);
		}
		else if(group_view_button == Group_A_button)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			Group_detail_view group_detail_view = new Group_detail_view(game_play_main_menu, this, groupA_events, groupA_teams, "Group A");
			group_detail_view.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
			group_detail_view.setSize(800, 600);
			group_detail_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			group_detail_view.setLocationRelativeTo(null);
			group_detail_view.setVisible(true);
		}
		else if(group_view_button == Group_B_button)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			Group_detail_view group_detail_view = new Group_detail_view(game_play_main_menu, this, groupB_events, groupB_teams, "Group B");
			group_detail_view.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
			group_detail_view.setSize(800, 600);
			group_detail_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			group_detail_view.setLocationRelativeTo(null);
			group_detail_view.setVisible(true);
		}
		else if(group_view_button == Group_C_button)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			Group_detail_view group_detail_view = new Group_detail_view(game_play_main_menu, this, groupC_events, groupC_teams, "Group C");
			group_detail_view.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
			group_detail_view.setSize(800, 600);
			group_detail_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			group_detail_view.setLocationRelativeTo(null);
			group_detail_view.setVisible(true);
		}
		else if(group_view_button == Group_D_button)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			Group_detail_view group_detail_view = new Group_detail_view(game_play_main_menu, this, groupD_events, groupD_teams, "Group D");
			group_detail_view.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
			group_detail_view.setSize(800, 600);
			group_detail_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			group_detail_view.setLocationRelativeTo(null);
			group_detail_view.setVisible(true);
		}
		else if(group_view_button == Group_E_button)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			Group_detail_view group_detail_view = new Group_detail_view(game_play_main_menu, this, groupE_events, groupE_teams, "Group E");
			group_detail_view.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
			group_detail_view.setSize(800, 600);
			group_detail_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			group_detail_view.setLocationRelativeTo(null);
			group_detail_view.setVisible(true);
		}
		else if(group_view_button == Group_F_button)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			Group_detail_view group_detail_view = new Group_detail_view(game_play_main_menu, this, groupF_events, groupF_teams, "Group F");
			group_detail_view.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
			group_detail_view.setSize(800, 600);
			group_detail_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			group_detail_view.setLocationRelativeTo(null);
			group_detail_view.setVisible(true);
		}
		else if(group_view_button == Group_G_button)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			Group_detail_view group_detail_view = new Group_detail_view(game_play_main_menu, this, groupG_events, groupG_teams, "Group G");
			group_detail_view.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
			group_detail_view.setSize(800, 600);
			group_detail_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			group_detail_view.setLocationRelativeTo(null);
			group_detail_view.setVisible(true);
		}
		else if(group_view_button == Group_H_button)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			Group_detail_view group_detail_view = new Group_detail_view(game_play_main_menu, this, groupH_events, groupH_teams, "Group H");
			group_detail_view.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
			group_detail_view.setSize(800, 600);
			group_detail_view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			group_detail_view.setLocationRelativeTo(null);
			group_detail_view.setVisible(true);
		}
		
	}
}
