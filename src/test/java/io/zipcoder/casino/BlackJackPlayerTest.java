package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class BlackJackPlayerTest {

    @Test
    public void testGamble() {
        // Given
        Player player = new Player("Curtis", 36, 100);
        BlackJackPlayer blackJackPlayer = new BlackJackPlayer(player);
        double expectedOutput = 100 - 75;

        // When
        blackJackPlayer.gamble(75);
        double actualOutput = 25;

        // Then
        Assert.assertEquals(expectedOutput, actualOutput, 0.01);
    }

    @Test
    public void testGamble2() {
        // Given
        Player player = new Player("Curtis", 36, 100);
        BlackJackPlayer blackJackPlayer = new BlackJackPlayer(player);
        double expectedOutput = 100;

        // When
        blackJackPlayer.gamble(200);
        double actualOutput = 100;

        // Then
        Assert.assertEquals(expectedOutput, actualOutput, 0.01);
    }

    @Test
    public void testSetAndGetHand() {
        // Given
        Player player = new Player("Curtis", 36, 100);
        BlackJackPlayer blackJackPlayer = new BlackJackPlayer(player);
        Hand hand = new Hand();
        blackJackPlayer.setPlayerHand(hand);
        Hand expectedOutput = hand;

        // When
        Hand actualOutput = blackJackPlayer.getPlayerHand();


        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
