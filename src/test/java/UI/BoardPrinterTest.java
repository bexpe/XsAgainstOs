package UI;

import UI.BoardPrinter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BoardPrinterTest {
    @Test
    void testPrintBoard() {
        BoardPrinter newBoard = new BoardPrinter();
        List<String> cellsContent = new ArrayList<>();
        String[] seeds = {"X"," "," "," "," ","X"," "," ","X"};

        for(int i =  0; i < seeds.length; i++){
            cellsContent.add(seeds[i]);
        }
        newBoard.printBoard(cellsContent);
        assertEquals(newBoard.getSb().toString(),
                "+---+---+---+---+\n" +
                "| X  |     |    |\n" +
                "-----------------\n" +
                "|    |     |  X |\n" +
                "-----------------\n" +
                "|    |     |  X |\n" +
                "+---+---+---+---+" );
    }
}
