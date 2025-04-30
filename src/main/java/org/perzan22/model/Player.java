package org.perzan22.model;

import org.perzan22.exceptions.MaxCardInHandException;

import java.util.ArrayList;

public class Player {

    // class variables

    private String name;
    private ArrayList<Card> hand;
    private int chips;
    private PlayerStatus status;

    // constructor
    public Player(String name, int chips) {
        this.name = name;
        this.chips = chips;
        this.hand = new ArrayList<>(2);
        this.status = PlayerStatus.INACTIVE;
    }

    // class logic

    // draw card form deck
    public void drawCardToHand(Card card) {
        if (hand.size() >= 2) {
            throw new MaxCardInHandException("Player can't draw more than 2 Cards in one round");
        }
        hand.add(card);
    }

    // after round reset hand
    public void resetHand() {
        hand.clear();
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

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    // toString() method

    @Override
    public String toString() {
        return "Player " + name + " is " + status + ". Player has " + hand.size()
                + " Cards in Hand: " + hand + " Tokens: " + chips;
    }
}
