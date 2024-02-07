package io.codeforall.bootcamp;

public enum RockPaperScissorGenerator {
    ROCK,
    PAPER,
    SCISSOR;

    public RockPaperScissorGenerator generatedNumber;

    public static RockPaperScissorGenerator randomPlay() {
         return RockPaperScissorGenerator.values()[(int)(Math.random()*3)];



    }
}


















