package game;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

import board.Board;
import board.BuyableSquare;
import board.Square;
import squareTypes.Property;
import squareTypes.Railroad;

public class Monopoly {

    private ArrayList<Player> playerList;
    private boolean checkedRent;
    private Board board;
    private Dice d1;
    private Dice d2;
    private int turn;
    private HashMap<Integer, Integer> playerSquares;

    public Monopoly() {
        board = new Board();
        playerList = new ArrayList();
        d1 = new Dice();
        d2 = new Dice();
        playerSquares = new HashMap();
        mapSetUp();
        turn = 0;
    }
    public HashMap<Integer, Integer> getPlayerSquares(){
    	return playerSquares;
    }
    public void mapSetUp() {
    	for(int i = 0; i < 40; i++) {
    		playerSquares.put(i, 0);
    	}
    }
    public Board getBoard(){
        return board;
    }
    public int getPlayers() {
    	return playerList.size();
    }
    public Player getPlayer(String s) {
    	for(Player p : playerList) {
    		if(p.getObject().equals(s)) return p;
    	}
    	return null;
    }
    public Player getPlayer() {
    	return playerList.get(turn);
    }
    public ArrayList<Player> getPlayerList(){
    	return playerList;
    }
    public void deletePlayer(String obj) {
    	for(Player p : playerList) {
    		if(p.getObject().equals(obj)) {
    			playerList.remove(p);
    		}
    	}
    }
    public void addPlayer(int num, String obj, ImageIcon i, Image ii) {
        playerList.add(new Player(num, obj, i, ii));
        playerSquares.put(0, playerSquares.get(0) + 1);
    }

    public int rollDie(int dieNum) {
    	return dieNum == 1 ? d1.roll() : d2.roll();
    }
    public void calculateSquare(int squaresMoved) {
    	if(playerList.get(turn).getSquare() + squaresMoved > 40) {
    		playerSquares.put(playerList.get(turn).getSquare(), playerSquares.get(playerList.get(turn).getSquare()) - 1);
    		playerList.get(turn).setLocation(squaresMoved + playerList.get(turn).getSquare() - 40);
    		playerSquares.put(playerList.get(turn).getSquare(), playerSquares.get(playerList.get(turn).getSquare())+1);
    	}else {
    		playerSquares.put(playerList.get(turn).getSquare(), playerSquares.get(playerList.get(turn).getSquare()) - 1);
    		playerList.get(turn).setLocation(squaresMoved + playerList.get(turn).getSquare());
    		playerSquares.put(playerList.get(turn).getSquare(), playerSquares.get(playerList.get(turn).getSquare())+1);
    	}
    }
    public Square getSquare(int loc) {
    	return board.getSquare(loc);
    }
    public void nextTurn(){
        if (turn + 1 >= playerList.size()) {
            turn = 0;
        } else {
            turn++;
        }
        checkedRent = false;
    }
    public void checkRent() {
    	Player p = getPlayer();
    	int curLocation = p.getSquare();
    	if(checkedRent) return;
    	switch(board.getSquare(curLocation).toString()) {
    		case "Property":
    			Property t = (Property) board.getSquare(curLocation);
    			if(!t.getOwned()) return;
    			if(playerList.get(t.getOwner()).checkColor(t.getColor())) {
    				p.changeBalance(-2*t.getRent());
    			}else {
    				p.changeBalance(-t.getRent());
    			}
    			break;
    		case "Railroad":	
    			Railroad t1 = (Railroad) board.getSquare(curLocation);
    			
    			break;
    		case "Utility":
    			break;
    	}
    	
    }
    public boolean buyHotel(Player buyer, Property b) {
    	if(b.getOwner() != buyer.getRollOrder() || buyer.getBalance() < b.getHotelCost() && b.enoughForHotel()) {
    		buyer.changeBalance(-b.getHotelCost());
    		b.addHotel();
    		return true;
    	}
    	return false;
    }
    public boolean buyHouse() {
    	return false;
    }
    public boolean buySquare(Player buyer, Square bb) {
    	BuyableSquare b = (BuyableSquare) bb;
    	if(buyer.getBalance() > b.getPrice() && b.getBuyable()) {
    		b.setBuyable(false);
    		b.setOwner(buyer.getRollOrder());
    		buyer.buy(b, b.getPrice());
    		b.setOwner(buyer.getRollOrder());
    		return true;
    	}
    	return false;
    }
    public boolean sellSquare(Player seller, BuyableSquare b, Player buyer, int price) {
    	if(buyer.getBalance() > price) {
    		seller.sell(b, price);
        	buyer.buy(b, price);
        	return true;
    	}
    	return false;
    }

}
