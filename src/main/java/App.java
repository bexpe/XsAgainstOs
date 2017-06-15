import Cell.CellNotEmptyException;
import Game.Game;
import Game.GameState;
import UI.BoardPrinter;
import UI.Input;
import UI.Message;

class App {
    private Game game;
    private Message message = new Message();
    private Input input = new Input();
    private BoardPrinter boardPrinter = new BoardPrinter();

    void run() {
        Boolean isRunning = true;
        while (isRunning) {
            game = new Game();
            game.initGame();
            message.menuMessage();
            String option = input.menuInput();
            switch (option) {
                case "1":
                    game();
                    break;
                case "2":
                    message.exitMessage();
                    isRunning = false;
            }
        }
    }

    private void game() {
        while (game.getGameState() == GameState.PLAYING) {
            boardPrinter.printBoard(game.getBoard().getCellsContentAsString());
            message.turnMessage(game);
            message.playerInputMessage(game);
            String coordinates = input.turnInput();
            try {
                game.getBoard().fillCell(game.getCurrentPlayer(), coordinates);
                game.updateGameState();
                game.changePlayer();
            } catch (CellNotEmptyException | IndexOutOfBoundsException e) {
                message.moveNotValidMessage();
            }
        }
        switch (game.getGameState()) {
            case CROSS_WON:
            case NOUGHT_WON:
                boardPrinter.printBoard(game.getBoard().getCellsContentAsString());
                message.wonMessage(game);
                break;
            case DRAW:
                message.drawMessage();
                break;
        }
    }
}
