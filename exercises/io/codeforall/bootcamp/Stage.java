package io.codeforall.bootcamp;

public class Stage {

    //public int guessPlayer1;
    //public int guessPlayer2;

    public static void main(String[] args) {

        Game game1 = new Game();
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        System.out.println("Let´s start this game!");


        while (game1.getTarget() != player2.getCurrentGuess() || game1.getTarget() != player1.getCurrentGuess()) {
            player2.generateCurrentGuess();
            player1.generateCurrentGuess();
            System.out.println("The number to be guessed is: " + game1.getTarget());
            System.out.println(" ");
            System.out.println("Player 2 guess is: " + player2.getCurrentGuess());

            System.out.println("Player 1 guess is: " + player1.getCurrentGuess());

            if (player1.getCurrentGuess() == game1.getTarget()) {
                System.out.println(" ");
                System.out.println(player1.name + " , you are the winner baby!");
                return;
            }
            if (player2.getCurrentGuess() == game1.getTarget()) {
                System.out.println(" ");
                System.out.println(player2.name + " , you are the winner baby!");
                return;
            } else {
                System.out.println(" ");
                System.out.println("None, let's try it again!");

                continue;

            }

        }
    }
}






