package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class GoFishPlayerTest {

    private GoFishPlayer goFishPlayer;

    @Test
    public void testSetAndGetHand() {
        // Given
        Player player = new Player("Curtis", 36, 100);
        GoFishPlayer goFishPlayer = new GoFishPlayer(player);
        Hand hand = new Hand();
        goFishPlayer.setPlayerHand(hand);
        Hand expectedOutput = hand;

        // When
        Hand actualOutput = goFishPlayer.getPlayerHand();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
