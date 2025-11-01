package pieces.movements;

import pieces.PieceColor;
import pieces.Tile;

public class PawnMovement implements Movement {

	private int direction;
	private boolean firstMoove;
	
	public PawnMovement(PieceColor color) {
		firstMoove = true;
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
		
		boolean destEmpty = board[destY][destY].isEmpty();
		difY = Math.abs(difY);
		if(difY < 1 || difY > 2 || difX < 0 || difX > 1) 
			return false;
	
		if(difY == 2)
			return firstMoove && difX == 0 && destEmpty; 
		
		if(difX == 0)
			return destEmpty;
		
		if(!destEmpty) {
			//TODO check en passant
			return false;
		}
		return true;
	}
	
	public void notifyMovement() {
		firstMoove = false;
	}

}