package org.perzan22.pokergame.command;

import org.perzan22.pokergame.engine.GameState;
import org.perzan22.pokergame.model.player.Player;

public class RaiseCommand extends PlayerActionCommand {
    public RaiseCommand(int amount) {
        super(amount);
    }

    @Override
    public void execute(Player player, GameState state) {
        bet(player, state);
        state.setWager(amount);
    }
}
