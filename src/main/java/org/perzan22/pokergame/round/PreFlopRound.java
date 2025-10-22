package org.perzan22.pokergame.round;

import org.perzan22.pokergame.engine.GameState;
import org.perzan22.pokergame.model.card.Deck;
import org.perzan22.pokergame.model.player.Player;
import org.perzan22.pokergame.model.player.PlayerList;
import org.perzan22.pokergame.model.player.PlayerStatus;

public class PreFlopRound extends Round {

    public PreFlopRound(GameState gameState, PlayerList players) {
        super(gameState, players);
    }

    @Override
    public void startRound(Deck deck) {
        for (int i = 0; i < 2; i++) {
            for (Player player : activePlayers) {
                player.drawCardToHand(deck.drawCard());
            }
        }
        initializePlayersStatus();
    }

    private void initializePlayersStatus() {
        for (Player player : activePlayers) {
            player.setStatus(PlayerStatus.ACTIVE);
            setBlinds(player);
        }
    }

    private void setBlinds(Player player) {
        if (player.isBigBlind()) {
            setBigBLind(player);
        }
        if (player.isSmallBlind()) {
            setSmallBlind(player);
        }
    }

    private void setSmallBlind(Player player) {
        bet(player, this.gameState.getSmallBlind());
    }

    private void setBigBLind(Player player) {
        bet(player, this.gameState.getBigBlind());
        this.gameState.setWager(this.gameState.getBigBlind());
    }

    @Override
    public String getName() {
        return "Pre-Flop";
    }
}
