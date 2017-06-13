package Cell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    void testIfConstructorThrowsExceptionWhenRowLT0() {
        assertThrows(IllegalArgumentException.class, () -> new Cell(-1, 0));
    }
}
