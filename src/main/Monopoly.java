package main;

import java.util.ArrayList;


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

    public Monopoly() {
        board = new Board();
        playerList = new ArrayList();
        d1 = new Dice();
        d2 = new Dice();
        turn = 0;
    }
    public Board getBoard(){
        return board;
    }

    public void addPlayer(int num, String obj) {
        playerList.add(new Player(num, obj));
    }

    public int rollDie(int dieNum) {
    	return dieNum == 1 ? d1.roll() : d2.roll();
    }
    public void calculateSquare(int squaresMoved) {
    	if(playerList.get(turn).getSquare() + squaresMoved > 40) {
    		playerList.get(turn).setLocation(squaresMoved + playerList.get(turn).getSquare() - 40);
    	}else {
    		playerList.get(turn).setLocation(squaresMoved + playerList.get(turn).getSquare());
    	}
    }
    public void nextTurn(){
        if (turn + 1 >= playerList.size()) {
            turn = 0;
        } else {
            turn++;
        }
        checkedRent = false;
    }
    public void checkRent(Player p, int curLocation) {
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

    public boolean buySquare(Player buyer, BuyableSquare b) {
    	if(buyer.getBalance() > b.getPrice() && !b.getOwned()) {
    		b.setBuyable(false);
    		b.setOwner(buyer.getRollOrder());
    		buyer.buy(b, b.getPrice());
    		b.setOwner(buyer.getRollOrder());
    		return true;
    	}
    	return false;
    }
    public boolean sellSquare(Player seller, Square b, Player buyer, int price) {
    	if(buyer.getBalance() > price) {
    		seller.sell(b, price);
    		b.setBuyable(false);
    		//need to set  owner
        	buyer.buy(b, price);
        	return true;
    	}
    	return false;
    }

}
