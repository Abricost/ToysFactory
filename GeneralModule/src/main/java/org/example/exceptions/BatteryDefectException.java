package org.example.exceptions;

public class BatteryDefectException extends RuntimeException{
    private static final String ERROR_MESSAGE = "Дефектная батарея";
    public BatteryDefectException() {
        super(ERROR_MESSAGE);
    }
}
