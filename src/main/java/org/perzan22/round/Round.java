package org.perzan22.round;

import org.perzan22.engine.GameState;
import org.perzan22.model.Deck;


public abstract class Round {

    protected GameState gameState;

    public Round(GameState gameState) {
        this.gameState = gameState;
    }

    public abstract void startRound(Deck deck);

    public abstract String getName();
}
