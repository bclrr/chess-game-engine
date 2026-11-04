package test.movements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;

class RookMovementsTest extends MovementsTest {

	@Test
	void rookMoves() {
		board.set(4, 4, PieceType.ROOK, PieceColor.WHITE);
		boolean[][] expected = grid(
			"....o...",
			"....o...",
			"....o...",
			"....o...",
			"oooo.ooo",
			"....o...",
			"....o...",
			"....o...");
		assertArrayEquals(expected, board.getMoves(4, 4));
	}
	
	@Test
	void rookBlockedByAlly() {
		board.set(4, 4, PieceType.ROOK, PieceColor.WHITE);
		board.set(4, 2, PieceType.BISHOP, PieceColor.WHITE);
		board.set(4, 6, PieceType.BISHOP, PieceColor.WHITE);
		board.set(2, 4, PieceType.BISHOP, PieceColor.WHITE);
		board.set(6, 4, PieceType.BISHOP, PieceColor.WHITE);
		boolean[][] expected = grid(
			"........",
			"........",
			"........",
			"....o...",
			"...o.o..",
			"....o...",
			"........",
			"........");
		assertArrayEquals(expected, board.getMoves(4, 4));
	}
	
	@Test
	void rookTakingBishop() {
		board.set(4, 4, PieceType.ROOK, PieceColor.WHITE);
		board.set(4, 2, PieceType.BISHOP, PieceColor.BLACK);
		board.set(4, 6, PieceType.BISHOP, PieceColor.BLACK);
		board.set(2, 4, PieceType.BISHOP, PieceColor.BLACK);
		board.set(6, 4, PieceType.BISHOP, PieceColor.BLACK);
		boolean[][] expected = grid(
			"........",
			"........",
			"....o...",
			"....o...",
			"..oo.oo.",
			"....o...",
			"....o...",
			"........");
		assertArrayEquals(expected, board.getMoves(4, 4));
	}

}
