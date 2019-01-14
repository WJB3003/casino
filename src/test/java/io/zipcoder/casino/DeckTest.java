
package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    private Deck deck;


    @Before
    public void setup(){
        deck = new Deck();
        deck.setCards();
    }


    @Test
    public void shuffleCards() {
        String before = deck.getCards().toString();
        deck.shuffleCards();
        String after = deck.getCards().toString();
        Assert.assertNotEquals(before, after);
    }

    @Test
    public void popTest() {
       Card actual = deck.pop();
       Card expected= new Card(Rank.KING, Suit.SPADES);
       Assert.assertEquals(expected.getSuit(),actual.getSuit());
       Assert.assertEquals(expected.getRank(), actual.getRank());
    }

    @Test
    public void popSizeTest() {
        int startSize = deck.getDeckSize();
        deck.pop();
        int actual = startSize - deck.getDeckSize();
        int expected= 1;
        Assert.assertEquals(expected,actual);

    }


    @Test
    public void peek() {
        Card actual = deck.peek();
        Card expected= new Card(Rank.KING, Suit.SPADES);
        Assert.assertEquals(expected.getSuit(),actual.getSuit());
        Assert.assertEquals(expected.getRank(), actual.getRank());
    }

    @Test
    public void peekSizeTest() {
        int startSize = deck.getDeckSize();
        deck.peek();
        int actual = startSize - deck.getDeckSize();
        int expected= 0;
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void isEmptyTest() {
        boolean actual = deck.isEmpty();
        Assert.assertFalse(actual);
    }


}

