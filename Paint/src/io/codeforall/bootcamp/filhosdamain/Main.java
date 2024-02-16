package io.codeforall.bootcamp.filhosdamain;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {

    public static void main(String[] args) {
        Player player = new Player(10,10);
        Grid grid = new Grid(10,10, player);

        Controls controls = new Controls(player);


    }
}
