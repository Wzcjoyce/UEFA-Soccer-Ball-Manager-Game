package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Club.Club;
import Club.Player;
import Club.PlayerField;
import soccer_manager.GameController;
import soccer_manager.Team_Background_Description;
import java.awt.FlowLayout;

/**
 * view class for letting user select team
 * @author Zuocheng Wang
 */
public class TeamSelectionView extends JFrame implements ActionListener{
	
	GameStatus status = GameStatus.Team_Selection;
	Font small_font =  new Font("ITALIC", Font.ITALIC, 15);
	Font normal_font =  new Font("ITALIC", Font.ITALIC, 18);
	Font welcome_font =  new Font("Bold & Italic", Font.ITALIC, 22);
	Font question_font =  new Font("Arial", Font.ITALIC, 24);
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    JButton confirm_button;
    JButton review_button;
    JButton second_confirm_button;
    final JComboBox<String> combo_box;
    
    String current_team_name = " ";
    String selected_team_name;
    
    static JFrame frame;
    static JPanel panel;
    static JPanel panel_2;
    
    static JLabel team_logo;
    JLabel team_background_label;
    private JLabel lblNewLabel;
    
	/**
	 * Constructor of team selection view
	 * @param selected_team_name
	 */
	public TeamSelectionView(String selected_team_name)
	{
		this.selected_team_name = selected_team_name;
		
		frame = new JFrame("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        this.setForeground(SelfColor.light_blue);
        
	    panel = new JPanel();
	    panel.setBackground(SelfColor.light_blue);
	    panel.setBounds(0, HEIGHT/2, WIDTH, HEIGHT/2);

	    frame.getContentPane().add(panel);

	    panel_2 = new JPanel();
	    panel_2.setBackground(SelfColor.light_blue);
	    panel_2.setBounds(0, 0, WIDTH, HEIGHT/2);
	    frame.getContentPane().add(panel_2);
	    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	    //panel_2.setLayout(null);
	    
	    lblNewLabel = new JLabel("Select Your Team:");
	    lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 16));
	    lblNewLabel.setForeground(new Color(255, 255, 255));
	    panel.add(lblNewLabel);
	    
	    JLabel space = new JLabel("<html><br/><html>");
	    space.setBounds(20, 29, 3, 14);
	    JLabel space_2 = new JLabel("<html><br/><html>");
	    space_2.setBounds(28, 29, 3, 14);
	    
	    // Add team 1st step
	    // Add team 2nd step download the team logo save it as "team_name.png" ex: "Bayern Munich.png"
	    // Add team 3rd step add the background description in Team_Background_Description class
	    // Add team 4th step edit get_team_background method in Team_Background_Description class
	    String[] team_choices = { "Chelsea","Atletico Madrid","Bayern Munich",
                "Lokomotiv Moscow","Red Bull Salzburg", "Real Madrid",
                "Borussia Mionchengladbach", "Shakhtar Donetsk", "Inter Milan",
                "Manchester City", "Porto", "Olympiacos","Marseille","Liverpool",
                "Atalanta", "Ajax", "Midtjylland", "Sevilla", "Spartak Moscow",
                "Rennes","Borussia Dortmund", "Lazio", "Club Brugge","PFC CSKA Moscow",
                "Juventus", "Barcelona", "Dynamo Kyiv", "Benfica", "Paris Saint-Germain",
                "RB Leipzig", "Manchester United", "Galatasaray"};
	    
	    
	    combo_box = new JComboBox<String>(team_choices);
	    
	   
	    panel.add(space);
	    panel.add(space_2); 
	    panel.add(combo_box); 
	    
	    JLabel lblpleaseSelectYour = new JLabel("<html><br/>Please Select the team you want to manage and click  confirm  to  Continue.<html>");
	    lblpleaseSelectYour.setHorizontalAlignment(SwingConstants.CENTER);
	    lblpleaseSelectYour.setFont(new Font("Sitka Display", Font.BOLD, 24));
	    lblpleaseSelectYour.setForeground(new Color(255, 255, 255));
	    
	    panel.add(lblpleaseSelectYour);
	    
	    JLabel review_description = new JLabel("<html>Review Basic team information by clicking Review team background<br/><br/><html>");
	    review_description.setHorizontalAlignment(SwingConstants.CENTER);
	    review_description.setFont(new Font("Sitka Heading", Font.BOLD, 24));
	    review_description.setForeground(new Color(255, 255, 255));
	    panel.add(review_description);
	    	    	    
	    review_button = new JButton("Review Team Background");
	    review_button.setForeground(new Color(25, 25, 112));
	    review_button.setFont(new Font("Sitka Display", Font.BOLD, 15));
	    review_button.addActionListener(this);
	    
	    	    
	    panel.add(review_button);
	    
	    confirm_button = new JButton("Confirm Your Selection");
	    confirm_button.setForeground(new Color(25, 25, 112));
	    confirm_button.setFont(new Font("Sitka Display", Font.BOLD, 15));
	    confirm_button.addActionListener(this);
	    panel.add(confirm_button);
	    
	    team_logo = new JLabel();
		ImageIcon logo_image = new ImageIcon("Chelsea.png");
		team_logo.setIcon(logo_image);
		
		team_background_label = new JLabel("Chelsea");
		team_background_label.setBackground(Color.white);
		team_background_label.setForeground(Color.black);
		team_background_label.setFont(normal_font);
		
	}
	
	public void show()
	{
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton Jbutton = (JButton) e.getSource();
		selected_team_name = (String) combo_box.getSelectedItem();
		
		if (Jbutton == review_button && current_team_name != selected_team_name) 
        {
			team_background_label.setText(null);
			team_logo.removeAll();
			team_logo.setIcon(null);
        	selected_team_name = (String) combo_box.getSelectedItem();
        	current_team_name = selected_team_name;
        	this.Add_team_logo(selected_team_name);
        	this.Add_team_background(selected_team_name);
        }
        else if (Jbutton == confirm_button)
        {
        	GameController.team_name = this.getTeamName();
        	this.AskUserName();
        	this.AskUserAge();
        	this.AskUserNationality();
        	//this.Ask_Tsubasa_choice(); //TODO
        	panel_2.setVisible(false);
        	panel.setVisible(false);
        	
        	panel = new JPanel();
    	    panel.setBackground(SelfColor.light_blue);
    	    
    	    panel.setBounds(0, 5, WIDTH, HEIGHT/2);
    	    panel_2 = new JPanel();
    	    panel_2.setBackground(SelfColor.light_blue);
    	    panel_2.setBounds(0, 200, WIDTH, HEIGHT/2);
    	    frame.getContentPane().add(panel_2);
    	    frame.getContentPane().add(panel);

    	    JLabel label_description = new JLabel("<html><br/>" + "Breaking News:<br/>"
    	    		+ "With a number of names being mentioned, it came as a bit of a surprise when "  + GameController.team_name +
    	    		"<br/>" +"announced the " + GameController.user_age +" years old manager " + GameController.user_name +" as their new Manager." + "<br/>" +
    	    		"<br/>"+"The Club said that of all other applicants "+  GameController.user_name + "<br/>" +
    	    		" really stand out despite his lack of experience. A spokesman from the Supporters said that this"+
    	    		"<br/>" + "was a \"HUGE RISK\" and that the fans would struggle to warm to a man with no proven track record."+ "<br/>" +"<br/>"+
    	    		"Time will tell if the fans can be won over, but there is no doubting the fact that the club will"  + "<br/>"+  "have given hope to many aspiring managers if the "
    	    		+"tensure turns out to be a successful one."+"<br/>"+ "<br/>" + "<html>");
    	    label_description.setFont(small_font);
    	    label_description.setForeground(Color.white);
    	    
    	    
    	    team_logo = new JLabel();
    		ImageIcon logo_image = new ImageIcon(selected_team_name + ".png");
    		team_logo.setIcon(logo_image);
    		panel.add(team_logo);
    		
    	    second_confirm_button = new JButton("Continue and Start your Journey");
    	    second_confirm_button.setFont(normal_font);
    	    second_confirm_button.addActionListener(this);
    	    panel_2.add(label_description);
    	    panel_2.add(second_confirm_button);

        	
        }
        else if (Jbutton == second_confirm_button)
        {
        	GameController.status = GameStatus.GAME_RUNNING;
        	frame.setVisible(false);
        	frame.dispose();
        }

	}
	
	
	public static void Add_team_logo(String selected_team_name)
	{
		team_logo = new JLabel();
		ImageIcon logo_image = new ImageIcon(selected_team_name + ".png");
		team_logo.setIcon(logo_image);
		panel_2.add(team_logo);
		frame.setVisible(true);
	}
	
	private void Add_team_background(String selected_team_name)
	{
		String description = Team_Background_Description.get_team_background(selected_team_name);
		team_background_label = new JLabel(description,  SwingConstants.CENTER);
		
		team_background_label.setBackground(Color.gray);
		team_background_label.setForeground(Color.white);
		team_background_label.setFont(normal_font);
		
		panel_2.add(team_background_label);
		frame.setVisible(true);
	}
	
	private String getTeamName()
	{
		return this.selected_team_name;
	}
	
	private void AskUserName()
	{
		String user_name = "";
		
		ImageIcon ask_name_background = new ImageIcon("ask_name.png");
		
		user_name = (String)JOptionPane.showInputDialog(frame,
               "Please Type your Name", 
               "Type your Name",            
               JOptionPane.PLAIN_MESSAGE,
               ask_name_background,            
               null, 
               null
            );
		
		if (user_name != null) 
		{
			GameController.user_name = user_name;
		}
		else
		{
			GameController.user_name = "Nameless";
		}
	}
	
	private void AskUserAge()
	{
		String user_age = "";
		
		ImageIcon ask_age_background = new ImageIcon("ask_name.png");
		
		user_age = (String)JOptionPane.showInputDialog(frame,
               "Please Type your age", 
               "Type your Age",            
               JOptionPane.PLAIN_MESSAGE,
               ask_age_background,            
               null, 
               null
            );
		
		if (user_age != null) 
		{
			try {
			int age = Integer.parseInt(user_age);
			GameController.user_age = age;
			} catch (NumberFormatException e){
				GameController.user_age = 30;
			}
		}
		else
		{
			GameController.user_age = 30;
		}
	}
	
	
	private void AskUserNationality()
	{
		String user_nationality = "";
		
		ImageIcon ask_nationality_background = new ImageIcon("ask_name.png");
		
		user_nationality = (String)JOptionPane.showInputDialog(frame,
               "Please Type your Nationality", 
               "Type your Nationality",            
               JOptionPane.PLAIN_MESSAGE,
               ask_nationality_background,            
               null, 
               null
            );
		
		if (user_nationality != null) 
		{
			GameController.user_nationality = user_nationality;
		}
		else
		{
			GameController.user_nationality = "USA";
		}
	}
	
	private void Ask_Tsubasa_choice()
	{
		Music_Background bgm = new Music_Background("tsubasa.wav");
		bgm.music_only();
		
		String add_tsubasa = "";
		
		ImageIcon Ask_Tsubasa_choice = new ImageIcon("Tsubasa_character.png");
		
		add_tsubasa = (String)JOptionPane.showInputDialog(frame,
               "Do you want to add Captain Tsubasa to join your team?", 
               "Captain Tsubasa to join your team?",            
               JOptionPane.PLAIN_MESSAGE,
               Ask_Tsubasa_choice,            
               null, 
               null
            );
		
		GameController.tsubasa_add = false;
		
		if (add_tsubasa.equals("yes") || add_tsubasa.equals("Yes") ) 
		{
			GameController.tsubasa_add = true;
		}
		bgm.Stop();

	}
	
}
