package squareTypes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import board.FixedSquare;
import cards.CommunityChestCard;
import game.Player;

public class CommunityChest extends FixedSquare{
    
    private static ArrayList <CommunityChestCard> deck;
    private ArrayList <String> deeds;
    public CommunityChest(int l, boolean b){
         super(l,b);
         deeds = new ArrayList();
         deck = new ArrayList();
         loadDeeds();
         loadDeck();
     }
    public String toString(){
        return "CommunityChest";
    }
    private void loadDeck(){
        deck.add(new CommunityChestCard(deeds.get(0), 20, false, false,-1,0,0,0));
        deck.add(new CommunityChestCard(deeds.get(1), 0, false, false,-1,0,40,115));
        deck.add(new CommunityChestCard(deeds.get(2), 100, false, false,-1,0,0,0));
        deck.add(new CommunityChestCard(deeds.get(3), 0, false, false,-1,10,0,0));
        
        deck.add(new CommunityChestCard(deeds.get(4), 100, false, false,-1,0,0,0));
        deck.add(new CommunityChestCard(deeds.get(5), 0, false, false,0,0,0,0));
        deck.add(new CommunityChestCard(deeds.get(6), 200, false, false,-1,0,0,0));
        deck.add(new CommunityChestCard(deeds.get(7), 0, false, true,-1,0,0,0));
        
        deck.add(new CommunityChestCard(deeds.get(8), -100, false, false,-1,0,0,0));
        deck.add(new CommunityChestCard(deeds.get(9), 25, false, false,-1,0,0,0));
        deck.add(new CommunityChestCard(deeds.get(10), 0, true, false,-1,0,0,0));
        deck.add(new CommunityChestCard(deeds.get(11), -50, false, false,-1,0,0,0));
        
        deck.add(new CommunityChestCard(deeds.get(12), -50, false, false,-1,0,0,0));
        deck.add(new CommunityChestCard(deeds.get(13), 50, false, false,-1,0,0,0));
        deck.add(new CommunityChestCard(deeds.get(14), 100, false, false,-1,0,0,0));
        deck.add(new CommunityChestCard(deeds.get(15), 10, false, false,-1,0,0,0));
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
    public void applyCard(Player p, CommunityChestCard c, ArrayList <Player> pList){
        p.changeBalance(c.moneyGained());
        p.setLocation(c.advanceToLocation());
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
    }

}
 
