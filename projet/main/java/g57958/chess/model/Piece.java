package g57958.chess.model;

import java.util.List;
import java.util.ArrayList;

/**
 * represent a pion of the board
 *
 * @author ebrus
 */
public class Piece {

    private Color color;

    // private Piece[][] echequier = new Piece[8][8];
    /**
     * initialize the pion with the given color
     *
     * @param color
     */
    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    /*
    private  Position deplace1case (Position position,Board board){
        
        
        if (square position.getRow()position.getColumn()==Color.BLACK){
            Direction mov =Direction.S;
        } else{
            Direction  mov=Direction.N;
        }
        Position mov = null;
        
     return mov;
       
    squares[pos.getRow()][pos.getColumn()]
    }
     */
    public List<Position> getPossibleMoves(Position pos, Board board) {
        List<Position> possiblePositions = new ArrayList<>();
        possiblePositions.addAll(possibleAdvances(pos, board));
        possiblePositions.addAll(possibleCaptures(pos, board));
        return possiblePositions;
    }

    public List<Position> possibleAdvances(Position pos, Board board) {
        List<Position> possibleAdvances = new ArrayList<>();
        //La direction dépend de la couleur du joueur 
        Direction forward = this.color == Color.BLACK ? Direction.S
                : Direction.N;
        //1ère Position devant

        Position nextPos = pos.next(forward);
        //SI la position dépend, pas d'avance possible.
        //Sinon regardons si c'est libre
        if (board.contains(nextPos) && board.isFree(nextPos)) {
            //Cas prochaine position libre, on ajoute
            possibleAdvances.add(nextPos);
            if (pos.getRow() == board.getInitialPawnRow(this.color)) {
                // Premier mouvement, regardons aussi 2 cases après
                Position secondPos = nextPos.next(forward);
                //**Pas besoin de regarder si on dépasse, étant d'office
                // en position de départ**
                //Si la seconde position est libre, possible d'y aller.
                if (board.isFree(secondPos)) {
                    possibleAdvances.add(secondPos);
                }
            }
        }
        return possibleAdvances;
    }

    /**
     *
     * @param pos given position
     * @param board
     * @return a list with possiblescaptures
     */
    public List<Position> possibleCaptures(Position pos, Board board) {
        List<Position> possibleCaptures = new ArrayList<>();
        // Les directions dépendent de la couleur du joueur.
        //LeftDiag : Diagonale vers la gauche
        Direction leftDiag = this.color == Color.BLACK ? Direction.SW
                : Direction.NO;
        //RightDiag : Diagonale vers la droite
        Direction rightDiag = this.color == Color.BLACK ? Direction.SE
                : Direction.NE;
        //Position en diagonale gauche
        Position nextPosLeft = pos.next(leftDiag);
        //Position en diagonale droite
        Position nextPosRight = pos.next(rightDiag);
        //Si la position à gauche est dans le plateau, et qu'une pièce
        // adverse l'occupe, à taaaable.
        if (board.contains(nextPosLeft)
                && board.containsOppositeColor(nextPosLeft, this.color)) {
            possibleCaptures.add(nextPosLeft);
        }
        //Idem pour la position à droite.
        if (board.contains(nextPosRight)
                && board.containsOppositeColor(nextPosRight, this.color)) {
            possibleCaptures.add(nextPosRight);
        }
        return possibleCaptures;

    }

}
