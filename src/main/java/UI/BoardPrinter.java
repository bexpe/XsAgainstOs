package UI;

import java.util.List;

public class BoardPrinter {

    public void printBoard(List<String> cellsContent) {
        System.out.println(String.format(
                    "+---+---+---+---+\n" +
                    "| %s  |  %s  |  %s |\n" +
                    "-----------------\n" +
                    "| %s  |  %s  |  %s |\n" +
                    "-----------------\n" +
                    "| %s  |  %s  |  %s |\n" +
                    "+---+---+---+---+",
                cellsContent.get(0), cellsContent.get(1), cellsContent.get(2),
                cellsContent.get(3), cellsContent.get(4), cellsContent.get(5),
                cellsContent.get(6), cellsContent.get(7), cellsContent.get(8)));
    }
}
