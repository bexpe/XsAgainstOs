package Board;

import Cell.Cell;
import enums.Seed;

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
        for (Integer index = 1; index <= board.getMAX_ROW_INDEX(); index++) {
            Integer counter = 1;
            Cell currentCell = cells.get(index + " " + index);

                if (currentCell.getContent() != cells.get((index + 1) + " " + (index + 1)).getContent() ||
                        currentCell.getContent() == Seed.EMPTY) {
                    break;
                }
                else {
                    if (counter == board.getMAX_ROW_INDEX()) {
                        return true;
                    }
                    counter++;
                }
            }
        return false;
    }

    private Boolean checkRightDiagonal(Board board, Map<String, Cell> cells) {
        for (Integer col = board.getMAX_ROW_INDEX(); col >= 1; col--) {
            Integer counter = 1;
            Cell currentCell = cells.get(1 + " " + col);
            for (Integer row = 2; row <= board.getMAX_ROW_INDEX(); row++) {
                if (currentCell.getContent() != cells.get(row + " " + (col-1)).getContent() ||
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
