package test.movements;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;

class KnightMovementsTest extends MovementsTest {

	@Test
	void knightMoves() {
		board.set(4, 4, PieceType.KNIGHT, PieceColor.WHITE);
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
		board.set(4, 4, PieceType.KNIGHT, PieceColor.WHITE);
		board.set(4, 5, PieceType.PAWN, PieceColor.WHITE);
		board.set(5, 5, PieceType.PAWN, PieceColor.WHITE);
		board.set(5, 4, PieceType.PAWN, PieceColor.WHITE);
		board.set(3, 4, PieceType.PAWN, PieceColor.WHITE);
		board.set(4, 3, PieceType.PAWN, PieceColor.BLACK);
		board.set(3, 3, PieceType.PAWN, PieceColor.BLACK);
		board.set(3, 5, PieceType.PAWN, PieceColor.BLACK);
		board.set(5, 3, PieceType.PAWN, PieceColor.BLACK);
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
		board.set(4, 4, PieceType.KNIGHT, PieceColor.WHITE);
		board.set(5, 6, PieceType.BISHOP, PieceColor.BLACK);
		board.set(5, 2, PieceType.BISHOP, PieceColor.BLACK);
		board.set(6, 5, PieceType.BISHOP, PieceColor.BLACK);
		board.set(6, 3, PieceType.BISHOP, PieceColor.BLACK);
		board.set(3, 6, PieceType.BISHOP, PieceColor.BLACK);
		board.set(3, 2, PieceType.BISHOP, PieceColor.BLACK);
		board.set(2, 5, PieceType.BISHOP, PieceColor.BLACK);
		board.set(2, 3, PieceType.BISHOP, PieceColor.BLACK);
		
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
		board.set(4, 4, PieceType.KNIGHT, PieceColor.WHITE);
		board.set(5, 6, PieceType.BISHOP, PieceColor.WHITE);
		board.set(5, 2, PieceType.BISHOP, PieceColor.WHITE);
		board.set(6, 5, PieceType.BISHOP, PieceColor.WHITE);
		board.set(6, 3, PieceType.BISHOP, PieceColor.WHITE);
		board.set(3, 6, PieceType.BISHOP, PieceColor.WHITE);
		board.set(3, 2, PieceType.BISHOP, PieceColor.WHITE);
		board.set(2, 5, PieceType.BISHOP, PieceColor.WHITE);
		board.set(2, 3, PieceType.BISHOP, PieceColor.WHITE);
		
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
