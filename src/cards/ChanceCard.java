package cards;

//Same comments as communityChest
//Two new variables
//AdvanceToType & subtractSquares
//Subtract to move back 3 squares and aTT to move to nearest class of Squares(Util. or Railroad)
public class ChanceCard {
  private String cardInfo;
  private int moneyGained;
  private boolean goingToJail;
  private boolean getOutOfJail;
  private int advanceToLocation;
  private int collectFromEachPlayer;
  private int payPerHouse;
  private int payPerHotel;
  private int subtractSquares;
  private int advanceToType;
  //0 = No Type, 1 = Nearest Railroad, 2 = Nearest Utility
  public ChanceCard(String d, int mG, boolean gTJ, boolean gOOJ,int aTL, int cFEP, int pPHe, int pPHl, int sS, int aTT){
      cardInfo = d;
      moneyGained = mG;
      goingToJail = gTJ;
      getOutOfJail = gOOJ;
      advanceToLocation = aTL;
      collectFromEachPlayer = cFEP;
      payPerHouse = pPHe;
      payPerHotel = pPHl;
      subtractSquares = sS;
      advanceToType = aTT;
  }
  public String getCardInfo(){
      return cardInfo;
  }
  public int moneyGained(){
      return moneyGained;
  }
  public boolean goingToJail(){
      return goingToJail;
  }
  public int advanceToLocation(){
      return advanceToLocation;
  }
  public boolean getOutOfJail(){
      return getOutOfJail;
  }
  public int collectFromEachPlayer(){
      return  collectFromEachPlayer;
  }
  public int payPerHouse(){
      return payPerHouse;
  }
  public int payPerHotel(){
      return payPerHotel;
  }
  public int subtractSquares(){
      return subtractSquares;
  }
  public int advanceToType(){
      return advanceToType;
  }

}

