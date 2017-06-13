package Cell;

import enums.Seed;
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
        void testIfContentIsEMPTYAfterClear() {
            Seed newContent = Seed.CROSS;
            cell.setContent(newContent);
            cell.clear();
            assertEquals(Seed.EMPTY, cell.getContent());
        }
    }

}
