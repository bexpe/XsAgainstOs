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
            this.cell = new Cell(2,3);
        }

        @Test
        void testIfDefaultContentIsEmpty() {
            assertEquals(Seed.EMPTY, cell.getContent());
        }
    }

}
