package io.codeforall.bootcamp.filhosdamain;

public class GenieDemon extends Genie {

    private boolean isRecycled;

    public GenieDemon(int numOfWishes) {
        super(numOfWishes);
    }

    @Override
    public void grantWish() {
        if (!isRecycled) {
            super.grantWish();
            System.out.println("👹: HERE IS YOUR WISH BUT IT WON'T BE FREE!!! MWAHAHAHAHA!!!");
            return;
        }
        System.out.println("👹: I HAVE BEEN RECYCLED , CANNOT GRANT MORE WISHES!!");

    }

    public void recycle() {
        if (!isRecycled) {
            System.out.println("👹: YOU RECYCLED MEEE.. NOOOOOOOOO!!!");
            isRecycled = true;
            return;
        }
        System.out.println("👹: I HAVE ALREADY BEEN RECYCLED YOU FOOL!!!");
    }
}


