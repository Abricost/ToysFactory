package org.example.toys.remoteControl;

import org.example.exceptions.BladesBlockedException;
import org.example.exceptions.EngineBlockedException;
import org.example.exceptions.HelicopterSignalException;
import org.example.exceptions.RotorBlockedException;
import org.example.interfaces.BladeMovement;
import org.example.supply.components.Battery;
import org.example.supply.components.Chip;
import org.example.supply.components.RadioModule;
import org.example.supply.components.RemoteController;
import org.example.supply.components.enums.BatteryProducer;
import org.example.supply.components.enums.BatteryType;

public class HelicopterSet extends RemoteControlToy {
    public static final String VENDOR_CODE = "123_H_RC";

    public HelicopterSet(String name) {
        super(name);
        device = new Helicopter();
        remoteController = new HelicopterRC(getHelicopter());
    }

    public Helicopter getHelicopter() {
        return (Helicopter) device;
    }

    public HelicopterRC getHelicopterRC() {
        return (HelicopterRC) remoteController;
    }

    @Override
    public void checkSignal() throws Exception {
        getHelicopterRC().checkRadioModule();
    }

    public class Helicopter extends Device implements BladeMovement {

        private RadioModule radioModule;

        public Helicopter() {
            radioModule = new RadioModule();
        }

        @Override
        public void moveBlades() {
            double random = Math.random();
            if (random <= 0.25) {
                throw new BladesBlockedException();
            } else if (random <= 0.5) {
                throw new RotorBlockedException();
            } else if (random <= 0.75) {
                throw new EngineBlockedException();
            } else {
                System.out.println("  " + "Движение лопастей");
            }
        }

        public RadioModule getRadioModule() {
            return radioModule;
        }

        public void setRadioModule(RadioModule radioModule) {
            this.radioModule = radioModule;
        }

    }

    class HelicopterRC extends RemoteController {
        private Chip chip;
        private final Helicopter helicopter;

        public HelicopterRC(Helicopter helicopter) {
            super(new Battery(BatteryType.AA, BatteryProducer.GP));
            chip = new Chip();
            this.helicopter = helicopter;
        }

        public Chip getChip() {
            return chip;
        }

        public void setChip(Chip chip) {
            this.chip = chip;
        }

        public void checkRadioModule() throws Exception{
            try {
                helicopter.getRadioModule().check();
            } catch (Exception e) {
                System.out.println("  " + e.getMessage());
                throw e;
            }
            sendRequest();
            try {
                helicopter.moveBlades();
            } catch (RotorBlockedException | BladesBlockedException e) {
                vibration();
                throw new HelicopterSignalException(e.getMessage(), helicopter);
            } catch (EngineBlockedException e) {
                vibration();
                vibration();
                vibration();
                throw new HelicopterSignalException(e.getMessage(), helicopter);
            }

        }

    }
}
