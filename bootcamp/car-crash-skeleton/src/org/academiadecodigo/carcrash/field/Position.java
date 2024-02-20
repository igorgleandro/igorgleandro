package org.academiadecodigo.carcrash.field;

public class Position {

    private int col;
    private int row;

    public Position(){
        this.col = ((int) Math.ceil(Math.random() * Field.getWidth()));
        this.row = ((int) Math.ceil(Math.random() * Field.getHeight()));
    }
    public int getCol() {
        return this.col;
    }
    public int getRow() {
        return this.row; }
    public void setCol(int col) {
        this.col = col;
    }
    public void setRow(int row) {
        this.row = row;
    }
}

