package board;

//For Squares that can be bought
public class BuyableSquare extends Square{
  //All of these squares have a price, and name
  private int price;
  private String deed;
  private int owner;
  public BuyableSquare(int l, boolean b, String d, int p) {
      super(l, b);
      owner = -1;
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
  public int getOwner(){
      return owner;
  }
  public void setOwner(int own){
      owner = own;
  }
  public void removeOwner(){
      owner = -1;
  }
  public boolean getOwned(){
      return owner == -1;
  }

}
