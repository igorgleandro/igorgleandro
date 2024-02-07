<<<<<<< HEAD
package io.codeforall.bootcamp.filhosdamain;
=======
>>>>>>> 3974082 (drag update)
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MyLittleObject {

<<<<<<< HEAD
    private Picture trackRace = new Picture(0,300,"resources/TrackRace.jpg");
    private Picture wallpaperImage = new Picture(0,0,"resources/Wallpaper.jpg");
    private Picture dragTwo = new Picture(0,250,"resources/DragTwo.png");
    private Picture dragLogo = new Picture(500,700,"resources/DragRaceLogo.png");
=======
    private Picture trackRace = new Picture(325,100,"resources/TrackRace.jpg");
    private Picture wallpaperImage = new Picture(100,100,"resources/Wallpaper.jpg");
    private Picture dragOne = new Picture(100,100,"resources/DragOne.png");
    private Picture dragTwo = new Picture(100,100,"resources/DragTwo.png");
>>>>>>> 3974082 (drag update)


    public MyLittleObject(){

        wallpaperImage.draw();
        trackRace.draw();
<<<<<<< HEAD
        dragTwo.draw();
        dragLogo.draw();
    }


    public MyLittleObjectP2(){
        dragTwo.draw();
    }


    public void moveRightP2(){dragTwo.translate(10,0);}
    public void moveLeftP2(){dragTwo.translate(-10,0);}
=======
        dragOne.draw();
        dragTwo.draw();
    }

    public void moveRight(){
        trackRace.translate(10,0);
    }

    public void moveLeft(){
        trackRace.translate(-10,0);
    }
>>>>>>> 3974082 (drag update)


}
