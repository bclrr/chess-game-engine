package test.movements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;

class QueenMovementsTest extends MovementsTest {
	
	@Test
	void testQueen() {
		int srcX = 4;
		int srcY = 4;
		board.changePiece(srcX, srcY, PieceFactory.create(PieceType.QUEEN, PieceColor.WHITE));
		System.out.println();
		System.out.println("Queen :");
		board.displayMovements(srcX, srcY);
	}
	

}
