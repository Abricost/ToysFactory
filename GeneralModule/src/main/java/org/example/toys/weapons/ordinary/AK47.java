package org.example.toys.weapons.ordinary;

public class AK47 extends OrdinaryGun{
    public static final String VENDOR_CODE = "ak_47";
    public AK47(String name) {
        super(name);
    }

    @Override
    public void blink() {
        System.out.println("  " + name + " моргает красным фонариком");
    }

    @Override
    public void sound() {
        System.out.println("  " + name + " издаёт звук стрельбы АК47");
    }
}
