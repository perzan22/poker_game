package org.perzan22.pokergame.model;

public enum HandRank {

    HIGHCARD(1), PAIR(2), TWOPAIRS(3),
    THREE(4), STRAIGHT(5), FLUSH(6),
    FULL(7), FOUR(8), STRAIGHTFLUSH(9), ROYALFLUSH(10);

    private final int handPower;

    HandRank(int handPower) {
        this.handPower = handPower;
    }

    public int getHandPower() {
        return handPower;
    }
}
