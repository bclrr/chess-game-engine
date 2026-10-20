package test.movements;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;

class KnightMovementsTest extends MovementsTest {

	@Test
	void knightMoves() {
		board.changePiece(4, 4, PieceFactory.create(PieceType.KNIGHT, PieceColor.WHITE));
		boolean[][] expected = grid(
			"........",
			"........",
			"...o.o..",
			"..o...o.",
			"........",
			"..o...o.",
			"...o.o..",
			"........");
		assertArrayEquals(expected, board.getMoves(4, 4));
	}

	@Test
	void knightWithPiecesNear() {
		board.changePiece(4, 4, PieceFactory.create(PieceType.KNIGHT, PieceColor.WHITE));
		board.changePiece(4, 5, PieceFactory.create(PieceType.PAWN, PieceColor.WHITE));
		board.changePiece(5, 5, PieceFactory.create(PieceType.PAWN, PieceColor.WHITE));
		board.changePiece(5, 4, PieceFactory.create(PieceType.PAWN, PieceColor.WHITE));
		board.changePiece(3, 4, PieceFactory.create(PieceType.PAWN, PieceColor.WHITE));
		board.changePiece(4, 3, PieceFactory.create(PieceType.PAWN, PieceColor.BLACK));
		board.changePiece(3, 3, PieceFactory.create(PieceType.PAWN, PieceColor.BLACK));
		board.changePiece(3, 5, PieceFactory.create(PieceType.PAWN, PieceColor.BLACK));
		board.changePiece(5, 3, PieceFactory.create(PieceType.PAWN, PieceColor.BLACK));
		boolean[][] expected = grid(
			"........",
			"........",
			"...o.o..",
			"..o...o.",
			"........",
			"..o...o.",
			"...o.o..",
			"........");
		assertArrayEquals(expected, board.getMoves(4, 4));
	}
	
	@Test
	void knightTakingBishop() {
		board.changePiece(4, 4, PieceFactory.create(PieceType.KNIGHT, PieceColor.WHITE));
		board.changePiece(5, 6, PieceFactory.create(PieceType.BISHOP, PieceColor.BLACK));
		board.changePiece(5, 2, PieceFactory.create(PieceType.BISHOP, PieceColor.BLACK));
		board.changePiece(6, 5, PieceFactory.create(PieceType.BISHOP, PieceColor.BLACK));
		board.changePiece(6, 3, PieceFactory.create(PieceType.BISHOP, PieceColor.BLACK));
		board.changePiece(3, 6, PieceFactory.create(PieceType.BISHOP, PieceColor.BLACK));
		board.changePiece(3, 2, PieceFactory.create(PieceType.BISHOP, PieceColor.BLACK));
		board.changePiece(2, 5, PieceFactory.create(PieceType.BISHOP, PieceColor.BLACK));
		board.changePiece(2, 3, PieceFactory.create(PieceType.BISHOP, PieceColor.BLACK));
		
		boolean[][] expected = grid(
			"........",
			"........",
			"...o.o..",
			"..o...o.",
			"........",
			"..o...o.",
			"...o.o..",
			"........");
		assertArrayEquals(expected, board.getMoves(4, 4));
	}
	
	@Test
	void knightBlockedByAlly() {
		board.changePiece(4, 4, PieceFactory.create(PieceType.KNIGHT, PieceColor.WHITE));
		board.changePiece(5, 6, PieceFactory.create(PieceType.BISHOP, PieceColor.WHITE));
		board.changePiece(5, 2, PieceFactory.create(PieceType.BISHOP, PieceColor.WHITE));
		board.changePiece(6, 5, PieceFactory.create(PieceType.BISHOP, PieceColor.WHITE));
		board.changePiece(6, 3, PieceFactory.create(PieceType.BISHOP, PieceColor.WHITE));
		board.changePiece(3, 6, PieceFactory.create(PieceType.BISHOP, PieceColor.WHITE));
		board.changePiece(3, 2, PieceFactory.create(PieceType.BISHOP, PieceColor.WHITE));
		board.changePiece(2, 5, PieceFactory.create(PieceType.BISHOP, PieceColor.WHITE));
		board.changePiece(2, 3, PieceFactory.create(PieceType.BISHOP, PieceColor.WHITE));
		
		boolean[][] expected = grid(
			"........",
			"........",
			"........",
			"........",
			"........",
			"........",
			"........",
			"........");
		assertArrayEquals(expected, board.getMoves(4, 4));
	}

}
