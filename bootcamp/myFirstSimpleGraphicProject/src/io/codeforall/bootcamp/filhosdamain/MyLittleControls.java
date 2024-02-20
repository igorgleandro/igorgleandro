package io.codeforall.bootcamp.filhosdamain;
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

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_RIGHT:
                myLittleObject.moveRight();
                break;
                case KeyboardEvent.KEY_LEFT:
                    myLittleObject.moveLeft();
                    break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
