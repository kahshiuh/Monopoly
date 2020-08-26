package board;


import java.awt.Color;
import java.util.ArrayList;

import game.Player;

public class Square implements Comparable{
    //Location of Square and Whether you can buy it
	private ArrayList <Player> presentPlayers;
    private int location;
    private boolean buyable;
    private String deed;
    public Square(int l, boolean b){
        location = l;
        buyable = b;
    }
    public void addPlayer(Player p) {
    	presentPlayers.add(p);
    }
    public void removePlayer(Player p) {
    	presentPlayers.remove(p);
    }
    public ArrayList<Player> getPresentPlayers(){
    	return presentPlayers;
    }
    //Basic Accessors
    public int getLocation(){
        return location;
    }
    public boolean getBuyable(){
        return buyable;
    }
    public void setBuyable(boolean b){
        buyable = b;
    }
    public Color getColor(){
        return null;
    }
    public String toString(){
        return "Space";
    }
    public String getDeed(){
        return deed;
    }

    public int compareTo(Object t) {
        Square other = (Square) t;
        return location - other.getLocation();
    }
    
    
}
