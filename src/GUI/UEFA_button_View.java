package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import soccer_manager.GameController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

/**
 * class for showing UEFA overall view
 * @author Zuocheng Wang
 *
 */
public class UEFA_button_View extends JFrame implements ActionListener  {
	
	private Game_Play_Main_Menu game_play_main_menu;
	private JPanel Background_panel;
	private JButton Group_view;
	private JButton Round_of_16_view;
	private JButton Round_of_8_view;
	private JButton Semi_final_view;
	private JButton final_view;
	private JButton Top_Score_List;
	private JButton go_back_main_menu;
	
	/**
	 * Constructor of UEFA button view
	 * @param game_play_main_menu
	 */
	public UEFA_button_View(Game_Play_Main_Menu game_play_main_menu)
	{
		getContentPane().setBackground(new Color(100, 149, 237));
		this.game_play_main_menu = game_play_main_menu;
		
		game_play_main_menu.setVisible(false);
		
		getContentPane().setLayout(null);
		
		Background_panel = new JPanel()
		{
			public void paintComponent(Graphics g)
		    {
		        Image img = new ImageIcon("UEFA_view.png").getImage();
		        Dimension size = new Dimension(682, 480);
		        setPreferredSize(size);
		        setMinimumSize(size);
		        setMaximumSize(size);
		        setSize(size);
		        getContentPane().setLayout(null);
		        g.drawImage(img, 0, 0, 682, 480, null);
		    }
		};
		Background_panel.setBounds(50, 27, 682, 480);
		getContentPane().add(Background_panel);
		Background_panel.setLayout(null);
		
		Group_view = new JButton("Group Stage");
		Group_view.setBackground(new Color(240, 255, 240));
		Group_view.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 14));
		Group_view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Group_view.setBounds(29, 109, 173, 76);
		Group_view.addActionListener(this);
		Background_panel.add(Group_view);
		
		
		Round_of_16_view = new JButton("Round of 16");
		Round_of_16_view.setForeground(new Color(0, 0, 0));
		Round_of_16_view.setBackground(new Color(240, 255, 240));
		Round_of_16_view.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 14));
		Round_of_16_view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Round_of_16_view.setBounds(29, 296, 173, 76);
		Round_of_16_view.addActionListener(this);
		Background_panel.add(Round_of_16_view);
		
		Round_of_8_view = new JButton("Round of 8");
		Round_of_8_view.setBackground(new Color(240, 255, 240));
		Round_of_8_view.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 14));
		Round_of_8_view.setBounds(249, 109, 173, 76);
		Round_of_8_view.addActionListener(this);
		Background_panel.add(Round_of_8_view);
		
		Semi_final_view = new JButton("Semi Final");
		Semi_final_view.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 14));
		Semi_final_view.setBackground(new Color(240, 255, 240));
		Semi_final_view.setBounds(249, 296, 173, 76);
		Semi_final_view.addActionListener(this);
		Background_panel.add(Semi_final_view);
		
		final_view = new JButton("Final");
		final_view.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 14));
		final_view.setBackground(new Color(240, 255, 240));
		final_view.setBounds(480, 109, 173, 76);
		final_view.addActionListener(this);
		Background_panel.add(final_view);
		
		Top_Score_List = new JButton("Top Score List");
		Top_Score_List.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Top_Score_List.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 14));
		Top_Score_List.setBackground(new Color(240, 255, 240));
		Top_Score_List.setBounds(480, 296, 173, 76);
		Top_Score_List.addActionListener(this);
		Background_panel.add(Top_Score_List);
		
		go_back_main_menu = new JButton("Main Menu");
		go_back_main_menu.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 12));
		go_back_main_menu.setBackground(new Color(240, 255, 240));
		go_back_main_menu.setBounds(623, 518, 109, 32);
		go_back_main_menu.addActionListener(this);
		getContentPane().add(go_back_main_menu);
		
	}

	@Override
	public void actionPerformed(ActionEvent UEFA_view) {
		JButton UEFA_buttons = (JButton) UEFA_view.getSource();
		
		if(UEFA_buttons == go_back_main_menu)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			this.dispose();
			game_play_main_menu.setVisible(true);
			
		}
		else if(UEFA_buttons == Group_view)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			Group_view group_view_window = new Group_view(game_play_main_menu, this);
			group_view_window.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
			group_view_window.setSize(800, 600);
			group_view_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			group_view_window.setLocationRelativeTo(null);
			group_view_window.setVisible(true);
			
		}
		
		else if(UEFA_buttons == Top_Score_List)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			Top_Scorer_List_view top_scorer_view_window = new Top_Scorer_List_view(game_play_main_menu, this);
			top_scorer_view_window.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
			top_scorer_view_window.setSize(800, 600);
			top_scorer_view_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			top_scorer_view_window.setLocationRelativeTo(null);
			top_scorer_view_window.setVisible(true);
			
		}
		
		else if(UEFA_buttons == Round_of_16_view)
		{

				GameController.pauseGame(200);
				this.setVisible(false);
				Round_16_View round_16_view_window = new Round_16_View(game_play_main_menu, this);
				round_16_view_window.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
				round_16_view_window.setSize(800, 600);
				round_16_view_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				round_16_view_window.setLocationRelativeTo(null);
				round_16_view_window.setVisible(true);

			
		}
		else if(UEFA_buttons == Round_of_8_view)
		{

				GameController.pauseGame(200);
				this.setVisible(false);
				Round_8_View round_8_view_window = new Round_8_View(game_play_main_menu, this);
				round_8_view_window.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
				round_8_view_window.setSize(800, 600);
				round_8_view_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				round_8_view_window.setLocationRelativeTo(null);
				round_8_view_window.setVisible(true);

			
		}
		else if(UEFA_buttons == Semi_final_view)
		{

				GameController.pauseGame(200);
				this.setVisible(false);
				Semi_Final_View semi_final_view_window = new Semi_Final_View(game_play_main_menu, this);
				semi_final_view_window.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
				semi_final_view_window.setSize(800, 600);
				semi_final_view_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				semi_final_view_window.setLocationRelativeTo(null);
				semi_final_view_window.setVisible(true);

			
		}
		else if(UEFA_buttons == final_view)
		{

				GameController.pauseGame(200);
				this.setVisible(false);
				Final_View final_view_window = new Final_View(game_play_main_menu, this);
				final_view_window.setTitle("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
				final_view_window.setSize(800, 600);
				final_view_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				final_view_window.setLocationRelativeTo(null);
				final_view_window.setVisible(true);
			
		}
		
	}
}
