package g57958.chess.model;

import java.util.List;
import java.util.ArrayList;

/**
 * Game takes he elements necessary for the game, and implements the different
 * stages of it. She is the point privileged access for view and controller
 *
 *
 * @author ebrus
 */
public class Game implements Model {

    private Board board;
    private Player white, black, currentPlayer;

    public Game() {
        this.board = new Board();
        this.white = new Player(Color.WHİTE);
        this.black = new Player(Color.BLACK);

    }

   

   

    /**
     * Start the game: create the pieces and put them on the board, initialize
     * the current player to 'WHITE'.  ----------
     * 
     */
    @Override
    public void start() {
          this.currentPlayer = this.white;
        for (int col = 0; col < 8; col++) {
            this.board.setPiece(new Piece(this.white.getColor()),
                    new Position(this.board.getInitialPawnRow(white.getColor()), col));
            this.board.setPiece(new Piece(this.black.getColor()),
                    new Position(this.board.getInitialPawnRow(black.getColor()),
                            col));
        }
    }

    /**
     * Get the piece of the board located on a given position
     *
     * @param pos the position
     * @return the piece located at P
     * @throws IllegalArgumentException pos is not located on the board.
     */
    @Override
    public Piece getPiece(Position pos) {

        if (!board.contains(pos)) {
            throw new IllegalArgumentException("pos is not located on the board");
        }
 
         return this.board.getPiece(pos);
    }

    /**
     * Getter for the current player.
     *
     * @return the current player.
     */
    @Override
    public Player getCurrentPlayer() {

        return this.currentPlayer;
    }

    /**
     * Getter for the second player.
     *
     * @return the player that is waiting
     */
    @Override
    public Player getOppositePlayer() {
        Player opposite;
    if (this.currentPlayer == this.white){
        opposite= this.black;
    }else{
        opposite=this.white;
    }
    return opposite;
    }

    /**
     * Check if the square at the given position is occupied by a piece of the
     * current player.
     *
     * @param pos the postion
     * @return true if the position is occupied by a piece of the current
     * player, false otherwise. piece == couleur dla coul joueur cour
     * @throws IllegalArgumentException if the position is not located on the
     * board.
     */
    @Override
    public boolean isCurrentPlayerPosition(Position pos) {
        boolean resultat = true;
        if (!board.contains(pos)) {
            throw new IllegalArgumentException("pos is not located on the board");
        }// free? et piece 

        if (!this.board.isFree(pos) && this.board.getPiece(pos).getColor() == this.currentPlayer.getColor()) {
            resultat = true;

        } else {
            resultat = false;
        }
        return resultat;
    }

    /**
     * Moves a piece from one position of the chess board to another one. If the
     * game is not over, change the current player.
     *
     * @param oldPos the current position
     * @param newPos the new position of the board where to put the piece
     * @throws IllegalArgumentException if 1) oldPos or newPos are not located
     * on the board, or 2) oldPos does not contain a piece, or 3) the piece does
     * not belong to the current player, or 4) the move is not valid for the
     * piece located at position oldPos
     */
    @Override
    public void movePiecePosition(Position oldPos, Position newPos) {
      if (this.board.contains(oldPos) && this.board.contains(newPos)) {
            if (!this.board.isFree(oldPos)) {
                if (this.board.containsOppositeColor(oldPos,
                        this.currentPlayer.getColor()))
                    throw new IllegalArgumentException("This position is not " +
                            "occupied by the current player!");
                if (!this.board.getPiece(oldPos).getPossibleMoves(oldPos,
                        this.board).contains(newPos))
                    throw new IllegalArgumentException("Move not possible !");
                this.board.setPiece(this.getPiece(oldPos), newPos);
                this.board.dropPiece(oldPos);
                if (!this.isGameOver()) this.currentPlayer =
                        this.getOppositePlayer();
            }
        }
    }
      
      
        
    
    

    /**
     * Check if the game is over or not soit blanc soit noir plus de piece et n
     * arrive plus a bouger
     *
     * @return true if the game is over, false otherwise.
     */
     @Override
    public boolean isGameOver() {
        return false;
    }


    /**
     * Get the possible moves for the piece located at the specified position.
     *
     * @param position the position of the piece
     * @return the liste of admissible positions.
     */
    public List<Position> getPossibleMoves(Position position) {
         List<Position> possibleMoves = new ArrayList<>();
         if (board.isFree(position)) return possibleMoves;
        return board.getPiece(position).getPossibleMoves(position, this.board);
      
        }

}

