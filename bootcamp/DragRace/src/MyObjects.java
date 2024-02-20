import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MyObjects {

    //Background
    private final Picture objectWallpaper = new Picture(0,0,"resources/Wallpaper.jpg");
    private final Picture objectTrack = new Picture(0,0,"resources/TrackRace.jpg");

    //Players
    private Picture dragOne = new Picture(0,0,"resources/DragOne.png");
    //private Picture dragTwo = new Picture(0,0,"resources/DragTwo.png");


    public MyObjects(){
        objectWallpaper.draw();
        objectTrack.draw();
        dragOne.draw();
        dragOne.draw();
    }

    public void moveRight(){
        dragOne.translate(10,0);
    }
    //public void moveRight(){dragTwo.translate(10,0);}

    public void moveLeft(){
        dragOne.translate(-10,0);
    }
   // public void moveLeft(){dragTwo.translate(-10,0);}


}
