package Cell;

public class Cell {
    private Seed content = Seed.EMPTY;
    private Integer row;
    private Integer col;

    public Cell(Integer row, Integer col) throws IllegalArgumentException {
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException("row or col cant be less than 0");
        }
        this.row = row;
        this.col = col;
    }

    public Seed getContent() {
        return content;
    }

    public void setContent(Seed content) throws CellNotEmptyException {
        if (this.content != Seed.EMPTY) {
            throw new CellNotEmptyException("Cell must be empty!");
        }
        this.content = content;
    }
}
