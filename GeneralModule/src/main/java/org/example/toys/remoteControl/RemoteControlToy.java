package org.example.toys.remoteControl;

import org.example.supply.components.RemoteController;
import org.example.toys.Toy;

public abstract class RemoteControlToy extends Toy {
    protected RemoteController remoteController;
    protected Device device;

    public RemoteControlToy(String name) {
        super(name);
    }

    public RemoteController getRemoteController() {
        return remoteController;
    }

    public Device getDevice() {
        return device;
    }

    public abstract void checkSignal() throws Exception;
}
