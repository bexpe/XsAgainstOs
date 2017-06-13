package Board;

import Cell.Cell;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Cell> cells = new ArrayList<>();

    public List<Cell> getCells() {
        return cells;
    }

    public void init() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                Cell cell = new Cell(i, j);
                cells.add(cell);
            }
        }
    }
}
