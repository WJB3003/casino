package io.zipcoder.casino;

public class CardGame implements Game {
    private Deck deck = new Deck();
    private Dealer dealer;

    public void playRound(){}

    public boolean gameOver(){ return false;}

    public boolean playing() {
        return false;
    }


}
