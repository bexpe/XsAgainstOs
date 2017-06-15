package Game;

import Board.Board;
import Cell.CellNotEmptyException;
import Cell.Seed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static java.util.concurrent.CompletableFuture.anyOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {
    Game game;
    Seed cross = Seed.CROSS;
    Seed nought = Seed.NOUGHT;

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
    void testGetCurrentPlayer() {
        Seed newPlayer = Seed.CROSS;
        game.setCurrentPlayer(newPlayer);
        assertEquals(Seed.CROSS, game.getCurrentPlayer());
    }

    @Test
    void testUpdateGameStateWhenWon() throws CellNotEmptyException {
        String coordinatesCenterTop = "1 2";
        String coordinatesCenter = "2 2";
        String coordinatesCenterBottom = "3 2";
        game.getBoard().getCells().get(coordinatesCenterTop).setContent(cross);
        game.getBoard().getCells().get(coordinatesCenter).setContent(cross);
        game.getBoard().getCells().get(coordinatesCenterBottom).setContent(cross);
        game.updateGameState();
        String player = game.getCurrentPlayer().toString();
        assertEquals(player+"_WON", game.getGameState().toString());
    }

    @Test
    void testUpdateGameStateWhenDraw () throws CellNotEmptyException {
        String coordinatesCenterTop = "1 2";
        String coordinatesLeftTop = "1 1";
        String coordinatesRightTop = "1 3";
        String coordinatesCenter = "2 2";
        String coordinatesLeftCenter = "2 1";
        String coordinatesRightCenter = "2 3";
        String coordinatesCenterBottom = "3 2";
        String coordinatesLeftBottom = "3 1";
        String coordinatesRightBottom = "3 3";
        game.getBoard().getCells().get(coordinatesLeftTop).setContent(cross);
        game.getBoard().getCells().get(coordinatesCenterTop).setContent(nought);
        game.getBoard().getCells().get(coordinatesRightTop).setContent(nought);
        game.getBoard().getCells().get(coordinatesLeftCenter).setContent(nought);
        game.getBoard().getCells().get(coordinatesCenter).setContent(cross);
        game.getBoard().getCells().get(coordinatesRightCenter).setContent(cross);
        game.getBoard().getCells().get(coordinatesLeftBottom).setContent(cross);
        game.getBoard().getCells().get(coordinatesCenterBottom).setContent(nought);
        game.getBoard().getCells().get(coordinatesRightBottom).setContent(nought);
        game.updateGameState();
        assertEquals("DRAW", game.getGameState().toString());
    }

    @RepeatedTest(100)
    void testChangePlayer() {
        String playerBeforeChange = game.getCurrentPlayer().toString();
        game.changePlayer();
        String playerAfterChange = game.getCurrentPlayer().toString();
        assertNotEquals(playerAfterChange, playerBeforeChange);
    }
}
