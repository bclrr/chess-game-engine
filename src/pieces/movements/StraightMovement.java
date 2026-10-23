package pieces.movements;

import game.BoardView;

public class StraightMovement implements Movement {

	public StraightMovement() {
		
	}
	
	@Override
	public MovementType isValidMove(int srcX, int srcY, int destX, int destY, BoardView board) {
		
		int difX = destX - srcX;
		int difY = destY - srcY;

		if((difX != 0) == (difY != 0)) {
			return MovementType.INVALID;
		}

		int stepX = Integer.signum(difX);
		int stepY = Integer.signum(difY);

		int x = srcX + stepX;
		int y = srcY + stepY;

		while(x != destX || y != destY) {
			if(!board.isEmpty(x, y)) {
				return MovementType.INVALID;
			}

			x += stepX;
			y += stepY;
		}

		return MovementType.NORMAL;
	}

}
