package Board;

import enums.Seed;
import exceptions.CellNotEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import Cell.Cell;

import java.util.Map;

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
        @BeforeEach
        void setUp() {
            board.init();
        }

        @Test
        void testIfIsDrawReturnsTrueWhenNoValidMoveLeft() throws CellNotEmptyException {

            Seed cross = Seed.CROSS;
            for (Map.Entry<String, Cell> pair : board.getCells().entrySet()) {
                pair.getValue().setContent(cross);
            }
            assertEquals(true, board.isDraw());
        }

        @Test
        void testIfFillCellThrowsExceptionWhenCellNotEmpty() throws CellNotEmptyException {
            Seed cross = Seed.CROSS;
            Seed nought = Seed.NOUGHT;
            String coordinates = "2 1";
            board.fillCell(cross, coordinates);
            assertThrows(CellNotEmptyException.class, () -> board.fillCell(nought, coordinates));
        }

        @Test
        void testIfFillCellThrowsExceptionWhenIndexOutOfBounds() {
            Seed cross = Seed.CROSS;
            String coordinates = "4 1";
            assertThrows(IndexOutOfBoundsException.class, () -> board.fillCell(cross, coordinates));
        }
    }
}
