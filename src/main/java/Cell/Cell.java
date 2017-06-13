package Cell;

import enums.Seed;

public class Cell {
    private Seed content = Seed.EMPTY;
    private int row;
    private int col;

    public Cell(int row, int col) throws IllegalArgumentException {
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException("row or col cant be less than 0");
        }
        this.row = row;
        this.col = col;
    }

    public Seed getContent() {
        return content;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
