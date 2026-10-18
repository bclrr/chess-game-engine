package pieces.movements;

import pieces.Tile;

public class KingMovement implements Movement {

	public KingMovement() {
		
	}
	
	@Override
	public boolean canMove(int srcX, int srcY, int destX, int destY, Tile[][] board) {
		int difX = Math.abs(srcX - destX);
		int difY = Math.abs(srcY - destY);
		if(difX == 1 || difY == 1) {
			return true;
		}
		if(difY != 0) {
			return false;
		}
		
		return false;
	}
	
	private boolean canShortCastle() {
		//TODO
		return false;
	}

	private boolean canLongCastle() {
		//TODO
		return false;
	}
	
}