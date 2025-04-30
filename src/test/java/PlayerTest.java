import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.perzan22.exceptions.MaxCardInHandException;
import org.perzan22.model.Card;
import org.perzan22.model.Player;

import static org.junit.jupiter.api.Assertions.*;
import static org.perzan22.model.Rank.ACE;
import static org.perzan22.model.Rank.KING;
import static org.perzan22.model.Suit.CLUBS;
import static org.perzan22.model.Suit.HEARTS;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("TestPlayer", 0);
    }

    @Test
    public void testDrawCard_lessThanTwoCards_addedOneCard() {
        // given
        Card card = new Card(ACE, CLUBS);

        // when
        player.drawCardToHand(card);

        // then
        assertEquals(1, player.getHand().size(), "Player should have one card");
        assertEquals(card, player.getHand().getFirst(), "Player should have same card as he drawn");
    }

    @Test
    public void testDrawCard_oneCardAdded_addedTwoCards() {
        // given
        Card card1 = new Card(ACE, CLUBS);
        Card card2 = new Card(KING, CLUBS);
        player.drawCardToHand(card1);

        // when
        player.drawCardToHand(card2);

        // then
        assertEquals(2, player.getHand().size(), "Player should have two cards");
        assertEquals(card1, player.getHand().getFirst(), "Player should have same card as he drawn");
        assertEquals(card2, player.getHand().get(1), "Player should have same card as he drawn");
    }

    @Test
    public void testDrawCard_twoCardsInHand_throwsMaxCardInHandException() {
        // given
        Card card1 = new Card(ACE, CLUBS);
        Card card2 = new Card(KING, CLUBS);
        Card card3 = new Card(ACE, HEARTS);
        player.drawCardToHand(card1);
        player.drawCardToHand(card2);


        // then
        assertThrows(
                MaxCardInHandException.class,
                () -> player.drawCardToHand(card3),
                "Player can't have 3 cards in hand, it should throw exception"
        );
    }

    @Test
    public void testResetHand_fullHand_clearHand() {
        // given
        Card card1 = new Card(ACE, CLUBS);
        Card card2 = new Card(KING, CLUBS);
        player.drawCardToHand(card1);
        player.drawCardToHand(card2);

        // when
        player.resetHand();

        // then
        assertEquals(0, player.getHand().size(), "Player should have zero cards");
        assertNotNull(player.getHand(), "Player should have hand");
    }
}
