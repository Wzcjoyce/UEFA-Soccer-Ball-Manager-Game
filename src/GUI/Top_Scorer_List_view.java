package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import Club.Club;
import Club.Player;
import soccer_manager.GameController;
import javax.swing.table.DefaultTableModel;
import java.awt.Graphics;
import java.awt.Image;

/**
 * view class for showing the latest top scorer list
 * @author Zuocheng Wang
 */
public class Top_Scorer_List_view extends JFrame implements ActionListener{
	
	protected JButton go_back_to_main_menu;
	protected JButton go_back_to_UEFA_view;
	
	protected Game_Play_Main_Menu game_play_main_menu;
	protected UEFA_button_View UEFA_view;
	protected JTextPane ChampionsLeagueScoreList;
	protected JTable Top_scorer_table;
	protected JTableHeader header;
	protected JScrollPane Top_ScorePane;
	protected LinkedList<LinkedList<Object>> top_score_list;
	
	/**
	 * Constructor of top scorer list view
	 * @param game_play_main_menu
	 * @param UEFA_view
	 */
	public Top_Scorer_List_view(Game_Play_Main_Menu game_play_main_menu, UEFA_button_View UEFA_view)
	{
		this.game_play_main_menu = game_play_main_menu;
		this.UEFA_view = UEFA_view;
		
		this.UEFA_view.setVisible(false);
		
		getContentPane().setBackground(new Color(100, 149, 237));
		getContentPane().setLayout(null);
		
		
		ChampionsLeagueScoreList = new JTextPane();
		ChampionsLeagueScoreList.setEditable(false);
		ChampionsLeagueScoreList.setForeground(new Color(240, 230, 140));
		ChampionsLeagueScoreList.setBackground(new Color(100, 149, 237));
		ChampionsLeagueScoreList.setFont(new Font("Times New Roman", Font.BOLD, 34));
		ChampionsLeagueScoreList.setText("Champions League Top Scorer");
		ChampionsLeagueScoreList.setBounds(165, 25, 493, 67);
		getContentPane().add(ChampionsLeagueScoreList);
		
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
		
		JPanel UEFA_image_1 = new JPanel() {
			public void paintComponent(Graphics g) {
				
		        Image img = new ImageIcon("golden_boots.png").getImage();
		        Dimension size = new Dimension(136, 224);
		        setPreferredSize(size);
		        setMinimumSize(size);
		        setMaximumSize(size);
		        setSize(size);
		        getContentPane().setLayout(null);
		        g.drawImage(img, 0, 0, 136, 224, null);
			}
		};
		UEFA_image_1.setBackground(new Color(255, 255, 224));
		UEFA_image_1.setBounds(30, 168, 136, 209);
		getContentPane().add(UEFA_image_1);
		
		JPanel UEFA_image_2 = new JPanel() {
			public void paintComponent(Graphics g) {
		        Image img = new ImageIcon("golden_boots.png").getImage();
		        Dimension size = new Dimension(136, 224);
		        setPreferredSize(size);
		        setMinimumSize(size);
		        setMaximumSize(size);
		        setSize(size);
		        getContentPane().setLayout(null);
		        g.drawImage(img, 0, 0, 136, 224, null);
			}
		};
		UEFA_image_2.setBackground(new Color(255, 255, 224));
		UEFA_image_2.setBounds(618, 168, 136, 209);
		getContentPane().add(UEFA_image_2);
		
		
		Top_scorer_table = new JTable() {

            @Override
            public Component prepareRenderer(
                TableCellRenderer renderer, int row, int col) {
                if (col == 0) {
                    return this.getTableHeader().getDefaultRenderer()
                        .getTableCellRendererComponent(this, this.getValueAt(
                            row, col), false, false, row, col);
                } else {
                    return super.prepareRenderer(renderer, row, col);
                }
            }
        };
		Top_scorer_table.setShowGrid(false);
		Top_scorer_table.setRowSelectionAllowed(false);
        Top_scorer_table.setBackground(new Color(240, 255, 240));
        Top_scorer_table.setFont(new Font("Tahoma", Font.PLAIN, 12));
        Top_scorer_table.setAutoCreateRowSorter(false);
        Top_scorer_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        header = Top_scorer_table.getTableHeader();
        header.setDefaultRenderer(new HeaderRenderer(Top_scorer_table));
        
        
        if(GameController.UEFA.score_list.size() > 0)
        {
	        GameController.UEFA.sort_score_list();
	        top_score_list = GameController.UEFA.score_list;
	        Top_scorer_table.setModel(new DefaultTableModel(
	        	new Object[][] {
	        		{"1", ((Player) top_score_list.get(top_score_list.size() - 1).get(0)).getName() , top_score_list.get(top_score_list.size() - 1).get(1), ((Club)top_score_list.get(top_score_list.size() - 1).get(2)).getClubName()},
	        		{"2", ((Player) top_score_list.get(top_score_list.size() - 2).get(0)).getName() , top_score_list.get(top_score_list.size() - 2).get(1), ((Club)top_score_list.get(top_score_list.size() - 2).get(2)).getClubName()},
	        		{"3", ((Player) top_score_list.get(top_score_list.size() - 3).get(0)).getName() , top_score_list.get(top_score_list.size() - 3).get(1), ((Club)top_score_list.get(top_score_list.size() - 3).get(2)).getClubName()},
	        		{"4", ((Player) top_score_list.get(top_score_list.size() - 4).get(0)).getName() , top_score_list.get(top_score_list.size() - 4).get(1), ((Club)top_score_list.get(top_score_list.size() - 4).get(2)).getClubName()},
	        		{"5", ((Player) top_score_list.get(top_score_list.size() - 5).get(0)).getName() , top_score_list.get(top_score_list.size() - 5).get(1), ((Club)top_score_list.get(top_score_list.size() - 5).get(2)).getClubName()},
	        		{"6", ((Player) top_score_list.get(top_score_list.size() - 6).get(0)).getName() , top_score_list.get(top_score_list.size() - 6).get(1), ((Club)top_score_list.get(top_score_list.size() - 6).get(2)).getClubName()},
	        		{"7", ((Player) top_score_list.get(top_score_list.size() - 7).get(0)).getName() , top_score_list.get(top_score_list.size() - 7).get(1), ((Club)top_score_list.get(top_score_list.size() - 7).get(2)).getClubName()},
	        		{"8", ((Player) top_score_list.get(top_score_list.size() - 8).get(0)).getName() , top_score_list.get(top_score_list.size() - 8).get(1), ((Club)top_score_list.get(top_score_list.size() - 8).get(2)).getClubName()},
	        		{"9", ((Player) top_score_list.get(top_score_list.size() - 9).get(0)).getName() , top_score_list.get(top_score_list.size() - 9).get(1), ((Club)top_score_list.get(top_score_list.size() - 9).get(2)).getClubName()},
	        		{"10", ((Player) top_score_list.get(top_score_list.size() - 10).get(0)).getName() , top_score_list.get(top_score_list.size() - 10).get(1), ((Club)top_score_list.get(top_score_list.size() - 10).get(2)).getClubName()},
	        		{"11", ((Player) top_score_list.get(top_score_list.size() - 11).get(0)).getName() , top_score_list.get(top_score_list.size() - 11).get(1), ((Club)top_score_list.get(top_score_list.size() - 11).get(2)).getClubName()},
	        		{"12", ((Player) top_score_list.get(top_score_list.size() - 12).get(0)).getName() , top_score_list.get(top_score_list.size() - 12).get(1), ((Club)top_score_list.get(top_score_list.size() - 12).get(2)).getClubName()},
	        		{"13", ((Player) top_score_list.get(top_score_list.size() - 13).get(0)).getName() , top_score_list.get(top_score_list.size() - 13).get(1), ((Club)top_score_list.get(top_score_list.size() - 13).get(2)).getClubName()},
	        		{"14", ((Player) top_score_list.get(top_score_list.size() - 14).get(0)).getName() , top_score_list.get(top_score_list.size() - 14).get(1), ((Club)top_score_list.get(top_score_list.size() - 14).get(2)).getClubName()},
	        		{"15", ((Player) top_score_list.get(top_score_list.size() - 15).get(0)).getName() , top_score_list.get(top_score_list.size() - 15).get(1), ((Club)top_score_list.get(top_score_list.size() - 15).get(2)).getClubName()}
	        	},
	        	new String[] {
	        		"Ranking", "Player Name", "Goals", "Team"
	        	}
	        ));
	        
	        Top_scorer_table.getColumnModel().getColumn(1).setPreferredWidth(80);
	        Top_scorer_table.getColumnModel().getColumn(3).setPreferredWidth(100);
	        
	        Top_ScorePane = new JScrollPane(Top_scorer_table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        Top_ScorePane.setBounds(214, 137, 335, 275);
	        getContentPane().add(Top_ScorePane);
        }
        else
        {
	        Top_scorer_table.setModel(new DefaultTableModel(
		        	new Object[][] {
		        		{"1", " ", " ", " "},
		        		{"2", " ", " ", " "},
		        		{"3", " ", " ", " "},
		        		{"4", " ", " ", " "},
		        		{"5", " ", " ", " "},
		        		{"6", " ", " ", " "},
		        		{"7", " ", " ", " "},
		        		{"8", " ", " ", " "},
		        		{"9", " ", " ", " "},
		        		{"10", " ", " ", " "},
		        		{"11", " ", " ", " "},
		        		{"12", " ", " ", " "},
		        		{"13", " ", " ", " "},
		        		{"14", " ", " ", " "},
		        		{"15", " ", " ", " "}
		        	},
		        	new String[] {
		        		"Ranking", "Player Name", "Goals", "Team"
		        	}
		        ));
		        
		        Top_scorer_table.getColumnModel().getColumn(1).setPreferredWidth(80);
		        Top_scorer_table.getColumnModel().getColumn(3).setPreferredWidth(100);
		        
		        Top_ScorePane = new JScrollPane(Top_scorer_table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		        Top_ScorePane.setBounds(214, 137, 335, 275);
		        getContentPane().add(Top_ScorePane);
        }
		
	}

	@Override
	public void actionPerformed(ActionEvent score_list_view_event) {
		JButton top_Score_view_button = (JButton) score_list_view_event.getSource();
		if(top_Score_view_button == go_back_to_main_menu)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			this.dispose();
			game_play_main_menu.setVisible(true);
		}
		else if(top_Score_view_button == go_back_to_UEFA_view)
		{
			GameController.pauseGame(200);
			this.setVisible(false);
			this.dispose();
			UEFA_view.setVisible(true);
		}
		
	}
	
    public static class HeaderRenderer implements TableCellRenderer {

        TableCellRenderer renderer;

        public HeaderRenderer(JTable table) {
            renderer = table.getTableHeader().getDefaultRenderer();
        }

        public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int col) {
            return renderer.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, col);
        }
    }
}
