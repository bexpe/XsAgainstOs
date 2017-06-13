package Board;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BoardTest {

    @Test
    void testIfConstructorCreateEmptyCellsArray() {
        Board board = new Board();
        assert equals(0, board.cells.size());
    }

}
