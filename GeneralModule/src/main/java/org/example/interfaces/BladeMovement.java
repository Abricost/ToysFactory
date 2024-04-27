package org.example.interfaces;

public interface BladeMovement {
    default void moveBlades() {
        System.out.println("Движение лопастей");
    }
}
