package Board;

import Cell.Cell;
import Cell.CellNotEmptyException;
import Cell.Seed;

import java.util.LinkedHashMap;
import java.util.Map;

public class Board {
    private Map<String, Cell> cells = new LinkedHashMap<>();
    private final Integer MAX_ROW_INDEX = 3;
    private final Integer MAX_COL_INDEX = 3;
    private BoardChecker boardChecker = new BoardChecker();


    public Map<String, Cell> getCells() {
        return cells;
    }

    public Integer getMAX_ROW_INDEX() {
        return MAX_ROW_INDEX;
    }

    public Integer getMAX_COL_INDEX() {
        return MAX_COL_INDEX;
    }

    public void init() {
        for (Integer row = 1; row <= MAX_ROW_INDEX; row++) {
            for (Integer col = 1; col <= MAX_COL_INDEX; col++) {
                Cell cell = new Cell(row, col);
                cells.put(row + " " + col, cell);
            }
        }
    }

    public void fillCell(Seed seed, String inputCoordinates) throws CellNotEmptyException, IndexOutOfBoundsException {
        String[] splitedCoordinates = inputCoordinates.split("\\s+");
        if (Integer.parseInt(splitedCoordinates[0]) > MAX_ROW_INDEX || Integer.parseInt(splitedCoordinates[1]) > MAX_COL_INDEX) {
            throw new IndexOutOfBoundsException("BoardPrinter size is 3 x 3");
        }
        cells.get(inputCoordinates).setContent(seed);
    }

    public Boolean hasWon() {
        return boardChecker.hasWon(this, cells);
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
