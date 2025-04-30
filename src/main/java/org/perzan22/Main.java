package org.perzan22;

import org.perzan22.model.Deck;

public class Main {
    public static void main(String[] args) {

        Deck deck = new Deck();
        System.out.println(deck);

        System.out.println(deck.drawCard());
        System.out.println(deck);
    }
}