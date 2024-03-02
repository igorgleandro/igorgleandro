package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.Game;
import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

abstract public class Car {


    /**
     * The position of the car on the grid
     */
    private Position pos;
    private boolean crashChecker;

    public Car() {
        this.pos = new Position();
        System.out.println("Car created");
    }

    public Position getPos() {
<<<<<<< HEAD
        return pos;
=======
        return pos; // Pos
>>>>>>> 50e834e9315388a91e7e383cc07c14749186fa2a
    }

    public boolean isCrashed() {
        return crashChecker;
    }

    public void move() {

        int num = ((int) Math.floor(Math.random() * 4));

        if (!isCrashed()) {
            int counter = 1;

            for (int j = 0; j < counter; j++) {
                if (num == (0) || num == (1) && (velocity() != 0)) {

                    if (num == 0 && pos.getCol() + velocity() < (Field.getWidth() - 1)) {
                        pos.setCol(pos.getCol() + velocity());
                    } else if (pos.getRow() + velocity() < (Field.getHeight() - 1)) {
                        pos.setRow(pos.getRow() + velocity());
                    }
                }
            }
        }

        if (!isCrashed()) {
            int counter = 1;
            for (int j = 0; j < counter; j++) {
                if (num == (2) || num == (3) && (velocity() != 0)) {

                    if (num == 2 && pos.getCol() - velocity() > 0) {
                        pos.setCol(pos.getCol() - velocity());
                    } else if (pos.getRow() - velocity() > 0) {
                        pos.setRow(pos.getRow() - velocity());

                    }
                }
            }
        }
    }

    public void setCrashChecker() {
        this.crashChecker = true;
    }

    public abstract int velocity();
}






