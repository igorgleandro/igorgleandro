package org.academiadecodigo.carcrash;

import org.academiadecodigo.carcrash.cars.Car;
import org.academiadecodigo.carcrash.cars.CarFactory;
import org.academiadecodigo.carcrash.field.Field;

public class Game {

    public static final int MANUFACTURED_CARS = 20;

    /**
     * Container of Cars
     */
    private Car[] cars;

    /**
     * Animation delay
     */
    private int delay;

    public Game(int cols, int rows, int delay) {

        Field.init(cols, rows);
        this.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        cars = new Car[MANUFACTURED_CARS];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = CarFactory.getNewCar();
        }

        Field.draw(cars);

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            Thread.sleep(delay);
            moveAllCars();
            Field.draw(cars);

        }

    }

    private void moveAllCars() {
        for (int i = 0; i < cars.length; i++) {
            cars[i].move();

            int getPosRow = cars[i].getPos().getRow();
            int getPosCol = cars[i].getPos().getCol();

            for (int j = 0; j < cars.length; j++) {
                if ((getPosRow == cars[j].getPos().getRow()) && (getPosCol == cars[j].getPos().getCol()) && (i != j)) {
                    cars[i].setCrashChecker();
                    cars[j].setCrashChecker();
                }

            }
        }
    }
}



