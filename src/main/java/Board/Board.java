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
        for (Integer row = 0; row < 3; row++) {
            for (Integer col = 0; col < 3; col++) {
                Cell cell = new Cell(row, col);
                cells.add(cell);
            }
        }
    }
}
