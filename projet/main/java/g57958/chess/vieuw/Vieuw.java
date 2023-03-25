/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package g57958.chess.vieuw;

import g57958.chess.model.Board;
import g57958.chess.model.Position;
import g57958.chess.model.Player;
import g57958.chess.model.Piece;

/**
 * InterfaceView has all the methods that must in the view for a correct
 * progress in the game.
 *
 * @author ebrus
 */
public interface Vieuw {

    public void displayTitle();

    public void displayBoard();

    public void displayWinner();

    public void displayPlayer();

    public Position askPosition();

    public void displayError(String message);

    //  public  void displayPossibilities(Position pos);
    // public   void displayWantedMove(Position from,Position to);
}
