package Cell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CellTest {
    @Nested
    class ConstructorTests {
        @Test
        void testIfConstructorThrowsExceptionWhenRowLT0() {
            Integer row = -2;
            Integer col = 2;
            assertThrows(IllegalArgumentException.class, () -> new Cell(row, col));
        }

        @Test
        void testIfConstructorThrowsExceptionWhenColLT0() {
            Integer row = 2;
            Integer col = -2;
            assertThrows(IllegalArgumentException.class, () -> new Cell(row, col));
        }
    }

    @Nested
    class MethodsTests {
        private Cell cell;

        @BeforeEach
        void setUp() {
            Integer row = 1;
            Integer col = 2;
            this.cell = new Cell(row, col);
        }

        @Test
        void testIfDefaultContentIsEmpty() {
            assertEquals(Seed.EMPTY, cell.getContent());
        }

        @Test
        void testIfContentIsEmptyAfterClear() throws CellNotEmptyException {
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
