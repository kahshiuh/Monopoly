package squareTypes;


import java.util.ArrayList;

import board.FixedSquare;
import main.Player;

public class Jail extends FixedSquare{
    private ArrayList <Player> jailedPlayers = new ArrayList();
    public Jail(int l, boolean b){
        super(l, b);
    }
    public void addPlayer(Player p){
        jailedPlayers.add(p);
    }
    public void removePlayer(Player p){
        jailedPlayers.remove(p);
    }
    public String toString(){
        return "Jail";
    }
    public String rollWhileInJail(int die1, int die2, Player p){
        if(die1 == die2){
            p.setJail(false);
            for(int i = 0; i < jailedPlayers.size(); i++){
                if(jailedPlayers.get(i).getRollOrder() == p.getRollOrder())
                    jailedPlayers.remove(i);
            }
            return "Free From Jail";
        }
        return "Still In Jail";
    }
}
