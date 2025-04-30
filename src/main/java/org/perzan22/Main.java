package org.perzan22;

import org.perzan22.model.Deck;
import org.perzan22.model.Player;

public class Main {
    public static void main(String[] args) {

        Deck deck = new Deck();
        System.out.println(deck);

        System.out.println(deck.drawCard());
        System.out.println(deck);

        Player player = new Player("Gracz", 0);
        player.drawCardToHand(deck.drawCard());
        player.drawCardToHand(deck.drawCard());

        System.out.println(player);

        System.out.println(deck);
    }
}