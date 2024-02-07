package io.codeforall.bootcamp.filhosdamain;

public class GenieGrumpy extends Genie {

    private boolean isGranted;

    public GenieGrumpy(int numOfWishes) {
        super(numOfWishes);
    }

    @Override
    public void grantWish() {
        if (!isGranted) {
            super.grantWish();
            isGranted = !isGranted;
            System.out.println("😾: YOUR ONLY WISH HAS BEEN GRANTED!!");
        } else {
            System.out.println("😾: NO MORE WISHES!!! GO AWAY!!");
        }
    }
}