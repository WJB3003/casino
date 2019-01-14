
package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    Card card;

    @Before
    public void setup(){

        card = new Card(card.getRank(), card.getSuit());

        card = new Card(Rank.ACE, Suit.CLUBS);
    }

    @Test
    public void getRankTest() {
        Rank expected =card.getRank();
        Rank actual = Rank.ACE;
        Assert.assertEquals(expected, actual);

    }

//    @Test
//    public void getRankTest() {
//
//        Enum expected = card.getRank();
//        Enum actual = Rank.ACE;
//
//        Rank expected =card.getRank();
//        Rank actual = Rank.ACE;
//
//        Assert.assertEquals(expected, actual);
//    }

    @Test
    public void getSuitTest() {
        Suit expected =card.getSuit();
        Suit actual = Suit.CLUBS;
        Assert.assertEquals(expected, actual);
    }
}
