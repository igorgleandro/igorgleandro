package io.codeforall.bootcamp;

public class Player {
    public String name;
    private int currentGuess;

    public Player(String name) {
        this.name = name;
    }

    public int getCurrentGuess() {
        return this.currentGuess;
    }

    public int generateCurrentGuess() {
        this.currentGuess = Rng.randomNumberGenerator();
        return this.currentGuess;
    }
}

