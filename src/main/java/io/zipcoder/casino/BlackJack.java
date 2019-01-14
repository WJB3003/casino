package io.zipcoder.casino;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class BlackJack extends CardGame {

    protected Dealer dealer1 = new Dealer();
    private BlackJackPlayer player1;
    private Console console = new Console();

    public BlackJack(Player player) {
        this.player1 = new BlackJackPlayer(player);

    }

    public BlackJackPlayer getPlayer(){
        return player1;
    }

    public void setPlayer(BlackJackPlayer player1) {
        this.player1 = player1;
    }



    public void playRound() {
        double wager = console.getDoubleInput(blackJackWelcome());
        player1.setWagerAmount(wager);

        dealer1.deal(2, player1);
        console.print(playerTotalsOutput());

        dealer1.deal(2, dealer1);

        blackJackRound();

        adjustFunds();

        playerWinLoss();
    }


    public String blackJackWelcome(){
        return "Welcome to BlackJack!  Please enter your bet: ";
    }


    public String playerTotalsOutput(){
        return "Your cards are " + player1.getPlayerHand().toString().trim() + "\n"
                +"Your current total is " + player1.getPlayerHand().getTotal();
    }

    public String dealerTotalOutput(){
        return "The dealer's cards are " + dealer1.getHand().toString().trim() + "\n"
                + "The dealer's total is " + dealer1.getHand().getTotal();
    }

    public String hitOrStand(){
        return "Would you like to hit or stand?";
    }



    public void blackJackRound(){
            if (dealerBlackJackorBust(dealer1.getHand())){
            } else if (playerBlackJackorBust(dealer1.getHand()))  {
            } else{
                playerSubRound();
                dealerSubRound();
            }
    }



    public void playerSubRound() {
        String userInput = console.getStringInput(hitOrStand());
            while (userInput.equalsIgnoreCase("Hit")|| userInput.equalsIgnoreCase("hit")) {
                if (playerBlackJackorBust(player1.getPlayerHand())) {
                    break;
                } else if (userInput.equalsIgnoreCase("Stand") || userInput.equalsIgnoreCase("stand")) {
                    break;
                } else if (userInput.equalsIgnoreCase("Hit") || userInput.equalsIgnoreCase("hit")) {
                    dealer1.pluck(player1.getPlayerHand());
                    console.print(playerTotalsOutput());
                    if(player1.getPlayerHand().getTotal() < 21){
                        userInput = console.getStringInput(hitOrStand());}
                }
            }
        }

    public boolean playerBlackJackorBust(Hand playerhand){
        if (playerhand.getTotal() >= 21){
            return true;
        }else{
            return false;
        }
    }

    public boolean dealerBlackJackorBust(Hand dealerhand){
        if (dealerhand.getTotal() == 21 || dealerhand.getTotal() > 21){
            return true;
        }else{
            return false;
        }

    }


    public void dealerSubRound(){
        while (dealer1.getHand().getTotal() <= 16) {
                dealer1.pluck(dealer1.getHand());
                break;
            }

    }

    public boolean getResult(){
        int dealerTotal = dealer1.getHand().getTotal();
        int playerTotal = player1.getPlayerHand().getTotal();
        if (dealerTotal > playerTotal && dealerTotal <= 21){
            return false;
        }else if(playerTotal > 21){
            return false;
        }else{
            return true;
        }
    }

    public void playerWinLoss(){
        if (getResult()) {
            console.print(dealerTotalOutput());
            console.print("YOU WON!");
            console.print("Your new account balance is " + String.format("%.2f", player1.getMoney()));
        }else {
            console.print(dealerTotalOutput());
            console.print("YOU LOST!");
            console.print("Your new account balance is " + String.format("%.2f", player1.getMoney()));
        }

    }


    public void adjustFunds() {
        if (getResult() == true) {
            player1.setMoney(player1.getMoney() + (player1.getWagerAmount() * 1.5));

        } else {
            player1.setMoney(player1.getMoney() - player1.getWagerAmount());
        }

    }

}
