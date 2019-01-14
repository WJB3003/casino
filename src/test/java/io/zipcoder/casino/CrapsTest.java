package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsTest {

    Craps craps;
    Player player = new Player("Maggie", 27, 10000);
    Console console = new Console();

    @Before
    public void setup(){
       craps = new Craps(player);
    }

    @Test
    public void instantWinTest() {
        craps.setWager(20);
        craps.instantWin();
        double expected = 20;
        double actual = craps.getBalance();
        Assert.assertEquals(expected, actual, .1);
    }

    @Test
    public void instantLoseTest() {
        craps.setWager(100);
        craps.instantLose();
        double expected = -100;
        double actual = craps.getBalance();
        Assert.assertEquals(expected,actual, .1);
    }

    @Test
    public void setPoint() {
        craps.setPointTester(5);
        craps.setPoint();
        int expected = 5;
        int actual = craps.getPoint();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void chasePoint() {
        craps.setRoll(5);

        int expected = 5;
        int actual = craps.chasePoint();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void throwDice() {
        craps.throwDice();
        boolean correct = false;

        int expected = craps.throwDice();
        int actual = craps.throwDice();
        if(actual >= 2 && actual <= 12){
            correct = true;
        }

        Assert.assertTrue(correct);
    }


    @Test
    public void accountBalanceTest() {

        craps.setBalance(1000);
        double expected = 1000;
        double actual = craps.getBalance();

        Assert.assertEquals(expected,actual, .01);
    }

    @Test
    public void addWinnings() {
        craps.setBalance(40);
        craps.setWager(10);
        craps.addWinnings();
        double expected = craps.getBalance();
        double actual =50;
        Assert.assertEquals(expected, actual, .1);

    }


    @Test
    public void lookForMatchPoint() {
        craps.setPointTester(5);
        craps.setPoint();

        craps.setRoll(5);

        boolean correct = false;

        
    }

    @Test
    public void subtractWinnings() {
    }

    @Test
    public void rollDice() {


    }

    @Test
    public void winningRoll() {
    }

    @Test
    public void losingRoll() {
    }




    @Test
    public void playRound() {
    }
}