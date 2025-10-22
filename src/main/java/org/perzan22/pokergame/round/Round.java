package org.perzan22.pokergame.round;

import org.perzan22.pokergame.command.ActionCommand;
import org.perzan22.pokergame.command.ActionCommandFactory;
import org.perzan22.pokergame.model.player.PlayerAction;
import org.perzan22.pokergame.engine.GameState;
import org.perzan22.pokergame.model.card.Deck;
import org.perzan22.pokergame.model.player.Player;
import org.perzan22.pokergame.model.player.PlayerList;
import org.perzan22.pokergame.model.player.PlayerStatus;

import java.util.List;
import java.util.function.Function;


public abstract class Round {

    protected GameState gameState;
    protected List<Player> activePlayers;

    public Round(GameState gameState, PlayerList playerList) {
        this.gameState = gameState;
        this.activePlayers = playerList.filterActivePlayers();
    }

    public void executeRound(Function<Player, PlayerAction> actionProvider) {
        startRound(gameState.getDeck());
        while (!isRoundCompleted()) {
            Player currentPlayer = activePlayers.get(gameState.getCurrentPlayerIndex());
            if (currentPlayer.getStatus() != PlayerStatus.FOLDED) {
                PlayerAction action = actionProvider.apply(currentPlayer);
                processAction(currentPlayer, action);
            }
            gameState.moveToNextPlayer(activePlayers.size());
        }
        finishRound();
    }

    private void processAction(Player player, PlayerAction action) {
        ActionCommand command = ActionCommandFactory.from(action);
        command.execute(player, gameState);
    }

    protected void bet(Player player, int amount) {
        player.subtractChips(amount);
        player.setPlayerBetAmount(amount);
        gameState.addToPot(amount);
    }

    protected boolean isRoundCompleted() {
        return activePlayers.stream()
                .filter(player -> player.getStatus() == PlayerStatus.ACTIVE)
                .allMatch(player -> player.getPlayerBetAmount() >= gameState.getWager());
    }

    protected void finishRound() {
        for (Player player : activePlayers) {
            player.setPlayerBetAmount(0);
        }
        gameState.setWager(0);
    }

    protected abstract void startRound(Deck deck);

    public abstract String getName();
}
