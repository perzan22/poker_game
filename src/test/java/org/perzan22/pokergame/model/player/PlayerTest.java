package org.perzan22.pokergame.model.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.perzan22.pokergame.exceptions.MaxCardInHandException;
import org.perzan22.pokergame.exceptions.NotEnoughChipsException;
import org.perzan22.pokergame.model.card.Card;

import static org.junit.jupiter.api.Assertions.*;
import static org.perzan22.pokergame.model.card.Rank.ACE;
import static org.perzan22.pokergame.model.card.Rank.KING;
import static org.perzan22.pokergame.model.card.Suit.CLUBS;
import static org.perzan22.pokergame.model.card.Suit.HEARTS;

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
        assertEquals(1, player.getHoleCards().size(), "Player should have one card");
        assertEquals(card, player.getHoleCards().getFirst(), "Player should have same card as he drawn");
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
        assertEquals(2, player.getHoleCards().size(), "Player should have two cards");
        assertEquals(card1, player.getHoleCards().getFirst(), "Player should have same card as he drawn");
        assertEquals(card2, player.getHoleCards().get(1), "Player should have same card as he drawn");
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
        assertEquals(0, player.getHoleCards().size(), "Player should have zero cards");
        assertNotNull(player.getHoleCards(), "Player should have hand");
    }

    @Test
    public void testSubtractChips_enoughChipsToBet_subtractedBetFromPlayerChips() {
        // given
        player.setChips(100);

        // when
        player.subtractChips(50);

        // then
        assertEquals(50, player.getChips(), "Player should have 50 chips after subtraction");
    }

    @Test
    public void testSubtractChips_notEnoughChipsToBet_throwsNotEnoughChipsException() {
        // given
        player.setChips(100);

        // then
        assertThrows(NotEnoughChipsException.class, () -> player.subtractChips(150),
                "Should throw NotEnoughChipsException after subtracting too much chips");
    }

    @Test
    public void testFold_playerIsActive_playerBecomesFolded() {
        // given
        player.setStatus(PlayerStatus.ACTIVE);

        // when
        player.fold();

        // then
        assertSame(PlayerStatus.FOLDED, player.getStatus(), "Player should be folded after calling fold()");
    }

    @Test
    public void testAllIn_playerIsActive_playerBecomesAllIn() {
        // given
        player.setStatus(PlayerStatus.ACTIVE);

        // when
        player.allIn();

        // then
        assertSame(PlayerStatus.ALLIN, player.getStatus(), "Player should be ALL_IN after calling allIn()");
    }
}
