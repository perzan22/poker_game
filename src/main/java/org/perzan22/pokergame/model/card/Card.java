package org.perzan22.pokergame.model.card;

import java.util.Objects;

public class Card {

    // class variables
    private Rank rank;
    private Suit suit;

    // constructor
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // getters and setters

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuits(Suit suit) {
        this.suit = suit;
    }

    // toString() method

    @Override
    public String toString() {
        return suit.getSymbol() + " " + rank.getSymbol();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}
