package Board;

import Cell.Cell;
import enums.Seed;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<String, Cell> cells = new HashMap<>();
    private final Integer MAX_ROW_INDEX = 2;
    private final Integer MAX_COL_INDEX = 2;

    public Map<String, Cell> getCells() {
        return cells;
    }

    public void init() {
        for (Integer row = 0; row <= MAX_ROW_INDEX; row++) {
            for (Integer col = 0; col <= MAX_COL_INDEX; col++) {
                Cell cell = new Cell(row, col);
                cells.put(row + " " + col, cell);
            }
        }
    }

    public Boolean isDraw() {
        for (Map.Entry<String, Cell> pair : cells.entrySet()) {
            if (pair.getValue().getContent() == Seed.EMPTY) {
                return false;
            }
        }
        return true;
    }
}
