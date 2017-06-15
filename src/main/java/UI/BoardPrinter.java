package UI;

import Board.Board;
import Cell.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardPrinter {

    public void printBoard(Board board) {
        List<String> cellsContent = new ArrayList<>();
        for (Map.Entry<String, Cell> entry : board.getCells().entrySet()) {
            Cell cell = entry.getValue();
            switch (cell.getContent()) {
                case CROSS:
                    cellsContent.add("X");
                    break;
                case NOUGHT:
                    cellsContent.add("O");
                    break;
                case EMPTY:
                    cellsContent.add(" ");
                    break;
            }
        }
        
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
