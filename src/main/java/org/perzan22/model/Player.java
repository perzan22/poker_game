package org.perzan22.model;

import org.perzan22.exceptions.MaxCardInHandException;
import org.perzan22.exceptions.NotEnoughChipsException;

import java.util.ArrayList;

public class Player {

    // class variables

    private String name;
    private ArrayList<Card> holeCards;
    private int chips;
    private PlayerStatus status;
    private boolean isSmallBlind;
    private boolean isBigBlind;
    private int playerBetAmount;


    // constructor
    public Player(String name, int chips) {
        this.name = name;
        this.chips = chips;
        this.holeCards = new ArrayList<>(2);
        this.status = PlayerStatus.INACTIVE;
        this.isSmallBlind = false;
        this.isBigBlind = false;
        this.playerBetAmount = 0;
    }

    // class logic

    // draw card form deck
    public void drawCardToHand(Card card) {
        if (holeCards.size() >= 2) {
            throw new MaxCardInHandException("Player can't draw more than 2 Cards in one round");
        }
        holeCards.add(card);
    }

    // subtract player's chips when he bet
    public void subtractChips(int bet) {
        if (chips >= bet) {
            chips -= bet;
        } else {
            throw new NotEnoughChipsException("Player doesn't have enough chips");
        }
    }

    // after round reset holeCards
    public void resetHand() {
        holeCards.clear();
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public ArrayList<Card> getHoleCards() {
        return holeCards;
    }

    public void setHoleCards(ArrayList<Card> holeCards) {
        this.holeCards = holeCards;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    public boolean isSmallBlind() {
        return isSmallBlind;
    }

    public void setSmallBlind(boolean smallBlind) {
        isSmallBlind = smallBlind;
    }

    public boolean isBigBlind() {
        return isBigBlind;
    }

    public void setBigBlind(boolean bigBlind) {
        isBigBlind = bigBlind;
    }

    public int getPlayerBetAmount() {
        return playerBetAmount;
    }

    public void setPlayerBetAmount(int playerBetAmount) {
        this.playerBetAmount = playerBetAmount;
    }

    // toString() method

    @Override
    public String toString() {
        return "Player " + name + " is " + status + ". Player has " + holeCards.size()
                + " Cards in Hand: " + holeCards + " Tokens: " + chips;
    }
}
