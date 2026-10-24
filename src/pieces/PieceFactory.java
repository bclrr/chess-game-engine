package pieces;

import pieces.movements.*;

public class PieceFactory {

	private static final Movement DIAGONAL = new DiagonalMovement();
	private static final Movement KING = new KingMovement();
	private static final Movement KNIGHT = new KnightMovement();
	private static final Movement STRAIGHT = new StraightMovement();
	
	private static final Movement WHITE_PAWN = new PawnMovement(-1);
	private static final Movement BLACK_PAWN = new PawnMovement(1);
	
	private static final Piece NOTHING = new Piece(PieceType.NONE, PieceColor.NONE);
	
	public static final Piece create(PieceType type, PieceColor color) {
		
		if(color == PieceColor.NONE) {
			return NOTHING;
		}
		
		switch(type) {
			case BISHOP :
				return new Piece(type, color, DIAGONAL);
			case ROOK :
				return new Piece(type, color, STRAIGHT);
			case KING :
				return new Piece(type, color, KING);
			case KNIGHT :
				return new Piece(type, color, KNIGHT);
			case QUEEN :
				return new Piece(type, color, DIAGONAL, STRAIGHT);
			case PAWN :
				return color == PieceColor.BLACK ?
					new Piece(type, color, BLACK_PAWN):
					new Piece(type, color, WHITE_PAWN);
			case NONE :
				return NOTHING;
			default:
				throw new IllegalArgumentException("Type de pièce inconnu : " + type);
		}
	}
	
	public static final Piece empty() {
		return NOTHING;
	}
}
