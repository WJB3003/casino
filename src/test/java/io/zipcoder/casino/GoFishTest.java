package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;
import sun.misc.ASCIICaseInsensitiveComparator;

public class GoFishTest {
    Player William = new Player("William", 18, 0.0);
    GoFish goFish = new GoFish(William);

    @Test
    public void testUserTurn(){
        //IDK HOW TO TEST
    }

    @Test
    public void testAiTurn(){
        //IDK HOW TO TEST
    }

    @Test
    public void testUserMatches(){
        //TEST SIZE
        //MATCH ONE
        //TEST SIZE FOR ONE LESS
        int expected = 0;
        int actual = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAiMatches(){
        //TEST SIZE
        //MATCH ONE
        //TEST SIZE FOR ONE LESS
        int expected = 0;
        int actual = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUserGuess(){
        //SHOULD RETURN THE INPUT
    }

    @Test
    public void testAiGuess(){
        //CANT BE TESTED BC IT IS RANDOM
    }

    @Test
    public void testPlayerGoFish(){
        //GET SIZE OF HAND
        //GO FISH
        //GET SIZE OF HAND + GO FISH
        //SEE IF IT IS ONE MORE
        int expected = 0;
        int actual = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlayerGotFish(){
        //GET SIZE OF HAND
        //GOT FISH
        //GET SIZE OF HAND - GOT FISH
        //SEE IF IT IS ONE LESS
        int expected = 0;
        int actual = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAiGoFish(){
        //GET SIZE OF HAND
        //GO FISH
        //GET SIZE OF HAND + GO FISH
        //SEE IF IT IS ONE MORE
        int expected = 0;
        int actual = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAiGotFish(){
        //GET SIZE OF HAND
        //GOT FISH
        //GET SIZE OF HAND - GOT FISH
        //SEE IF IT IS ONE LESS
        int expected = 0;
        int actual = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCheckUserHandSize(){
        //SET HAND SIZE TO ZERO
        //RUN CHECKUSERHANDSIZE()
        //GET HAND SIZE
        //SEE IF THE HAND SIZE IS 7
        int expected = 0;
        int actual = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCheckAiHandSize(){
        //SET HAND SIZE TO ZERO
        //RUN CHECKUSERHANDSIZE()
        //GET HAND SIZE
        //SEE IF THE HAND SIZE IS 7
        int expected = 0;
        int actual = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAiWinner(){
        //SET AI SCORE TO ONE HIGHER
        goFish.setAiScore(1);


        //COMPARE THE SCORES AND SEE IF IT RETURNS AI
    }

    @Test
    public void testPlayerWinner(){
        //SET PLAYER SCORE TO ONE HIGHER
        goFish.setPlayerScore(1);


        //COMPARE THE SCORES AND SEE IF IT RETURNS PLAYER
    }

    @Test
    public void testResultsAiWinner(){
        //SET AI SCORE TO ONE HIGHER
        goFish.setAiScore(1);


        //SHOULD RETURN FALSE
        Assert.assertFalse(goFish.getResult());
    }

    @Test
    public void testResultsPlayerWinner(){
        //SET PLAYER SCORE TO ONE HIGHER
        goFish.setPlayerScore(1);


        //SHOULD RETURN TRUE
        Assert.assertTrue(goFish.getResult());
    }

}
