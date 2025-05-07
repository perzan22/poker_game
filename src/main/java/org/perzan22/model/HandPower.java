package org.perzan22.model;

public class HandPower {

    private HandRank handRank;
    private int power;

    public HandPower(HandRank handRank, int power) {
        this.handRank = handRank;
        this.power = power;
    }

    public HandRank getHandRank() {
        return handRank;
    }

    public int getPower() {
        return power;
    }
}
