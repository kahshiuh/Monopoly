package squareTypes;

import board.BuyableSquare;

public class Utility extends BuyableSquare {
    
    //Utility has an owner
    public Utility(int l, boolean b, String d, int p) {
        super(l,b,d,p);
    }
    //One mutator and accessor
    //There shouldn't be much to add
    public String toString(){
        return "Utility";
    }

}