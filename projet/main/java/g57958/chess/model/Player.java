/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g57958.chess.model;

import g57958.chess.model.Color;

/**
 *
 * @author ebrus
 */
public class Player {

    private Color color;

    /**
     * initialize a new player of given color
     *
     * @param color
     */
    public Player(Color color) {
        this.color = color;
    }

    /**
     *
     * @return the attribute value of player color
     */
    public Color getColor() {
        return this.color;
    }

}
