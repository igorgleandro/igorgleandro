package io.codeforall.bootcamp;

public class Rng {
    public Rng() {
    }

    public static int randomNumberGenerator() {
        int randomNumb = (int)Math.ceil(Math.random() * 20.0);
        return randomNumb;
    }
}
