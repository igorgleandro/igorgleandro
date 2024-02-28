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
    private int cellSize = 30;


    private int maxHeight;
    private int minHeight;
    private int maxWidth;
    private int minWidth;


    public void setArrayGrid(Rectangle[][] arrayGrid) {
        this.arrayGrid = arrayGrid;
    }

    public Player(int col, int row) {
        this.col = col;
        this.row = row;
        this.playerImage = new Rectangle(padding, padding, cellSize, cellSize);
        this.playerImage.setColor(Color.GREEN);
        this.playerImage.fill();
    }

    public void moveRight() {
        if (this.col + this.playerImage.getWidth() < (padding + (cellSize*30))) {
            this.playerImage.translate(cellSize, 0.0);
            this.col += 30;
        }
    }

    public void moveLeft() {
        if (this.col >= 30) {
            this.playerImage.translate(-cellSize, 0.0);
            this.col -= 30;
        }
    }

    public void moveUp() {
        if (this.row <= padding) {
            this.playerImage.translate(00.0, -cellSize);
            this.row -= 30;
        }
    }

    public void moveDown() {
        if (this.row + this.playerImage.getHeight() < ((cellSize*30))) {
            this.playerImage.translate(00.0, cellSize);
            this.row -= 30;
            System.out.println(this.row + this.playerImage.getHeight());
            System.out.println((padding + (cellSize*30)));
        }
    }

   public void paint() {
        for (int row = 0; row < 30; row++) {
            for (int col = 0; col < 30; col++) {
                if (arrayGrid[col][row].getX() == playerImage.getX() && arrayGrid[col][row].getY() == playerImage.getY()) {
                    if (!arrayGrid[col][row].isFilled()) {
                        paint = new Rectangle(playerImage.getX(), playerImage.getY(), cellSize, cellSize);
                        paint.fill();
                        arrayGrid[col][row].fill();

                    } else {
                        paint = new Rectangle(playerImage.getX(), playerImage.getY(), cellSize, cellSize);
                        paint.setColor(Color.WHITE);
                        paint.fill();

                        paint = new Rectangle(playerImage.getX(), playerImage.getY(), cellSize, cellSize);
                        paint.setColor(Color.BLACK);
                        paint.draw();
                    }
                }
            }
        }
    }
}







