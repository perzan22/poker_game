package org.perzan22.round;

import org.perzan22.engine.GameState;
import org.perzan22.model.Deck;
import org.perzan22.model.Player;
import org.perzan22.model.PlayerList;

public class PreFlopRound extends Round {

    private final PlayerList players;

    public PreFlopRound(GameState gameState, PlayerList players) {
        super(gameState);
        this.players = players;
    }

    @Override
    public void startRound(Deck deck) {
        for (int i = 0; i < 2; i++) {
            for (Player player : players.getPlayers()) {
                player.drawCardToHand(deck.drawCard());
            }
        }
    }

    @Override
    public String getName() {
        return "Pre-Flop";
    }
}
