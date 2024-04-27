package org.example.supply.qualityAssurance;

import org.example.exceptions.BatteryDefectException;
import org.example.interfaces.Blinking;
import org.example.interfaces.Sounding;
import org.example.supply.Storekeeper;
import org.example.supply.components.Battery;
import org.example.supply.components.RemoteController;
import org.example.toys.Toy;
import org.example.toys.remoteControl.RemoteControlToy;
import org.example.toys.weapons.Gun;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class QualityAssuranceSpecialist {
    private final List<String> methodsToCheck = List.of("sound", "blink", "fire");

    public void checkToy(Toy toy) throws Exception {
        final String delimiter = "#############################";
        System.out.println(delimiter);

        printFieldInfo(toy);

        for (String method : methodsToCheck) {
            if (hasMethod(toy, method)) {
                System.out.println("Function: " + method);
            }
        }

        if (toy instanceof Blinking) {
            System.out.println("Начинаем проверку света:");
            ((Blinking) toy).blink();
        }
        if (toy instanceof Sounding) {
            System.out.println("Начинаем проверку звука:");
            ((Sounding) toy).sound();
        }
        if (toy instanceof Gun) {
            System.out.println("Начинаем проверку стрельбы:");
            ((Gun) toy).fire();
        }

        if (toy instanceof RemoteControlToy) {
            System.out.println("Начинаем проверку сигнала:");
            try {
                ((RemoteControlToy) toy).checkSignal();
            } catch (BatteryDefectException e) {
                RemoteController remoteController = ((RemoteControlToy) toy).getRemoteController();
                Battery battery = Storekeeper.replaceBattery(remoteController.getBattery());
                remoteController.setBattery(battery);
                System.out.println("  " + "батарейка заменена");
                printFieldInfo(toy);
            } catch (Exception e) {
//                if (toy instanceof HelicopterSet) {
////                    System.out.println("  " + "Дополнительная информация о вертолете:");
////                    System.out.println("  " + ((HelicopterSet) toy).getHelicopter().getRadioModule());
//                }
                System.out.println("  " + e.getMessage());
            }

        }

        System.out.println(delimiter + "\n");
    }

    public boolean hasMethod(Toy toy, String method) {
        Method[] methods = toy.getClass().getMethods();
        for (Method m : methods) {
            if (m.getName().equals(method)) {
                return true;
            }
        }
        return false;
    }

    public void printFieldInfo(Toy toy) throws IllegalAccessException {
        Field[] fields = toy.getClass().getFields();
        for (Field field : fields) {
            System.out.println(field.getName() + ": " + field.get(toy));
        }
    }
}
