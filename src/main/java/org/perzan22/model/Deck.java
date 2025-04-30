package org.perzan22.model;

import java.util.*;

public class Deck {

    private Deque<Card> deck;

    public Deck() {
        this.deck = createDeck();
        shuffle();
    }

    // create new card deck
    private Deque<Card> createDeck() {

        // create deque instance
        Deque<Card> deck = new ArrayDeque<>();

        // add every card to deck
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }

        return deck;
    }

    // method shuffles whole deck of cards
    public void shuffle() {
        if (deck.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }

        // chage type to List to implement shuffle method
        List<Card> deckShuffled = new ArrayList<>(this.deck);

        // shuffle cards
        Collections.shuffle(deckShuffled);

        // change type back to deque
        deck = new ArrayDeque<>(deckShuffled);
    }

    // drawing card from deck
    public Card drawCard() {
        if (deck.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        // poll() method removes top card from deck and returns it
        return deck.poll();
    }

    // returns size of the deck
    public int size() {
        return deck.size();
    }

    // after round reset deck and shuffle again
    public void resetDeck() {
        this.deck = createDeck();
    }

    // getter
    public Deque<Card> getDeck() {
        return deck;
    }


    // toString() method

    @Override
    public String toString() {
        return "Deck shuffled: " + deck;
    }
}
