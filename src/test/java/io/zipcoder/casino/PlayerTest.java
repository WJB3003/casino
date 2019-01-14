package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void testGetName() {
        // Given
        Player player = new Player("Curtis", 37, 500);
        String expectedOutput = "Curtis";

        // When
        String actualOutput = player.getName();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);

    }

    @Test
    public void testGetAge() {
        // Given
        Player player = new Player("Curtis", 37, 500);
        int expectedOutput = 37;

        // When
        int actualOutput = player.getAge();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
