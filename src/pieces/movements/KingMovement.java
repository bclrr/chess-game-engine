package pieces.movements;

import pieces.Tile;

public class KingMovement implements Movement {

	public KingMovement() {
		
	}
	
	@Override
	public boolean canMove(int srcX, int srcY, int destX, int destY, Tile[][] board) {
		int difX = Math.abs(srcX - destX);
		int difY = Math.abs(srcY - destY);
		return difX == 1 || difY == 1;
	}

}