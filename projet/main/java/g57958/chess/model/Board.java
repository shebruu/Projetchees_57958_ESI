/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g57958.chess.model;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ebrus
 */
public class Board {

    private Square[][] squares;
    private Position pos;

    /**
     * Defines an inital board and make an new instance of board.
     *
     */
    public Board() {
        this.squares = new Square[8][8];

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                this.squares[i][j] = new Square(null);  //new Square () pour un vrai Square!!
            }

        }
        //this.squares[0][0].setPiece(new Piece(Color.BLACK)); faut mettre dans le main
    }

    /**
     * verify if the given position is in the board.
     *
     * @param pos the given positon
     * @return true if the position is on the board, false otherwise
     */
    public boolean contains(Position pos) {
        int ligne = pos.getRow();
        int colonne = pos.getColumn();
        if (pos == null) {
            throw new IllegalArgumentException("the position is null!");
        }
       
      
        return (ligne >= 0 && ligne <=7) && (colonne >=0 && colonne <=7);

    }

    /**
     * set the given piece on the given position
     *
     * @param piece the given piec
     * @param position the given position
     */
    public void setPiece(Piece piece, Position position) {
        int ligne = position.getRow();
        int col = position.getColumn();

        if (contains(position)) {
            this.squares[ligne][col].setPiece(piece);
        } else {
            throw new IllegalArgumentException("the position must be ın the board");
        }

    }

    /**
     *
     * @param pos given position
     * @return the piece on the given position in the square
     */
    public Piece getPiece(Position pos) {

        if (!this.contains(pos)) {
            throw new IllegalArgumentException("the position must be in the board");

        }
        return squares[pos.getRow()][pos.getColumn()].getPiece();
    }

    /**
     *
     * @param color the given piece's color
     * @return the row number on the board, the number 1 for the white and the
     * number 2 for black
     */
 public int getInitialPawnRow(Color color) {
        return color == Color.BLACK ? 6 : 1;
    }

    /**
     * removes the piece from the given position
     *
     * @param pos a given position
     */
    public void dropPiece(Position pos) {
        if (!this.contains(pos)) {
            throw new IllegalArgumentException("the position must be on the board");
        }

        this.squares[pos.getRow()][pos.getColumn()] = new Square(null); // va se deplacer a la case et creer une nouvelle case et supprimer l ancien 

    }

    /**
     *
     * @param pos position of the piece on the board
     * @return true if the given position box is free (there is no room above)
     * and false otherwise.
     */
     public boolean isFree(Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("the position must be on the board");
        }

        Piece resultat = squares[pos.getRow()][pos.getColumn()].getPiece(); //
        return resultat == null;
    }


    /**
     * verify that a square is occupied by the opposing piece.
     *
     * @param pos position
     * @param col color
     * @return true if the box whose position passed as a parameter contains a
     * piece of the color opposite
     */
    public boolean containsOppositeColor(Position pos, Color col) {
         if (!this.contains(pos)) {
            throw new IllegalArgumentException("the position is not on the board!");
        }

        return this.squares[pos.getRow()][pos.getColumn()].getPiece()!=null
                &&this.squares[pos.getRow()][pos.getColumn()].getPiece().getColor() == col.opposite();
    }


    /**
     *
     *
     *
     * @param player given player
     * @return a list of all positions occupied by the player
     *
     *
     */
    public List<Position> getPositionsOccupiedBy(Player player) {
// ArrayList<Position>()= new ArrayList();
        // fıxme verıfıer sı player est null 
        if (player ==null){
            throw new IllegalArgumentException("the player must not be null!");
        }
       var liste = new ArrayList<Position>();
        for (int i = 0; i < this.squares.length; i++) {//lignes
            for (int j = 0; j <this.squares[i].length; j++) {// parcourt les colonnes 
                if (this.squares[i][j] != null && this.squares[i][j].getPiece()!=null
                        &&this.squares[i][j].getPiece().getColor() == player.getColor()) {
                    liste.add(new Position(i, j));
                }
            }
        }

        return liste;

    }

}
