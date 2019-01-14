package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlackJackTest {

    Player playerTest = new Player("Joe", 23, 100);
    BlackJack blackjack1 = new BlackJack(playerTest);
    BlackJackPlayer player = new BlackJackPlayer(playerTest);
    Dealer dealer1 = new Dealer();

    @Test
    public void setGetBlackJackPlayerTest(){
        BlackJackPlayer expectedOutput = player;

        blackjack1.setPlayer(player);
        BlackJackPlayer actualOutput = blackjack1.getPlayer();

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void blacjackWelcomeTest(){
        String expectedOutput = "Welcome to BlackJack!  Please enter your bet: ";

        String actualOutput = blackjack1.blackJackWelcome();

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void hitOrStandTest(){
        String expectedOutput = "Would you like to hit or stand?";

        String actualOutput = blackjack1.hitOrStand();

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void playerTotalsTest(){
        Hand h12 = new Hand();
        h12.add(new Card(Rank.QUEEN, Suit.CLUBS));
        h12.add(new Card(Rank.JACK, Suit.DIAMONDS));
        this.player.setPlayerHand(h12);
        blackjack1.setPlayer(this.player);

        String expectedOutput = "Your cards are QUEENCLUBS JACKDIAMONDS"+"\n"+ "Your current total is 20";

        String actualOutput = blackjack1.playerTotalsOutput();

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void dealerTotalsTest(){
        Hand h12 = new Hand();
        h12.add(new Card(Rank.QUEEN, Suit.CLUBS));
        h12.add(new Card(Rank.JACK, Suit.DIAMONDS));
        this.dealer1.setHand(h12);
        blackjack1.dealer1 = this.dealer1;

        String expectedOutput = "The dealer's cards are QUEENCLUBS JACKDIAMONDS"+"\n"+ "The dealer's total is 20";

        String actualOutput = blackjack1.dealerTotalOutput();

        Assert.assertEquals(expectedOutput, actualOutput);
    }



    @Test
    public void playerBlackJackorBustTest(){
        Hand h = new Hand();
        h.add(new Card(Rank.TWO, Suit.CLUBS));
        h.add(new Card(Rank.JACK, Suit.DIAMONDS));
        this.player.setPlayerHand(h);

        boolean actualOutput = blackjack1.playerBlackJackorBust(h);

        Assert.assertFalse(actualOutput);
    }


    @Test
    public void playerBlackJackorBustTest2(){
        Hand h1 = new Hand();
        h1.add(new Card(Rank.TWO, Suit.CLUBS));
        h1.add(new Card(Rank.JACK, Suit.DIAMONDS));
        h1.add(new Card(Rank.QUEEN, Suit.SPADES));
        this.player.setPlayerHand(h1);

        boolean actualOutput = blackjack1.playerBlackJackorBust(h1);

        Assert.assertTrue(actualOutput);
    }

    @Test
    public void playerBlackJackorBustTest3(){
        Hand h2 = new Hand();
        h2.add(new Card(Rank.ACE, Suit.CLUBS));
        h2.add(new Card(Rank.JACK, Suit.DIAMONDS));
        h2.add(new Card(Rank.QUEEN, Suit.SPADES));
        this.player.setPlayerHand(h2);

        boolean actualOutput = blackjack1.playerBlackJackorBust(h2);

        Assert.assertTrue(actualOutput);
    }

    @Test
    public void dealerBlackJackorBust(){
        Hand h3 = new Hand();
        h3.add(new Card(Rank.ACE, Suit.CLUBS));
        h3.add(new Card(Rank.JACK, Suit.DIAMONDS));
        h3.add(new Card(Rank.QUEEN, Suit.SPADES));
        this.dealer1.setHand(h3);

        boolean actualOutput = blackjack1.dealerBlackJackorBust(h3);

        Assert.assertTrue(actualOutput);

    }

    @Test
    public void dealerBlackJackorBust1(){
        Hand h4 = new Hand();
        h4.add(new Card(Rank.TWO, Suit.CLUBS));
        h4.add(new Card(Rank.JACK, Suit.DIAMONDS));
        h4.add(new Card(Rank.QUEEN, Suit.SPADES));
        this.dealer1.setHand(h4);

        boolean actualOutput = blackjack1.dealerBlackJackorBust(h4);

        Assert.assertTrue(actualOutput);

    }

    @Test
    public void dealerBlackJackorBust2(){
        Hand h5 = new Hand();
        h5.add(new Card(Rank.TWO, Suit.CLUBS));
        h5.add(new Card(Rank.JACK, Suit.DIAMONDS));
        this.dealer1.setHand(h5);

        boolean expectedOutput = false;

        boolean actualOutput = blackjack1.dealerBlackJackorBust(h5);

        Assert.assertFalse(actualOutput);

    }

//    @Test
//    public void playerSubRoundTestOver21(){
//        Hand h6 = new Hand();
//        h6.add(new Card(Rank.TWO, Suit.CLUBS));
//        h6.add(new Card(Rank.JACK, Suit.DIAMONDS));
//        h6.add(new Card(Rank.QUEEN, Suit.SPADES));
//        this.player.setPlayerHand(h6);
//        blackjack1.dealer1 = this.dealer1;
//
//        int expectedOutput = 22;
//
//        blackjack1.playerSubRound();
//        int actualOutput = player.getPlayerHand().getTotal();
//
//        Assert.assertEquals(expectedOutput, actualOutput);
//
//    }
//
//    @Test
//    public void playerSubRoundTestHit(){
//        Hand h6 = new Hand();
//        h6.add(new Card(Rank.TWO, Suit.CLUBS));
//        h6.add(new Card(Rank.QUEEN, Suit.SPADES));
//        this.player.setPlayerHand(h6);
//        blackjack1.dealer1 = this.dealer1;
//        //blackjack1. = this.player1;
//
//
//        blackjack1.playerSubRound();
//        int actualOutput = player.getPlayerHand().getTotal();
//
//        Assert.assertTrue(actualOutput > 12);
//
//    }
//
//    @Test
//    public void playerSubRoundTestStay(){
//        Hand h7 = new Hand();
//        h7.add(new Card(Rank.TWO, Suit.CLUBS));
//        h7.add(new Card(Rank.JACK, Suit.DIAMONDS));
//        this.player.setPlayerHand(h7);
//        blackjack1.dealer1 = this.dealer1;
//
//
//        int expectedOutput = 12;
//
//        blackjack1.playerSubRound();
//        int actualOutput = player.getPlayerHand().getTotal();
//
//        Assert.assertEquals(expectedOutput, actualOutput);
//
//    }

    @Test
    public void dealerSubRoundTest(){
        Hand h8 = new Hand();
        h8.add(new Card(Rank.TWO, Suit.CLUBS));
        h8.add(new Card(Rank.JACK, Suit.DIAMONDS));
        this.dealer1.setHand(h8);
        blackjack1.dealer1 = this.dealer1;


        blackjack1.dealerSubRound();
        int actualOutput = dealer1.getHand().getTotal();

        Assert.assertTrue(actualOutput > 16);
    }

    @Test
    public void dealerSubRoundTest2(){
        Hand h9 = new Hand();
        h9.add(new Card(Rank.TWO, Suit.CLUBS));
        h9.add(new Card(Rank.JACK, Suit.DIAMONDS));
        h9.add(new Card(Rank.QUEEN, Suit.SPADES));
        this.dealer1.setHand(h9);
        blackjack1.dealer1 = this.dealer1;

        int expectedOutput = 22;


        blackjack1.dealerSubRound();
        int actualOutput = dealer1.getHand().getTotal();

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void dealerSubRoundTest3(){
        Hand h10 = new Hand();
        h10.add(new Card(Rank.SIX, Suit.CLUBS));
        h10.add(new Card(Rank.JACK, Suit.DIAMONDS));
        this.dealer1.setHand(h10);
        blackjack1.dealer1 = this.dealer1;

        blackjack1.dealerSubRound();
        int actualOutput = dealer1.getHand().getTotal();

        Assert.assertTrue(actualOutput > 16);
    }

    @Test
    public void getResultTestDealerBlackJack(){
        Hand h11 = new Hand();
        h11.add(new Card(Rank.ACE, Suit.CLUBS));
        h11.add(new Card(Rank.JACK, Suit.DIAMONDS));
        h11.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        this.dealer1.setHand(h11);
        blackjack1.dealer1 = this.dealer1;

        Hand h12 = new Hand();
        h12.add(new Card(Rank.FIVE, Suit.CLUBS));
        h12.add(new Card(Rank.JACK, Suit.DIAMONDS));
        this.player.setPlayerHand(h12);


        boolean actualOutput = blackjack1.getResult();

        Assert.assertFalse(actualOutput);

    }

    @Test
    public void getResultTestDealerWin(){
        Hand h11 = new Hand();
        h11.add(new Card(Rank.JACK, Suit.DIAMONDS));
        h11.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        this.dealer1.setHand(h11);
        blackjack1.dealer1 = this.dealer1;

        Hand h12 = new Hand();
        h12.add(new Card(Rank.FIVE, Suit.CLUBS));
        h12.add(new Card(Rank.JACK, Suit.DIAMONDS));
        this.player.setPlayerHand(h12);

        boolean actualOutput = blackjack1.getResult();

        Assert.assertFalse(actualOutput);

    }

    @Test
    public void getResultTestPlayerWin(){
        Hand h11 = new Hand();
        h11.add(new Card(Rank.FIVE, Suit.DIAMONDS));
        h11.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        this.dealer1.setHand(h11);
        blackjack1.dealer1 = this.dealer1;

        Hand h12 = new Hand();
        h12.add(new Card(Rank.QUEEN, Suit.CLUBS));
        h12.add(new Card(Rank.JACK, Suit.DIAMONDS));
        this.player.setPlayerHand(h12);
        blackjack1.setPlayer(this.player);


        System.out.println(blackjack1.getResult());
        boolean actualOutput = blackjack1.getResult();

        Assert.assertTrue(actualOutput);

    }

    @Test
    public void playerWinLossWinTest(){
        Hand h11 = new Hand();
        h11.add(new Card(Rank.FIVE, Suit.DIAMONDS));
        h11.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        this.dealer1.setHand(h11);
        blackjack1.dealer1 = this.dealer1;

        Hand h12 = new Hand();
        h12.add(new Card(Rank.QUEEN, Suit.CLUBS));
        h12.add(new Card(Rank.JACK, Suit.DIAMONDS));
        this.player.setPlayerHand(h12);
        blackjack1.setPlayer(this.player);

        blackjack1.getResult();
        String expectedOutput = "The dealer's cards are FIVEDIAMONDS QUEENDIAMONDS"+"\n"+ "The dealer's total is 15"+"\n"+
                "YOU WON!"+"\n";

    }

    @Test
    public void adjustFundsWin(){
        player.setWagerAmount(25.00);

        Hand h11 = new Hand();
        h11.add(new Card(Rank.FIVE, Suit.DIAMONDS));
        h11.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        this.dealer1.setHand(h11);
        blackjack1.dealer1 = this.dealer1;

        Hand h12 = new Hand();
        h12.add(new Card(Rank.QUEEN, Suit.CLUBS));
        h12.add(new Card(Rank.JACK, Suit.DIAMONDS));
        this.player.setPlayerHand(h12);
        blackjack1.setPlayer(this.player);

        double expectedOutput = 137.50;

        blackjack1.adjustFunds();
        double actualOutput = player.getMoney();

        Assert.assertEquals(expectedOutput, actualOutput, .002);

    }

    @Test
    public void adjustFundsLoss(){
        player.setWagerAmount(25.00);

        Hand h11 = new Hand();
        h11.add(new Card(Rank.FIVE, Suit.DIAMONDS));
        h11.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        this.player.setPlayerHand(h11);
        blackjack1.setPlayer(this.player);


        Hand h12 = new Hand();
        h12.add(new Card(Rank.QUEEN, Suit.CLUBS));
        h12.add(new Card(Rank.JACK, Suit.DIAMONDS));
        this.dealer1.setHand(h12);
        blackjack1.dealer1 = this.dealer1;


        double expectedOutput = 75.00;
        blackjack1.adjustFunds();

        double actualOutput = player.getMoney();

        Assert.assertEquals(expectedOutput, actualOutput, .002);

    }

}