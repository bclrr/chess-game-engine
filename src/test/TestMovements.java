package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import game.Board;
import pieces.Bishop;
import pieces.Knight;
import pieces.PieceColor;
import pieces.Queen;
import pieces.Rook;

class TestMovements {

	private static Board board;
	
	@BeforeAll
	public static void initTestMovements() {
		board = Board.getTestBoard();
	}
	
	@Test
	void testRook() {
		int srcX = 4;
		int srcY = 4;
		board.addPiece(srcX, srcY, new Rook(PieceColor.WHITE));
		System.out.println();
		System.out.println("Rook :");
		board.displayMovements(srcX, srcY);
	}
	
	@Test
	void testRookWithPieceSameColor() {
		int srcX = 4;
		int srcY = 4;
		board.addPiece(srcX, srcY, new Rook(PieceColor.WHITE));
		board.addPiece(srcX, 6, new Bishop(PieceColor.WHITE));
		System.out.println();
		System.out.println("Rook with piece same color:");
		board.displayMovements(srcX, srcY);
	}
	
	@Test
	void testRookWithPieceOtherColor() {
		int srcX = 4;
		int srcY = 4;
		board.addPiece(srcX, srcY, new Rook(PieceColor.WHITE));
		board.addPiece(srcX, 6, new Bishop(PieceColor.BLACK));
		System.out.println();
		System.out.println("Rook with piece other color:");
		board.displayMovements(srcX, srcY);
	}
	
	@Test
	void testBishop() {
		int srcX = 4;
		int srcY = 4;
		board.addPiece(srcX, srcY, new Bishop(PieceColor.WHITE));
		System.out.println();
		System.out.println("Bishop :");
		board.displayMovements(srcX, srcY);
	}
	
	@Test
	void testQueen() {
		int srcX = 4;
		int srcY = 4;
		board.addPiece(srcX, srcY, new Queen(PieceColor.WHITE));
		System.out.println();
		System.out.println("Queen :");
		board.displayMovements(srcX, srcY);
	}
	
	@Test
	void testKnight() {
		int srcX = 4;
		int srcY = 4;
		board.addPiece(srcX, srcY, new Knight(PieceColor.WHITE));
		System.out.println();
		System.out.println("Knight :");
		board.displayMovements(srcX, srcY);
	}
	
}
