package squareTypes;

import board.BuyableSquare;

public class Railroad extends BuyableSquare{
    private String owner;
    public Railroad(int l, boolean b, String d, int p){
        super(l, b,d,p);
        owner = "";
    }
    public void setOwner(String own){
        owner = own;
    }
    public String getOwner(){
        return owner;
    }
    public String toString(){
        return "Railroad";
    }
}
