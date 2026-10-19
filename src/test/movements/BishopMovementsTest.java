package test.movements;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;

class BishopMovementsTest extends MovementsTest {

	@Test
	void testBishop() {
		board.changePiece(4, 4, PieceFactory.create(PieceType.BISHOP, PieceColor.WHITE));
		boolean[][] expected = grid(
			"o.......",
			".o.....o",
			"..o...o.",
			"...o.o..",
			"........",
			"...o.o..",
			"..o...o.",
			".o.....o");
		assertArrayEquals(expected, board.getMovements(4, 4));
	}

}
