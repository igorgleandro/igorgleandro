package io.codeforall.bootcamp;

public enum RockPaperScissorGenerator {
    ROCK,
    PAPER,
    SCISSOR;

    public RockPaperScissorGenerator generatedNumber;

    private RockPaperScissorGenerator() {
    }

    public static RockPaperScissorGenerator randomPlay() {
        return values()[(int)(Math.random() * RockPaperScissorGenerator.values().length)];
    }
}
