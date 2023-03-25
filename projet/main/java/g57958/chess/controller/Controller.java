package g57958.chess.controller;

import g57958.chess.model.Position;
import g57958.chess.model.Model;
import g57958.chess.vieuw.Vieuw;

/**
 * Controller is responsible for the dynamics of the game and updating the view
 * as the game progresses.
 *
 * @author ebrus
 */
public class Controller {

    private final Model game;
    private final Vieuw view;

    public Controller(Model game, Vieuw view) {
        this.game = game;
        this.view = view;
    }

    /**
     * this method drives the game
     */
    public void play() {
        boolean gameIsOver = false;
        this.view.displayTitle();
        this.game.start();

        while (!gameIsOver) {
            this.view.displayPlayer();
            this.view.displayBoard();
            Position oldPos = view.askPosition();

            Position newPos = view.askPosition();
            try {

                this.game.movePiecePosition(oldPos, newPos);
            } catch (IllegalArgumentException exception) {
                this.view.displayError(exception.getMessage());
            }
            this.view.displayPlayer();
            this.view.displayBoard();
            gameIsOver = this.game.isGameOver();
        }
        this.view.displayWinner();
    }
}
