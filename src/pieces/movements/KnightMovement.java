package pieces.movements;

import game.BoardView;

public class KnightMovement implements Movement {

	public KnightMovement() {
		
	}
	
	@Override
	public boolean canMove(int srcX, int srcY, int destX, int destY, BoardView board) {
		int difX = Math.abs(srcX - destX);
		int difY = Math.abs(srcY - destY);
		return (difX == 2 && difY == 1) || (difX == 1 && difY == 2);
	}

}
