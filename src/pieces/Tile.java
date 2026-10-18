package pieces;

import pieces.movements.Movement;

public class Tile implements Movement {

	private Piece myPiece;
	
	public Tile(Piece _myPiece) {
		this.myPiece = _myPiece;
	}
	
	public Tile() {
		removePiece();
	}
	
	public void changePiece(Piece newPiece) {
		this.myPiece = newPiece;
	}
	
	public void removePiece() {
		this.myPiece = Piece.Nothing();
	}
	
	public Piece getPiece() {
		return myPiece;
	}
	
	
	public boolean isEmpty() {
		return myPiece.getPieceType() == PieceType.NONE || myPiece == null;
	}

	public boolean canMove(int srcX, int srcY, int destX, int destY, Tile[][] board) {
		if(board[destY][destX].myPiece.getPieceColor() == myPiece.getPieceColor())
			return false;
		return myPiece.canMove(srcX, srcY, destX, destY, board);
	}
	
	public boolean hasMoved() {
	    if(this.isEmpty()) {
	    	return false;
	    }
	    return this.getPiece().hasMoved();
	}
	

}
