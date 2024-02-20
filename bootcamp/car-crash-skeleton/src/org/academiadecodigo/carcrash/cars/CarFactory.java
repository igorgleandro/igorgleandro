package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.Game;

public class CarFactory {

    public static Car getNewCar() {

        int randomNum = (int) Math.ceil(Math.random() * 10);
        System.out.println(randomNum);
        if (randomNum % 2 == 0) {
            Car car = new Fiat();
            return car;
        } else {
            Car car = new Mustang();
            return car;
        }
    }
}
