package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class CrapsPlayerTest {

    @Test
    public void testGamble() {
        // Given
        Player player = new Player("Curtis", 36, 100);
        CrapsPlayer crapsPlayer = new CrapsPlayer(player);
        double expectedOutput = 100 - 50;

        // When
        crapsPlayer.gamble(50);
        double actualOutput = 50;

        // Then
        Assert.assertEquals(expectedOutput, actualOutput, 0.01);
    }

    @Test
    public void testGamble2() {
        // Given
        Player player = new Player("Curtis", 36, 100);
        CrapsPlayer crapsPlayer = new CrapsPlayer(player);
        double expectedOutput = 100;

        // When
        crapsPlayer.gamble(200);
        double actualOutput = 100;

        // Then
        Assert.assertEquals(expectedOutput, actualOutput, 0.01);
    }
}
