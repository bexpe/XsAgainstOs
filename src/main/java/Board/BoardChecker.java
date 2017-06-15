package Board;

import Cell.Cell;
import Cell.Seed;

import java.util.Map;

class BoardChecker {


    Boolean hasWon(Board board, Map<String, Cell> cells) {
        return checkVertical(board, cells) || checkHorizontal(board, cells) || checkLeftDiagonal(board, cells) || checkRightDiagonal(board, cells);
    }

    private Boolean checkHorizontal(Board board, Map<String, Cell> cells) {
        for (Integer row = 1; row <= board.getMAX_ROW_INDEX(); row++) {
            Integer counter = 1;
            Cell currentCell = cells.get(row + " " + 1);
            for (Integer col = 2; col <= board.getMAX_COL_INDEX(); col++) {
                if (currentCell.getContent() != cells.get(row + " " + col).getContent() ||
                        currentCell.getContent() == Seed.EMPTY) {
                    break;
                } else {
                    counter++;
                }
            }
            if (counter == board.getMAX_ROW_INDEX()) {
                return true;
            }
        }
        return false;
    }

    private Boolean checkVertical(Board board, Map<String, Cell> cells) {
        for (Integer col = 1; col <= board.getMAX_ROW_INDEX(); col++) {
            Integer counter = 1;
            Cell currentCell = cells.get(1 + " " + col);
            for (Integer row = 2; row <= board.getMAX_ROW_INDEX(); row++) {
                if (currentCell.getContent() != cells.get(row + " " + col).getContent() ||
                        currentCell.getContent() == Seed.EMPTY) {
                    break;
                } else {
                    counter++;
                }
            }
            if (counter == board.getMAX_ROW_INDEX()) {
                return true;
            }
        }
        return false;
    }

    private Boolean checkLeftDiagonal(Board board, Map<String, Cell> cells) {
        Cell cellLeftTop = cells.get("1 1");
        Cell cellCenter = cells.get("2 2");
        Cell cellRightBottom = cells.get("3 3");
        if (cellLeftTop.getContent() == cellCenter.getContent() &&
                cellCenter.getContent() == cellRightBottom.getContent() &&
                cellCenter.getContent() != Seed.EMPTY) {
            return true;
        }
        return false;
    }

    private Boolean checkRightDiagonal(Board board, Map<String, Cell> cells) {
        Cell cellRightTop = cells.get("1 3");
        Cell cellCenter = cells.get("2 2");
        Cell cellLeftBottom = cells.get("3 1");
        if (cellLeftBottom.getContent() == cellCenter.getContent() &&
                cellCenter.getContent() == cellRightTop.getContent() &&
                cellCenter.getContent() != Seed.EMPTY) {
            return true;
        }
        return false;
    }
}
