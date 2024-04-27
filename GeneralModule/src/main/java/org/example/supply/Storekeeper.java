package org.example.supply;

import org.example.supply.components.Battery;

public class Storekeeper {
    public static Battery replaceBattery(Battery battery) {
        System.out.println("  " + "Выдать батарейку");
        return new Battery(battery.getType(), battery.getProducer());
    }
}
