package io.zipcoder.casino;

public class Card implements Comparable<Card>{


    private final Rank rank;
    private final Suit suit;

    Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int compareTo(Card o) {
        if(o.getRank().getGoFishValue() > this.getRank().getGoFishValue()) {
            return -1;
        }else
            return 1;
        }


    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
