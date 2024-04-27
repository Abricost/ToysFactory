package org.example.supply.components;

import org.example.exceptions.BatteryDefectException;

public class RadioModule {

    public void check() {
        if (Math.random() < 0.5) {
            throw new BatteryDefectException();
        }
    }

    @Override
    public String toString() {
        return "RadioModule{}";
    }
}
