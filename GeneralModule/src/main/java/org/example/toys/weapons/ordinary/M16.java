package org.example.toys.weapons.ordinary;

public class M16 extends OrdinaryGun{
    public static final String VENDOR_CODE = "m_16";
    public M16(String name) {
        super(name);
    }

    @Override
    public void blink(){
        System.out.println("  " + name + " моргает белым фонариком");
    }

    @Override
    public void sound() {
        System.out.println("  " + name + " издаёт звук стрельбы М16");
    }
}
