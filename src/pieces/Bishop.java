package pieces;

import pieces.movements.DiagonalMovement;
import pieces.movements.Movement;

public class Bishop extends Piece {

	public Bishop(PieceColor _pieceColor) {
		super(PieceType.BISHOP, _pieceColor);
		Movement[] listMovements = new Movement[1];
		listMovements[0] = new DiagonalMovement();
		super.addMovements(listMovements);
	}

}
