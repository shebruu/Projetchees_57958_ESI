/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package g57958.chess.model;

/**
 *represents a location direction in the game board 
 * @author ebrus
 */
public enum Direction {
    NO (1,-1),
    N(1,0),
    NE(1,1),
    W(0,-1),
    E(0,1),
    SW(-1,-1),
    S(-1,0),
    SE(-1,-1);
    
    private int deltaRow;
    private int deltaColumn;

   /**
    *  initialize the values of
deltaRow and deltaColumn. 
    * @param deltaRow represent the  rows of the board
    * @param deltaColumn represent the columns of the board
    */
    private Direction(int deltaRow, int deltaColumn) { // utilisable que ds cette classe pas ds une autre!
        this.deltaRow = deltaRow;
        this.deltaColumn = deltaColumn;
    }
/**
 * 
 * @return the value of move for rows
 */
    public int getDeltaRow() {
        return this.deltaRow;
    }
 /**
  * 
  * @return the value of move for columns
  */
    public int getDeltaColumn() {
        return this.deltaColumn;
    }
    
    
}