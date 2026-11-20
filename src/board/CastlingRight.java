package board;

import pieces.PieceColor;

public enum CastlingRight {
	NONE(0),
	WHITE_LONG(1),
	WHITE_SHORT(2),
	BLACK_SHORT(4),
	BLACK_LONG(8);
	
	private final int value;
	
	CastlingRight(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public static CastlingRight longOf(PieceColor color) {
		if(color == PieceColor.WHITE) {
			return WHITE_LONG;
		}
		if(color == PieceColor.BLACK) {
			return BLACK_LONG;
		}
		return NONE;
	}
	public static CastlingRight shortOf(PieceColor color) {
		if(color == PieceColor.WHITE) {
			return WHITE_SHORT;
		}
		if(color == PieceColor.BLACK) {
			return BLACK_SHORT;
		}
		return NONE;
	}
}
