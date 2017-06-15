package UI;

import Cell.CellNotEmptyException;
import Cell.Seed;
import Game.Game;
import UI.BoardPrinter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BoardPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private Game game;
    private BoardPrinter boardPrinter;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        this.boardPrinter = new BoardPrinter();
        this.game = new Game();
        game.initGame();
    }

    @AfterEach
    void cleanUp() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    void testIfBoardPrinterPrintsProperBoard() throws CellNotEmptyException {
        Seed cross = Seed.CROSS;
        Seed nought = Seed.NOUGHT;
        String topLeftCoordinate = ("1 1");
        String topCenterCoordinate = ("1 2");
        String topRightCoordinate = ("1 3");
        game.getBoard().fillCell(cross, topCenterCoordinate);
        game.getBoard().fillCell(cross, topLeftCoordinate);
        game.getBoard().fillCell(nought, topRightCoordinate);
        boardPrinter.printBoard(game.getBoard().getCellsContentAsString());
        Assertions.assertEquals(
                "+---+---+---+---+\n" +
                "| X  |  X  |  O |\n" +
                "-----------------\n" +
                "|    |     |    |\n" +
                "-----------------\n" +
                "|    |     |    |\n" +
                "+---+---+---+---+\n", outContent.toString());
    }
}
