package org.perzan22.pokergame.engine;

import org.perzan22.pokergame.model.card.Deck;
import org.perzan22.pokergame.model.player.ActionType;
import org.perzan22.pokergame.model.player.PlayerAction;
import org.perzan22.pokergame.model.player.Player;
import org.perzan22.pokergame.model.player.PlayerList;
import org.perzan22.pokergame.round.Round;
import org.perzan22.pokergame.ui.UserInterface;

public class PokerGame {

    private final PlayerList players;
    private final UserInterface ui;
    private final GameState gameState;

    public PokerGame(PlayerList players, UserInterface ui, GameState gameState) {
        this.players = players;
        this.ui = ui;
        this.gameState = gameState;
    }

    public void playRound(Round round) {
        round.executeRound(this::getPlayerAction);
    }

    public PlayerAction getPlayerAction(Player player) {
        int[] chosenAction = ui.getUserDecision();
        ActionType type = ActionType.fromCode(chosenAction[0]);
        int amount = chosenAction[1];

        if (type == ActionType.ALL_IN) {
            amount = player.getChips();
        }
        if (type == ActionType.CHECK_CALL) {
            amount = gameState.getWager() - player.getPlayerBetAmount();
        }
        return new PlayerAction(type, amount);
    }
}
