package test.movements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;

class QueenMovementsTest extends MovementsTest {
	

	@Test
	void queenMoves() {
		board.changePiece(4, 4, PieceFactory.create(PieceType.QUEEN, PieceColor.WHITE));
		boolean[][] expected = grid(
			"o...o...",
			".o..o..o",
			"..o.o.o.",
			"...ooo..",
			"oooo.ooo",
			"...ooo..",
			"..o.o.o.",
			".o..o..o");
		assertArrayEquals(expected, board.getMoves(4, 4));
	}
	

}
