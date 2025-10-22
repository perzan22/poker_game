package org.perzan22.pokergame.engine;

import org.perzan22.pokergame.model.card.Card;
import org.perzan22.pokergame.model.card.Deck;
import org.perzan22.pokergame.round.Round;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    // class variables
    private int pot;    // refers to cumulative money on the table
    private Round round;
    private List<Card> communityCards;
    private int wager; // refers to actual bet players need to call
    private int smallBlind;
    private int bigBlind;
    private int currentPlayerIndex;
    private Deck deck;

    // constructor
    public GameState(int bigBlind, int smallBlind) {
        pot = 0;
        round = null;
        communityCards = new ArrayList<>();
        wager = 0;
        this.bigBlind = bigBlind;
        this.smallBlind = smallBlind;
        this.currentPlayerIndex = 0;
        this.deck = new Deck();
    }

    // class logic

    // add player bet to the table pot
    public void addToPot(int bet) {
        pot += bet;
    }

    // draw community card
    public void drawCommunityCard(Card card) {
        communityCards.add(card);
    }

    public void moveToNextPlayer(int activePlayersSize) {
        currentPlayerIndex = (currentPlayerIndex + 1) % activePlayersSize;
    }

    // getters and setters

    public int getPot() {
        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public int getWager() {
        return wager;
    }

    public void setWager(int wager) {
        this.wager = wager;
    }

    public List<Card> getCommunityCards() {
        return communityCards;
    }

    public void setCommunityCards(List<Card> communityCards) {
        this.communityCards = communityCards;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public int getSmallBlind() {
        return smallBlind;
    }

    public void setSmallBlind(int smallBlind) {
        this.smallBlind = smallBlind;
    }

    public int getBigBlind() {
        return bigBlind;
    }

    public void setBigBlind(int bigBlind) {
        this.bigBlind = bigBlind;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public Deck getDeck() {
        return deck;
    }
}
