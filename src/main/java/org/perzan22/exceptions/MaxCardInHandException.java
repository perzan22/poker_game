package org.perzan22.exceptions;

public class MaxCardInHandException extends RuntimeException {
    public MaxCardInHandException(String message) {
        super(message);
    }
}
