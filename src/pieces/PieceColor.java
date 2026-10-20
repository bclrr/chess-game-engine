package pieces;

public enum PieceColor {

	WHITE("W"),
	BLACK("B"),
	NONE(" ");
	
	final String notation;
	
	PieceColor(String _notation) {
		this.notation = _notation;
	}
	
	public String toString() {
		return notation;
	}
}
