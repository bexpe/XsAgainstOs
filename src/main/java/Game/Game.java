package Game;

import Board.Board;
import enums.GameState;
import enums.Seed;

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
}
