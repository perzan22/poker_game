package org.perzan22.pokergame.round;

import org.perzan22.pokergame.engine.GameState;
import org.perzan22.pokergame.model.card.Deck;
import org.perzan22.pokergame.model.player.PlayerList;

public class FlopRound extends Round {

    // constructor
    public FlopRound(GameState gameState, PlayerList playerList) {
        super(gameState, playerList);
    }

    @Override
    public void startRound(Deck deck) {
        for (int i = 0; i < 3; i++) {
            this.gameState.drawCommunityCard(deck.drawCard());
        }
    }

    @Override
    public String getName() {
        return "Flop";
    }
}
