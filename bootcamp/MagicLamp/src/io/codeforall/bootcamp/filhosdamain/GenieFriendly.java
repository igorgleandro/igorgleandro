package io.codeforall.bootcamp.filhosdamain;

public class GenieFriendly extends Genie {


    public GenieFriendly(int numOfWishes) {
        super(numOfWishes);
    }

    @Override
    public void grantWish() {
        if (getNumOfWishes() > 0) {
            super.grantWish();
            System.out.println("🦄: Here it is.. Your wish my friend :)");
        } else {
            System.out.println("🦄: I'm sorry... I cannot grant any more wishes :(");
        }
    }
}
