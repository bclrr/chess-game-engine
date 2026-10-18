package pieces.movements;

import game.BoardView;
import pieces.Piece;
import pieces.PieceColor;

public class PawnMovement implements Movement {

	private int direction;
	
	public PawnMovement(int direction) {
		this.direction = direction;
	}
	
	@Override
	//TODO implement with GameState class
	public boolean canMove(int srcX, int srcY, int destX, int destY, BoardView board) {
		int difY = destY - srcY;
		int difX = Math.abs(destX - srcX);

		//check destination same direction than the color of the piece (white -1; black 1)
		if(difY * direction <= 0)
			return false;
		
		boolean destEmpty = board.isEmpty(destX, destY);
		Piece myPiece = board.get(srcX, srcY);
		difY = Math.abs(difY);
		
		//Two squares on the first turn
		if(difY == 2)
			return
				(
					(myPiece.getPieceColor() == PieceColor.BLACK && srcY == 1) ||
					(myPiece.getPieceColor() == PieceColor.WHITE && srcY == 6)
				) && difX == 0 && destEmpty;

		//Forward only
		if(difY != 1)
			return false;
		
		//Forward movement without blocked path
		if(difX == 0)
			return destEmpty;
		
		if(destEmpty) {
			//TODO check en passant
			return false;
		}

		return true;
	}

}