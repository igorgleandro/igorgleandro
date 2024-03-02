package io.codeforall.bootcamp;

public class Player {
    private String name;
    public Player(String name){
        this.name = name;

    }

    public static RockPaperScissorGenerator getRandomPlay() {
        return RockPaperScissorGenerator.randomPlay();
    }
}

