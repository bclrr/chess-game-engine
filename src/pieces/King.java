package pieces;

import pieces.movements.KingMovement;
import pieces.movements.Movement;

public class King extends Piece {

	public King(PieceColor _pieceColor) {
		super(PieceType.KING, _pieceColor);
		Movement[] listMovements = new Movement[1];
		listMovements[0] = new KingMovement();
		super.addMovements(listMovements);
	}

}
