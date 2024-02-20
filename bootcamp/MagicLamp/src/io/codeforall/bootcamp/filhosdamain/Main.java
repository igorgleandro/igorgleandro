package io.codeforall.bootcamp.filhosdamain;

public class Main {
    public static void main(String[] args) {

        MagicLamp magicLamp = new MagicLamp(2);
        Genie genie = magicLamp.rubLamp();
        genie.grantWish();
        genie.grantWish();
        genie.grantWish();
        genie.grantWish();
        genie.grantWish();
        genie = magicLamp.rubLamp();
        genie.grantWish();
        genie = magicLamp.rubLamp();
        genie.grantWish();
        genie = magicLamp.rubLamp();
        genie.grantWish();
        magicLamp.recycle(genie);
        genie = magicLamp.rubLamp();
        genie.grantWish();
        magicLamp.recycle(genie);
        MagicLamp magicLamp1 = new MagicLamp(2);
        MagicLamp magicLamp2 = new MagicLamp(2);

        magicLamp1.compareLamps(magicLamp1,magicLamp);





    }
}
