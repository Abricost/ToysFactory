package org.example.toys.stuffedToys;

import org.example.interfaces.Sounding;
import org.example.supply.components.enums.FillerType;
import org.example.toys.Toy;

public class Cow extends Toy implements Sounding {

    public static final String VENDOR_CODE = "soft_cow";
    static final FillerType FILLER_TYPE = FillerType.SINTEPUH;

    public Cow(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("  " + "Мычание коровы " + name);
    }

}
