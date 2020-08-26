package board;
import squareTypes.Chance;
import squareTypes.CommunityChest;
import squareTypes.GoTo;
import squareTypes.Jail;
import squareTypes.Property;
import squareTypes.Railroad;
import squareTypes.Tax;
import squareTypes.Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import game.Dice;
import game.Player;

public class Board {

    private ArrayList<Square> board;

    public Board() {
        board = new ArrayList();
        loadBoard();
        Collections.sort(board);  
    }
    public ArrayList<Square> getBoard(){
    	return board;
    }

    public Square getSquare(int location){
        return board.get(location);
    }
    public Property getProperty(int loc){
        for(Square s : board) {
        	if(s.getLocation() == loc) return (Property) s;
        }
        return null;
    }
    public Utility getUtility(int loc){
    	for(Square s : board) {
        	if(s.getLocation() == loc) return (Utility) s;
        }
        return null;
    }
    public Railroad getRailroad(int loc){
    	for(Square s : board) {
        	if(s.getLocation() == loc) return (Railroad) s;
        }
        return null;
    }
    private void loadBoard(){
        loadProperties();
        loadUtilities();
        loadRailroads();
        loadChanceAndCommunityChest();
        loadOtherSquares();
    } 
    private void loadOtherSquares(){
        board.add(new Tax(4,false,"Income Tax", 200));
        board.add(new Tax(38, false, "LuxuryTax", 100));
        board.add(new Jail(10,false));
        board.add(new FixedSquare(20,false));
        board.add(new GoTo(30,false,10,"GTJ", 0));
        board.add(new GoTo(0,false,0,"Go",200));
    }
    private void loadChanceAndCommunityChest(){
        Chance c = new Chance(7,false);
        Chance c1 = new Chance(22,false);
        Chance c2 = new Chance(36,false);
        CommunityChest cc = new CommunityChest(2,false);
        CommunityChest cc1 = new CommunityChest(17,false);
        CommunityChest cc2 = new CommunityChest(33,false);
        board.add(c);
        board.add(c1);
        board.add(c2);
        board.add(cc);
        board.add(cc1);
        board.add(cc2);
    }
    private void loadProperties() {
        try {
            BufferedReader input = new BufferedReader(new FileReader("textDocuments/properties.txt"));
            String line;
            line = input.readLine();
            int i = 0;
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                String deed = st.nextToken();
                boolean buyable = Boolean.parseBoolean(st.nextToken());
                int location = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                int rent = Integer.parseInt(st.nextToken());
                String color = st.nextToken();
                int oneHouseRent = Integer.parseInt(st.nextToken());
                int twoHouseRent = Integer.parseInt(st.nextToken());
                int threeHouseRent = Integer.parseInt(st.nextToken());
                int fourHouseRent = Integer.parseInt(st.nextToken());
                int hotelRent = Integer.parseInt(st.nextToken());
                int mortgage = Integer.parseInt(st.nextToken());
                int houseCost = Integer.parseInt(st.nextToken());
                int hotelCost = Integer.parseInt(st.nextToken());
                int r= Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                board.add(new Property(location, buyable, cost, deed, mortgage, rent, oneHouseRent, twoHouseRent, threeHouseRent, fourHouseRent, hotelRent, color, hotelCost, houseCost,r,g,b));
                i++;
                line = input.readLine();
            }
            input.close();
        } catch (IOException io) {

        }
    }
    private void loadUtilities() {
        try {
            BufferedReader input = new BufferedReader(new FileReader("textDocuments/utilities.txt"));
            String line;
            line = input.readLine();
            int i = 0;
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                String deed = st.nextToken();
                boolean buyable = Boolean.parseBoolean(st.nextToken());
                int location = Integer.parseInt(st.nextToken());
                int price = Integer.parseInt(st.nextToken());
                board.add(new Utility(location, buyable, deed, price));
                i++;
                line = input.readLine();
            }
            input.close();
        } catch (IOException io) {

        }
    }
    private void loadRailroads(){
        try {
            BufferedReader input = new BufferedReader(new FileReader("textDocuments/railroads.txt"));
            String line;
            line = input.readLine();
            int i = 0;
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                String deed = st.nextToken();
                int location = Integer.parseInt(st.nextToken());
                boolean buyable = Boolean.parseBoolean(st.nextToken());
                int price = Integer.parseInt(st.nextToken());
                board.add(new Railroad(location, buyable, deed, price));
                i++;
                line = input.readLine();
            }
            input.close();
        } catch (IOException io) {

        }
    }
}

