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
		
		int startX = srcX;
		int startY = srcY;
		int endX = destX;
		int endY = destY;
		if(srcX > destX) {
			startX = destX;
			startY = destY;
			endX = srcX;
			endY = srcY;
		}
		startX++;
		endX--;
		if(startY > endY) {
			startY--;
			endY++;
		} else {
			startY++;
			endY--;
		}

		for(int i = startX; i <= endX; i++) {
			if(startY < endY) {
				for(int j = startY; j <= endY; j++) {
					if(!board.isEmpty(i, j))
						return MovementType.INVALID;
				}
			} else {
				for(int j = startY; j >= endY; j--) {
					if(!board.isEmpty(i, j))
						return MovementType.INVALID;
				}
			}
		}
		return MovementType.NORMAL;
	}

}
