/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g57958.chess.model;



/**
 *represent one of the 64 squares on the game board 
 * @author ebrus
 */
public class Square {
    private Piece piece ;
    /**
     *  return null if square don't contain any piece
     * @param piece represent a case of the board
     */
    
    public Square(Piece piece) {
        
        this.piece = piece;
    }

    public Piece getPiece() {
        return this.piece;
    }

    /**
     * for setting an element of the square
     * @param piece 
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    /**
     * check if the case is empty or not
     * @return true if square is empty
     */
    public boolean isfree (){
       return (this.piece==null);
    }

    Color getColor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean isFree() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
