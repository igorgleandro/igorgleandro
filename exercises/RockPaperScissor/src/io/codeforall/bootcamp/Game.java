package io.codeforall.bootcamp;

public class Game {

    private int gameCounter;
    private Player player;
    private Player player1;
    private String name = "Sofia Game Master";

    public void gameStart(Player player, Player player1){

        this.player= player;
        this.player1 = player1;

        RockPaperScissorGenerator.randomPlay();


        }
    }

