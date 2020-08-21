package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StartScreenDisplay extends JFrame{
		private JButton startButton;
		private JButton addPlayer;
		private JButton delPlayer;
		private JComboBox<String> delPlayerChoice;
		private JComboBox<String> pieceChoice;
		int players = 0;
		private static String[] choices = {"Scottie Dog", "Top Hat", "Thimble", "Boot", "Wheelbarrow", "Iron", "Racing Car", "Battleship"};
	  	static boolean quit;
	  	public StartScreenDisplay() {
	  		super("Create Game Screen");
	  		setBounds(480, 480, 1280, 920);
	  		getContentPane().setBackground(new Color (143, 188, 114));
	  		setLayout(null);
	  		initComponents();
	  		add(startButton);
	  		add(addPlayer);
	  		add(delPlayer);
	  		add(pieceChoice);
	  		add(delPlayerChoice);
	  		quit = false;
	  	}
	  	private void initComponents() {
	  		startButton = new JButton();
	  		startButton.setBounds(550, 450, 200, 50);
	  		startButton.setText("Create New Game");
	  		startButton.setBackground(new Color(191, 219, 174));
	  		startButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					quit = true;
					dispose();
					SwingUtilities.invokeLater(new Runnable() {
			             public void run() {
			                 new GameDisplay();
			             }
			         });
				}	  			
	  		});
	  		
	  		pieceChoice = new JComboBox(choices);
	  		pieceChoice.setBounds(775, 525, 200, 50);
	  		pieceChoice.setBackground(new Color(255,255,255));
	  		delPlayerChoice = new JComboBox();
	  		delPlayerChoice.setBounds(775, 600, 200, 50);
	  		delPlayerChoice.setBackground(new Color(255,255,255));
	  		addPlayer = new JButton();
	  		addPlayer.setBounds(550, 525, 200, 50);
	  		addPlayer.setText("Add New Player");
	  		addPlayer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String s = (String) pieceChoice.getSelectedItem();
					if(s != null) {
						System.out.println(s);
						pieceChoice.removeItem(s);
						delPlayerChoice.addItem(s);
						GameDisplay.getGame().addPlayer(players, s);
					}
				}
	  		});
	  		addPlayer.setBackground(new Color(191, 219, 174));
	  		delPlayer = new JButton();
	  		delPlayer.setBounds(550, 600, 200, 50);
	  		delPlayer.setText("Delete Player");
	  		delPlayer.setBackground(new Color(191, 219, 174));
	  		delPlayer.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					String s = (String) delPlayerChoice.getSelectedItem();
					if(s != null) {
						System.out.println(s);
						delPlayerChoice.removeItem(s);
						pieceChoice.addItem(s);
						GameDisplay.getGame().deletePlayer(s);
					}
					
				}
	  		});
	  	}
	  	
	  	public static boolean quitCheck() {
	  		return quit;
	  	}

}
