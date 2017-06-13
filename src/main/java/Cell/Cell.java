package Cell;

public class Cell {
    int row;
    int col;

    public Cell(int row, int col) throws IllegalArgumentException {
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException("row or col cant be less than 0");
        }
        this.row = row;
        this.col = col;
    }
}
