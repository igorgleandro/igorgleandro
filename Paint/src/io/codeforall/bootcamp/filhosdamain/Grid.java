package io.codeforall.bootcamp.filhosdamain;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;
import java.lang.reflect.Field;

public class Grid {


    private int padding = 10;
    private int cols;
    private int rows;
    private int cellSize = 10;
    private boolean isPainted;
    private  Player player;


    private Rectangle field;
    private Rectangle gridFields;

    public Grid(int cols, int rows, Player player) {
        this.cols = cols;
        this.rows = rows;
        this.player = player;
        init();
    }

    public void init() {
        field = new Rectangle(padding, padding, 100, 100);

        int tempRow = 0;
        int tempCol = 0;
        Rectangle[][] arrayFields = new Rectangle[10][10];

        for (int row = 0; row < 10; row++) {

            for (int col = 0; col < 10; col++) {
                gridFields = new Rectangle(tempCol + 10,tempRow + 10, 100, 100);
                arrayFields[col][row] = gridFields;
                System.out.println(arrayFields[col][row]);
                gridFields.draw();
                tempCol = tempCol + 100;
            }
            tempRow = tempRow + 100;
            tempCol = 0;
            System.out.print("\n");
        }
        player.setArrayGrid(arrayFields);
    }

}


