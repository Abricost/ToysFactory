package org.example;

import org.example.supply.qualityAssurance.QualityAssuranceSpecialist;
import org.example.toys.SimpleCar;
import org.example.toys.Toy;
import org.example.toys.remoteControl.CarSet;
import org.example.toys.remoteControl.HelicopterSet;
import org.example.toys.stuffedToys.Bear;
import org.example.toys.stuffedToys.Cow;
import org.example.toys.weapons.ordinary.AK47;
import org.example.toys.weapons.ordinary.M16;
import org.example.toys.weapons.water.WaterGun;

public class Main {
    public static void main(String[] args) throws Exception {

        Toy bear = new Bear("My bear");
        Toy cow = new Cow("My cow");
        Toy simpleCar = new SimpleCar("My simple car");
        Toy remoteCar = new CarSet("My RC car");
        Toy heli = new HelicopterSet("My RC heli");
        Toy waterGun = new WaterGun("My water gun");
        Toy ak47 = new AK47("My ak47");
        Toy m16 = new M16("My m16");

        callSpecialist(bear, cow, simpleCar, remoteCar, heli, waterGun, ak47, m16);
    }

    public static void callSpecialist(Toy... toys) throws Exception {
        QualityAssuranceSpecialist specialist = new QualityAssuranceSpecialist();
        for (Toy toy : toys) {
            specialist.checkToy(toy);
        }
    }
}