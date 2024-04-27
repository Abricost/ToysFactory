package org.example.toys;

import org.example.interfaces.Blinking;
import org.example.interfaces.Sounding;

public class SimpleCar extends Toy implements Sounding, Blinking{
    public static final String VENDOR_CODE = "simple_car";
    public SimpleCar(String name) {
        super(name);
    }

    @Override
    public void blink() {
        System.out.println("  " + name + " моргает фарами");
    }

    @Override
    public void sound() {
        System.out.println("  " + name + " издает звук клаксона");
    }
}
