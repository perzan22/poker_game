package org.perzan22.pokergame.engine;

import org.perzan22.pokergame.model.card.Card;
import org.perzan22.pokergame.model.HandPower;
import org.perzan22.pokergame.model.card.Suit;

import java.util.*;
import java.util.stream.Collectors;

public class HandEvaluator {

    public HandEvaluator() {

    }

    public HandPower evaluateHand(List<Card> communityCards, List<Card> holeCards) {
        List<Card> hand = new ArrayList<>(communityCards);
        hand.addAll(holeCards);

        return null;
    }

    private Card isFlush(List<Card> hand) {
        Optional<Card> highCard = Arrays.stream(Suit.values())
                .map(suit ->
                        hand.stream()
                                .filter(card -> card.getSuit() == suit)
                                .sorted(Comparator.comparing(Card::getRank).reversed())
                                .toList()
                )
                .filter(suitGroup -> suitGroup.size() >= 5)
                .map(List::getFirst)
                .findFirst();

        return highCard.orElse(null);
    }

    private int isStraight(List<Card> hand) {

        Set<Integer> uniqueRanks = hand.stream()
                .map(card -> card.getRank().getValue())
                .collect(Collectors.toSet());

        if (uniqueRanks.contains(14)) {
            uniqueRanks.add(1);
        }

        List<Integer> sortedRanks = new ArrayList<>(uniqueRanks);
        Collections.sort(sortedRanks);

        boolean isStraight = false;
        int count = 1;
        for (int i = 1; i < sortedRanks.size(); i++) {
            if (sortedRanks.get(i) == sortedRanks.get(i - 1) + 1) {
                count++;
                if (count == 5) {isStraight = true;}
            } else {
                count = 1;
            }
        }

        if (isStraight) {
            return sortedRanks.getFirst();
        }
        return 0;
    }
}
