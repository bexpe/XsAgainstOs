package Board;

import Cell.Cell;
import Cell.Seed;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class BoardChecker {


    Boolean hasWon(Board board, Map<String, Cell> cells) {
        return checkVertical(board) || checkHorizontal(board) || checkLeftDiagonal(board, cells) || checkRightDiagonal(board, cells);
    }

    private Boolean checkHorizontal(Board board) {
        List<Seed> cellsContent = board.getCellsContentAsSeed();

        for (Integer index = 0; index < cellsContent.size(); index += board.getMAX_COL_INDEX()) {
            if (new HashSet<>(cellsContent.subList(index, index + board.getMAX_COL_INDEX())).size() == 1 &&
                    cellsContent.get(index) != Seed.EMPTY) {
                return true;
            }
        }
        return false;
    }

    private Boolean checkVertical(Board board) {
        List<Seed> cellsContent = board.getCellsContentAsSeed();

        for (Integer colIndex = 0; colIndex < board.getMAX_COL_INDEX(); colIndex++) {
            List<Seed> colList = new ArrayList<>();
            for (Integer rowIndex = 0; rowIndex < cellsContent.size(); rowIndex += board.getMAX_COL_INDEX()) {
                colList.add(cellsContent.get(rowIndex + colIndex));
            }
            if (new HashSet<>(colList).size() == 1 &&
                    !colList.contains(Seed.EMPTY)) {
                return true;
            }
        }
        return false;
    }

    private Boolean checkLeftDiagonal(Board board, Map<String, Cell> cells) {
        List<Seed> cellsContent = board.getCellsContentAsSeed();
        List<Seed> diagonalList = new ArrayList<>();

        for (Integer index = 0; index < cellsContent.size(); index += board.getMAX_COL_INDEX() + 1) {
            diagonalList.add(cellsContent.get(index));
        }
        return new HashSet<>(diagonalList).size() == 1 &&
                !diagonalList.contains(Seed.EMPTY);
    }

    private Boolean checkRightDiagonal(Board board, Map<String, Cell> cells) {
        List<Seed> cellsContent = board.getCellsContentAsSeed();
        List<Seed> diagonalList = new ArrayList<>();

        for (Integer index = board.getMAX_COL_INDEX() - 1; index < cellsContent.size() - 1; index += (board.getMAX_COL_INDEX() - 1)) {
            diagonalList.add(cellsContent.get(index));
        }
        return new HashSet<>(diagonalList).size() == 1 &&
                !diagonalList.contains(Seed.EMPTY);
    }
}
