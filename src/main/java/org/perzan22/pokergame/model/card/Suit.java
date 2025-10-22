package org.perzan22.pokergame.model.card;

public enum Suit {

    // possible card suit

    HEARTS('♥'), DIAMONDS('♦'), CLUBS('♣'), SPADES('♠');

    // enum variables
    private final char symbol;

    // constructor
    Suit(char symbol) {
        this.symbol = symbol;
    }

    // getter
    public char getSymbol() {
        return symbol;
    }
}
