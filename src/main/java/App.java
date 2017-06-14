import Game.Game;

public class App {
    Game game;

    public void startGame() {
        game = new Game();
        game.initGame();

        Boolean isPlaying = true;
        while (isPlaying) {
            System.out.println("Current player is: " + game.getCurrentPlayer());

        }
    }
}
