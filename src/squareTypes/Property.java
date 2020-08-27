package squareTypes;

import java.awt.Color;

import board.BuyableSquare;


public class Property extends BuyableSquare{
    
    private String color;
    private final int mortgage, rent;
    private final int oneHouseRent, twoHouseRent, threeHouseRent, fourHouseRent, hotelRent;
    private final int hotelCost, houseCost;
    private int houses;
    private Color propertyGroupColor;
    private boolean hotel;
    public Property(int l, boolean bo, int c, String n, int m, int re, int o, int t, int th, int f, int h, String co, int hC, int hCC, int r,int g,int b){
        super(l,bo,n,c);
        mortgage = m;
        rent = re;
        oneHouseRent = o;
        twoHouseRent = t;
        threeHouseRent = th;
        fourHouseRent = f;
        hotelRent = h;
        hotelCost = hC;
        houseCost = hCC;
        color = co;
        propertyGroupColor = new Color(r,g,b);
    }
    public boolean getHotel() {
    	return hotel;
    }
    public void addHouse() {
    	houses++;
    }
    public int getHouses() {
    	return houses;
    }
    public void addHotel() {
    	hotel = true;
    }
    
    public boolean validHouseSpace() {
    	return houses < 4;
    }
    public boolean enoughForHotel() {
    	return houses == 4;
    }
    public Color getColor(){
        return propertyGroupColor;
    }
    public int getRent(){
        switch(houses){
            case 0:
                return rent;
            case 1:
                return oneHouseRent;
            case 2:
                return twoHouseRent;
            case 3:
                return threeHouseRent;
            case 4:   
                if(hotel){
                    return hotelRent;
                }else{
                    return fourHouseRent;
                }
        }
        return 0;
    }
    public int getRent(int house){
        switch(house){
            case 0:
                return rent;
            case 1:
                return oneHouseRent;
            case 2:
                return twoHouseRent;
            case 3:
                return threeHouseRent;
            case 4:   
                return fourHouseRent;
            case 5:
                return hotelRent;
        }
        return 0;
    }
    public int getHotelCost(){
        return hotelCost;
    }
    public int getHouseCost(){
        return houseCost;
    }
    public int getMortgage(){
        return mortgage;
    }
    public String toString(){
        return "Property";
    }
}
