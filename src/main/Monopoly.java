package main;

import java.util.ArrayList;

import board.Board;

public class Monopoly {

    private ArrayList<Player> playerList;
    private Board board;
    public int dice1, dice2;
    private Dice d1;
    private Dice d2;
    private int turn;

    public Monopoly() {
        board = new Board();
        playerList = new ArrayList();
        d1 = new Dice();
        d2 = new Dice();
        dice1 = dice2 = 1;
        turn = 0;
    }
    public Board getBoard(){
        return board;
    }

    public void addPlayer(int num, String obj) {
        playerList.add(new Player(num, obj));
    }

    public int rollDice() {
        dice1 = d1.roll();
        dice2 = d2.roll();
        int i = dice1 + dice2;
        int newSquare = playerList.get(turn).addSquare(i);
        if(newSquare > 40){
            newSquare -= 40;
        }
        return i;
    }
    public void nextTurn(){
        if (turn + 1 >= playerList.size()) {
            turn = 0;
        } else {
            turn++;
        }

    }

    public String buyProperty() {
        int location = playerList.get(turn).getSquare();
        if (board.getSquare(location).getBuyable()) {
            playerList.get(turn).addProperty(board.getProperty(playerList.get(turn).getSquare()));
            playerList.get(turn).changeBalance(-board.getProperty(playerList.get(turn).getSquare()).getPrice());
            board.getProperty(turn).setOwner(turn);
            return "Property Bought";
        }else{
            return "Property Cannot Be Bought";
        }
    }

    public void sellProperty() {
        
    }

}
