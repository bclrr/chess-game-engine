package test.movements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;

class PawnMovementsTest extends MovementsTest {
	
	@Test
	void whitePawnFirstMoves() {
		board.set(4, 6, PieceType.PAWN, PieceColor.WHITE);
		boolean[][] expected = grid(
			"........",
			"........",
			"........",
			"........",
			"....o...",
			"....o...",
			"........",
			"........");
		assertArrayEquals(expected, board.getMoves(4, 6));
	}
	
	@Test
	void blackPawnFirstMoves() {
		board.set(4, 1, PieceType.PAWN, PieceColor.BLACK);
		boolean[][] expected = grid(
			"........",
			"........",
			"....o...",
			"....o...",
			"........",
			"........",
			"........",
			"........");
		assertArrayEquals(expected, board.getMoves(4, 1));
	}
	
	@Test
	void whitePawnTakingPiece() {
		board.set(4, 4, PieceType.PAWN, PieceColor.WHITE);
		board.set(5, 3, PieceType.ROOK, PieceColor.BLACK);
		board.set(3, 3, PieceType.BISHOP, PieceColor.BLACK);
		boolean[][] expected = grid(
			"........",
			"........",
			"........",
			"...ooo..",
			"........",
			"........",
			"........",
			"........");
		assertArrayEquals(expected, board.getMoves(4, 4));
	}
	
	@Test
	void blackPawnTakingPiece() {
		board.set(4, 4, PieceType.PAWN, PieceColor.BLACK);
		board.set(5, 5, PieceType.ROOK, PieceColor.WHITE);
		board.set(3, 5, PieceType.BISHOP, PieceColor.WHITE);
		boolean[][] expected = grid(
			"........",
			"........",
			"........",
			"........",
			"........",
			"...ooo..",
			"........",
			"........");
		assertArrayEquals(expected, board.getMoves(4, 4));
	}
	
	@Test
	void whitePawnBlockedByAlly() {
		board.set(4, 4, PieceType.PAWN, PieceColor.WHITE);
		board.set(4, 3, PieceType.ROOK, PieceColor.WHITE);
		board.set(3, 3, PieceType.BISHOP, PieceColor.BLACK);
		boolean[][] expected = grid(
			"........",
			"........",
			"........",
			"...o....",
			"........",
			"........",
			"........",
			"........");
		assertArrayEquals(expected, board.getMoves(4, 4));
	}
	
	@Test
	void blackPawnBlockedByAlly() {
		board.set(4, 4, PieceType.PAWN, PieceColor.BLACK);
		board.set(4, 5, PieceType.ROOK, PieceColor.BLACK);
		board.set(5, 5, PieceType.BISHOP, PieceColor.WHITE);
		boolean[][] expected = grid(
			"........",
			"........",
			"........",
			"........",
			"........",
			".....o..",
			"........",
			"........");
		assertArrayEquals(expected, board.getMoves(4, 4));
	}

}
