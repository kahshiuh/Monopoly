package main;


import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import board.BuyableSquare;
import board.Square;
import squareTypes.Property;
import squareTypes.Railroad;
import squareTypes.Utility;

public class Player {
    private ArrayList <Square> ownedProperties;
    private int bankAccount;
    private int houses;
    private int hotels;
    private int rollOrder; 
    private int currentSquare;
    private int railroadsOwned;
    private boolean inJail;
    private boolean getOutOfJail;
    private String object;
    private ImageIcon piece;
    
    public Player(int r, String o){
        ownedProperties = new ArrayList<Square>();
        rollOrder = r;
        object = o;
        bankAccount = 0;
        inJail = false;
        railroadsOwned = houses = hotels = 0;
    }
    public String getObject() {
    	return object;
    }
    public void buy(Square b, int price) {
    	ownedProperties.add(b);
    	bankAccount -= price;
    }
    public void sell(Square b, int price) {
    	for(Square s : ownedProperties) {
    		if(s.equals(b)) ownedProperties.remove(s);
    		bankAccount += price;
    	}
    }
    /*
     * Need to figure out the properties where there is only two of that color
     */
    public boolean checkColor(Color pGroup) {
    	int count = 0;
    	for(Square s : ownedProperties) {
    		if(s.toString().equals("Property") && s.getColor().equals(pGroup)) {
    			count++;
    		}
    	}
    	return !pGroup.equals(new Color(108,69,46)) && !pGroup.equals(new Color(0,70,146)) && count == 3 ? true : count == 2;
    }
    public int getBalance(){
        return bankAccount;
    }
    public void addHouses(int h){
        houses+=h;
    }
    public void addHotels(int h){
        hotels+=h;
    }
    public int getHotels(){
        return hotels;
    }
    public int getHouses(){
        return houses;
    }
    public void changeBalance(int c){
        bankAccount = bankAccount + c;
    }
    public int getRollOrder(){
        return rollOrder;
    }
    public int getSquare(){
        return currentSquare;
    }
    public int getRailroads(){
        return railroadsOwned;
    }
    public void changeRailroadCount(int r){
        railroadsOwned += r;
    }
    public void setJail(boolean j){
        inJail = j;
    }
    public boolean getJailed(){
        return inJail;
    }
    public void setLocation(int l){
        currentSquare = l;
    }
    public void setGetOutOfJail(boolean b){
        getOutOfJail = b;
    }
    public boolean getFreeOutOfJail(){
        return getOutOfJail;
    }
    public void setImageIcon(ImageIcon p){
        piece = p;
    }
    public ImageIcon getPiece(){
        return piece;
    }
    
}
