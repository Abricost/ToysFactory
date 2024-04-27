package org.example.exceptions;

public class BladesBlockedException extends RuntimeException{
    private static final String ERROR_MESSAGE = "Блокировка лопастей";
    public BladesBlockedException() {
        super(ERROR_MESSAGE);
    }
}
