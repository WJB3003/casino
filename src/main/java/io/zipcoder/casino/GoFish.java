package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Scanner;

public class GoFish extends CardGame {

    private int playerScore;
    private int aiScore;
    private GoFishPlayer player;
    private GoFishPlayer ai;

    public static void main(String[] args) {
        Player William = new Player("William", 18, 0.0);
        GoFish goFish = new GoFish(William);

        goFish.playRound();
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getAiScore() {
        return aiScore;
    }

    public void setAiScore(int aiScore) {
        this.aiScore = aiScore;
    }

    public GoFish(Player player) {
        Player ai = new Player("ai", 0, 0.0);

        this.player = new GoFishPlayer(player);
        this.ai = new GoFishPlayer(ai);
    }

    public Dealer dealer = new Dealer();

    public boolean running(){
        return true;
    }

    public void playRound() {
        System.out.println("Welcome to Baby Fish.");
        dealer.deal(7, player);
        dealer.deal(7, ai);
        while (dealer.getNewDeck().getDeckSize() != 0 && player.getPlayerHand().size() != 0 && ai.getPlayerHand().size() != 0) {
            usersTurn();
            aiTurn();
        }
        findWinner();
    }

    public void usersTurn(){
        checkUserHandSize();
        System.out.println(player.getPlayerHand().toString());
        System.out.println("What are you asking for?");
        Card userGuess = userGuess(tempInput());
        playerGoFish(userGuess);
        playerGotFish(userGuess);
        checkUserHandSize();
    }

    public void aiTurn(){
        checkAiHandSize();
        Card aiGuess = aiGuess();
        System.out.println("The AI asks for a " + aiGuess);
        aiGoFish(aiGuess);
        aiGotFish(aiGuess);
        checkAiHandSize();
    }

    public void playerMatches(){
        if(player.getPlayerHand().numberOfDuplicates() > 0) {
            int num = player.getPlayerHand().numberOfDuplicates();
            player.getPlayerHand().removeDuplicates();
            playerScore = playerScore + num;
        }
    }

    public void aiMatches(){
        if(ai.getPlayerHand().numberOfDuplicates() > 0) {
            int num = ai.getPlayerHand().numberOfDuplicates();
            ai.getPlayerHand().removeDuplicates();
            aiScore = aiScore + num;
        }
        //checks if hand is 0 & if deck is < 7
    }

    public Card userGuess(Card guess){
        ArrayList<Card> playerHand = player.getPlayerHand().getHand();
        if(playerHand.contains(guess)){
            return guess;
        }
        return null;
    }

    public Card aiGuess(){
        ArrayList<Card> aiHandHand= ai.getPlayerHand().getHand();
        Card aiGuess = aiHandHand.get(0);
        return aiGuess;
    }

    public void playerGoFish(Card guess){
        if(!ai.getPlayerHand().contains(guess)){
            System.out.println("The AI doesnt have a " + guess);
            player.getPlayerHand().add(dealer.getNewDeck().pop());
            playerMatches();
            System.out.println("The player went fishing.");
        }
    }

    public void playerGotFish(Card guess){
        if(ai.getPlayerHand().contains(guess)){
            ArrayList<Card> aiHandHand= ai.getPlayerHand().getHand();
            aiHandHand.remove(guess);
            aiMatches();
            System.out.println("The player has gained a point.");
        }
    }

    public void aiGoFish(Card guess){
        if(!player.getPlayerHand().contains(guess)){
            if(dealer.getNewDeck().getDeckSize() >= 1){
                ai.getPlayerHand().add(dealer.getNewDeck().pop());
            }
            aiMatches();
            System.out.println("The AI has gone fishing.");
        }
    }

    public void aiGotFish(Card guess){
        if(player.getPlayerHand().contains(guess)){
            ArrayList<Card> playerHandHand= player.getPlayerHand().getHand();
            playerHandHand.remove(guess);
            aiMatches();
            System.out.println("The AI has gained a point.");
        }
    }

    public void checkUserHandSize(){
        if(player.getPlayerHand().size() == 0 && dealer.getNewDeck().getDeckSize() > 7){
            System.out.println("Your hand was empty here's some cards.");
            dealer.deal(7, player);
        } else if(player.getPlayerHand().size() == 0){
            System.out.println("Your hand was empty here's some cards.");
            dealer.deal(dealer.getNewDeck().getDeckSize(), player);
        }
    }

    public void checkAiHandSize(){
        if(ai.getPlayerHand().size() == 0 && dealer.getNewDeck().getDeckSize() > 7){
            dealer.deal(7, ai);
        } else if(ai.getPlayerHand().size() == 0){
            dealer.deal(7, ai);
        }
    }

    public boolean getResult(){
        if(playerScore < aiScore){
            System.out.println("AI won this time.");
            return false;
        }else {
            System.out.println("You won!!!");
            return true;
        }
    }

    public void findWinner(){
        if(playerScore < aiScore){
            System.out.println("AI won this time.");
//            return ai;
        }else {
            System.out.println("You won!!!");
//            return player;
        }
    }

    public Card tempInput(){
        //TAKES A STRING INPUT CONVERTS IT TO RANK
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        for(Card card : ai.getPlayerHand().getHand()){
            if(input.equals(card.getRank().getStringValue())){
                return card;
            }
        }
        return null;
    }

}
