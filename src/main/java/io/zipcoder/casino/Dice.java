package io.zipcoder.casino;

public class Dice {
    private int diceRolled = 0;

    public Dice(int numOfDice){
        diceRolled = numOfDice;
    }

    public int tossAndSum(){
        int toss = 0;
        for (int i = 0; i < diceRolled; i++) {
            toss += (int) (Math.ceil(Math.random() * 6));
        }
        return toss;
    }

}