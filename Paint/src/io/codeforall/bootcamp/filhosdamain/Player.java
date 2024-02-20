package io.codeforall.bootcamp.filhosdamain;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Player {

    private Rectangle playerImage;
    private int padding = 10;
    private int col;
    private int row;
    private boolean isPainted;
    private Rectangle[][] arrayGrid;
    private Rectangle paint;


    public void setArrayGrid(Rectangle[][] arrayGrid) {
        this.arrayGrid = arrayGrid;
    }

    public Player(int col, int row) {
        this.col = col;
        this.row = row;
        this.playerImage = new Rectangle(padding, padding, 100, 100);
        this.playerImage.setColor(Color.GREEN);
        this.playerImage.fill();
    }

    public void moveRight() {
        if (this.col + this.playerImage.getWidth() < 1100) {
            this.playerImage.translate(100.0, 0.0);
            this.col += 10;
        }
    }

    public void moveLeft() {
        if (this.col > 10) {
            this.playerImage.translate(-100.0, 0.0);
            this.col -= 10;
        }
    }

    public void moveUp() {
        if (this.row < 10) {
            this.playerImage.translate(00.0, -100.0);
            this.row -= 10;
        }
    }

    public void moveDown() {
        if (this.row + this.playerImage.getHeight() < 1000) {
            this.playerImage.translate(00.0, 100.0);
            this.row -= 10;
        }
    }

    public void paint() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if (arrayGrid[col][row].getX() == playerImage.getX() && arrayGrid[col][row].getY() == playerImage.getY()) {
                    if (!arrayGrid[col][row].isFilled()) {
                        paint = new Rectangle(playerImage.getX(), playerImage.getY(), 100, 100);
                        paint.setColor(Color.BLACK);
                        paint.fill();
                        arrayGrid[col][row].fill();
                        System.out.println("");

                    } else {
                        paint = new Rectangle(playerImage.getX(), playerImage.getY(), 100, 100);
                        paint.setColor(Color.WHITE);
                        paint.fill();

                        paint = new Rectangle(playerImage.getX(), playerImage.getY(), 100, 100);
                        paint.setColor(Color.BLACK);
                        paint.draw();
                    }
                }
            }
        }
    }
}







