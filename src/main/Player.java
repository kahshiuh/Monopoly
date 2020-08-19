package main;


import java.util.ArrayList;
import javax.swing.ImageIcon;

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
    private ImageIcon piece;
    
    public Player(int r, String o){
        ownedProperties = new ArrayList();
        rollOrder = r;
        bankAccount = 0;
        inJail = false;
        railroadsOwned = houses = hotels = 0;
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
    public Square removeProperty(int location){
        int positionInArrayList = 0;
        for(int i = 0; i < ownedProperties.size(); i++){
            if(ownedProperties.get(i).getLocation() == location){
                positionInArrayList = i;
            }
        }
        return ownedProperties.remove(positionInArrayList);
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
    public int addSquare(int s){
        currentSquare += s;
        if(currentSquare > 40){
            currentSquare-=40;
        }
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
    public void addProperty(Property p){
        ownedProperties.add(p);
    }
    public void addRailroad(Railroad r){
        ownedProperties.add(r);
    }
    public void addUtilities(Utility u){
        ownedProperties.add(u);
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
