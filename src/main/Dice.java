package main;

import java.util.Random;

//Dice class for rolling
public class Dice {
  private Random r;
  //Allows you to play with higher level die
  private int sideDie;
  public Dice(){
      r = new Random();
      sideDie = 6;
  }
  //Roll for random int 1 to sideDie
  public int roll(){
      return r.nextInt(sideDie)+1;
  }
  //Kind of useless accessor for now
  public int getSides(){
      return sideDie;
  }
  //SetSides for future use
  public void setSides(int sides){
      sideDie = sides;
  }
}
