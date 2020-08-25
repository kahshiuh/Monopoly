package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class StartScreenDisplay extends JFrame{
	
		private JButton startButton;
		private JButton addPlayer;
		private JButton delPlayer;
		private JComboBox<String> delPlayerChoice;
		private JComboBox<String> pieceChoice;
		private ImageIcon board;
		private JLabel bLogo;
		private JLabel title;
		int players = 0;
		private static String[] choices = {"Scottie Dog", "Top Hat", "Thimble", "Boot", "Wheelbarrow", "Iron", "Racing Car", "Battleship"};
	  	
		public StartScreenDisplay() {
	  		super("Create Game Screen");
	  		setBounds(480, 480, 960, 720);
	  		getContentPane().setBackground(new Color (143, 188, 114));
	  		setLayout(null);
	  		initComponents();
	  		add(startButton);
	  		add(addPlayer);
	  		add(delPlayer);
	  		add(pieceChoice);
	  		add(delPlayerChoice);
	  		add(bLogo);
	  		add(title);
	  		repaint();
	  	}
	  	private void initComponents() {
	  		startButton = new JButton();
	  		startButton.setBounds(450, 325, 200, 50);
	  		startButton.setText("Create New Game");
	  		startButton.setBackground(new Color(191, 219, 174));
	  		startButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					SwingUtilities.invokeLater(new Runnable() {
			             public void run() {
			                 new GameDisplay();
			             }
			         });
				}	  			
	  		});
	  		
	  		pieceChoice = new JComboBox(choices);
	  		pieceChoice.setBounds(675, 175, 200, 50);
	  		pieceChoice.setBackground(new Color(255,255,255));
	  		delPlayerChoice = new JComboBox();
	  		delPlayerChoice.setBounds(675, 250, 200, 50);
	  		delPlayerChoice.setBackground(new Color(255,255,255));
	  		addPlayer = new JButton();
	  		addPlayer.setBounds(450, 175, 200, 50);
	  		addPlayer.setText("Add New Player");
	  		addPlayer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String s = (String) pieceChoice.getSelectedItem();
					if(s != null) {
						System.out.println(s);
						pieceChoice.removeItem(s);
						delPlayerChoice.addItem(s);
						switch(s) {
						case "Scottie Dog":
							try {
								Image image = ImageIO.read(new File("images/gamePieces/dog.png"));
				    			Image image1 = image.getScaledInstance(GameDisplay.unitSquare*2, GameDisplay.unitSquare*2, java.awt.Image.SCALE_SMOOTH);
				    			GameDisplay.getGame().addPlayer(players, s, new ImageIcon(image1));;
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case "Top Hat":
							try {
								Image image = ImageIO.read(new File("images/gamePieces/hat.png"));
				    			Image image1 = image.getScaledInstance(GameDisplay.unitSquare*2, GameDisplay.unitSquare*2, java.awt.Image.SCALE_SMOOTH);
				    			GameDisplay.getGame().addPlayer(players, s, new ImageIcon(image1));;
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case "Thimble":
							try {
								Image image = ImageIO.read(new File("images/gamePieces/thimble.png"));
				    			Image image1 = image.getScaledInstance(GameDisplay.unitSquare*2, GameDisplay.unitSquare*2, java.awt.Image.SCALE_SMOOTH);
				    			GameDisplay.getGame().addPlayer(players, s, new ImageIcon(image1));;
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case "Boot":
							try {
								Image image = ImageIO.read(new File("images/gamePieces/boot.png"));
				    			Image image1 = image.getScaledInstance(GameDisplay.unitSquare*2, GameDisplay.unitSquare*2, java.awt.Image.SCALE_SMOOTH);
				    			GameDisplay.getGame().addPlayer(players, s, new ImageIcon(image1));;
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case "Wheelbarrow":
							try {
								Image image = ImageIO.read(new File("images/gamePieces/wheelbarrow.png"));
				    			Image image1 = image.getScaledInstance(GameDisplay.unitSquare*2, GameDisplay.unitSquare*2, java.awt.Image.SCALE_SMOOTH);
				    			GameDisplay.getGame().addPlayer(players, s, new ImageIcon(image1));;
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case "Iron":
							try {
								Image image = ImageIO.read(new File("images/gamePieces/iron.png"));
				    			Image image1 = image.getScaledInstance(GameDisplay.unitSquare*2, GameDisplay.unitSquare*2, java.awt.Image.SCALE_SMOOTH);
				    			GameDisplay.getGame().addPlayer(players, s, new ImageIcon(image1));;
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case "Racing Car":	
							try {
								Image image = ImageIO.read(new File("images/gamePieces/car.png"));
				    			Image image1 = image.getScaledInstance(GameDisplay.unitSquare*2, GameDisplay.unitSquare*2, java.awt.Image.SCALE_SMOOTH);
				    			GameDisplay.getGame().addPlayer(players, s, new ImageIcon(image1));;
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case "Battleship":	
							try {
								Image image = ImageIO.read(new File("images/gamePieces/ship.png"));
				    			Image image1 = image.getScaledInstance(GameDisplay.unitSquare*2, GameDisplay.unitSquare*2, java.awt.Image.SCALE_SMOOTH);
				    			GameDisplay.getGame().addPlayer(players, s, new ImageIcon(image1));;
							} catch (IOException e) {
								// TODO Auto-generated catch block
							e.printStackTrace();
							}
							break;
						}
						players++;
					}
				}
	  		});
	  		addPlayer.setBackground(new Color(191, 219, 174));
	  		delPlayer = new JButton();
	  		delPlayer.setBounds(450, 250, 200, 50);
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
						players--;
					}
					
				}
	  		});
	  		try {
	  			Image image = ImageIO.read(new File("images/misc/m.jpg"));
    			Image image1 = image.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH);
                board = new ImageIcon(image1);
	  		}catch(IOException io) {
	  			
	  		}
	  		
	  		bLogo = new JLabel(board);
	  		bLogo.setBounds(25,175, 400, 400);
	  		bLogo.setBackground(new Color(191,219,174));
	  		bLogo.setVisible(true);
	  		title = new JLabel();
	  		title.setFont(new Font("Consolas", Font.BOLD, 92));
	  		title.setText("Monopoly");
	  		title.setBounds(230,20, 575,125);
	  		title.setForeground(new Color(199, 0, 0));
	  	}


}
