 package pieces;

import game.BoardView;
import pieces.movements.*;

public class Piece implements Movement {

	private PieceType pieceType;
	private PieceColor pieceColor;
	private Movement[] movements;
	private boolean hasMoved;
	
	public Piece(PieceType _pieceType, PieceColor _pieceColor, Movement... movements) {
		this.pieceType = _pieceType;
		this.pieceColor = _pieceColor;
		this.movements = (movements == null) ? new Movement[0] : movements;
		this.hasMoved = false;
	}
	
	public MovementType isValidMove(int srcX, int srcY, int destX, int destY, BoardView board) {
		for(Movement m : movements) {
			MovementType res = m.isValidMove(srcX, srcY, destX, destY, board);
			if(res != MovementType.INVALID) {
				return res;
			}
		}
		return MovementType.INVALID;
	}
	
	public String toString() {
		return pieceType.toString() + pieceColor.toString();
	}
	
	public PieceType getType() {
		return pieceType;
	}
	
	public PieceColor getColor() {
		return pieceColor;
	}
	
	public void notifyMovement() {
		this.hasMoved = true;
	}
	
	protected boolean hasMoved() {
	    return this.hasMoved;
	}
	
}
