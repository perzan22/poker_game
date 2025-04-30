package org.perzan22.model;

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
}
