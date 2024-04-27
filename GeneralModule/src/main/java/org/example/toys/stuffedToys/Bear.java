package org.example.toys.stuffedToys;

import org.example.interfaces.Sounding;
import org.example.supply.components.enums.FillerType;
import org.example.toys.Toy;

public class Bear extends Toy implements Sounding {

    public static final String VENDOR_CODE = "soft_bear";
    static final FillerType FILLER_TYPE = FillerType.SINTEPON;

    public Bear(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("  " + "Рычание медведя " + name);
    }

}
