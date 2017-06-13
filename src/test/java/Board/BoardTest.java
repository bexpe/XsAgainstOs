package Board;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    void testIfConstructorCreateEmptyCellsArray() {
        Board board = new Board();
        assertEquals(0, board.getCells().size());
    }

}
