package org.perzan22.round;

import org.perzan22.engine.GameState;
import org.perzan22.model.Deck;

public class TurnRound extends Round {


    public TurnRound(GameState gameState) {
        super(gameState);
    }

    @Override
    public void startRound(Deck deck) {

    }

    @Override
    public String getName() {
        return "";
    }
}
