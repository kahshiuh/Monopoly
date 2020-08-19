package squareTypes;

import board.BuyableSquare;

public class Utility extends BuyableSquare {
    
    //Utility has an owner
    private String owner;
    public Utility(int l, boolean b, String d, int p) {
        super(l,b,d,p);
        owner = "";
    }
    //One mutator and accessor
    //There shouldn't be much to add
    public void setOwner(String own) {
        owner = own;
    }
    public String getOwner() {
        return owner;
    }
    public String toString(){
        return "Utility";
    }

}