package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Championship_Stage.Group;
import Schedule.Group_events;
import soccer_manager.GameController;

import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Group stage result view class (GUI)
 * @author Zuocheng Wang
 *
 */
public class Group_detail_view extends JFrame implements ActionListener{
	
	private Group group_teams;
	private  Group_events group_events;
	private Game_Play_Main_Menu game_play_main_menu;
	private Group_view group_view;
	JTextPane Title;
	JTextPane Game_Score_panel;
	JScrollPane Game_Score_scroll_panel;
	public static String Group_A_Score_results = "UEFA Group Stage Result:\n\n";
	public static String Group_B_Score_results = "UEFA Group Stage Result:\n\n";
	public static String Group_C_Score_results = "UEFA Group Stage Result:\n\n";
	public static String Group_D_Score_results = "UEFA Group Stage Result:\n\n";
	public static String Group_E_Score_results = "UEFA Group Stage Result:\n\n";
	public static String Group_F_Score_results = "UEFA Group Stage Result:\n\n";
	public static String Group_G_Score_results = "UEFA Group Stage Result:\n\n";
	public static String Group_H_Score_results = "UEFA Group Stage Result:\n\n";
	
	JButton go_back_to_group_view;
	JButton go_back_to_main_menu;
	JTable score_table;
	JScrollPane ScorePane;
	JTableHeader header;
	
	/**
	 * Constructor of Group Detail View
	 * @param game_play_main_menu
	 * @param group_view
	 * @param group_events
	 * @param group_teams
	 * @param Group_name
	 */
	public Group_detail_view(Game_Play_Main_Menu game_play_main_menu, Group_view group_view, Group_events group_events, Group group_teams, String Group_name)
	{
		getContentPane().setBackground(new Color(100, 149, 237));
		this.group_teams = group_teams;
		this.group_events = group_events;
		this.game_play_main_menu = game_play_main_menu;
		this.group_view = group_view;
		
		this.game_play_main_menu.setVisible(false);
		this.group_view.setVisible(false);
		getContentPane().setLayout(null);
		
		
		Title = new JTextPane();
		Title.setBounds(29, 0, 745, 91);
		Title.setEditable(false);
		Title.setBackground(new Color(100, 149, 237));
		Title.setForeground(new Color(255, 255, 255));
		Title.setFont(new Font("Sitka Heading", Font.BOLD, 42));
		getContentPane().add(Title);
		Title.setText(Group_name + " Standings and Details");
		
		Game_Score_scroll_panel = new JScrollPane();
		Game_Score_scroll_panel.setBounds(475, 102, 309, 383);
		Game_Score_scroll_panel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(Game_Score_scroll_panel);
		
		Game_Score_panel = new JTextPane();
		Game_Score_scroll_panel.setViewportView(Game_Score_panel);
		Game_Score_panel.setEditable(false);
		Game_Score_panel.setBackground(new Color(240, 255, 240));
		Game_Score_panel.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		Game_Score_panel.setForeground(new Color(0, 0, 0));
		
		if(Group_name.equals("Group A"))
		{
			Game_Score_panel.setText(Group_A_Score_results);
		}
		else if(Group_name.equals("Group B"))
		{
			Game_Score_panel.setText(Group_B_Score_results);
		}
		else if(Group_name.equals("Group C"))
		{
			Game_Score_panel.setText(Group_C_Score_results);
		}
		else if(Group_name.equals("Group D"))
		{
			Game_Score_panel.setText(Group_D_Score_results);
		}
		else if(Group_name.equals("Group E"))
		{
			Game_Score_panel.setText(Group_E_Score_results);
		}
		else if(Group_name.equals("Group F"))
		{
			Game_Score_panel.setText(Group_F_Score_results);
		}
		else if(Group_name.equals("Group G"))
		{
			Game_Score_panel.setText(Group_G_Score_results);
		}
		else
		{
			Game_Score_panel.setText(Group_H_Score_results);
		}
		
		go_back_to_main_menu = new JButton("Main Menu");
		go_back_to_main_menu.setBounds(643, 509, 131, 32);
		go_back_to_main_menu.setFont(new Font("Sitka Display", Font.BOLD | Font.ITALIC, 12));
		go_back_to_main_menu.setBackground(new Color(240, 255, 240));
		go_back_to_main_menu.addActionListener(this);
		getContentPane().add(go_back_to_main_menu);
		
		go_back_to_group_view = new JButton("Previous Page");
		go_back_to_group_view.setBounds(475, 509, 144, 32);
		go_back_to_group_view.setFont(new Font("Sitka Display", Font.BOLD | Font.ITALIC, 12));
		go_back_to_group_view.setBackground(new Color(240, 255, 240));
		go_back_to_group_view.addActionListener(this);
		getContentPane().add(go_back_to_group_view);
		

		score_table = new JTable() 
		{
            public Component prepareRenderer(TableCellRenderer render, int r, int c) 
            {
                if (c == 0) 
                {
                    return this.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(this, this.getValueAt(r, c), false, false, r, c);
                } else {
                    return super.prepareRenderer(render, r, c);
                }
            }
        };
        score_table.setBackground(new Color(240, 255, 240));
        score_table.setFont(new Font("Tahoma", Font.PLAIN, 12));
        score_table.setAutoCreateRowSorter(false);
        score_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        header = score_table.getTableHeader();
        header.setDefaultRenderer(new TableRender(score_table));
        
        score_table.setModel(new DefaultTableModel(
            new Object[][]{
                {this.group_teams.getGroup_1st().getClubName(),this.group_teams.getGroup_1st().group_win_num , this.group_teams.getGroup_1st().group_draw_num , this.group_teams.getGroup_1st().group_lose_num, 
                	this.group_teams.getGroup_1st().group_total_goal, this.group_teams.getGroup_1st().group_total_loss_goal, this.group_teams.getGroup_1st().group_total_net_goal,
                	this.group_teams.getGroup_1st().group_points},
                
                {this.group_teams.getGroup_2nd().getClubName(), this.group_teams.getGroup_2nd().group_win_num , this.group_teams.getGroup_2nd().group_draw_num , this.group_teams.getGroup_2nd().group_lose_num,
                	this.group_teams.getGroup_2nd().group_total_goal, this.group_teams.getGroup_2nd().group_total_loss_goal, this.group_teams.getGroup_2nd().group_total_net_goal,
                	this.group_teams.getGroup_2nd().group_points},
                
                {this.group_teams.getGroup_3rd().getClubName(),this.group_teams.getGroup_3rd().group_win_num , this.group_teams.getGroup_3rd().group_draw_num , this.group_teams.getGroup_3rd().group_lose_num, 
                	this.group_teams.getGroup_3rd().group_total_goal , this.group_teams.getGroup_3rd().group_total_loss_goal, this.group_teams.getGroup_3rd().group_total_net_goal,
                	this.group_teams.getGroup_3rd().group_points},
                
                {this.group_teams.getGroup_4th().getClubName(), this.group_teams.getGroup_4th().group_win_num , this.group_teams.getGroup_4th().group_draw_num , this.group_teams.getGroup_4th().group_lose_num, 
                	this.group_teams.getGroup_4th().group_total_goal, this.group_teams.getGroup_4th().group_total_loss_goal, this.group_teams.getGroup_4th().group_total_net_goal,
                	this.group_teams.getGroup_4th().group_points}
            },
            new String[]{
                "","Win", "Draw", "Lose", "Total Goals", "Loss", "Net Goals", "PTS"
            }));
        
        
        ScorePane = new JScrollPane(score_table, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        ScorePane.setBounds(29, 317, 431, 111);
        getContentPane().add(ScorePane);
       
        
		JPanel UEFA_image = new JPanel()
		{
		    public void paintComponent(Graphics g)
		    {
		        Image image = new ImageIcon("UEFA.png").getImage();
		        Dimension size = new Dimension(96, 90);
		        setPreferredSize(size);
		        setMinimumSize(size);
		        setMaximumSize(size);
		        setSize(size);
		        getContentPane().setLayout(null);
		        g.drawImage(image, 0, 0, 96, 90, null);
		    }
		};
		UEFA_image.setBackground(new Color(100, 149, 237));
		UEFA_image.setBounds(10, 460, 96, 90);
		getContentPane().add(UEFA_image);
		
		
        
        String team1_name = group_teams.getClub_list().get(0).getClubName();
        String team2_name = group_teams.getClub_list().get(1).getClubName();
        String team3_name = group_teams.getClub_list().get(2).getClubName();
        String team4_name = group_teams.getClub_list().get(3).getClubName();
		
		JPanel team_1_image = new JPanel()
		{
			
		    public void paintComponent(Graphics g)
		    {
		        Image image = new ImageIcon(team1_name + ".png").getImage();
		        Dimension size = new Dimension(96, 90);
		        setPreferredSize(size);
		        setMinimumSize(size);
		        setMaximumSize(size);
		        setSize(size);
		        getContentPane().setLayout(null);
		        g.drawImage(image, 0, 0, 96, 90, null);
		    }
		};
		team_1_image.setBackground(new Color(100, 149, 237));
		team_1_image.setBounds(293, 102, 96, 90);
		getContentPane().add(team_1_image);
		
		JPanel team_2_image = new JPanel()
		{
			
		    public void paintComponent(Graphics g)
		    {
		        Image image = new ImageIcon(team2_name + ".png").getImage();
		        Dimension size = new Dimension(96, 90);
		        setPreferredSize(size);
		        setMinimumSize(size);
		        setMaximumSize(size);
		        setSize(size);
		        getContentPane().setLayout(null);
		        g.drawImage(image, 0, 0, 96, 90, null);
		    }
		};
		team_2_image.setBackground(new Color(100, 149, 237));
		team_2_image.setBounds(117, 102, 96, 90);
		getContentPane().add(team_2_image);
		
		JPanel team_3_image = new JPanel()
		{
			
		    public void paintComponent(Graphics g)
		    {
		        Image image = new ImageIcon(team3_name + ".png").getImage();
		        Dimension size = new Dimension(96, 90);
		        setPreferredSize(size);
		        setMinimumSize(size);
		        setMaximumSize(size);
		        setSize(size);
		        getContentPane().setLayout(null);
		        g.drawImage(image, 0, 0, 96, 90, null);
		    }
		};
		team_3_image.setBackground(new Color(100, 149, 237));
		team_3_image.setBounds(117, 203, 96, 90);
		getContentPane().add(team_3_image);
		
		
		JPanel team_4_image = new JPanel()
		{
			
		    public void paintComponent(Graphics g)
		    {
		        Image image = new ImageIcon(team4_name + ".png").getImage();
		        Dimension size = new Dimension(96, 90);
		        setPreferredSize(size);
		        setMinimumSize(size);
		        setMaximumSize(size);
		        setSize(size);
		        getContentPane().setLayout(null);
		        g.drawImage(image, 0, 0, 96, 90, null);
		    }
		};
		team_4_image.setBackground(new Color(100, 149, 237));
		team_4_image.setBounds(293, 203, 96, 90);
		getContentPane().add(team_4_image);
		
	}

	@Override
	public void actionPerformed(ActionEvent group_detail_view) {
		JButton group_detail_buttons = (JButton) group_detail_view.getSource();
		
		if (group_detail_buttons == go_back_to_main_menu)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			this.dispose();
			game_play_main_menu.setVisible(true);
		}
		else if(group_detail_buttons == go_back_to_group_view)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			this.dispose();
			group_view.setVisible(true);
		}
	}
	
    private static class TableRender implements TableCellRenderer 
    {

        TableCellRenderer tablerender;

        public TableRender(JTable table) 
        {
        	tablerender = table.getTableHeader().getDefaultRenderer();
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean is_Selected, boolean is_Focused, int r, int c) 
        {
            return tablerender.getTableCellRendererComponent(table, value, is_Selected, is_Focused, r, c);
        }
    }
}
