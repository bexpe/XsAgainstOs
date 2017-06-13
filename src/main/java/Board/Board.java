package Board;

import Cell.Cell;
import enums.Seed;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Cell> cells = new ArrayList<>();
    private final Integer MAX_ROW_INDEX = 2;
    private final Integer MAX_COL_INDEX = 2;

    public List<Cell> getCells() {
        return cells;
    }

    public void init() {
        for (Integer row = 0; row <= MAX_ROW_INDEX; row++) {
            for (Integer col = 0; col <= MAX_ROW_INDEX; col++) {
                Cell cell = new Cell(row, col);
                cells.add(cell);
            }
        }
    }

    public Boolean isDraw() {
        for (Cell cell: cells) {
            if (cell.getContent() == Seed.EMPTY) {
                return false;
            }
        }
        return true;
    }

}
