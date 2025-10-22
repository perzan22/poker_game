package org.perzan22.pokergame.exceptions;

public class MaxCardInHandException extends RuntimeException {
    public MaxCardInHandException(String message) {
        super(message);
    }
}
