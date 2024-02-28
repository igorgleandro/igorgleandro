package io.codeforall.bootcamp.filhosdamain;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {


    private int padding = 10;
    private int cellSize = 30;
    private boolean isPainted;
    private  Player player;
    private Rectangle gridFields;

    public Grid(Player player) {
        this.player = player;
        init();
    }

    public void init() {

        int tempRow = 0;
        int tempCol = 0;
        Rectangle[][] arrayFields = new Rectangle[50][50];

        for (int row = 0; row < 30; row++) {
            for (int col = 0; col < 30; col++) {
                gridFields = new Rectangle(tempCol + padding,tempRow + padding, cellSize, cellSize);
                arrayFields[col][row] = gridFields;
                gridFields.draw();
                tempCol = tempCol + cellSize;
            }
            tempRow = tempRow + cellSize;
            tempCol = 0;

        }
        player.setArrayGrid(arrayFields);

    }

}


