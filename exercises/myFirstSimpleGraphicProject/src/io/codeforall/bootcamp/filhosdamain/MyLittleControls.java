<<<<<<< HEAD

package io.codeforall.bootcamp.filhosdamain;
=======
>>>>>>> 3974082 (drag update)
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MyLittleControls implements KeyboardHandler {

    MyLittleObject myLittleObject;
    Keyboard myKeyboard;
    public MyLittleControls(MyLittleObject myLittleObject) {
        this.myLittleObject = myLittleObject;
        init();
    }

    public void init(){
        myKeyboard = new Keyboard(this);

        KeyboardEvent pressedRight = new KeyboardEvent();
        pressedRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedRight.setKey(KeyboardEvent.KEY_RIGHT);
        myKeyboard.addEventListener(pressedRight);

        KeyboardEvent pressedLeft = new KeyboardEvent();
        pressedLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedLeft.setKey(KeyboardEvent.KEY_LEFT);
        myKeyboard.addEventListener(pressedLeft);

<<<<<<< HEAD
        KeyboardEvent pressedW = new KeyboardEvent();
        pressedW.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedW.setKey(KeyboardEvent.KEY_W);
        myKeyboard.addEventListener(pressedW);

        KeyboardEvent pressedQ = new KeyboardEvent();
        pressedQ.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedQ.setKey(KeyboardEvent.KEY_Q);
        myKeyboard.addEventListener(pressedQ);

=======
>>>>>>> 3974082 (drag update)
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){
<<<<<<< HEAD
            case KeyboardEvent.KEY_RIGHT, KeyboardEvent.KEY_W:
                MyLittleObject .moveRightP1();
                break;
            case KeyboardEvent.KEY_LEFT, KeyboardEvent.KEY_Q:
                    myLittleObject.moveLeftP1();
                    break;


=======
            case KeyboardEvent.KEY_RIGHT:
                myLittleObject.moveRight();
                break;
                case KeyboardEvent.KEY_LEFT:
                    myLittleObject.moveLeft();
                    break;
>>>>>>> 3974082 (drag update)
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
