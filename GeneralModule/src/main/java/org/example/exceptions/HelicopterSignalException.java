package org.example.exceptions;

import org.example.toys.remoteControl.HelicopterSet;

public class HelicopterSignalException extends RuntimeException{
    public HelicopterSignalException(String message, HelicopterSet.Helicopter helicopter) {
        super(message +
                "\n  Дополнительная информация о вертолете:\n  " +
                helicopter.getRadioModule());
    }
}