package io.zipcoder.casino;

import org.junit.Test;
import org.junit.Assert;

public class DealerTest {
    Dealer dealer1 = new Dealer();
    Player player = new Player("Joe", 21, 100);
    BlackJackPlayer player1 = new BlackJackPlayer(player);
    GoFishPlayer player2 = new GoFishPlayer(player);


    @Test
    public void dealTest(){
//        int expectedOutput = 0;
//        int actualOutput = dealer1.getHand().size();

        dealer1.deal(2, dealer1);

        int expectedOutput = 2;
        int actualOutput = dealer1.getHand().size();

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void dealBlackJackTest(){
        int expectedOutput = 2;

        dealer1.deal(2, player1);
        int actualOutput = player1.getPlayerHand().size();

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void dealGoFishTest(){
        int expectedOutput = 7;

        dealer1.deal(7, player2);
        int actualOutput = player2.getPlayerHand().size();

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void pluckTest(){
        int expectedOutput = 1;

        dealer1.pluck(player1.getPlayerHand());
        int actualOutput = player1.getPlayerHand().size();

        Assert.assertEquals(expectedOutput, actualOutput);

    }
}
