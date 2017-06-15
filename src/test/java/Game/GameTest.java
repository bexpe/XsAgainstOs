package Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        this.game = new Game();
        game.initGame();
    }

    @Nested
    class InitTest {

        @Test
        void testIfConstructorCreateCellsArrayWithSize9() {
            Integer boardSize = 9;
            assertEquals((int) boardSize, game.getBoard().getCells().size());
        }

        @Test
        void testIfGameStateInInitIsPlaying() {
            assertEquals(GameState.PLAYING, game.getGameState());
        }

        @Test
        void testIfCurrentPlayerIsXorO() {
            String expectedTitles[] = {"CROSS","NOUGHT"};
            List<String> expectedTitlesList = Arrays.asList(expectedTitles);
            assertTrue(expectedTitlesList.contains((game.getCurrentPlayer()).toString()));
        }
    }

    @Test
    void testGetBoard() {

    }
}
