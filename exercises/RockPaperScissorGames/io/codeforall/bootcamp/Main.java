package io.codeforall.bootcamp;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {

        Player player = new Player("Igor");
        Player player1 = new Player("Rui");



        GameMaster game1 = new GameMaster() ;
        game1.gameStart(player ,player1);


    }


}
