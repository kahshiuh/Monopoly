package squareTypes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import board.FixedSquare;
import cards.ChanceCard;
import game.Player;


public class Chance extends FixedSquare{    
    private static ArrayList <ChanceCard> deck;
    private ArrayList <String> deeds;
    public Chance(int l, boolean b){
        super(l,b);
        deck = new ArrayList();
        deeds = new ArrayList();
        loadDeeds();
        loadDeck();
    }
    public String toString(){
        return "Chance";
    }
    private void loadDeck(){
        deck.add(new ChanceCard(deeds.get(0), 0, false, false,-1,0,0,0,0,0));//Reading Railroad
        deck.add(new ChanceCard(deeds.get(1), -15, false, false,-1,0,0,0,0,0));
        deck.add(new ChanceCard(deeds.get(2), 50, false, false,-1,0,0,0,0,0));
        deck.add(new ChanceCard(deeds.get(3), 0, false, false,-1,0,0,0,0,0));//Illinois
        
        deck.add(new ChanceCard(deeds.get(4), 150, false, false,-1,0,0,0,0,0));
        deck.add(new ChanceCard(deeds.get(5), 0, false, true,-1,0,0,0,0,0));
        deck.add(new ChanceCard(deeds.get(6), 0, false, false,-1,0,25,100,0,0));
        deck.add(new ChanceCard(deeds.get(7), 0, false, false,-1,0,0,0,0,1));
        
        deck.add(new ChanceCard(deeds.get(8), 0, false, false,-1,0,0,0,0,1));
        deck.add(new ChanceCard(deeds.get(9), 0, false, false,39,0,0,0,0,0));
        deck.add(new ChanceCard(deeds.get(10), 0, false, false,-1,0,0,0,0,0));//St Charles
        deck.add(new ChanceCard(deeds.get(11), 0, false, false,-1,-50,0,0,0,0));
        
        deck.add(new ChanceCard(deeds.get(12), 0, false, false,-1,0,0,0,0,2));
        deck.add(new ChanceCard(deeds.get(13), 0, false, false,-1,0,0,0,3,0));
        deck.add(new ChanceCard(deeds.get(14), 200, false, false,0,0,0,0,0,0));
        deck.add(new ChanceCard(deeds.get(15), 0, true, false,-1,0,0,0,0,0));
    }
    private void loadDeeds(){
        try{
           BufferedReader input = new BufferedReader(new FileReader("textDocuments/communityChestCards.txt"));
            String line;
            line = input.readLine();
            int i = 0;
             while (line != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                String d = st.nextToken();
                deeds.add(d);
                i++;
                line = input.readLine();
             }
             input.close();
        }catch(IOException IO){
            
        }
    }
    public void applyCard(Player p, ChanceCard c, ArrayList <Player> pList){
        p.changeBalance(c.moneyGained());
        if(c.advanceToLocation() != -1){
            p.setLocation(c.advanceToLocation());
        }
        p.setGetOutOfJail(c.getOutOfJail());
        p.setLocation(c.advanceToLocation());
        for(int i = 0; i < pList.size(); i++){
            if(pList.get(i).getRollOrder() != p.getRollOrder()){
                pList.get(i).changeBalance(-c.collectFromEachPlayer());
                p.changeBalance(c.collectFromEachPlayer());
            }
        }
        p.changeBalance(-p.getHouses()*c.payPerHouse());
        p.changeBalance(-p.getHotels()*c.payPerHotel());
        if(c.subtractSquares() != -1){
            p.setLocation(p.getSquare()-c.subtractSquares());
        }
        //1 is nearest railroad and 2 is nreaest utility
        switch(c.advanceToType()){
            case 0:
                break;
            case 1:
                int location = 5;
                if(Math.abs(p.getSquare()-location) > Math.abs(p.getSquare()-15)); location = 15;
                if(Math.abs(p.getSquare()-location) > Math.abs(p.getSquare()-25)); location = 25;
                if(Math.abs(p.getSquare()-location) > Math.abs(p.getSquare()-35)); location = 35;
                p.setLocation(location);
                break;
            case 2:
                int location1 = 12;
                if(Math.abs(p.getSquare() - location1) > Math.abs(p.getSquare() - 28)); location1 = 28;
                p.setLocation(location1);
                break;
        }
    }
    
    
}
