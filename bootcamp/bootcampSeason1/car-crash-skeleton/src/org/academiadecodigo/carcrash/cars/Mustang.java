package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

public class Mustang extends Car{

    @Override
    public String toString(){
        if(!isCrashed()){
        return "M";}
        else { return "C";}
    }
    @Override
    public int velocity() {
        System.out.println(" mustang moves 1 ");
        return 1;
    }
}
