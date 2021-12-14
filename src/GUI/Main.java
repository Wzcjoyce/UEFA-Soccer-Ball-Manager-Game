package GUI;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import soccer_manager.GameController;

/**
 * Starting main menu view (GUI)
 * @author Zuocheng Wang
 *
 */
public class Main extends JFrame implements ActionListener {
	
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private JButton start_button;
    private JButton quit_button;
    private JFrame frame;
    private JPanel Jpanel;
    private JLabel label;
    private Container container;
    Music_Background main_menu_music;
    Font title = new Font("Arial", Font.ITALIC, 26);
    Font normal_font = new Font("Arial", Font.ITALIC, 14);
    
    /**
     * Constructor of main menu
     */
    public Main() {
    	
    	
        frame = new JFrame("UEFA Champions League Soccer Manager designed by Zuocheng Wang");
        frame.setResizable(false);
        frame.setBackground(SelfColor.light_blue);
        frame.getContentPane().setBackground(Color.black);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        
        try {
        	frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("Main_menu.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
             
        start_button = new JButton("Start Game");
        start_button.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 14));
        start_button.addActionListener(this);
        Dimension size = start_button.getPreferredSize();
        start_button.setBounds(200, 500, size.width, size.height);
        start_button.setForeground(new Color(25, 25, 112));
        start_button.setBackground(new Color(255, 255, 255));
        
        quit_button = new JButton("Quit Game");
        quit_button.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 14));
        quit_button.addActionListener(this);
        quit_button.setBounds(500, 500, size.width, size.height);
        quit_button.setForeground(new Color(25, 25, 112));
        quit_button.setBackground(new Color(255, 255, 255));
        
        frame.getContentPane().add(start_button);
        frame.getContentPane().add(quit_button);
        frame.setVisible(true);
        container = frame.getContentPane();
                
        Jpanel = new JPanel();
        Jpanel.setForeground(new Color(255, 215, 0));
        Jpanel.setBounds(40, 10, 700, 60);
        Jpanel.setBackground(SelfColor.light_blue);
        Jpanel.setLayout(null);
       
        label = new JLabel("UEFA Champions League Soccer Manager");
        label.setBounds(43, 11, 616, 43);
        label.setForeground(new Color(255, 215, 0));
        label.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 34));

        
        Jpanel.add(label);
        
        container.add(Jpanel);
        frame.setVisible(false);
        container.setVisible(false);
        
    }
    
    private void show_main_menu()
    {
		this.container.setVisible(true);
    	frame.setVisible(true);
    }
    
    private void stop_main_frame()
    {
    	Jpanel.setVisible(false);
		container.setVisible(false);
		frame.setVisible(false);
		GameController.status = GameStatus.Team_Selection;
    	this.main_menu_music.Stop();
    	this.dispose();
    }
    
    public  Container start()
    {
		String musicFileName = "start.wav";
		String backgroundFileName = "menu.gif";
		String question_text = "Click Ok to Continue";
		Music_Background music_bg = new Music_Background(musicFileName, backgroundFileName, question_text);
		music_bg.play_no_text();
		
		this.show_main_menu();
    	
		Music_Background main_menu_music = new Music_Background("menu.wav", backgroundFileName, question_text);
		main_menu_music.play_without_image();
		this.main_menu_music = main_menu_music;
		return this.frame;
		
    }

    
    public void actionPerformed(ActionEvent menu_event) {
        JButton Jbutton = (JButton) menu_event.getSource();
        if (Jbutton == start_button) {
            this.stop_main_frame();
 
        } else if (Jbutton == quit_button) {
            this.setVisible(false);
            this.dispose();
            System.exit(0);
        }
    }
    
    public GameStatus getGameStatus()
    {
    	return GameController.status;
    }
    
}
