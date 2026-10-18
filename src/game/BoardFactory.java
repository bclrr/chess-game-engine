package game;

import pieces.Piece;
import pieces.PieceColor;
import pieces.PieceFactory;
import pieces.PieceType;

public class BoardFactory {
	
	public static Board createNormal() {

		Piece[][] pieces = new Piece[8][8];
		for(int i = 0; i < 8; i++) {
			pieces[1][i] = PieceFactory.create(PieceType.PAWN, PieceColor.BLACK);
			pieces[6][i] = PieceFactory.create(PieceType.PAWN, PieceColor.WHITE);
			for(int j = 2; j < 6; j++) {
				pieces[j][i] = PieceFactory.create(PieceType.NONE, PieceColor.NONE);
			}
		}
		
		pieces[0][0] = PieceFactory.create(PieceType.ROOK, PieceColor.BLACK);
		pieces[0][1] = PieceFactory.create(PieceType.KNIGHT, PieceColor.BLACK);
		pieces[0][2] = PieceFactory.create(PieceType.BISHOP, PieceColor.BLACK);
		pieces[0][3] = PieceFactory.create(PieceType.QUEEN, PieceColor.BLACK);
		pieces[0][4] = PieceFactory.create(PieceType.KING, PieceColor.BLACK);
		pieces[0][5] = PieceFactory.create(PieceType.BISHOP, PieceColor.BLACK);
		pieces[0][6] = PieceFactory.create(PieceType.KNIGHT, PieceColor.BLACK);
		pieces[0][7] = PieceFactory.create(PieceType.ROOK, PieceColor.BLACK);
		
		pieces[7][0] = PieceFactory.create(PieceType.ROOK, PieceColor.WHITE);
		pieces[7][1] = PieceFactory.create(PieceType.KNIGHT, PieceColor.WHITE);
		pieces[7][2] = PieceFactory.create(PieceType.BISHOP, PieceColor.WHITE);
		pieces[7][3] = PieceFactory.create(PieceType.QUEEN, PieceColor.WHITE);
		pieces[7][4] = PieceFactory.create(PieceType.KING, PieceColor.WHITE);
		pieces[7][5] = PieceFactory.create(PieceType.BISHOP, PieceColor.WHITE);
		pieces[7][6] = PieceFactory.create(PieceType.KNIGHT, PieceColor.WHITE);
		pieces[7][7] = PieceFactory.create(PieceType.ROOK, PieceColor.WHITE);
		
		return new Board(pieces);
	}
	
	public static Board createEmpty() {
		Piece[][] pieces = new Piece[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				pieces[i][j] = PieceFactory.create(PieceType.NONE, PieceColor.NONE);
			}
		}
		return new Board(pieces);
	}
}
