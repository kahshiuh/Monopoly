package main;

import java.util.Random;

//Dice class for rolling
public class Dice {
  private Random r;
  public Dice(){
      r = new Random();
  }
  //Roll for random int 1 to sideDie
  public int roll(){
      return r.nextInt(6)+1;
  }

}
