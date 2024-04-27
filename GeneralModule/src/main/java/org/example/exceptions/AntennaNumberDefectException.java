package org.example.exceptions;

public class AntennaNumberDefectException extends RuntimeException{
    private static final String ERROR_MESSAGE = "Дефектный номер";
    public AntennaNumberDefectException() {
        super(ERROR_MESSAGE);
    }
}
