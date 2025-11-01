package pieces;

import pieces.movements.KnightMovement;
import pieces.movements.Movement;

public class Knight extends Piece {

	public Knight(PieceColor _pieceColor) {
		super(PieceType.KING, _pieceColor);
		Movement[] listMovements = new Movement[1];
		listMovements[0] = new KnightMovement();
		super.addMovements(listMovements);
	}

}
