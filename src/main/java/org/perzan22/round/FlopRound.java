package org.perzan22.round;

import org.perzan22.engine.GameState;
import org.perzan22.model.Deck;

public class FlopRound extends Round {

    // constructor
    public FlopRound(GameState gameState) {
        super(gameState);
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
