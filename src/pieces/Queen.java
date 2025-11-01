package pieces;

import pieces.movements.DiagonalMovement;
import pieces.movements.Movement;
import pieces.movements.StraightMovement;

public class Queen extends Piece {

	public Queen(PieceColor _pieceColor) {
		super(PieceType.QUEEN, _pieceColor);
		Movement[] listMovements = new Movement[2];
		listMovements[0] = new StraightMovement();
		listMovements[1] = new DiagonalMovement();
		super.addMovements(listMovements);
	}

}
