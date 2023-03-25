/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

import g57958.chess.model.Game;
import g57958.chess.vieuw.TextVieuw;
import g57958.chess.controller.Controller;
import g57958.chess.model.Model;


/**
 *
 * @author ebrus
 */
public class Main {

    Model game = new Game();
    Controller controller = new Controller(game, new TextVieuw(game));
   controller.play();

 


}
