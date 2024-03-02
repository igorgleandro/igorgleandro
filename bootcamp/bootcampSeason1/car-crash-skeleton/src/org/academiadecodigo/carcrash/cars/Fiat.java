package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.Game;
import org.academiadecodigo.carcrash.field.Position;

<<<<<<< HEAD
public class Fiat extends Car {
=======
public class


Fiat extends Car {
>>>>>>> 50e834e9315388a91e7e383cc07c14749186fa2a
    boolean moveFiat;

    @Override
    public String toString() {
        if (!isCrashed()) {
            return "F";
        } else {
            return "C";
        }
    }

    @Override
    public int velocity() {
       if (moveFiat){
           moveFiat = !moveFiat;
           System.out.println("fiat moves 1");
           return 1;
       }else{
           moveFiat = !moveFiat;
           System.out.println("fiat moves 0");
           return 0;
       }
    }

}

