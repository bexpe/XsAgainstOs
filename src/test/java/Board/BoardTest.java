package Board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Nested
    class InitTest {
        private Board board;

        @BeforeEach
        void setUp() {
            this.board = new Board();
        }

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


}
