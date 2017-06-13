package Board;

import enums.Seed;
import exceptions.CellNotEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import Cell.Cell;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        void testIfIsDrawReturnsTrueWhenNoValidMoveLeft() throws CellNotEmptyException {
            Seed cross = Seed.CROSS;
            for (Cell cell: board.getCells()) {
                cell.setContent(cross);
            }
            assertEquals(true, board.isDraw());
        }
    }
}
