/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g57958.chess.model;

/**
 * represent a position in the board of the chess game.
 *
 * @author ebrus
 */
public class Position {

    private int row;
    private int column;

    /**
     * Defines a position with its row and its column.
     *
     * @param row the given integer for row
     * @param column the given integer for column
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Gets the number of row represented by this board object.
     *
     * @return the number of row in the board
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Gets the number of column represented by this board object.
     *
     * @return the number of column in the board
     */
    public int getColumn() {
        return this.column;
    }

    @Override
    public String toString() {
        return column + "" + row;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.row;
        hash = 43 * hash + this.column;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        return this.column == other.column;
    }

    /**
     *
     * @param dir
     * @return the new position obtained by moving in the given direction,
     */
    public Position next(Direction dir) {
        return new Position(this.row + dir.getDeltaRow(), this.column + dir.getDeltaColumn());
    }

    //penser a tostring () et equals() apres!!!
}
