 package pieces;

import game.BoardView;
import game.Position;
import pieces.movements.*;

public class Piece implements Movement {

	private PieceType pieceType;
	private PieceColor pieceColor;
	private Movement[] movements;
	private boolean hasMoved;
	
	public Piece(PieceType pieceType, PieceColor pieceColor, Movement... movements) {
		this.pieceType = pieceType;
		this.pieceColor = pieceColor;
		this.movements = (movements == null) ? new Movement[0] : movements;
		this.hasMoved = false;
	}
	
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
		return pieceType.toString() + pieceColor.toString();
	}
	
	public PieceType type() {
		return pieceType;
	}
	
	public PieceColor color() {
		return pieceColor;
	}
	
	public void notifyMovement() {
		this.hasMoved = true;
	}
	
	protected boolean hasMoved() {
	    return this.hasMoved;
	}
	
}
