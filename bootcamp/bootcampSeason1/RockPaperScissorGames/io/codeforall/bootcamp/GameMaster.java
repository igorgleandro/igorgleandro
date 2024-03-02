package io.codeforall.bootcamp;

import static io.codeforall.bootcamp.RockPaperScissorGenerator.*;

public class GameMaster {
    private static int gameCounter = 0;
    private Player player;
    private Player player1;
    private String name = "Sofia Game Master";
    private RockPaperScissorGenerator guess;
    private RockPaperScissorGenerator guess1;
    private static int score;
    private static int score1;
    public GameMaster() {

    }

    public void gameStart(Player player, Player player1) {
        this.player = player;
        this.player1 = player1;

        System.out.println("Welcome to the game,RockPaperScissor!");
        System.out.println("let´s start it:");
        System.out.println(" | | | | | | | | | | |");
        System.out.println(" v v v v v v v v v v v");

        System.out.println(" ");
        System.out.println(" ");

        System.out.println(" Score starts in: " + player.getName() + ": " + score + "  " +   player1.getName() + ": score1");


       while (gameCounter < 3) {

           guess = randomPlay();
           guess1 = randomPlay();

           System.out.println( "Player1 " + player.getName() + ": " + guess + " || Player2 " + player1.getName() + " : " + guess1);

           if (guess == guess1) {
               System.out.println(" It doesn't count, Lets try it again!");
               System.out.println(" ");
               continue;
           }

           if (guess == PAPER){
               if (guess1 == ROCK){
                   score = score + 1;
                   gameCounter++;
                   System.out.println( "Player1 gets 1 point\n Player1: " + score + " || Player2: " + score1+ "\n");
                   continue;
               }else{ //guess2 will be Scissor

                   score1 = score1 + 1;
                   gameCounter++;
                   System.out.println( "Player1 gets 1 point\n Player1: " + score + " || Player2: " + score1+ "\n");
                    continue;
               }
           }

           if (guess == ROCK){
               if (guess1 == SCISSOR){

                   score = score + 1;
                   gameCounter++;
                   System.out.println( "Player1: " + score + " || Player2: " + score1+ "\n");
                   continue;

               }else{ //guess2 will be Paper

                   score1 = score1 + 1;
                   gameCounter++;
                   System.out.println( "Player1 gets 1 point\nPlayer1: " + score + " || Player2: " + score1+ "\n");
                   continue;
               }
           }

           if (guess == SCISSOR){
               if (guess1 == PAPER){

                   score = score + 1;
                   gameCounter++;
                   System.out.println( "Player1 gets 1 point\nPlayer1: " + score + " || Player2: " + score1+ "\n");
                   continue;

               }else{ //guess2 will be ROCK

                   score1 = score1 + 1;
                   gameCounter++;
                   System.out.println( "Player1 gets 1 point\n Player1: " + score + " || Player2: " + score1 + "\n");
                   continue;
               }
           }
       }

        if (gameCounter == 3){
            if (score > score1){
                System.out.println(" ");
                System.out.println("Player 1, you are the winner baby!");
            }else{
                System.out.println(" ");
                System.out.println("Player 2, you are the winner baby!");
            }
        }
    }
}