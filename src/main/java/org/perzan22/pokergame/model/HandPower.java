package org.perzan22.pokergame.model;

public class HandPower implements Comparable<HandPower>{

    private final HandRank handRank;
    private final int power;

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

    @Override
    public int compareTo(HandPower o) {
        if (this.handRank.getHandPower() > o.handRank.getHandPower()) {
            return 1;
        } else if (this.handRank.getHandPower() < o.handRank.getHandPower()) {
            return -1;
        } else {
            return Integer.compare(this.power, o.power);
        }
    }
}
