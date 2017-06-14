package UI;

import Game.Game;

public class Messages {
    public void turnMessage(Game game) {
        System.out.println("Current player is: " + game.getCurrentPlayer());
    }

    public void playerInputMessage(Game game) {
        System.out.println("Player "+ game.getCurrentPlayer() +", enter your move (row[1-3], column[1-3])");
    }

    public void moveNotValidMessage() {
        System.out.println("This move is not valid!");
    }

    public void wonMessage(Game game) {
        System.out.println(game.getCurrentPlayer() + " has won!");
    }

    public void drawMessage() {
        System.out.println("It's a draw!");
    }

    public void playAgainMessage() {
        System.out.println("Do you want to play again [Y/N]");
    }
}
