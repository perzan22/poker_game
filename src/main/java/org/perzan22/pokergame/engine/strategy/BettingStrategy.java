package org.perzan22.pokergame.engine.strategy;

import org.perzan22.pokergame.engine.GameState;
import org.perzan22.pokergame.model.player.Player;
import org.perzan22.pokergame.model.player.PlayerAction;

public interface BettingStrategy {
    PlayerAction decideAction(Player player, GameState state);
}
