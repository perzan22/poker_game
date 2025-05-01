import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.perzan22.model.Player;
import org.perzan22.model.PlayerList;

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

}
