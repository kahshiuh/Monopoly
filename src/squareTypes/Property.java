package squareTypes;

import java.awt.Color;

import board.BuyableSquare;


public class Property extends BuyableSquare{
    
    private int owner;
    private boolean owned;
    private String color;
    private final int mortgage;
    private final int rent;
    private final int oneHouseRent;
    private final int twoHouseRent;
    private final int threeHouseRent;
    private final int fourHouseRent;
    private final int hotelRent;
    private final int hotelCost;
    private final int houseCost;
    private int houses;
    private Color propertyGroupColor;
    private boolean hotel;
    public Property(int l, boolean bo, int c, String n, int m, int re, int o, int t, int th, int f, int h, String co, int hC, int hCC, int r,int g,int b){
        super(l, bo,n,c);
        owner = -1;
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
        owned = false;
        propertyGroupColor = new Color(r,g,b);
    }
    public Color getColor(){
        return propertyGroupColor;
    }
    public int getOwner(){
        return owner;
    }
    public void setOwner(int own){
        owner = own;
        owned = true;
    }
    public void removeOwner(){
        owned = false;
        owner = -1;
    }
    public boolean getOwned(){
        return owned;
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
