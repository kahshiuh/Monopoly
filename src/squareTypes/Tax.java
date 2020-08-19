package squareTypes;

import board.FixedSquare;

//Squares that deduct money from you(There are 2)
public class Tax extends FixedSquare{
  //Deed is name of square and price is how much you pay
  private String deed;
  private int price;
  public Tax(int l, boolean b, String d, int p) {
      super(l, b);
      deed = d;
      price = p;
  }
  //Accessors + toString for square comparisons
  public int getPrice(){
      return price;
  }
  public String getDeed(){
      return deed;
  }
  public String toString(){
      return "Tax";
  }

}