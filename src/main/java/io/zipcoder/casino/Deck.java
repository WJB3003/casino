package io.zipcoder.casino;

import java.util.Collections;
import java.util.Stack;


    public class Deck {


        private Stack<Card> cards = new Stack<Card>();

        public Deck() {
            setCards();
        }

        public int getDeckSize(){
            return cards.size();
        }

        public Stack<Card> getCards() {
            return cards;
        }

        public void setCards() {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    cards.push(new Card(rank, suit));
                }
            }
        }

            public void shuffleCards () {
                Collections.shuffle(cards);
            }

            public Card pop () {
                return cards.pop();
            }

            public Card peek () {
                return cards.peek();
            }

            public boolean isEmpty () {
                return cards.empty();
            }


    }
