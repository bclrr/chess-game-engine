package pieces;

import pieces.movements.Movement;
import pieces.movements.StraightMovement;

public class Rook extends Piece {

	public Rook(PieceColor _pieceColor) {
		super(PieceType.ROOK, _pieceColor);
		Movement[] listMovements = new Movement[1];
		listMovements[0] = new StraightMovement();
		super.addMovements(listMovements);
	}

}
