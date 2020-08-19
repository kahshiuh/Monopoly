package cards;

//Pretty Self-Explnatory
//Variables for each possible card outcome
//Should loop through each variable and see what the card does
//I can't think of a more efficient way to do this
public class CommunityChestCard {
  private String cardInfo;
  private int moneyGained;
  private boolean goingToJail;
  private boolean getOutOfJail;
  private int advanceToLocation;
  private int collectFromEachPlayer;
  private int payPerHouse;
  private int payPerHotel;
  //Everything is done in constructor
  //Maybe should be constant
  public CommunityChestCard(String d, int mG, boolean gTJ, boolean gOOJ,int aTL, int cFEP, int pPHe, int pPHl){
      cardInfo = d;
      moneyGained = mG;
      goingToJail = gTJ;
      getOutOfJail = gOOJ;
      advanceToLocation = aTL;
      collectFromEachPlayer = cFEP;
      payPerHouse = pPHe;
      payPerHotel = pPHl;
  }
  //Basic Accessors
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
}
