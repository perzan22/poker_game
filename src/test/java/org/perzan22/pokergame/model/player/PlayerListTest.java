package org.perzan22.pokergame.model.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerListTest {

    private PlayerList playerList;

    @BeforeEach
    public void setUp() {
        playerList = new PlayerList();
    }

    @Test
    public void testAddPlayer_newPlayer_playerAddedToList() {
        // given
        Player newPlayer = new Player("testName", 0);

        // when
        playerList.addPlayer(newPlayer);

        // then
        assertEquals(1, playerList.getPlayers().size(),
                "The list should contain one player after adding a player to empty list");
    }

    @Test
    public void testRemovePlayer_playerInTheList_playerRemoved() {
        // given
        Player newPlayer = new Player("testName", 0);
        playerList.addPlayer(newPlayer);

        // when
        playerList.removePlayer(newPlayer);

        // then
        assertTrue(playerList.getPlayers().isEmpty(), "List should be empty after removing player");
    }

    @Test
    public void testRemovePlayer_playerNotInTheList_throwIllegalArgumentException() {
        // given
        Player newPlayer = new Player("testName", 0);
        Player newPlayerNotInTheList = new Player("testName", 1);
        playerList.addPlayer(newPlayer);

        // then
        assertThrows(IllegalArgumentException.class, () -> playerList.removePlayer(newPlayerNotInTheList),
                "The player is not in the list, exception should be thrown");
    }

    @Test
    public void testFilterActivePlayers_activeAndFoldedPlayers_onlyActivePlayersList() {
        // given
        Player activePlayer1 = new Player("active1", 0);
        Player activePlayer2 = new Player("active2", 0);
        activePlayer1.setStatus(PlayerStatus.ACTIVE);
        activePlayer2.setStatus(PlayerStatus.ACTIVE);

        Player notActivePlayer = new Player("notActive", 0);
        notActivePlayer.fold();

        playerList.addPlayer(activePlayer1);
        playerList.addPlayer(activePlayer2);
        playerList.addPlayer(notActivePlayer);

        // when
        List<Player> activePlayers = playerList.filterActivePlayers();

        // then
        assertEquals(2, activePlayers.size(),
                "The filtered list should contain only active players");
        assertTrue(activePlayers.contains(activePlayer1),
                "The filtered list should contain active player 1");
        assertTrue(activePlayers.contains(activePlayer2),
                "The filtered list should contain active player 2");
        assertFalse(activePlayers.contains(notActivePlayer),
                "The filtered list should not contain not active player");
    }

}
