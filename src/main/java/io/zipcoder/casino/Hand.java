package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Hand {
    private ArrayList<Card> playerHand = new ArrayList<Card>();

    public Hand() {}

    //public void add() {}

    public void add(Card card){
        playerHand.add(card);
    }

    public ArrayList<Card> getHand(){
        return playerHand;
    }

    public int numberOfDuplicates(){


        int countDuplicates = 0;
        sortHand();
        for (int i=1; i<playerHand.size(); i++) {
            if(ifFirstCard(i))
                {countDuplicates++;}
            else if (twoInARow(i))
                {countDuplicates++;}
            else if (fourInARow(i))
                {countDuplicates++;}
        }
            return countDuplicates;
        }

        public boolean ifFirstCard(int i){
            if (i == 1 && playerHand.get(i - 1).getRank() == playerHand.get(i).getRank()) {

                return true;
            }
            return false;
        }

        public boolean twoInARow(int i){
        if (playerHand.get(i - 1).getRank() == playerHand.get(i).getRank()
                    && playerHand.get(i - 2).getRank() != playerHand.get(i).getRank()) {
        return true;}
        return false;
        }

        public boolean fourInARow(int i){
        if (i>3 && playerHand.get(i - 1).getRank() == playerHand.get(i).getRank()
                && playerHand.get(i - 2).getRank() == playerHand.get(i).getRank()
                && playerHand.get(i - 3).getRank() == playerHand.get(i).getRank()){
            return true;
        }
    return false;}

    public int size(){return playerHand.size();}

    public boolean contains(Card card){ return playerHand.contains(card);}

    public void sortHand(){
        Collections.sort(playerHand);
    }


    //removes pairs of duplicates
    public void removeDuplicates(){
        sortHand();
        for (int i=playerHand.size()-3; i>=0; i--) {
            if (playerHand.get(i + 1).getRank() == playerHand.get(i).getRank()) {
                playerHand.remove(i+1);
                playerHand.remove(i);
            }
        }
    }

    //returns number of occurrences of input
    public int getNumberOfRankOccurrences(Card card) {
        int count =0;
        for(int i = 0; i<playerHand.size(); i++){
            if(playerHand.get(i).getRank() == card.getRank())
            {count++;}
        }
        return count;
    }

    //Creates a string with rank and suit
    public String toString() {
        String  result = "";
        for (Card card : playerHand){
            result += card.getRank().toString() + card.getSuit().toString() + " ";
        }
        return result;
    }

    public int getTotal(){
        int result = 0;
        for(Card card : playerHand){
            result += card.getRank().getBlackJackValue();
        }
        return result;
    }
}