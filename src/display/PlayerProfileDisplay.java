package display;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private Color dGreen = new Color(143, 188, 114);
	private String player;
	private int unitSquare = GameDisplay.unitSquare;
	private Player p;
	private JLabel playerName, currentBalance, currentSquare, housesLBL, hotelsLBL, hotelCount, houseCount;
	private JButton quit;
	private JComboBox <String> ownedSquares;
	//private String[] ownedProperties = new String[p.getPropertyCount()];
	
	public PlayerProfileDisplay(String player) {
		super("Profile");
		this.player = player;
		p = GameDisplay.getGame().getPlayer(this.player);
		setBounds(480, 480, GameDisplay.unitSquare*40, GameDisplay.unitSquare*40);
		getContentPane().setBackground(new Color(143, 188, 114));
		initComponents();
		adder();
		repaint();
	}
	private void initComponents() {
		playerName = new JLabel(player);
		playerName.setFont(new Font("Consolas", Font.BOLD, 92));
		playerName.setText(player);
		playerName.setBackground(dGreen);
		playerName.setBounds(unitSquare, unitSquare, unitSquare*18, unitSquare*4);
		currentBalance = new JLabel();
		currentBalance.setFont(new Font("Consolas", Font.BOLD, 24));
		currentBalance.setText("Current Balance: "+ p.getBalance() + "$");
		currentBalance.setBackground(dGreen);
		currentBalance.setBounds(unitSquare*21, unitSquare*6, unitSquare*9, unitSquare*4);
		currentSquare = new JLabel();
		currentSquare.setFont(new Font("Consolas", Font.BOLD, 24));
		currentSquare.setText("Current Square: Square Name"); //Need to figure out how to get square name
		currentSquare.setBackground(dGreen);
		currentSquare.setBounds(unitSquare*31, unitSquare*6, unitSquare*9, unitSquare*4);
		ownedSquares = new JComboBox();
		housesLBL = new JLabel();
		hotelsLBL = new JLabel();
		hotelCount = new JLabel();
		houseCount = new JLabel();
		quit = new JButton();
		quit.setFont(new Font("Consolas", Font.BOLD, 24));
		quit.setText("Quit");
		quit.setBackground(dGreen);
		quit.setBounds(unitSquare*21, unitSquare*11, unitSquare*9, unitSquare*4);
	}
	private void adder() {
		add(playerName);
		add(currentBalance);
		add(quit);
	}
	private void addActionListeners() {
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
			
		});
	}
	
}
