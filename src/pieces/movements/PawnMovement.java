package pieces.movements;

import pieces.PieceColor;
import pieces.Tile;

public class PawnMovement implements Movement {

	private int direction;
	
	public PawnMovement(PieceColor color) {
		direction = 0;
		if(color == PieceColor.BLACK) 
			direction = 1;
		if(color == PieceColor.WHITE)
			direction = -1;
	}
	
	@Override
	//TODO implement with GameState class
	public boolean canMove(int srcX, int srcY, int destX, int destY, Tile[][] board) {
		int difY = destY - srcY;
		int difX = Math.abs(destX - srcX);

		//check destination same direction than the color of the piece (white -1; black 1)
		if(difY * direction <= 0)
			return false;
		
		boolean destEmpty = board[destY][destX].isEmpty();
		boolean hasMoved = board[srcY][srcX].hasMoved();
		difY = Math.abs(difY);
		
		//Two squares on the first turn
		if(difY == 2)
			return !hasMoved && difX == 0 && destEmpty;

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