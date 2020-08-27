package game;


import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import board.BuyableSquare;
import board.Square;
import squareTypes.Property;
import squareTypes.Railroad;
import squareTypes.Utility;

public class Player {
    private ArrayList <BuyableSquare> ownedProperties;
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
    private Image rawImage;
    
    public Player(int r, String o, ImageIcon piece, Image i){
        ownedProperties = new ArrayList<BuyableSquare>();
        rollOrder = r;
        object = o;
        bankAccount = 1500;
        inJail = false;
        railroadsOwned = houses = hotels = 0;
        rawImage = i;
        this.piece = piece;
    }
    /*
     * 
     * Need to check for if the square is a property
     * 
     * 
     */
    public int totalHotelsOwned() {
    	int ans = 0;
    	for(int i = 0; i < getPropertyCount(); i++) {
    		if(ownedProperties.toString().equals("Property")) {
    			Property p = (Property) ownedProperties.get(i);
    			ans += p.getHotel() ? 1 : 0;
    		}
    	}
    	return ans;
    }
    public int totalHousesOwned() {
    	int ans = 0;
    	for(int i = 0; i < getPropertyCount(); i++) {
    		if(ownedProperties.toString().equals("Property")) {
    			Property p = (Property) ownedProperties.get(i);
    			ans += p.getHouses();
    		}
    	}
    	return ans;
    }
    public ArrayList<BuyableSquare> getOwnedProperties() {
    	return ownedProperties;
    }
    public int getPropertyCount() {
    	return ownedProperties.size();
    }
    public Image getRawImage() {
    	return rawImage;
    }
    public ImageIcon getIcon(){
    	return piece;
    }
    public String getObject() {
    	return object;
    }
    public void buy(BuyableSquare b, int price) {
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
