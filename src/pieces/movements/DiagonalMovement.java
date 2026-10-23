package pieces.movements;

import game.BoardView;

public class DiagonalMovement implements Movement {

	public DiagonalMovement() {
		
	}
	
	@Override
	public MovementType isValidMove(int srcX, int srcY, int destX, int destY, BoardView board) {

		int difX = Math.abs(srcX - destX);
		int difY = Math.abs(srcY - destY);

		if(difX != difY)
			return MovementType.INVALID;
		
		int stepX = srcX < destX ? 1 : -1;
		int stepY = srcY < destY ? 1 : -1;

		int x = srcX + stepX;
		int y = srcY + stepY;

		while(x != destX) {
			if(!board.isEmpty(x, y)) {
				return MovementType.INVALID;
			}
			x += stepX;
			y += stepY;
		}
		return MovementType.NORMAL;
	}

}
