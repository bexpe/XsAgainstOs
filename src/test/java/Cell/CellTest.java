package Cell;

import enums.Seed;
import exceptions.CellNotEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Nested
    class ConstructorTests {
        @Test
        void testIfConstructorThrowsExceptionWhenRowLT0() {
            assertThrows(IllegalArgumentException.class, () -> new Cell(-1, 0));
        }

        @Test
        void testIfConstructorThrowsExceptionWhenColLT0() {
            assertThrows(IllegalArgumentException.class, () -> new Cell(2, -6));
        }
    }

    @Nested
    class MethodsTests {
        private Cell cell;

        @BeforeEach
        void setUp() {
            int row = 2;
            int col = 3;
            this.cell = new Cell(row, col);
        }

        @Test
        void testIfDefaultContentIsEmpty() {
            assertEquals(Seed.EMPTY, cell.getContent());
        }

        @Test
        void testIfContentIsEMPTYAfterClear() throws CellNotEmptyException {
            Seed newContent = Seed.CROSS;
            cell.setContent(newContent);
            cell.clear();
            assertEquals(Seed.EMPTY, cell.getContent());
        }

        @Test
        void testIfSetContentThrowsExceptionWhenContentIsNotEmpty() throws CellNotEmptyException {
            Seed contentCross = Seed.CROSS;
            Seed contentNought = Seed.NOUGHT;
            cell.setContent(contentCross);
            assertThrows(CellNotEmptyException.class, () -> cell.setContent(contentNought));
        }
    }

}
