package test.movements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;

class PawnMovementsTest extends MovementsTest {
	
	@Test
	void whitePawnFirstMoves() {
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
	
	@Test
	void blackPawnFirstMoves() {
		board.changePiece(4, 1, PieceFactory.create(PieceType.PAWN, PieceColor.BLACK));
		boolean[][] expected = grid(
			"........",
			"........",
			"....o...",
			"....o...",
			"........",
			"........",
			"........",
			"........");
		assertArrayEquals(expected, board.getMovements(4, 1));
	}
	
	@Test
	void whitePawnTakingPiece() {
		board.changePiece(4, 4, PieceFactory.create(PieceType.PAWN, PieceColor.WHITE));
		board.changePiece(5, 3, PieceFactory.create(PieceType.ROOK, PieceColor.BLACK));
		board.changePiece(3, 3, PieceFactory.create(PieceType.BISHOP, PieceColor.BLACK));
		boolean[][] expected = grid(
			"........",
			"........",
			"........",
			"...ooo..",
			"........",
			"........",
			"........",
			"........");
		assertArrayEquals(expected, board.getMovements(4, 4));
	}
	
	@Test
	void blackPawnTakingPiece() {
		board.changePiece(4, 4, PieceFactory.create(PieceType.PAWN, PieceColor.BLACK));
		board.changePiece(5, 5, PieceFactory.create(PieceType.ROOK, PieceColor.WHITE));
		board.changePiece(3, 5, PieceFactory.create(PieceType.BISHOP, PieceColor.WHITE));
		boolean[][] expected = grid(
			"........",
			"........",
			"........",
			"........",
			"........",
			"...ooo..",
			"........",
			"........");
		assertArrayEquals(expected, board.getMovements(4, 4));
	}
	
	@Test
	void whitePawnBlockedByAlly() {
		board.changePiece(4, 4, PieceFactory.create(PieceType.PAWN, PieceColor.WHITE));
		board.changePiece(4, 3, PieceFactory.create(PieceType.ROOK, PieceColor.WHITE));
		board.changePiece(3, 3, PieceFactory.create(PieceType.BISHOP, PieceColor.BLACK));
		boolean[][] expected = grid(
			"........",
			"........",
			"........",
			"...o....",
			"........",
			"........",
			"........",
			"........");
		assertArrayEquals(expected, board.getMovements(4, 4));
	}
	
	@Test
	void blackPawnBlockedByAlly() {
		board.changePiece(4, 4, PieceFactory.create(PieceType.PAWN, PieceColor.BLACK));
		board.changePiece(4, 5, PieceFactory.create(PieceType.ROOK, PieceColor.BLACK));
		board.changePiece(5, 5, PieceFactory.create(PieceType.BISHOP, PieceColor.WHITE));
		boolean[][] expected = grid(
			"........",
			"........",
			"........",
			"........",
			"........",
			".....o..",
			"........",
			"........");
		assertArrayEquals(expected, board.getMovements(4, 4));
	}

}
