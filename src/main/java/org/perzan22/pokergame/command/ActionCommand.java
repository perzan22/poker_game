package org.perzan22.pokergame.command;

import org.perzan22.pokergame.engine.GameState;
import org.perzan22.pokergame.model.player.Player;

public interface ActionCommand {

    void execute(Player player, GameState state);
}
