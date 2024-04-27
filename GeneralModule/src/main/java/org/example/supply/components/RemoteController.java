package org.example.supply.components;

public class RemoteController {
    private Battery battery;

    public RemoteController(Battery battery) {
        this.battery = battery;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public void vibration() {
        System.out.println("  " + "Пульт вибрирует");
    }

    public void sendRequest() {
        System.out.println("  " + "Отправляем широкополосный запрос");
    }

}
