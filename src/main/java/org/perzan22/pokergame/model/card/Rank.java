package org.perzan22.pokergame.model.card;

import java.util.Comparator;

public enum Rank implements Comparator<Rank> {

    // possible card ranks

    TWO("2", 2), THREE("3", 3), FOUR("4", 4),
    FIVE("5", 5), SIX("6", 6), SEVEN("7", 7),
    EIGHT("8", 8), NINE("9", 9), TEN("10", 10),
    JACK("J", 11), QUEEN("Q", 12), KING("K", 13),
    ACE("A", 14);

    // enum variables
    private final String symbol;
    private final int value;

    // constructor
    Rank(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    // compare ranks by the values
    @Override
    public int compare(Rank o1, Rank o2) {
        return Integer.compare(o1.getValue(), o2.getValue());
    }

    // getter
    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }


}
