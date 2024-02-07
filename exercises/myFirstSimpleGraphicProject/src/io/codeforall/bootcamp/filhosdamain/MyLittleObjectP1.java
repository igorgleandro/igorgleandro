package io.codeforall.bootcamp.filhosdamain;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MyLittleObjectP1 {
    private Picture dragOne = new Picture(0,10,"resources/DragOne.png");

    public MyLittleObjectP1(){
        dragOne.draw();
    }

    public void moveRightP1(){dragOne.translate(10,0);}
    public void moveLeftP1(){dragOne.translate(-10,0);}
}
