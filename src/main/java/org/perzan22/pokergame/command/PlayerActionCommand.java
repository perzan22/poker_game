package org.perzan22.pokergame.command;

import org.perzan22.pokergame.engine.GameState;
import org.perzan22.pokergame.model.player.Player;

public abstract class PlayerActionCommand implements ActionCommand {

    protected final int amount;

    public PlayerActionCommand(int amount) {
        this.amount = amount;
    }

    protected void bet(Player player, GameState gameState) {
        player.subtractChips(amount);
        player.setPlayerBetAmount(amount);
        gameState.addToPot(amount);
    }
}
