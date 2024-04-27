package org.example.exceptions;

public class EngineBlockedException extends RuntimeException{
    private static final String ERROR_MESSAGE = "Блокировка двигателя";
    public EngineBlockedException() {
        super(ERROR_MESSAGE);
    }
}