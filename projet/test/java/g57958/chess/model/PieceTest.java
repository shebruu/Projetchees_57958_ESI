package g57958.chess.model;


import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author srexhep
 */
public class PieceTest {
    
    Board board;
    
    public PieceTest() {
    }
    
    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testGetPossibleMovesWinit() {
        Position position = new Position(1,1);
        Piece piece = new Piece(Color.WHİTE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(3, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
     @Test
    public void testGetPossibleMovesWninit() {
        Position position = new Position(6,7);
        Piece piece = new Piece(Color.WHİTE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(7, 7)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
        @Test
    public void testGetPossibleMovesBlnotinit() {
        Position position = new Position(3,4);
        Piece piece = new Piece(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 4) );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
       public void testGetPossibleMovesblposinit() {
        Position position = new Position(6,6);
        Piece piece = new Piece(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(5,6),
                 new Position (4,6));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    
   
    
    /*
     *      Permet de tester si deux listes de positions sont identiques à l'ordre
     *      des éléments prêts. Cette méthode est appelée
     *      par les méthodes de test.
     */
    private void assertEqualsIgnoringOrder(List<Position> expected, List<Position> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));
    }
    
}
