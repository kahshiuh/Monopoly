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
	private Color dGreen = new Color(143, 188, 114), lGreen = new Color(191, 219, 174);
	private String player;
	private int unitSquare = GameDisplay.unitSquare;
	private Player p;
	private JLabel playerName, currentBalance, currentSquare, housesLBL, hotelsLBL, hotelCount, houseCount;
	private JButton quit;
	private JComboBox <String> ownedSquares;
	private String[] squares;
	//private String[] ownedProperties = new String[p.getPropertyCount()];
	
	public PlayerProfileDisplay(String player) {
		super("Profile");
		this.player = player;
		setLayout(null);
		p = GameDisplay.getGame().getPlayer(this.player);
		setBounds(480, 480, GameDisplay.unitSquare*40, GameDisplay.unitSquare*40);
		getContentPane().setBackground(dGreen);
		initComponents();
		adder();
		repaint();
	}
	private void initComponents() {
		playerName = new JLabel(player);
		playerName.setFont(new Font("Consolas", Font.BOLD, 52));
		playerName.setText(player);
		playerName.setBackground(lGreen);
		playerName.setVisible(true);
		playerName.setBounds(unitSquare, unitSquare, unitSquare*18, unitSquare*4);
		currentBalance = new JLabel();
		currentBalance.setFont(new Font("Consolas", Font.BOLD, 16));
		currentBalance.setText("Balance: "+ p.getBalance() + "$");
		currentBalance.setBackground(lGreen);
		currentBalance.setBounds(unitSquare*21, unitSquare*6, unitSquare*9, unitSquare*4);
		currentBalance.setForeground(new Color(199, 0, 0));
		currentBalance.setVisible(true);
		currentSquare = new JLabel();
		currentSquare.setFont(new Font("Consolas", Font.BOLD, 16));
		currentSquare.setText("Square: Square Name"); //Need to figure out how to get square name
		currentSquare.setBackground(lGreen);
		currentSquare.setBounds(unitSquare*31, unitSquare*6, unitSquare*9, unitSquare*4);
		ownedSquares = new JComboBox();
		ownedSquares.setFont(new Font("Consolas", Font.BOLD, 16));
		ownedSquares.setBackground(Color.WHITE);
		ownedSquares.setBounds(unitSquare*21, unitSquare*21, unitSquare*9, unitSquare*4);
		hotelCount = new JLabel();
		hotelCount.setFont(new Font("Consolas", Font.BOLD, 16));
		hotelCount.setText("Hotels Owned: ");
		hotelCount.setForeground(lGreen);
		hotelCount.setBounds(unitSquare*21, unitSquare*11, unitSquare*9, unitSquare*4);
		houseCount = new JLabel();
		houseCount.setFont(new Font("Consolas", Font.BOLD, 16));
		houseCount.setText("Houses Owned: ");
		houseCount.setForeground(lGreen);
		houseCount.setBounds(unitSquare*31, unitSquare*11, unitSquare*9, unitSquare*4);
		quit = new JButton();
		quit.setFont(new Font("Consolas", Font.BOLD, 24));
		quit.setText("Quit");
		quit.setBackground(lGreen);
		quit.setBounds(unitSquare*21, unitSquare*16, unitSquare*9, unitSquare*4);
	}
	private void properties() {
		
	}
	private void adder() {
		add(playerName);
		add(currentBalance);
		add(quit);
		add(hotelCount);
		add(houseCount);
		add(ownedSquares);
		add(currentSquare);
	}

	private void addActionListeners() {
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
			
		});
	}
	
}
