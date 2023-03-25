/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package g57958.chess.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author ebrus
 */
public class PositionTest {


    /**
     * Test of next method, of class Position.
     * a faire le test 8 fois pour chaque position et changer les NE,SW
     */ 
    @Test
    public void testNext_cas1() {
        Direction dir = Direction.NE;
        Position instance = new Position (3,2);
        Position expResult = new Position (4,3); //res attendu on doit calculer et connaitre a l avance
        Position result = instance.next(dir);
        //assertEquals(expResult, result);  pas de methode equals donc soucis poure echapper a ce soucis j utilise un getter pour comparer les deux
        assertEquals(result.getRow(),expResult.getRow()); //on compare row avec ce que j esperrais
        assertEquals(result.getColumn(), expResult.getColumn());
    }
       @Test
    public void testNext_cas2() {
        Direction dir = Direction.NO;
        Position instance = new Position (3,2);
        Position expResult = new Position (4,1); 
        Position result = instance.next(dir);
        assertEquals(result.getRow(),expResult.getRow()); 
        assertEquals(result.getColumn(), expResult.getColumn());
    }
      /**
     * Test of next method, of class Position.
     * a faire le test 8 fois pour chaque position et changer les NE,SW
     */ 
    @Test
    public void testNext_cas3() {
        Direction dir = Direction.N;
        Position instance = new Position (3,2);
        Position expResult = new Position (4,2); 
        Position result = instance.next(dir);
       
        assertEquals(result.getRow(),expResult.getRow()); //on compare row avec ce que j esperrais
        assertEquals(result.getColumn(), expResult.getColumn());
    }
     /**
     * Test of next method, of class Position.
     *
     */ 
    @Test
    public void testNext_cas4() {
        Direction dir = Direction.W;
        Position instance = new Position (3,2);
        Position expResult = new Position (3,1); 
        Position result = instance.next(dir);
       
        assertEquals(result.getRow(),expResult.getRow()); //on compare row avec ce que j esperrais
        assertEquals(result.getColumn(), expResult.getColumn());
    }
      /**
     * Test of next method, of class Position.
     *
     */ 
    @Test
    public void testNext_cas5() {
        Direction dir = Direction.E;
        Position instance = new Position (3,2);
        Position expResult = new Position (3,3); 
        Position result = instance.next(dir);
       
        assertEquals(result.getRow(),expResult.getRow()); 
        assertEquals(result.getColumn(), expResult.getColumn());
    }
        /**
     * Test of next method, of class Position.
     *
     */ 
    @Test
    public void testNext_cas6() {
        Direction dir = Direction.SW;
        Position instance = new Position (3,2);
        Position expResult = new Position (2,1); 
        Position result = instance.next(dir);
       
        assertEquals(result.getRow(),expResult.getRow()); 
        assertEquals(result.getColumn(), expResult.getColumn());
    }
            /**
     * Test of next method, of class Position.
     *
     */ 
    @Test
    public void testNext_cas7() {
        Direction dir = Direction.S;
        Position instance = new Position (3,2);
        Position expResult = new Position (2,2); 
        Position result = instance.next(dir);
       
        assertEquals(result.getRow(),expResult.getRow()); 
        assertEquals(result.getColumn(), expResult.getColumn());
    }
                /**
     * Test of next method, of class Position.
     *
     */ 
    @Test
    public void testNext_cas8() {
        Direction dir = Direction.SE;
        Position instance = new Position (3,2);
        Position expResult = new Position (2,1); 
        Position result = instance.next(dir);
       
        assertEquals(result.getRow(),expResult.getRow()); 
        assertEquals(result.getColumn(), expResult.getColumn());
    }
}

