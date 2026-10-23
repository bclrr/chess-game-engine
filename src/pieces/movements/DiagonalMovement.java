package pieces.movements;

import game.BoardView;

public class DiagonalMovement implements Movement {

	public DiagonalMovement() {
		
	}
	
	@Override
	public MovementType isValidMove(int srcX, int srcY, int destX, int destY, BoardView board) {

		int difX = destX - srcX;
		int difY = destY - srcY;

		if(difX != difY && difX * -1 != difY) {
			return MovementType.INVALID;
		}
		
		int stepX = Integer.signum(difX);
		int stepY = Integer.signum(difY);

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
