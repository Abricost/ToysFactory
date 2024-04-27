package org.example.toys.weapons;

import org.example.toys.Toy;

public abstract class Gun extends Toy {

    public Gun(String name) {
        super(name);
    }

    public abstract void fire();
}
