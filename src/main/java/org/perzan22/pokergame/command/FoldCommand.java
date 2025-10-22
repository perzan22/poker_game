package org.perzan22.pokergame.command;

import org.perzan22.pokergame.engine.GameState;
import org.perzan22.pokergame.model.player.Player;

public class FoldCommand extends PlayerActionCommand {
    public FoldCommand() {
        super(0);
    }

    @Override
    public void execute(Player player, GameState state) {
        player.fold();
    }
}
