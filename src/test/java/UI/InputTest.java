package UI;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputTest {

    private Input input;

    @Test
    void testIfMenuInputReturnsValueProvidedByUser() {
        String userInput = "2";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        input = new Input(System.in);
        assertEquals("2", input.menuInput());
    }

    @Test
    void testIfTurnInputReturnsValueProvidedByUser() {
        String userInput = "2 2";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        input = new Input(System.in);
        assertEquals("2 2", input.turnInput());
    }
}
