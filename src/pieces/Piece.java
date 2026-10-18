 package pieces;

import pieces.movements.*;

public abstract class Piece implements Movement {

	private PieceType pieceType;
	private PieceColor pieceColor;
	private Movement[] movements;
	private boolean hasMoved;
	
	public Piece(PieceType _pieceType, PieceColor _pieceColor) {
		this.pieceType = _pieceType;
		this.pieceColor = _pieceColor;
		this.hasMoved = false;
	}
	
	public boolean canMove(int srcX, int srcY, int destX, int destY, Tile[][] board) {
		if(movements == null || movements.length <= 0)
			return false;
		
		for(Movement m : movements) {
			if(m.canMove(srcX, srcY, destX, destY, board))
				return true;
		}
		return false;
	}
	
	public String toString() {
		return pieceType.toString() + pieceColor.toString();
	}
	
	public static NothingPiece Nothing() {
		return new NothingPiece();
	}
	
	public PieceType getPieceType() {
		return pieceType;
	}
	
	public PieceColor getPieceColor() {
		return pieceColor;
	}
	
	protected void addMovements(Movement[] _movements) {
		this.movements = _movements;
	}
	
	public void notifyMovement() {
		this.hasMoved = true;
	}
	
	protected boolean hasMoved() {
	    return this.hasMoved;
	}
	
}
