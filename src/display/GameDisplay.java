package display;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.*;

import game.Monopoly;
import game.Player;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GameDisplay extends JFrame {

    private final int CANV_WIDTH = 1600, CANV_HEIGHT = 1000;
    private Color green = new Color(191, 219, 174), lg = new Color(191, 219, 174);
    private int mouseX, mouseY;
    public final static int unitSquare = 18;
    private static Monopoly m = new Monopoly();
    private ArrayList<Point> startPoint = new ArrayList(40);
    private Canvas canvas;
    private ImageIcon [] dieSides= new ImageIcon[6];
    private ImageIcon [] gamePieces = new ImageIcon[8];
    private JLabel dL1, dL2, logo;
    private ArrayList<JLabel> playerPieces = new ArrayList();
    private boolean dieRolled = false;
    private Button diceRollBUT, nextTurnBUT, buyPropertyBUT, sellPropertyBUT, viewProfileBUT;
    private String[] pNames = new String[m.getPlayers()];
    private JComboBox<String> playerViewList;

    public GameDisplay() {
    	super("Monopoly");
    	setResizable(false);
    	getContentPane().setBackground(new Color(143, 188, 114));
    	logo = new JLabel();
    	logo.setBounds(unitSquare*13, unitSquare*19, unitSquare*24, unitSquare*8);
    	loadImages();
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(CANV_WIDTH, CANV_HEIGHT));
        //Gets scrolls
        canvas.addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
            }
        });
        //Gets X and Y position of mouse
        canvas.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent me) {
            }

            //Shows the property image of the square you are hovering over
            public void mouseMoved(MouseEvent me) {
                mouseX = (int) me.getPoint().getX();
                mouseY = (int) me.getPoint().getY();
                canvas.drawCard(squareSearcher(mouseX, mouseY));
            }

        });
        Container cp = getContentPane();
        cp.add(canvas);
        nameGetter();
        buttonInitializer();
        componentAdder();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }
    private void nameGetter() {
    	for(int i = 0; i < m.getPlayers(); i++) {
    		pNames[i] = m.getPlayerList().get(i).getObject();
    	}
    }
    private void componentAdder() {
    	canvas.add(dL1);
        canvas.add(dL2);
        canvas.add(nextTurnBUT);
        canvas.add(diceRollBUT);
        canvas.add(sellPropertyBUT);
        canvas.add(buyPropertyBUT);
        canvas.add(viewProfileBUT);
        canvas.add(playerViewList);
        canvas.add(logo);
    }
    private void buttonInitializer() {
    	diceRollBUT = new Button("Roll");
        nextTurnBUT = new Button("Next Turn");
        buyPropertyBUT = new Button("Buy Property");
        sellPropertyBUT = new Button("Sell Property");
        viewProfileBUT = new Button("View Profile");
        viewProfileBUT.setBackground(lg);
        viewProfileBUT.setBounds(unitSquare*79, unitSquare*26, unitSquare*6, unitSquare*3);
        viewProfileBUT.setBackground(lg);
        sellPropertyBUT.setBackground(lg);
        sellPropertyBUT.setBounds(unitSquare*79, unitSquare*22, unitSquare*6, unitSquare*3);
        buyPropertyBUT.setBackground(lg);
        buyPropertyBUT.setBounds(unitSquare*72, unitSquare*22, unitSquare*6, unitSquare*3);
        nextTurnBUT.setBounds(unitSquare*79, unitSquare*18, unitSquare*6, unitSquare*3);
        nextTurnBUT.setBackground(new Color(191, 219, 174));
        diceRollBUT.setBounds(unitSquare*72, unitSquare*18, unitSquare*6, unitSquare*3);
        diceRollBUT.setBackground(new Color(191, 219, 174));
        JPanel p = new JPanel();
        p.setBounds(unitSquare*15, unitSquare*25, 125, 50);
        canvas.setLayout(null);
        dL1 = new JLabel();
        dL2 = new JLabel();
       actionListenerInitializer();
       playerViewList = new JComboBox(pNames);
       playerViewList.setBackground(new Color(255,255,255));
       playerViewList.setBounds(unitSquare*72, unitSquare*26, unitSquare*6, unitSquare*3);
        
    }
    private void actionListenerInitializer() {
    	buyPropertyBUT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				m.buySquare(m.getPlayer(), m.getSquare(m.getPlayer().getSquare()));	
				buyPropertyBUT.setEnabled(false);
			}        	
        });
        sellPropertyBUT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				new SellPropertyDisplay(m.getPlayer());
			}
        });
    	nextTurnBUT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				m.nextTurn();
				diceRollBUT.setEnabled(true);
				nextTurnBUT.setEnabled(false);
				buyPropertyBUT.setEnabled(true);
			}
        	
        });
    	diceRollBUT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					int d1 = m.rollDie(1), d2 = m.rollDie(2);
					dL1.setIcon(dieSides[d1-1]);
					dL2.setIcon(dieSides[d2-1]);
					dL1.setBounds(unitSquare*23, unitSquare*15, 50, 50);
					dL2.setBounds(unitSquare*23+50, unitSquare*15, 50, 50);	
					m.calculateSquare(d1+ d2);
					diceRollBUT.setEnabled(false);
					nextTurnBUT.setEnabled(true);
					if(!m.getSquare(m.getPlayer().getSquare()).getBuyable()) {
						buyPropertyBUT.setEnabled(false);
					}
			}
        	
        });
    	viewProfileBUT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) playerViewList.getSelectedItem();
				PlayerProfileDisplay d = new PlayerProfileDisplay(s);
				d.setVisible(true);
				d.setResizable(false);
			}       	
        });
    }
    public static Monopoly getGame() {
    	return m;
    }
    
    private void loadImages() {
    	for(int i = 0; i < 6; i++) {
    		try {
    			Image image = ImageIO.read(new File("images/dieSides/" + i + ".gif"));
    			Image image1 = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                dieSides[i] = new ImageIcon(image1);
    		}catch(Exception e) {
    			
    		}
    	}
    	try {
			Image image = ImageIO.read(new File("images/misc/logo.png"));
			Image image1 = image.getScaledInstance(unitSquare*24, unitSquare*8, java.awt.Image.SCALE_SMOOTH);
            ImageIcon t = new ImageIcon(image1);
            logo.setIcon(t);
    	}catch(Exception e) {
			
		}
    }

    private int squareSearcher(int mouseX, int mouseY) {
        int squareNumber = 0;
        //From Square 0-10
        if (mouseX >= 0 && mouseX < 7 * unitSquare && mouseY <= 50 * unitSquare) {
            if (mouseY > unitSquare * 43 && mouseY < unitSquare * 50)return squareNumber;
            for (int i = 10; i >= 0; i--) {
                if (mouseY < unitSquare * 4 * i + unitSquare + unitSquare * 7 && mouseY > unitSquare * 4 * (i - 1) + unitSquare * 7) return squareNumber;
                squareNumber++;
            }
            if (mouseY > 0 && mouseY < unitSquare * 7)return squareNumber;

            //From Square 11-19    
        } else if (mouseX >= 7 * unitSquare && mouseX <= unitSquare * 43 && mouseY <= 7 * unitSquare) {
            squareNumber = 11;
            for (int i = 0; i < 9; i++) {
            	 if (mouseX > 7 * unitSquare + unitSquare * 4 * i && mouseX < 7 * unitSquare + unitSquare * 4 * (i + 1)) return squareNumber;
            	 squareNumber++;
            }
            //From Square 20-30
        } else if (mouseX > 43 * unitSquare && mouseX <= 50 * unitSquare && mouseY <= 50 * unitSquare) {
            squareNumber = 20;
            if (mouseY > 0 && mouseY < 7 * unitSquare) return squareNumber;
            squareNumber++;
            for (int i = 0; i < 9; i++) {
                if (mouseY > i * 4 * unitSquare + 7 * unitSquare && mouseY < unitSquare * (i + 1) * 4 + 7 * unitSquare) return squareNumber;
                squareNumber++;
            }
            if (mouseY > 43 * unitSquare && mouseY < 50 * unitSquare)return squareNumber;
            //From Square 31-39
        } else if (mouseX >= 7 * unitSquare && mouseX <= unitSquare * 43 && mouseY >= 43 * unitSquare && mouseY < 50 * unitSquare) {
            squareNumber = 31;
            for (int i = 9; i > 0; i--) {
                if (mouseX < 7 * unitSquare + i * 4 * unitSquare && mouseX > 7 * unitSquare + (i - 1) * 4 * unitSquare) return squareNumber;
                squareNumber++;
            }
        }
        return -1;
    }

    private class Canvas extends JPanel {

        public Graphics2D g;
        private boolean drawCard = false;
        private int loca;

        protected void paintComponent(Graphics g2) {
            super.paintComponent(g2);
            g = (Graphics2D) g2;
            drawBoardOutline(g);
            if (drawCard) {
                drawCard(g);
            }
            g.setColor(Color.BLACK);
            g.drawRect(57 * unitSquare, unitSquare * 18, 12 * unitSquare, 16 * unitSquare);
            g.drawRect(57 * unitSquare, unitSquare * 18, 12 * unitSquare, 4 * unitSquare);
            setBackground(new Color(143, 188, 114));
            drawPieces();
            repaint();
        }
        
        public void drawPieces() {
        	HashMap <Integer, Integer> map = new HashMap<Integer, Integer>(m.getPlayerSquares());
        	if(dieRolled) {
        		for(int i = 0; i < m.getPlayers(); i++) {
        			remove(playerPieces.get(i));
        		}
        		playerPieces.clear();
        	}
        	for(Player p : m.getPlayerList()) {
        		int xMultiplier = 0, yMultiplier = 0, ocXM, ocYM, pSpot = map.get(p.getSquare());
        		yMultiplier = (int) Math.floor(pSpot/3.1);
        		xMultiplier = pSpot%3;
        		if(pSpot%3 == 0) xMultiplier = 3;
        		ocYM = Math.abs(pSpot%2-1);
        		ocXM = (int) Math.floor(pSpot/2.1);
        		JLabel t = new JLabel();
            	t.setIcon(p.getIcon());
            	if(pSpot == 1) {
            		t.setBounds((int) startPoint.get(p.getSquare()).getX(), (int) startPoint.get(p.getSquare()).getY(), unitSquare*2,unitSquare*2);
            	}else if(p.getSquare() == 0 || p.getSquare() == 10 || p.getSquare() == 20 || p.getSquare() == 30){
            		t.setBounds((int) startPoint.get(p.getSquare()).getX() + (unitSquare*2*(xMultiplier-1)), (int) startPoint.get(p.getSquare()).getY()+(unitSquare*2*yMultiplier), unitSquare*2,unitSquare*2);
            	}else if((p.getSquare() > 0 && p.getSquare() < 10) || (p.getSquare() > 20 && p.getSquare() < 30)){
            		t.setBounds((int) startPoint.get(p.getSquare()).getX()+(unitSquare*2*ocXM), (int) startPoint.get(p.getSquare()).getY() + (unitSquare*2*ocYM), unitSquare*2,unitSquare*2);
            	}else {
            		t.setBounds((int) startPoint.get(p.getSquare()).getX()+(unitSquare*2*ocYM), (int) startPoint.get(p.getSquare()).getY() + (unitSquare*2*ocXM), unitSquare*2,unitSquare*2);
            	}
            	map.put(p.getSquare(), map.get(p.getSquare()) - 1);
            	playerPieces.add(t);
            	add(t);
            	dieRolled = true;
        	} 
        }
        
        public void drawCard(int loc) {
            if (loc >= 0) {
                loca = loc;
                drawCard = true;
            }
        }
        
        public void drawCard(Graphics2D g) {
            if (m.getBoard().getSquare(loca).toString().equals("Property")) { 
            	int[] nums = {(int)(unitSquare / 0.57),(int)(unitSquare / 0.61),(int)(unitSquare / 0.75), (int )(unitSquare / 0.72), (int)(unitSquare / 0.75), (int)(unitSquare / 0.78), (int) (unitSquare / 0.82), (int) (unitSquare / 1.6), (int) (unitSquare / 1.54)};
                g.setColor(Color.BLACK);
                g.drawRect(57 * unitSquare, unitSquare * 18, 12 * unitSquare, 16 * unitSquare);
                g.setColor(m.getBoard().getSquare(loca).getColor());
                g.fillRect(57 * unitSquare, unitSquare * 18, 12 * unitSquare, 4 * unitSquare);
                g.setFont(new Font("Serif", Font.BOLD, 24));
                g.setColor(Color.BLACK);
                String name = m.getBoard().getSquare(loca).getDeed();
                int left = name.length() / 2;
                int adjuster = nums[8];
                g.drawString(name, 63 * unitSquare - left * adjuster, 20 * unitSquare);
                name = "Rent $" + m.getBoard().getProperty(loca).getRent();
                left = name.length() / 2;
                adjuster = nums[7];
                g.drawString(name, 63 * unitSquare - left * adjuster, 23 * unitSquare);
                g.setFont(new Font("Serif", Font.PLAIN, 22));
                adjuster = nums[6];
                if (loca < 10) adjuster = nums[2];
                g.drawString("With 1 House: $" + m.getBoard().getProperty(loca).getRent(1), 63 * unitSquare - left * adjuster, 25 * unitSquare);
                adjuster = nums[5];
                if (loca < 10) adjuster = nums[1];
                g.drawString("With 2 Houses: $" + m.getBoard().getProperty(loca).getRent(2), 63 * unitSquare - left * adjuster, 26 * unitSquare);
                g.drawString("With 3 Houses: $" + m.getBoard().getProperty(loca).getRent(3), 63 * unitSquare - left * adjuster, 27 * unitSquare);
                g.drawString("With 4 Houses: $" + m.getBoard().getProperty(loca).getRent(3), 63 * unitSquare - left * adjuster, 28 * unitSquare);
                adjuster = nums[6];
                if (loca < 10) adjuster = nums[2];
                g.drawString("With HOTEL: $" + m.getBoard().getProperty(loca).getRent(5), 63 * unitSquare - left * adjuster, 29 * unitSquare);
                g.setFont(new Font("Serif", Font.BOLD, 22));
                adjuster = nums[4];
                if (loca < 10) adjuster = nums[1];  
                g.drawString("Mortage Value: $" + m.getBoard().getProperty(loca).getMortgage(), 63 * unitSquare - left * adjuster, 31 * unitSquare);
                g.setFont(new Font("Serif", Font.PLAIN, 22));
                adjuster = nums[3];
                if (loca < 10) adjuster= nums[0];
                g.drawString("House Cost: $" + m.getBoard().getProperty(loca).getHouseCost() + " Each", 63 * unitSquare - left * adjuster, 32 * unitSquare);
                g.drawString("Hotel Cost: $" + m.getBoard().getProperty(loca).getHouseCost() + " Each", 63 * unitSquare - left * adjuster, 33 * unitSquare);
            }
        }

        private void drawBoardOutline(Graphics2D g) {
            //Squares on Corners
            g.setColor(green);
            g.fillRect(0, 0, unitSquare * 7, unitSquare * 7);
            g.fillRect(43 * unitSquare, 0, unitSquare * 7, unitSquare * 7);
            g.fillRect(0, 43 * unitSquare, unitSquare * 7, unitSquare * 7);
            g.fillRect(43 * unitSquare, 43 * unitSquare, unitSquare * 7, unitSquare * 7);
            g.setColor(Color.BLACK);
            g.drawRect(0, 0, unitSquare * 7, unitSquare * 7);
            g.drawRect(43 * unitSquare, 0, unitSquare * 7, unitSquare * 7);
            g.drawRect(0, 43 * unitSquare, unitSquare * 7, unitSquare * 7);
            g.drawRect(43 * unitSquare, 43 * unitSquare, unitSquare * 7, unitSquare * 7);
            int ii = 1;
            startPoint.add(new Point(0, 43*unitSquare));
            //BottomLeft to TopLeft
            for (int i = 8; i >= 0; i--) {
                g.setColor(green);
                g.fillRect(0, unitSquare * 7 + i * unitSquare * 4, unitSquare * 7, unitSquare * 4);
                g.setColor(Color.BLACK);
                g.drawRect(0, unitSquare * 7 + i * unitSquare * 4, unitSquare * 7, unitSquare * 4);
                if (m.getBoard().getSquare(ii).toString().equals("Property")) {
                    g.setColor(m.getBoard().getSquare(ii).getColor());
                    g.fillRect(5 * unitSquare, unitSquare * 7 + i * unitSquare * 4, unitSquare * 2, unitSquare * 4);
                    g.setColor(Color.BLACK);
                    g.drawRect(5 * unitSquare, unitSquare * 7 + i * unitSquare * 4, unitSquare * 2, unitSquare * 4);
                }
                startPoint.add(new Point(0, unitSquare * 7 + i * unitSquare * 4));
                ii++;
            }
            startPoint.add(new Point(0,0));
            ii++;
            //TopLeft to TopRight
            for (int i = 0; i < 9; i++) {
                g.setColor(green);
                g.fillRect(unitSquare * 7 + i * unitSquare * 4, 0, unitSquare * 4, unitSquare * 7);
                g.setColor(Color.BLACK);
                g.drawRect(unitSquare * 7 + i * unitSquare * 4, 0, unitSquare * 4, unitSquare * 7);
                if (m.getBoard().getSquare(ii).toString().equals("Property")) {
                    g.setColor(m.getBoard().getSquare(ii).getColor());
                    g.fillRect(unitSquare * 7 + i * unitSquare * 4, 5 * unitSquare, unitSquare * 4, unitSquare * 2);
                    g.setColor(Color.BLACK);
                    g.drawRect(unitSquare * 7 + i * unitSquare * 4, 5 * unitSquare, unitSquare * 4, unitSquare * 2);
                }
                startPoint.add(new Point(unitSquare * 7 + i * unitSquare * 4 , 0));
                ii++;
            }
            ii++;
            startPoint.add(new Point(43*unitSquare, 0));
            //TopRight to BottomRight
            for (int i = 0; i < 9; i++) {
                g.setColor(green);
                g.fillRect(unitSquare * 43, unitSquare * 7 + i * unitSquare * 4, unitSquare * 7, unitSquare * 4);
                g.setColor(Color.BLACK);
                g.drawRect(unitSquare * 43, unitSquare * 7 + i * unitSquare * 4, unitSquare * 7, unitSquare * 4);
                if (m.getBoard().getSquare(ii).toString().equals("Property")) {
                    g.setColor(m.getBoard().getSquare(ii).getColor());
                    g.fillRect((int) 43 * unitSquare, unitSquare * 7 + i * unitSquare * 4, unitSquare * 2, unitSquare * 4);
                    g.setColor(Color.BLACK);
                    g.drawRect((int) 43 * unitSquare, unitSquare * 7 + i * unitSquare * 4, unitSquare * 2, unitSquare * 4);
                }
                startPoint.add(new Point(43 * unitSquare, unitSquare * 7 + i * unitSquare * 4));
                ii++;
            }
            ii++;
            startPoint.add(new Point(43 * unitSquare, 43 * unitSquare));
            //BottomRight to BottomLeft
            for (int i = 8; i >= 0; i--) {
                g.setColor(green);
                g.fillRect(unitSquare * 7 + i * unitSquare * 4, unitSquare * 43, unitSquare * 4, unitSquare * 7);
                g.setColor(Color.BLACK);
                g.drawRect(unitSquare * 7 + i * unitSquare * 4, unitSquare * 43, unitSquare * 4, unitSquare * 7);
                if (m.getBoard().getSquare(ii).toString().equals("Property")) {
                    g.setColor(m.getBoard().getSquare(ii).getColor());
                    g.fillRect(unitSquare * 7 + i * unitSquare * 4, 43 * unitSquare, unitSquare * 4, unitSquare * 2);
                    g.setColor(Color.BLACK);
                    g.drawRect(unitSquare * 7 + i * unitSquare * 4, 43 * unitSquare, unitSquare * 4, unitSquare * 2);
                }
                startPoint.add(new Point(unitSquare * 7 + i * unitSquare * 4, 43 * unitSquare));
                ii++;
            }
        }
        
    }

}
