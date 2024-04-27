package org.example.toys.remoteControl;

import org.example.interfaces.Blinking;
import org.example.interfaces.Sounding;
import org.example.supply.components.Antenna;
import org.example.supply.components.Battery;
import org.example.supply.components.RadioModule;
import org.example.supply.components.RemoteController;
import org.example.supply.components.enums.BatteryProducer;
import org.example.supply.components.enums.BatteryType;

public class CarSet extends RemoteControlToy implements Blinking, Sounding {
    public static final String VENDOR_CODE = "123_RC";

    public CarSet(String name) {
        super(name);
        device = new Car();
        Antenna antenna = getCar().getAntenna();
        remoteController = new CarRC(antenna);
    }

    public Car getCar() {
        return (Car) device;
    }

    public CarRC getCarRC() {
        return (CarRC) remoteController;
    }

    @Override
    public void checkSignal() throws Exception {
        getCarRC().checkAntenna();
    }

    @Override
    public void blink() {
        System.out.println("  " + name + " моргает фарами");
        getCar().getAntenna().blink();
    }

    @Override
    public void sound() {
        System.out.println("  " + name + " издаёт звук двигателя");
    }

    public class Car extends Device {

        private final Antenna antenna;

        public Car() {
            antenna = new Antenna();
        }

        public Antenna getAntenna() {
            return antenna;
        }

    }
    public class CarRC extends RemoteController {
        private RadioModule radioModule;
        private final Antenna antenna;

        public CarRC(Antenna antenna) {
            super(new Battery(BatteryType.AAA, BatteryProducer.GP));
            radioModule = new RadioModule();
            this.antenna = antenna;
        }

        public RadioModule getRadioModule() {
            return radioModule;
        }

        public void setRadioModule(RadioModule radioModule) {
            this.radioModule = radioModule;
        }

        public void checkAntenna() throws Exception{
            antenna.check();
            for (int i = 0; true; i++) {
                sendRequest();
                try {
                    System.out.println("  " + antenna.sendSerialNumber());
                    break;
                } catch (Exception e) {
                    if (i == 1) throw e;
                    System.out.println("  " + e.getMessage());
                }
            }
            vibration();
        }

    }
}
