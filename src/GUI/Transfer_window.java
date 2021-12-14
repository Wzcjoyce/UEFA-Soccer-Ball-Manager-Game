package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Club.Club;
import Club.Player;
import soccer_manager.GameController;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;

/**
 * Class for showing transfer window view
 * @author Zuocheng Wang
 *
 */
public class Transfer_window extends JFrame implements ActionListener  {
	
	private Game_Play_Main_Menu game_play_main_menu;
	private JPanel Breaking_news_image_panel;
	private JPanel transfer_in_club_logo;
	private JPanel transfer_out_club_logo;
	private JTextPane Transfer_news_panel;
	private JScrollPane Transfer_news_scroll_panel;
	private JPanel submit_offer_button_panel;
	private Club transfer_out_club;
	private Club transfer_in_club; 
	private Player transfer_player;
	private static double offer;
	private String current_news;
	private JButton new_offer_button;
	private JButton Give_up_button;
	private int offer_count = 1;
	private boolean result = false;
	
	Music_Background bgm;
	
	/**
	 * constructor of transfer window view
	 * @param game_play_main_menu
	 * @param transfer_out_club
	 * @param transfer_in_club
	 * @param transfer_player
	 */
	public Transfer_window(Game_Play_Main_Menu game_play_main_menu, Club transfer_out_club, Club transfer_in_club, Player transfer_player)
	{
		bgm = new Music_Background("transfer_bgm.wav");
		bgm.music_only();
		
		setResizable(false);
		getContentPane().setBackground(new Color(255, 218, 185));
		this.game_play_main_menu = game_play_main_menu;
		this.transfer_out_club = transfer_out_club;
		this.transfer_in_club = transfer_in_club;
		this.transfer_player = transfer_player;
		
		this.game_play_main_menu.setVisible(false);
		this.setVisible(true);
		
		getContentPane().setLayout(null);
		
		Breaking_news_image_panel = new JPanel()
		{
			public void paintComponent(Graphics g)
		    {
		        Image img = new ImageIcon("Breaking_news.png").getImage();
		        Dimension size = new Dimension(400, 200);
		        setPreferredSize(size);
		        setMinimumSize(size);
		        setMaximumSize(size);
		        setSize(size);
		        getContentPane().setLayout(null);
		        g.drawImage(img, 0, 0, 400, 200, null);
		    }
		};
		Breaking_news_image_panel.setBounds(194, 0, 400, 200);
		getContentPane().add(Breaking_news_image_panel);
		
		
		transfer_in_club_logo = new JPanel()
		{
			public void paintComponent(Graphics g)
		    {
				String transfer_in_club_name = transfer_in_club.getClubName(); 
		        Image img = new ImageIcon(transfer_in_club_name + ".png").getImage();
		        Dimension size = new Dimension(149, 151);
		        setPreferredSize(size);
		        setMinimumSize(size);
		        setMaximumSize(size);
		        setSize(size);
		        getContentPane().setLayout(null);
		        g.drawImage(img, 0, 0, 149, 151, null);
		    }
	    };
		transfer_in_club_logo.setForeground(new Color(255, 218, 185));
		transfer_in_club_logo.setBackground(new Color(250, 235, 215));
		transfer_in_club_logo.setBounds(21, 32, 149, 151);
		getContentPane().add(transfer_in_club_logo);
		
		
		transfer_out_club_logo = new JPanel()
		{
			public void paintComponent(Graphics g)
		    {
				String transfer_out_club_name = transfer_out_club.getClubName(); 
		        Image img = new ImageIcon(transfer_out_club_name + ".png").getImage();
		        Dimension size = new Dimension(149, 151);
		        setPreferredSize(size);
		        setMinimumSize(size);
		        setMaximumSize(size);
		        setSize(size);
		        getContentPane().setLayout(null);
		        g.drawImage(img, 0, 0, 149, 151, null);
		    }
	    };
		transfer_out_club_logo.setBackground(new Color(250, 235, 215));
		transfer_out_club_logo.setForeground(new Color(255, 218, 185));
		transfer_out_club_logo.setBounds(622, 32, 149, 151);
		getContentPane().add(transfer_out_club_logo);
		
		Transfer_news_panel = new JTextPane();
		Transfer_news_panel.setBackground(new Color(250, 235, 215));
		Transfer_news_panel.setFont(new Font("Myanmar Text", Font.ITALIC, 16));
		Transfer_news_panel.setForeground(new Color(25, 25, 112));
		String value_string = String.format("%.0f", this.transfer_player.getValue());
		current_news = "BREAKING NEWS:\n" +this.transfer_in_club.getClubName() + " have made the " + this.transfer_player.getAge() +
				"-year-old " + this.transfer_player.getNationality() + " Player " +
				this.transfer_player.getName() + " their top transfer target this transfer window, " +
				"with it reported recently that " + this.transfer_in_club.getClubName() + " have set aside funds worth " + value_string
				 +" € in pursuit of a " + this.transfer_player.getBest_position() + ". " + this.transfer_out_club.getClubName() + 
				" is currently negotiating with "+ this.transfer_in_club.getClubName() + " about this transfer. "+ "\n\n";
		
		Transfer_news_panel.setText(current_news);
		Transfer_news_scroll_panel = new JScrollPane(Transfer_news_panel);
		Transfer_news_scroll_panel.setBounds(0, 200, 594, 360);
		Transfer_news_scroll_panel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(Transfer_news_scroll_panel);
		
		
		submit_offer_button_panel = new JPanel();
		submit_offer_button_panel.setBackground(new Color(250, 235, 215));
		submit_offer_button_panel.setForeground(new Color(255, 218, 185));
		submit_offer_button_panel.setBounds(592, 200, 192, 360);
		getContentPane().add(submit_offer_button_panel);
		submit_offer_button_panel.setLayout(null);
		
		new_offer_button = new JButton("New Offer");
		new_offer_button.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 14));
		new_offer_button.setForeground(new Color(25, 25, 112));
		new_offer_button.setBounds(30, 80, 143, 54);
		submit_offer_button_panel.add(new_offer_button);
		new_offer_button.addActionListener(this);
		
		Give_up_button = new JButton("End Conversation");
		Give_up_button.setForeground(new Color(25, 25, 112));
		Give_up_button.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 14));
		Give_up_button.setBounds(30, 226, 143, 54);
		submit_offer_button_panel.add(Give_up_button);
		Give_up_button.addActionListener(this);
		
	}


	@Override
	public void actionPerformed(ActionEvent transfer_window) {
		JButton game_play_buttons = (JButton) transfer_window.getSource();
		
		if(game_play_buttons == Give_up_button)
		{
			this.setVisible(false);
			game_play_main_menu.setVisible(true);
			bgm.Stop();
			this.dispose();
		}
		
		if(game_play_buttons == new_offer_button)
		{
			try {
				
				if(offer_count < 6 && result == false)
				{
					offer = Game_Play_Main_Menu.AskforOffer(transfer_player.getName(), transfer_out_club.getClubName());
					this.update_transfer_news_window();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Cannot make this transfer since" + transfer_out_club.getClubName() +
							"\nNegotiation ended. please click End Conversation to go back to main menu."
							,"Cannot make this Transfer",JOptionPane.INFORMATION_MESSAGE, null);
				}
			}
			catch (Exception e)
			{
				System.out.println("Offer cancelled!");
			}
		}
		
	}
	
	private void update_transfer_news_window()
	{
		if(Transfer_news_scroll_panel != null)
		{
			Transfer_news_panel.setVisible(false);
			Transfer_news_scroll_panel.setVisible(false);
		}

		Transfer_news_panel = new JTextPane();
		Transfer_news_panel.setBackground(new Color(250, 235, 215));
		Transfer_news_panel.setFont(new Font("Myanmar Text", Font.ITALIC, 16));
		Transfer_news_panel.setForeground(new Color(25, 25, 112));
		
		pause_transfer_news_window(1000);
		
		result = GameController.UEFA.Transfer_determination(transfer_player, offer, transfer_in_club);
		

		String offer_string = String.format("%.0f", offer);
		current_news += "BREAKING NEWS:\n" +"According to the lastest news, " +transfer_in_club.getClubName() + "\'s manager " + transfer_in_club.getClub_manager().getName()
				+ " had decided to make a offer of " + offer_string + " € to " + transfer_out_club.getClubName() + " for  " + transfer_player.getName() + "\n\n";
		
		//Transfer_news_panel.setText(current_news);
		Transfer_news_scroll_panel = new JScrollPane(Transfer_news_panel);
		Transfer_news_scroll_panel.setBounds(0, 200, 594, 360);
		Transfer_news_scroll_panel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(Transfer_news_scroll_panel);
		Transfer_news_panel.setText(current_news);
		
		pause_transfer_news_window(500);
		
		
		if(Transfer_news_scroll_panel != null)
		{
			Transfer_news_panel.setVisible(false);
			Transfer_news_scroll_panel.setVisible(false);
		}
		
		Transfer_news_panel = new JTextPane();
		Transfer_news_panel.setBackground(new Color(250, 235, 215));
		Transfer_news_panel.setFont(new Font("Myanmar Text", Font.ITALIC, 16));
		Transfer_news_panel.setForeground(new Color(25, 25, 112));
			

	
		
		if(result == false)
		{
			offer_string = String.format("%.0f", offer);
			current_news += "BREAKING NEWS:\n" +transfer_out_club.getClubName() + " have reportedly rejected " + transfer_in_club.getClubName()
			+ " 's " + offer_string + " € proposal for " +  transfer_player.getName() + "\n\n";
			
			offer_count += 1;
			
			if (offer_count > 5)
			{
				pause_transfer_news_window(500);
				current_news += "BREAKING NEWS:\n" +transfer_out_club.getClubName() + " have reportedly decided to end this conversation with " + transfer_in_club.getClubName();
			}
		}
		else
		{
			offer_string = String.format("%.0f", offer);
			current_news +="BREAKING NEWS:\n" + transfer_out_club.getClubName() + " have reportedly accepted " + transfer_in_club.getClubName()
			+ " 's " + offer_string + " € proposal for " +  transfer_player.getName();
			
			GameController.UEFA.Transfer(transfer_in_club.getClubName(), transfer_out_club.getClubName(), transfer_player.getName());
			transfer_in_club.getClubAccount().balance = transfer_in_club.getClubAccount().balance - offer; 
			transfer_out_club.getClubAccount().balance = transfer_out_club.getClubAccount().balance + offer; 
			
		}


		Transfer_news_scroll_panel = new JScrollPane(Transfer_news_panel);
		Transfer_news_scroll_panel.setBounds(0, 200, 594, 360);
		Transfer_news_scroll_panel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(Transfer_news_scroll_panel);
		Transfer_news_panel.setText(current_news);
	}
	
	
	private void pause_transfer_news_window(int pause_time)
	{
		try {
			Thread.sleep(pause_time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
