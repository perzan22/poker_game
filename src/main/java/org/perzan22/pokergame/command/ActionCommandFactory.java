package org.perzan22.pokergame.command;

import org.perzan22.pokergame.model.player.PlayerAction;

public final class ActionCommandFactory {

    private ActionCommandFactory() {}

    public static ActionCommand from(PlayerAction action) {
        return switch (action.actionType()) {
            case CHECK_CALL -> new CheckCallCommand(action.amount());
            case RAISE -> new RaiseCommand(action.amount());
            case ALL_IN -> new AllInCommand(action.amount());
            case FOLD -> new FoldCommand();
        };
    }
}
