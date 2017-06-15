package UI;

import Cell.CellNotEmptyException;
import Cell.Seed;
import Game.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private Message message = new Message();
    private Game game = new Game();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        game.initGame();
    }

    @AfterEach
    void cleanUp() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    void testIfMenuMessagePrintsProperText() {
        message.menuMessage();
        assertEquals(
                "1. Play the game\n" +
                "2. Exit\n" +
                "Choose option: \n", outContent.toString());
    }

    @Test
    void testIfTurnMessageProperText() {
        message.turnMessage(game);
        assertEquals("Current player is: " + game.getCurrentPlayer() + "\n", outContent.toString());
    }

    @Test
    void testIfPlayerInputMessagePrintsProperText() {
        message.playerInputMessage(game);
        assertEquals("Player " + game.getCurrentPlayer() + ", enter your move (row[1-3] column[1-3])\n", outContent.toString());
    }

    @Test
    void testIfMoveNotValidMessagePrintsProperText() {
        message.moveNotValidMessage();
        assertEquals("This move is not valid!\n", outContent.toString());
    }

    @Test
    void testIfWonMessagePrintsProperText() throws CellNotEmptyException {
        Seed seed = Seed.CROSS;
        game.setCurrentPlayer(seed);
        String topRightCoordinate = ("1 1");
        String topCenterCoordinate = ("1 2");
        String topLeftCoordinate = ("1 3");
        game.getBoard().fillCell(seed, topCenterCoordinate);
        game.getBoard().fillCell(seed, topLeftCoordinate);
        game.getBoard().fillCell(seed, topRightCoordinate);
        game.updateGameState();
        message.wonMessage(game);
        assertEquals("CROSS_WON\n", outContent.toString());
    }

    @Test
    void testIfDrawMessagePrintsProperText() {
        message.drawMessage();
        assertEquals("It's a draw!\n", outContent.toString());
    }

    @Test
    void testIfWrongInputMessagePrintsProperText() {
        message.wrongInputMessage();
        assertEquals("Wrong input! Try again!\n", outContent.toString());
    }

    @Test
    void testIfExitMessagePrintsProperText() {
        message.exitMessage();
        assertEquals("Thanks for playing!\n", outContent.toString());
    }
}
