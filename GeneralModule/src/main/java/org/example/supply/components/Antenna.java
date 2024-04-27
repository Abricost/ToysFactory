package org.example.supply.components;

import org.example.exceptions.AntennaNotFoundException;
import org.example.exceptions.AntennaNumberDefectException;
import org.example.exceptions.BatteryDefectException;
import org.example.interfaces.Blinking;

import java.util.UUID;

public class Antenna implements Blinking {

    private final String serialNumber = UUID.randomUUID().toString();

    public String sendSerialNumber() throws Exception{
        double random = Math.random();
        if (random < 0.33) {
            throw new AntennaNotFoundException();
        } else if (random < 0.66) {
            throw new AntennaNumberDefectException();
        } else {
            return serialNumber;
        }
    }

    @Override
    public void blink() {
        System.out.println("  " + "Антенна моргает лампочкой");
    }

    public void check() {
        if (Math.random() < 0.5) {
            throw new BatteryDefectException();
        }
    }
}
