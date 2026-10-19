package test.movements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;

class PawnMovementsTest extends MovementsTest {
	
	@Test
	void pawnFirstMoves() {
		board.changePiece(4, 6, PieceFactory.create(PieceType.PAWN, PieceColor.WHITE));
		boolean[][] expected = grid(
			"........",
			"........",
			"........",
			"........",
			"....o...",
			"....o...",
			"........",
			"........");
		assertArrayEquals(expected, board.getMovements(4, 6));
	}

}
