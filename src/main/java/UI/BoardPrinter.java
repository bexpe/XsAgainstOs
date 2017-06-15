package UI;

import java.util.List;

public class BoardPrinter {
    private StringBuilder sb;

    public StringBuilder getSb() {
        return this.sb;
    }

    public void printBoard(List<String> cellsContent) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(
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
        this.sb =sb;
    }
}
