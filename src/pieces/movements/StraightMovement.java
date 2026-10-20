package pieces.movements;

import game.BoardView;

public class StraightMovement implements Movement {

	public StraightMovement() {
		
	}
	
	@Override
	public boolean isValidMove(int srcX, int srcY, int destX, int destY, BoardView board) {
		
		int difX = Math.abs(srcX - destX);
		int difY = Math.abs(srcY - destY);
		if(difX > 0 && difY > 0)
			return false;
		
		int startX = srcX;
		int startY = srcY;
		int endX = destX;
		int endY = destY;
		
		if(srcX > destX || srcY > destY) {
			startX = destX;
			startY = destY;
			endX = srcX;
			endY = srcY;
		}
		
		if(difX > 0) {
			startX++;
			endX--;
		} else {
			startY++;
			endY--;
		}
		
		for(int i = startX; i <= endX; i++) { 
			for(int j = startY; j <= endY; j++) {
				if(!board.isEmpty(i, j))
					return false;
			}
		}
		return true;
	}

}
