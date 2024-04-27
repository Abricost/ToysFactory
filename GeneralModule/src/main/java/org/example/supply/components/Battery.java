package org.example.supply.components;

import org.example.supply.components.enums.BatteryProducer;
import org.example.supply.components.enums.BatteryType;

public class Battery {
    private BatteryProducer producer;
    private BatteryType type;

    private double voltage;

    public Battery() {
        this.producer = BatteryProducer.GP;
        this.type = BatteryType.AAA;
        voltage = Math.random();
    }
    public Battery(BatteryType type, BatteryProducer producer) {
        this.producer = producer;
        this.type = type;
    }

    public BatteryProducer getProducer() {
        return producer;
    }

    public BatteryType getType() {
        return type;
    }

    public double getVoltage() {
        return voltage;
    }

    public void push() {
        if (getType().equals(BatteryType.Crona)) {
            System.out.println("  " + "Текущее напряжение " + getVoltage());
        }
    }
}
