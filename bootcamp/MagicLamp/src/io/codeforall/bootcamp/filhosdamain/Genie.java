package io.codeforall.bootcamp.filhosdamain;

public class Genie {

    private int numOfWishes;

    public Genie(int numOfWishes){
        this.numOfWishes = numOfWishes;
    }

    public int getNumOfWishes() {
        return numOfWishes;
    }

    public void grantWish(){
            numOfWishes--;
    }

}
