package org.demointernetshop.exception;

public class IsAlreadyExistException extends RuntimeException {

    public IsAlreadyExistException(String message) {
        super(message);
    }
}
