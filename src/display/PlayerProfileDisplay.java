package display;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Player;

/*Timer Class Should Be Implemented
 * Once timer hits certain number, tab auto closes
 * Timer resets once the screen is interacted with
 */
public class PlayerProfileDisplay extends JFrame{
	private Font setFont;
	private Color dGreen = new Color(143, 188, 114), lGreen = new Color(191, 219, 174);
	private String player;
	private int unitSquare = GameDisplay.unitSquare;
	private Player p;
	private JLabel playerName, currentBalance, currentSquare, housesLBL, hotelsLBL, hotelCount, houseCount, playerIcon;
	private JLabel housesOnSelected, hotelsOnSelected;
	private JComboBox <String> ownedSquares;
	private JButton check;
	private String[] squares;
	//private String[] ownedProperties = new String[p.getPropertyCount()];
	
	public PlayerProfileDisplay(String player) {
		super("Profile");
		this.player = player;
		setLayout(null);
		p = GameDisplay.getGame().getPlayer(this.player);
		setBounds(480, 480, GameDisplay.unitSquare*40, GameDisplay.unitSquare*34);
		getContentPane().setBackground(dGreen);
		initComponents();
		adder();
		repaint();
	}
	private void labelInitializer(JLabel j, String t, int a, int b, int c, int d, int fS) {
		setFont = new Font("Consolas", Font.BOLD, fS);
		j.setFont(setFont);
		j.setText(t);
		j.setBackground(dGreen);
		j.setVisible(true);
		j.setOpaque(true);
		j.setBounds(unitSquare*a, unitSquare*b, unitSquare*c, unitSquare*d);
	}
	private void initComponents() {
		check = new JButton();
		check.setBounds(unitSquare*31,unitSquare*12, unitSquare*7, unitSquare*2);
		check.setBackground(lGreen);
		check.setText("Check Property");
		playerName = new JLabel();
		labelInitializer(playerName, player, 1,1,18,4, 52);
		housesOnSelected = new JLabel();
		labelInitializer(housesOnSelected, "Houses Present: ", 31, 15, 9, 3, 16);
		hotelsOnSelected = new JLabel();
		labelInitializer(hotelsOnSelected, "Hotels Present: ", 31, 18, 9, 3, 16);
		currentBalance = new JLabel();
		labelInitializer(currentBalance, "Balance: "+ p.getBalance() + "$", 21,5,9,3, 16);
		currentSquare = new JLabel();
		labelInitializer(currentSquare, "Square: Property", 31,5,9,3, 16); //Need to figure out how to get square name
		ownedSquares = new JComboBox(p.getProperties());
		ownedSquares.setFont(new Font("Consolas", Font.BOLD, 16));
		ownedSquares.setBackground(Color.WHITE);
		ownedSquares.setBounds(unitSquare*21, unitSquare*12, unitSquare*8, unitSquare*2);
		hotelCount = new JLabel();
		labelInitializer(hotelCount, "Hotels Owned: "+ p.getHotels(), 21,8,9, 3, 16);
		houseCount = new JLabel();
		labelInitializer(houseCount, "Houses Owned: "+ p.getHouses(), 31,8,9, 3, 16);
		Image image = p.getRawImage();
		Image image1 = image.getScaledInstance(GameDisplay.unitSquare*15, GameDisplay.unitSquare*15, java.awt.Image.SCALE_SMOOTH);
		playerIcon = new JLabel(new ImageIcon(image1));
		playerIcon.setBounds(unitSquare, unitSquare*6, unitSquare*15, unitSquare*15);
	}
	private void adder() {
		add(playerName);
		add(currentBalance);
		add(hotelCount);
		add(houseCount);
		add(ownedSquares);
		add(currentSquare);
		add(playerIcon);
		add(check);
		add(housesOnSelected);
		add(hotelsOnSelected);
	}

	private void addALs() {
		check.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
	}
	
}
