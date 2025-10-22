package org.perzan22.pokergame.round;

import org.perzan22.pokergame.engine.GameState;
import org.perzan22.pokergame.model.card.Deck;
import org.perzan22.pokergame.model.player.PlayerList;

public class TurnRound extends Round {


    public TurnRound(GameState gameState, PlayerList playerList) {
        super(gameState, playerList);
    }

    @Override
    public void startRound(Deck deck) {
        this.gameState.drawCommunityCard(deck.drawCard());

    }

    @Override
    public String getName() {
        return "Turn";
    }
}
