package squareTypes;

import board.BuyableSquare;

public class Railroad extends BuyableSquare{

    public Railroad(int l, boolean b, String d, int p){
        super(l, b,d,p);
    }
    public String toString(){
        return "Railroad";
    }
}
