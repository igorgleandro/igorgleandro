package io.codeforall.bootcamp;

public class Main {

    public static void main (String[] args){
        System.out.println(RockPaperScissorGenerator.randomPlay());

        Player player =new Player( "Igor");
        Player player1 =new Player("Rui");

         Game game1= new Game();
            game1.gameStart(player,player1);


    }



}
