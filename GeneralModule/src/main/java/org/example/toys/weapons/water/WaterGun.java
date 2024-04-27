package org.example.toys.weapons.water;

import org.example.toys.weapons.Gun;

public class WaterGun extends Gun {
    public WaterGun(String name) {
        super(name);
    }

    @Override
    public void fire() {
        System.out.println("  " + name + " стреляет водой");
    }
}
