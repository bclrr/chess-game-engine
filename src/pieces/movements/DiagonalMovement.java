package pieces.movements;

import pieces.Tile;

public class DiagonalMovement implements Movement {

	public DiagonalMovement() {
		
	}
	
	@Override
	public boolean canMove(int srcX, int srcY, int destX, int destY, Tile[][] board) {
		int difX = Math.abs(srcX - destX);
		int difY = Math.abs(srcY - destY);
		if(difX != difY)
			return false;
		
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
					if(!board[j][i].isEmpty())
						return false;
				}
			} else {
				for(int j = startY; j >= endY; j--) {
					if(!board[j][i].isEmpty())
						return false;
				}
			}
		}
		return true;
	}

}
