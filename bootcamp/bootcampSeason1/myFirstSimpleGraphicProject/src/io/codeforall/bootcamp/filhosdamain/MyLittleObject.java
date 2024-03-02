package io.codeforall.bootcamp.filhosdamain;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MyLittleObject {

    private Picture trackRace = new Picture(325,100,"resources/TrackRace.jpg");
    private Picture wallpaperImage = new Picture(100,100,"resources/Wallpaper.jpg");
    private Picture dragOne = new Picture(100,100,"resources/DragOne.png");
    private Picture dragTwo = new Picture(100,100,"resources/DragTwo.png");


    public MyLittleObject(){

        wallpaperImage.draw();
        trackRace.draw();
        dragOne.draw();
        dragTwo.draw();
    }
    public void moveRight(){
        trackRace.translate(10,0);
    }
    public void moveLeft(){
        trackRace.translate(-10,0);
    }
}
