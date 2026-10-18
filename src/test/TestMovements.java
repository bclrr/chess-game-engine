package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import game.Board;
import game.BoardFactory;
import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;

class TestMovements {

	private static Board board;
	
	@BeforeAll
	public static void initTestMovements() {
		board = BoardFactory.createEmpty();
	}
	
	@Test
	void testDisplayBoard() {
		BoardFactory.createNormal().display();
	}
	
	@Test
	void testRook() {
		int srcX = 4;
		int srcY = 4;
		board.changePiece(srcX, srcY, PieceFactory.create(PieceType.ROOK, PieceColor.WHITE));
		System.out.println();
		System.out.println("Rook :");
		board.displayMovements(srcX, srcY);
	}
	
	@Test
	void testRookWithPieceSameColor() {
		int srcX = 4;
		int srcY = 4;
		board.changePiece(srcX, srcY, PieceFactory.create(PieceType.ROOK, PieceColor.WHITE));
		board.changePiece(srcX, 6, PieceFactory.create(PieceType.BISHOP, PieceColor.WHITE));
		System.out.println();
		System.out.println("Rook with piece same color:");
		board.displayMovements(srcX, srcY);
	}
	
	@Test
	void testRookWithPieceOtherColor() {
		int srcX = 4;
		int srcY = 4;
		board.changePiece(srcX, srcY, PieceFactory.create(PieceType.ROOK, PieceColor.WHITE));
		board.changePiece(srcX, 6, PieceFactory.create(PieceType.BISHOP, PieceColor.BLACK));
		System.out.println();
		System.out.println("Rook with piece other color:");
		board.displayMovements(srcX, srcY);
	}
	
	@Test
	void testBishop() {
		int srcX = 4;
		int srcY = 4;
		board.changePiece(srcX, srcY, PieceFactory.create(PieceType.BISHOP, PieceColor.WHITE));
		System.out.println();
		System.out.println("Bishop :");
		board.displayMovements(srcX, srcY);
	}
	
	@Test
	void testQueen() {
		int srcX = 4;
		int srcY = 4;
		board.changePiece(srcX, srcY, PieceFactory.create(PieceType.QUEEN, PieceColor.WHITE));
		System.out.println();
		System.out.println("Queen :");
		board.displayMovements(srcX, srcY);
	}
	
	@Test
	void testKnight() {
		int srcX = 4;
		int srcY = 4;
		board.changePiece(srcX, srcY, PieceFactory.create(PieceType.KNIGHT, PieceColor.WHITE));
		System.out.println();
		System.out.println("Knight :");
		board.displayMovements(srcX, srcY);
	}
	
}
