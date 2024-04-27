package org.example.exceptions;

public class RotorBlockedException extends RuntimeException{
    private static final String ERROR_MESSAGE = "Блокировка ротора";
    public RotorBlockedException() {
        super(ERROR_MESSAGE);
    }
}
