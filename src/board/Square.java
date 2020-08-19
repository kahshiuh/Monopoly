package board;


import java.awt.Color;

public class Square implements Comparable{
    //Location of Square and Whether you can buy it
    private int location;
    private boolean buyable;
    private String deed;
    public Square(int l, boolean b){
        location = l;
        buyable = b;
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

    @Override
    public int compareTo(Object t) {
        Square other = (Square) t;
        return location - other.getLocation();
    }
    
    
}
