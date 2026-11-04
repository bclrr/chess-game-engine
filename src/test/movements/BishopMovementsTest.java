package test.movements;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import board.BoardPrinter;
import board.Position;
import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;

class BishopMovementsTest extends MovementsTest {

	@Test
	void bishopMoves() {
		board.set(4, 4, PieceType.BISHOP, PieceColor.WHITE);
		boolean[][] expected = grid(
			"o.......",
			".o.....o",
			"..o...o.",
			"...o.o..",
			"........",
			"...o.o..",
			"..o...o.",
			".o.....o");
		assertArrayEquals(expected, board.getMoves(4, 4));
	}
	
	@Test
	void bishopBlockedByAlly() {
		board.set(4, 4, PieceType.BISHOP, PieceColor.WHITE);
		board.set(6, 6, PieceType.ROOK, PieceColor.WHITE);
		board.set(2, 2, PieceType.ROOK, PieceColor.WHITE);
		board.set(2, 6, PieceType.ROOK, PieceColor.WHITE);
		board.set(6, 2, PieceType.ROOK, PieceColor.WHITE);
		boolean[][] expected = grid(
			"........",
			"........",
			"........",
			"...o.o..",
			"........",
			"...o.o..",
			"........",
			"........");
		assertArrayEquals(expected, board.getMoves(4, 4));
	}
	
	@Test
	void bishopTakingRook() {
		board.set(4, 4, PieceType.BISHOP, PieceColor.WHITE);
		board.set(6, 6, PieceType.ROOK, PieceColor.BLACK);
		board.set(2, 2, PieceType.ROOK, PieceColor.BLACK);
		board.set(2, 6, PieceType.ROOK, PieceColor.BLACK);
		board.set(6, 2, PieceType.ROOK, PieceColor.BLACK);
		boolean[][] expected = grid(
			"........",
			"........",
			"..o...o.",
			"...o.o..",
			"........",
			"...o.o..",
			"..o...o.",
			"........");
		assertArrayEquals(expected, board.getMoves(4, 4));
	}
}
