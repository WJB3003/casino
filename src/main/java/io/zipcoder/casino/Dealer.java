package io.zipcoder.casino;

public class Dealer {
    private Hand dealerHand = new Hand();
    Deck newDeck = new Deck();

    public Hand getHand(){
        return dealerHand;
    }

    public void setHand(Hand hand){
        this.dealerHand = hand;
    }

    public void pluck(Hand playerHand) {
        Card newCard = newDeck.pop();
        playerHand.add(newCard);
    }

    public Deck getNewDeck() {
        return newDeck;
    }

    public void deal(int numberOfCards, BlackJackPlayer player1){
        newDeck.shuffleCards();
        for (int i = 1; i <= numberOfCards; i++){
            Card newCard = newDeck.pop();
            Hand player1Hand = player1.getPlayerHand();
            player1Hand.add(newCard);
        }

    }

    public void deal(int numberOfCards, GoFishPlayer player2){
        newDeck.shuffleCards();
        for (int i = 1; i <= numberOfCards; i++){
            Card newCard = newDeck.pop();
            Hand player2Hand = player2.getPlayerHand();
            player2Hand.add(newCard);
        }

    }

    public void deal(int numberOfCards, Dealer dealer){
        newDeck.shuffleCards();
        for (int i = 1; i <= numberOfCards; i++){
            Card newCard = newDeck.pop();
            Hand dealerHand = dealer.getHand();
            dealerHand.add(newCard);
        }



    }

}
