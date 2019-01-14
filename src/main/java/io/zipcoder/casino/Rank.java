package io.zipcoder.casino;

public enum Rank {
    ACE(1, "ace"),
    TWO(2, "two"),
    THREE(3, "three"),
    FOUR(4, "four"),
    FIVE(5, "five"),
    SIX(6, "six"),
    SEVEN(7, "seven"),
    EIGHT(8, "eight"),
    NINE(9, "nine"),
    TEN(10, "ten"),
    JACK(10, "jack"),
    QUEEN(10, "queen"),
    KING(10, "king");

    private int goFishValue;
    private int blackJackValue;
    private String stringValue;

    Rank(int goFishValue, String stringValue) {
        this.goFishValue = goFishValue;
        this.blackJackValue = goFishValue;
        this.stringValue = stringValue;
    }


    public int getGoFishValue() {
        return goFishValue;
    }

    public int getBlackJackValue() {
        return blackJackValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
