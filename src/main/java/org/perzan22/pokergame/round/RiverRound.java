package org.perzan22.pokergame.round;

import org.perzan22.pokergame.engine.GameState;
import org.perzan22.pokergame.model.card.Deck;
import org.perzan22.pokergame.model.player.Player;
import org.perzan22.pokergame.model.player.PlayerList;

public class RiverRound extends Round {


    public RiverRound(GameState gameState, PlayerList playerList) {
        super(gameState, playerList);
    }

    @Override
    public void startRound(Deck deck) {
        this.gameState.drawCommunityCard(deck.drawCard());
    }

    @Override
    public String getName() {
        return "River";
    }

    @Override
    protected void finishRound() {
        super.finishRound();
        this.gameState.setPot(0);
        for (Player player : activePlayers) {
            player.resetHand();
        }
    }
}
