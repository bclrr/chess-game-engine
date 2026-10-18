package pieces;

public enum PieceType {
	
	KING("K"),
	QUEEN("Q"),
	ROOK("R"),
	BISHOP("B"),
	KNIGHT("N"),
	PAWN("P"),
	NONE(" ");
	
	final String notation;
	
	PieceType(String _notation) {
		this.notation = _notation;
	}
	
	public String toString() {
		return notation;
	}
	
}
