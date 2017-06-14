package Board;

import enums.Seed;
import exceptions.CellNotEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import Cell.Cell;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        this.board = new Board();
    }

    @Nested
    class InitTest {

        @Test
        void testIfConstructorCreateEmptyCellsArray() {
            Integer emptyBoardSize = 0;
            assertEquals((int) emptyBoardSize, board.getCells().size());
        }

        @Test
        void testIfArraySizeAfterInitEquals9() {
            Integer boardSize = 9;
            board.init();
            assertEquals((int) boardSize, board.getCells().size());
        }
    }

    @Nested
    class MethodsTests {
        Seed cross = Seed.CROSS;
        Seed nought = Seed.NOUGHT;

        @BeforeEach
        void setUp() {
            board.init();
        }

        @Test
        void testIfIsDrawReturnsTrueWhenNoValidMoveLeft() throws CellNotEmptyException {
            for (Map.Entry<String, Cell> pair : board.getCells().entrySet()) {
                pair.getValue().setContent(cross);
            }
            assertEquals(true, board.isDraw());
        }

        @Test
        void testIfFillCellThrowsExceptionWhenCellNotEmpty() throws CellNotEmptyException {
            String coordinates = "2 1";
            board.fillCell(cross, coordinates);
            assertThrows(CellNotEmptyException.class, () -> board.fillCell(nought, coordinates));
        }

        @Test
        void testIfFillCellThrowsExceptionWhenIndexOutOfBounds() {
            String coordinates = "4 1";
            assertThrows(IndexOutOfBoundsException.class, () -> board.fillCell(cross, coordinates));
        }

        @Test
        void testIfFillCellChangeCellSeed() throws CellNotEmptyException {
            String coordinates = "2 1";
            board.getCells().get(coordinates).setContent(nought);
            assertEquals(nought, board.getCells().get(coordinates).getContent());
        }

    }
    @Nested
    class ScenarioTest {
        Seed cross = Seed.CROSS;

        @BeforeEach
        void setUp() {
            board.init();
        }

        @Test
        void testWinningScenarioHorizontal1() throws CellNotEmptyException {
            String coordinatesLeftTop = "1 1";
            String coordinatesCenterTop = "1 2";
            String coordinatesRightTop = "1 3";
            board.getCells().get(coordinatesLeftTop).setContent(cross);
            board.getCells().get(coordinatesCenterTop).setContent(cross);
            board.getCells().get(coordinatesRightTop).setContent(cross);
            assertEquals(true, board.hasWon());
        }

        @Test
        void testWinningScenarioHorizontal2() throws CellNotEmptyException {
            String coordinatesCenterLeft = "2 1";
            String coordinatesCenter = "2 2";
            String coordinatesCenterRight = "2 3";
            board.getCells().get(coordinatesCenterLeft).setContent(cross);
            board.getCells().get(coordinatesCenter).setContent(cross);
            board.getCells().get(coordinatesCenterRight).setContent(cross);
            assertEquals(true, board.hasWon());
        }

        @Test
        void testWinningScenarioHorizontal3() throws CellNotEmptyException {
            String coordinatesRightBottom = "3 1";
            String coordinatesCenterBottom = "3 2";
            String coordinatesLeftBottom = "3 3";
            board.getCells().get(coordinatesRightBottom).setContent(cross);
            board.getCells().get(coordinatesCenterBottom).setContent(cross);
            board.getCells().get(coordinatesLeftBottom).setContent(cross);
            assertEquals(true, board.hasWon());
        }

        @Test
        void testWinningScenarioVertical1() throws CellNotEmptyException {
            String coordinatesLeftTop = "1 1";
            String coordinatesLeft = "2 1";
            String coordinatesLeftBottom = "3 1";
            board.getCells().get(coordinatesLeftTop).setContent(cross);
            board.getCells().get(coordinatesLeft).setContent(cross);
            board.getCells().get(coordinatesLeftBottom).setContent(cross);
            assertEquals(true, board.hasWon());
        }

        @Test
        void testWinningScenarioVertical2() throws CellNotEmptyException {
            String coordinatesCenterTop = "1 2";
            String coordinatesCenter = "2 2";
            String coordinatesCenterBottom = "3 2";
            board.getCells().get(coordinatesCenterTop).setContent(cross);
            board.getCells().get(coordinatesCenter).setContent(cross);
            board.getCells().get(coordinatesCenterBottom).setContent(cross);
            assertEquals(true, board.hasWon());
        }

        @Test
        void testWinningScenarioVertical3() throws CellNotEmptyException {
            String coordinatesRightTop = "1 3";
            String coordinatesRight = "2 3";
            String coordinatesRightBottom = "3 3";
            board.getCells().get(coordinatesRightTop).setContent(cross);
            board.getCells().get(coordinatesRight).setContent(cross);
            board.getCells().get(coordinatesRightBottom).setContent(cross);
            assertEquals(true, board.hasWon());
        }

        @Test
        void testWinningScenarioDiagonal1() throws CellNotEmptyException {
            String coordinatesLeftTop = "1 1";
            String coordinatesCenter = "2 2";
            String coordinatesRightBottom = "3 3";
            board.getCells().get(coordinatesLeftTop).setContent(cross);
            board.getCells().get(coordinatesCenter).setContent(cross);
            board.getCells().get(coordinatesRightBottom).setContent(cross);
            assertEquals(true, board.hasWon());
        }

        @Test
        void testWinningScenarioDiagonal2() throws CellNotEmptyException {
            String coordinatesRightTop = "1 3";
            String coordinatesCenter = "2 2";
            String coordinatesLeftBottom = "3 1";
            board.getCells().get(coordinatesRightTop).setContent(cross);
            board.getCells().get(coordinatesCenter).setContent(cross);
            board.getCells().get(coordinatesLeftBottom).setContent(cross);
            assertEquals(true, board.hasWon());
        }
    }
}
