package board;

//For Squares that can be bought
public class BuyableSquare extends Square{
  //All of these squares have a price, and name
  private int price;
  private String deed;
  public BuyableSquare(int l, boolean b, String d, int p) {
      super(l, b);
      deed = d;
      price = p;
  }
  //Basic accessors
  public int getPrice(){
      return price;
  }
  public String getDeed(){
      return deed;
  }

}
