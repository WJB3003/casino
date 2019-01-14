
package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class HandTest {


    Hand hand;
    Card card1;
    Card card2;
    Card card3;
    Card card4;
    Card card5;
    Card card11;
    Card card12;
    Card card13;
    Card card14;


    @Before
    public void setup(){
        hand = new Hand();
        card1 = new Card(Rank.KING, Suit.SPADES);
        card2 = new Card(Rank.TWO, Suit.HEARTS);
        card3 = new Card(Rank.ACE, Suit.DIAMONDS);
        card4 = new Card(Rank.ACE, Suit.SPADES);
        card5 = new Card(Rank.ACE, Suit.HEARTS);
        card11 = new Card(Rank.THREE, Suit.HEARTS);
        card12 = new Card(Rank.THREE, Suit.SPADES);
        card13 = new Card(Rank.THREE, Suit.CLUBS);
        card14 = new Card(Rank.THREE, Suit.DIAMONDS);


    }

    @Test
    public void addTest() {
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        int actual = hand.size();
        int expected = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandTest() {
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        ArrayList<Card> expected = new ArrayList<Card>(Arrays.asList(card1, card2,card3));
        ArrayList<Card> actual = hand.getHand();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void numberOfDuplicatesTest() {
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        int expected = 1;
        int actual = hand.numberOfDuplicates();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void numberOfDuplicatesBigTest() {
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        hand.add(card11);
        hand.add(card12);
        hand.add(card13);
        hand.add(card14);
        int expected = 3;
        int actual = hand.numberOfDuplicates();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void containsTestTrue() {
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        boolean actual= hand.contains(card2);
        Assert.assertTrue(actual);
    }

    @Test
    public void containsTestFalse() {
        hand.add(card1);
        hand.add(card3);
        boolean actual= hand.contains(card2);
        Assert.assertFalse(actual);
    }

    @Test
    public void removeDuplicatesTest() {
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.removeDuplicates();
        String expected = "TWOHEARTS KINGSPADES ";
        String actual = hand.toString();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void removeDuplicatesBigTest() {
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        hand.add(card11);
        hand.add(card12);
        hand.add(card13);
        hand.add(card14);
        hand.removeDuplicates();
        String expected = "ACEDIAMONDS TWOHEARTS KINGSPADES ";
        String actual = hand.toString();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void toStringTest() {
        hand.add(card1);
        hand.add(card2);
        String actual = hand.toString();
        String expected = "KINGSPADES TWOHEARTS ";

    }

    @Test
    public void getNumberOfOccurrences() {
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        int actual = hand.getNumberOfRankOccurrences(card3);
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }




    @Test
    public void getTotalValue(){
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        hand.add(card11);
        hand.add(card12);
        hand.add(card13);
        hand.add(card14);
        int actual = hand.getTotal();
        int expected =27;
        Assert.assertEquals(expected, actual);
    }
}

