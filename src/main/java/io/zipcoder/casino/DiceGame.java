package io.zipcoder.casino;

public class DiceGame implements Game {
    private Dice dice;

    public boolean playing() {
        return false;
    }

    public void playRound() {}

    public boolean gameOver() {
        return false;
    }
}
