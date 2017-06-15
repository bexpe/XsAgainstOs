package Game;

import Board.Board;
import Cell.Seed;

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
        this.board.init();
        this.gameState = GameState.PLAYING;
        this.currentPlayer = chooseRandomPlayer();
    }

    public Board getBoard() {
        return board;
    }

    public GameState getGameState() {
        return gameState;
    }

    private void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Seed getCurrentPlayer() {
        return currentPlayer;
    }

    private void setCurrentPlayer(Seed player) {
        this.currentPlayer = player;
    }

    private Seed chooseRandomPlayer() {
        return PLAYERS.get(RANDOM.nextInt(SIZE));
    }

    public void updateGameState() {
        if (board.hasWon()) {
            switch (getCurrentPlayer()) {
                case NOUGHT:
                    setGameState(GameState.NOUGHT_WON);
                    break;
                case CROSS:
                    setGameState(GameState.CROSS_WON);
                    break;
            }
        } else if (board.isDraw()) {
            setGameState(GameState.DRAW);
        }
    }

    public void changePlayer() {
        switch (currentPlayer) {
            case CROSS:
                setCurrentPlayer(Seed.NOUGHT);
                break;
            case NOUGHT:
                setCurrentPlayer(Seed.CROSS);
                break;
        }
    }
}
