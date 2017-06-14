package Game;

import Board.Board;
import enums.GameState;
import enums.Seed;
import exceptions.CellNotEmptyException;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game {
    private Board board;
    private GameState gameState;
    private Seed currentPlayer;

    private final List<Seed> PLAYERS = Arrays.asList(Seed.CROSS, Seed.NOUGHT);
    private final Integer SIZE = PLAYERS.size();
    private final Random RANDOM = new Random();

    public void initGame() {
        this.board = new Board();
        this.gameState = GameState.PLAYING;
        this.currentPlayer = chooseRandomPlayer();
    }

    public Board getBoard() {
        return board;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Seed getCurrentPlayer() {
        return currentPlayer;
    }

    private Seed chooseRandomPlayer() {
        return PLAYERS.get(RANDOM.nextInt(SIZE));
    }

    public void updateGameState(Seed player, String coordinates) {
        if (board.hasWon()) {
            if (currentPlayer == Seed.CROSS) {
                setGameState(GameState.CROSS_WON);
            }
            setGameState(GameState.NOUGHT_WON);
        }
        if (board.isDraw()) {
            setGameState(GameState.DRAW);
        }

    }
}
