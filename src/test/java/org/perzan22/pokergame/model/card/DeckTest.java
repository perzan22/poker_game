package org.perzan22.pokergame.model.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {


    private Deck deck;

    // create deck before each test
    @BeforeEach
    public void setUp() {
        deck = new Deck();
    }

    @Test
    public void testCreateAndShuffleDeck_newDeck_deckContainsEveryCard() {
        // when
        // deck created in setUp() method

        //then
        assertEquals(52, deck.size(), "Deck should contains 52 cards");
    }

    @Test
    public void testShuffleDeck_deckNotEmpty_shuffledDeck() {
        // given
        List<Card> deckBeforeShuffle = new ArrayList<>(deck.getDeck());

        // when
        deck.shuffle();

        // then
        List<Card> deckAfterShuffle = new ArrayList<>(deck.getDeck());
        assertNotEquals(deckBeforeShuffle, deckAfterShuffle, "Deck before shuffle should be different after shuffle");
    }

    @Test
    public void testDrawCard_deckNotEmpty_cardDrawn() {
        // when
        Card drawnCard = deck.drawCard();

        // then
        assertNotNull(drawnCard, "Drawn card shouldn't be null");
        assertEquals(51, deck.size(), "Deck should contain one less card after draw");
    }

    @Test
    public void testShuffleDeck_emptyDeck_throwIllegalStateException() {
        // given
        deck.getDeck().clear();

        // then
        assertThrows(IllegalStateException.class, () -> deck.shuffle(), "Empty deck should throw exception.");
    }

    @Test
    public void testDrawCard_emptyDeck_throwIllegalStateException() {
        // given
        deck.getDeck().clear();

        // then
        assertThrows(IllegalStateException.class, () -> deck.drawCard(), "Empty deck should throw exception.");
    }

    @Test
    public void testResetDeck_deck_deckAfterReset() {
        // given
        Deque<Card> deckBeforeReset = new ArrayDeque<>(deck.getDeck());

        // when
        deck.resetDeck();

        // then
        assertNotEquals(deck.getDeck(), deckBeforeReset, "Deck should be different after reset");
        assertNotNull(deck.getDeck(), "Deck should not be null");
    }

}
