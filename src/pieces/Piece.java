 package pieces;

import board.BoardView;
import board.Position;
import pieces.movements.*;

public class Piece implements Movement {

	private PieceType type;
	private PieceColor color;
	private Movement[] movements;
	
	public Piece(PieceType pieceType, PieceColor pieceColor, Movement... movements) {
		this.type = pieceType;
		this.color = pieceColor;
		this.movements = (movements == null) ? new Movement[0] : movements;
	}
	
	@Override
	public MovementType isValidMove(Position src, Position dest, BoardView board) {
		for(Movement m : movements) {
			MovementType res = m.isValidMove(src, dest, board);
			if(res != MovementType.INVALID) {
				return res;
			}
		}
		return MovementType.INVALID;
	}
	
	public String toString() {
		return type.toString() + color.toString();
	}
	
	public PieceType type() {
		return type;
	}
	
	public PieceColor color() {
		return color;
	}
	
}
