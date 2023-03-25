/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g57958.chess.vieuw;

import g57958.chess.model.*;

import java.util.Scanner;

/**
 *
 * @author ebrus
 */
public class TextVieuw implements Vieuw {

    private Model model;

    public TextVieuw(Model model) {
        this.model = model;
    }

    //attr de model
    /**
     * displays a title and welcome message to players
     *
     */
    @Override
    public void displayTitle() {

        System.out.println("Welcome to Chess !");

    }

    /**
     * shows the winning player.
     *
     */
    @Override
    public void displayBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        sb.append("---".repeat(8));
        sb.append("\n");
        for (int row = 0; row < 8; row++) {
            sb.append(8 - row).append(" ");
            for (int col = 0; col < 8; col++) {
                Position currentPosition = new Position(row, col);
                sb.append("|").append(this.model.getPiece(currentPosition) == null ? "  "
                        : this.model.getPiece(currentPosition).getColor() == Color.WHİTE ? "PB" : "PN");
            }
            sb.append("|\n");
        }
        sb.append("  ");
        sb.append("---".repeat(8));
        sb.append("\n");
        sb.append("   ");
        for (char letter = 'a'; letter <= 'h'; letter++) {
            sb.append(letter).append("  ");
        }
        String boardDisplay = sb.toString();
        System.out.println(boardDisplay);
    }

    /**
     * displays the game board. See the important note at this statement below.
     */
    @Override
    public void displayWinner() {
        System.out.println("Winner displayed");

    }

    /**
     * displays a message inviting the current player (white or black) to player
     *
     * 
     */
    @Override
    public void displayPlayer() {
        System.out.println("Current player is "
                + this.model.getCurrentPlayer().getColor());

    }

    /**
     * requests a valid position on the game board from the user. See the
     * important note about this below.
     *
     * 
     */
    @Override
    public Position askPosition() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("choose a Column(a-h) and Row(1-8)? (For example : a7) ");

        while (!keyboard.hasNext("([0-8]+),([0-8]+)")) {
            displayError(
                    "Veuillez suivre le format de position [ligne,colonne] : ");
            keyboard.next();
        }

        String[] positions = keyboard.next().split(",");
        return new Position(Integer.parseInt(positions[0]),
                Integer.parseInt(positions[1]));
    }

    /**
     * : affiche le message d’erreur passé en paramètre.
     *
     * @param message
     * 
     */
    @Override
    public void displayError(String message) {
        System.err.println(message);
    }

}
