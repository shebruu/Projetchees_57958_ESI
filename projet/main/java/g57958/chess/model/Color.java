/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package g57958.chess.model;

/**
 * representof the color of a player, a square or a piece in the board
 *
 * @author ebrus
 */
public enum Color {
    WHİTE, BLACK; // enum tjrs, 
  

    /**
     *
     * @param color
     * @return the opposite color
     */
    public  Color opposite() {
        return this== WHİTE ? BLACK : WHİTE;
    }
    
}
