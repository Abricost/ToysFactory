package org.example.exceptions;

public class AntennaNotFoundException extends RuntimeException{
    private static final String ERROR_MESSAGE = "Антенна не найдена";
    public AntennaNotFoundException() {
        super(ERROR_MESSAGE);
    }
}
