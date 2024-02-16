package io.codeforall.bootcamp.filhosdamain;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Controls implements  KeyboardHandler {

        Player player;
        Keyboard myKeyboard;
        public Controls (Player player) {
            this.player = player;
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

            KeyboardEvent pressedUp = new KeyboardEvent();
            pressedUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            pressedUp.setKey(KeyboardEvent.KEY_UP);
            myKeyboard.addEventListener(pressedUp);

            KeyboardEvent pressedDown = new KeyboardEvent();
            pressedDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            pressedDown.setKey(KeyboardEvent.KEY_DOWN);
            myKeyboard.addEventListener(pressedDown);

            KeyboardEvent pressedSpace = new KeyboardEvent();
            pressedSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            pressedSpace.setKey(KeyboardEvent.KEY_SPACE);
            myKeyboard.addEventListener(pressedSpace);

        }

        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {

            switch (keyboardEvent.getKey()){
                case KeyboardEvent.KEY_RIGHT:
                    player.moveRight();
                    break;
                case KeyboardEvent.KEY_LEFT:
                    player.moveLeft();
                    break;
                case KeyboardEvent.KEY_UP:
                    player.moveUp();
                    break;
                case KeyboardEvent.KEY_DOWN:
                    player.moveDown();
                    break;
                case KeyboardEvent.KEY_SPACE:
                    player.paint();
                    break;
            }

        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {

        }
    }
