package Game;

import Cell.CellNotEmptyException;
import Cell.Seed;
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
    Seed cross = Seed.CROSS;

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
    void testUpdateGameState() throws CellNotEmptyException {
        String coordinatesCenterTop = "1 2";
        String coordinatesCenter = "2 2";
        String coordinatesCenterBottom = "3 2";
        game.getBoard().getCells().get(coordinatesCenterTop).setContent(cross);
        game.getBoard().getCells().get(coordinatesCenter).setContent(cross);
        game.getBoard().getCells().get(coordinatesCenterBottom).setContent(cross);
        game.updateGameState();
        assertEquals("CROSS_WON", game.getGameState().toString());
    }
}
