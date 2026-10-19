package test.movements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;

class RookMovementsTest extends MovementsTest {

	@Test
	void rookMoves() {
		board.changePiece(4, 4, PieceFactory.create(PieceType.ROOK, PieceColor.WHITE));
		boolean[][] expected = grid(
			"....o...",
			"....o...",
			"....o...",
			"....o...",
			"oooo.ooo",
			"....o...",
			"....o...",
			"....o...");
		assertArrayEquals(expected, board.getMovements(4, 4));
	}
	
	@Test
	void rookBlockedByAlly() {
		board.changePiece(4, 4, PieceFactory.create(PieceType.ROOK, PieceColor.WHITE));
		board.changePiece(4, 6, PieceFactory.create(PieceType.BISHOP, PieceColor.WHITE));
		boolean[][] expected = grid(
			"....o...",
			"....o...",
			"....o...",
			"....o...",
			"oooo.ooo",
			"....o...",
			"........",
			"........");
		assertArrayEquals(expected, board.getMovements(4, 4));
	}
	
	@Test
	void rookTakingBishop() {
		board.changePiece(4, 4, PieceFactory.create(PieceType.ROOK, PieceColor.WHITE));
		board.changePiece(4, 6, PieceFactory.create(PieceType.BISHOP, PieceColor.BLACK));
		boolean[][] expected = grid(
			"....o...",
			"....o...",
			"....o...",
			"....o...",
			"oooo.ooo",
			"....o...",
			"....o...",
			"........");
		assertArrayEquals(expected, board.getMovements(4, 4));
	}

}
