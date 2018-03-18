package com.wawcode.smogue.domain.exception;

public class SmogueException extends Exception {
    public SmogueException() {
        super();
    }

    public SmogueException(String message) {
        super(message);
    }

    public SmogueException(String message, Throwable cause) {
        super(message, cause);
    }

    public SmogueException(Throwable cause) {
        super(cause);
    }
}
