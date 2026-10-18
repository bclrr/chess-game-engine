 package pieces;

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
	
	public boolean canMove(int srcX, int srcY, int destX, int destY, Tile[][] board) {
		for(Movement m : movements) {
			if(m.canMove(srcX, srcY, destX, destY, board)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return pieceType.toString() + pieceColor.toString();
	}
	
	public PieceType getPieceType() {
		return pieceType;
	}
	
	public PieceColor getPieceColor() {
		return pieceColor;
	}
	
	public void notifyMovement() {
		this.hasMoved = true;
	}
	
	protected boolean hasMoved() {
	    return this.hasMoved;
	}
	
}
