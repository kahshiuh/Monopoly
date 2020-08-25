package squareTypes;

import board.FixedSquare;

//Two Squares (Go and GoToJail)
//IDK why Go is classified here but i dont have anywhere else for it
public class GoTo extends FixedSquare{
  //Location is where you are going, deed is name and money Gained is how much money you making
  private int location;
  private String deed;
  private int moneyGained;
  public GoTo(int l, boolean b, int loc, String d, int m) {
      super(l, b);
      location = loc;
      deed = d;
      moneyGained = m;
  }
  //Basic Accessors + toString for comparisons
  public int getNewLocation(){
      return location;
  }
  public String getDeed(){
      return deed;
  }
  public int getMoneyGained(){
      return moneyGained;
  }
  public String toString(){
      if(moneyGained == 0){
          return "Go To Jail";
      }else{
          return "Go";
      }
  }
}
 