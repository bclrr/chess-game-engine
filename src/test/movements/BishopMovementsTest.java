package test.movements;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import game.BoardPrinter;
import game.Position;
import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;

class BishopMovementsTest extends MovementsTest {

	@Test
	void bishopMoves() {
		board.changePiece(4, 4, PieceType.BISHOP, PieceColor.WHITE);
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
		board.changePiece(4, 4, PieceType.BISHOP, PieceColor.WHITE);
		board.changePiece(6, 6, PieceType.ROOK, PieceColor.WHITE);
		board.changePiece(2, 2, PieceType.ROOK, PieceColor.WHITE);
		board.changePiece(2, 6, PieceType.ROOK, PieceColor.WHITE);
		board.changePiece(6, 2, PieceType.ROOK, PieceColor.WHITE);
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
		board.changePiece(4, 4, PieceType.BISHOP, PieceColor.WHITE);
		board.changePiece(6, 6, PieceType.ROOK, PieceColor.BLACK);
		board.changePiece(2, 2, PieceType.ROOK, PieceColor.BLACK);
		board.changePiece(2, 6, PieceType.ROOK, PieceColor.BLACK);
		board.changePiece(6, 2, PieceType.ROOK, PieceColor.BLACK);
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
