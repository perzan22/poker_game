package org.perzan22.pokergame.command;

import org.perzan22.pokergame.engine.GameState;
import org.perzan22.pokergame.model.player.Player;

public class AllInCommand extends PlayerActionCommand {
    public AllInCommand(int amount) {
        super(amount);
    }

    @Override
    public void execute(Player player, GameState state) {
        bet(player, state);
        player.allIn();
        state.setWager(Math.max(amount, state.getWager()));
    }
}
