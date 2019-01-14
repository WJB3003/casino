package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class RoulettePlayerTest {

    @Test
    public void testGamble() {
        // Given
        Player player = new Player("Curtis", 36, 100);
        RoulettePlayer roulettePlayer = new RoulettePlayer(player);
        double expectedOutput = 100 - 25;

        // When
        roulettePlayer.gamble(25);
        double actualOutput = 75;

        // Then
        Assert.assertEquals(expectedOutput, actualOutput, 0.01);
    }

    @Test
    public void testGamble2() {
        // Given
        Player player = new Player("Curtis", 36, 100);
        RoulettePlayer roulettePlayer = new RoulettePlayer(player);
        double expectedOutput = 100;

        // When
        roulettePlayer.gamble(125);
        double actualOutput = 100;

        // Then
        Assert.assertEquals(expectedOutput, actualOutput, 0.01);
    }
}
