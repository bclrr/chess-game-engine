package pieces.movements;

import pieces.Tile;

public interface Movement {
		
	public abstract boolean canMove(int srcX, int srcY, int destX, int destY, Tile[][] board);
	
}
