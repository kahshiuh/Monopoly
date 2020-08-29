package display;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import game.Player;
public class SellPropertyDisplay extends JFrame{
	private final Color dGreen = new Color(143, 188, 114), lGreen = new Color(191, 219, 174);
	private JComboBox cB;
	private int unitSquare = GameDisplay.unitSquare;
	private JButton sellSquare, sellHouse, sellHotel;
	private Player p;
	
	public SellPropertyDisplay(Player p) {
		this.p = p;
		setVisible(true);
		setLayout(null);
		getContentPane().setBackground(dGreen);
		setBounds(480, 480, GameDisplay.unitSquare*40, GameDisplay.unitSquare*34);
		initComponents();
		adder();
	}
	private void initComponents() {
		cB= new JComboBox(p.getProperties());
		cB.setBounds(unitSquare*20, unitSquare*10, unitSquare*6, unitSquare*3);
		sellSquare = new JButton();
		buttonInitializer(sellSquare, 27, 10, 6, 3, "Sell Square");
		sellHouse = new JButton();
		buttonInitializer(sellHouse, 27, 14, 6, 3, "Sell House");
		sellHotel = new JButton();
		buttonInitializer(sellHotel, 27, 18, 6, 3, "Sell Hotel");
	}
	private void buttonInitializer(JButton bu, int a, int b, int c, int d, String t) {
		bu.setBackground(lGreen);
		bu.setBounds(unitSquare*a, unitSquare*b, unitSquare*c, unitSquare*d);
		bu.setText(t);
	}
	private void adder() {
		add(cB);
		add(sellSquare);
		add(sellHouse);
		add(sellHotel);
	}
	private void addALs() {
		sellSquare.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		sellHotel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
			
		});
		sellHouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
			
		});
	}
}
