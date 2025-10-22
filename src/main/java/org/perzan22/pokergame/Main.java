package org.perzan22.pokergame;

import org.perzan22.pokergame.model.card.Deck;
import org.perzan22.pokergame.model.player.Player;

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
        deck.resetDeck();
        System.out.println(deck);
    }
}