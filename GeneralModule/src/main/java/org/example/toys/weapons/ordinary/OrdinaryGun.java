package org.example.toys.weapons.ordinary;

import org.example.interfaces.Blinking;
import org.example.interfaces.Sounding;
import org.example.toys.weapons.Gun;

public abstract class OrdinaryGun extends Gun implements Sounding, Blinking {
    public OrdinaryGun(String name) {
        super(name);
    }

    @Override
    public void fire(){
        sound();
        blink();
    }

}
